package com.example.erika_000.devmanager;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
/** La aplicación extiende la clase Activity. Además implementamos
 * cuatro interfaces que corresponden a varios escuchadores de eventos. Luego continúa la
 * declaración de variables. Las primeras corresponden a diferentes elementos de la aplicación
 * y su significado resulta obvio. La variable pause nos indica si el usuario ha pulsado el
 * botón correspondiente, la variable path nos indica dónde está el vídeo en reproducción y la
 * variable savePos almacena la posición de reproducción.*/

public class VideoPlayer extends Activity implements
        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private EditText editText;
    private ImageButton bPlay, bPause, bStop, bLog;
    private TextView logTextView;
    private boolean pause;
    private String path;
    private int savePos = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        editText = (EditText) findViewById(R.id.path);
        editText.setText(
                "https://www.youtube.com/playlist?list=PLAAhC8kCE0VlfmKREk2JJ-hFRPpTl3Daq");

        logTextView = (TextView) findViewById(R.id.Log);
        bPlay = (ImageButton) findViewById(R.id.play);
        bPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (pause) {
                        mediaPlayer.start();
                    } else {
                        playVideo();
                    }
                }
            }
        });
        bPause = (ImageButton) findViewById(R.id.pause);
        bPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    pause = true;
                    mediaPlayer.pause();
                }
            }
        });
        bStop = (ImageButton) findViewById(R.id.stop);
        bStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    pause = false;
                    mediaPlayer.stop();
                }
            }
        });
        bLog = (ImageButton) findViewById(R.id.logButton);
        bLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (logTextView.getVisibility() == TextView.VISIBLE) {
                    logTextView.setVisibility(TextView.INVISIBLE);
                } else {
                    logTextView.setVisibility(TextView.VISIBLE);
                }
            }
        });
        log("");
    }
            /* El código continúa con la definición del método playVideo(). Este método se encarga
   de obtener la ruta de reproducción, crear un nuevo objeto MediaPlayer, luego se le asigna
   la ruta y la superficie de visualización, a continuación se prepara la reproducción del vídeo.
    En caso de querer reproducir un stream desde la red, esta función puede tardar bastante tiempo,
     en tal caso es recomendable utilizar en su lugar el método prepareAsync() que permite continuar
     con la ejecución del programa, aunque sin esperar a que el vídeo esté preparado. Las siguientes tres líneas asignan a nuestro objeto varios escuchadores de eventos que serán descritos más adelante. Tras preparar el tipo de audio, se sitúa la posición de reproducción a
    los milisegundos indicados en la variable savePos. Si se trata de una nueva reproducción, esta variable será cero.*/
    private void playVideo() {
        try {
            pause = false;
            path = editText.getText().toString();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.prepare();
            // mMediaPlayer.prepareAsync(); Para streaming
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.seekTo(savePos);
        } catch (Exception e) {
            log("ERROR: " + e.getMessage());
        }
    }
    public void onBufferingUpdate(MediaPlayer arg0, int percent) {
            log("onBufferingUpdate percent:" + percent);
        }
    /*implementa la interfaz OnPreperedListener. Es invocado una vez que el vídeo ya está preparado para su reproducción.
     En este momento podemos conocer el alto y el ancho del vídeo y ponerlo en reproducción.*/
    public void onPrepared(MediaPlayer mediaplayer) {
        log("onPrepared called");
        int mVideoWidth = mediaPlayer.getVideoWidth();
        int mVideoHeight = mediaPlayer.getVideoHeight();
        if (mVideoWidth != 0 && mVideoHeight != 0) {
            surfaceHolder.setFixedSize(mVideoWidth, mVideoHeight);
            mediaPlayer.start();
        }
    }

    public void onCompletion(MediaPlayer arg0) {
        log("onCompletion called");
    }




    public void surfaceCreated(SurfaceHolder holder) {
        log("surfaceCreated called");
        playVideo();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder,
                               int i, int j, int k) {
        log("surfaceChanged called");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        log("surfaceDestroyed called");
    }
    @Override protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
   /*Los dos métodos siguientes se invocan cuando la actividad pasa a un segundo plano y cuando vuelve a primer plano.
   Dado que queremos que el vídeo deje de reproducirse y continúe reproduciéndose en cada uno de estos casos,
    se invocan a los métodos pause() y start(), respectivamente. No hay que confundir esta
   acción con la variable pause que lo que indica es que el usuario ha pulsado el botón correspondiente.*/
    @Override public void onPause() {
        super.onPause();
        if (mediaPlayer != null & !pause) {
            mediaPlayer.pause();
        }
    }
    @Override public void onResume() {
        super.onResume();
        if (mediaPlayer != null & !pause) {
            mediaPlayer.start();
        }
    }
    /*Cuando este sistema necesita memoria, puede decidir eliminar nuestra actividad. Antes de hacerlo llamará al método
     onSaveInstanceState para darnos la oportunidad de guardar información sensible.
     Si más adelante el usuario vuelve a la aplicación, esta se volverá a cargar,
     invocándose el método onRestoreInstanceState, donde podremos restaurar el estado perdido. En nuestro caso la información a guardar son las variables path y savePos, que representan el vídeo y la posición que estamos reproduciendo.

Ocurre el mismo proceso cuando el usuario cambia la posición del teléfono.
 Es decir, cuando el teléfono se voltea las actividades son destruidas y vueltas a crear, por lo
 que también se invocan estos métodos.*/
    @Override
    protected void onSaveInstanceState(Bundle guardarEstado) {
        super.onSaveInstanceState(guardarEstado);
        if (mediaPlayer != null) {
            int pos = mediaPlayer.getCurrentPosition();
            guardarEstado.putString("ruta", path);
            guardarEstado.putInt("posicion", pos);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle recEstado) {
        super.onRestoreInstanceState(recEstado);
        if (recEstado != null) {
            path = recEstado.getString("ruta");
            savePos = recEstado.getInt("posicion");
        }
    }
    /*El último método es utilizado por varios escuchadores de eventos para mostrar información sobre lo que está pasando.
     Esta información puede visualizarse o no, utilizando el botón correspondiente.*/
    private void log(String s) {
        logTextView.append(s + "\n");
    }
}

