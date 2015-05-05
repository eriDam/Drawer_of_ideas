package com.example.erika_000.followl;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by erika_000 on 16/04/2015.
 */

    public class Flotant extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.flotant);

            findViewById(R.id.pink_icon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Flotant.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
                }
            });

            FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);
            button.setSize(FloatingActionButton.SIZE_MINI);
            button.setColorNormalResId(R.color.pink);
            button.setColorPressedResId(R.color.pink_pressed);
            button.setIcon(R.mipmap.ic_fab_star);
            button.setStrokeVisible(false);

            final View actionB = findViewById(R.id.action_b);

            FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
            actionC.setTitle("Hide/Show Action above");
            actionC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                }
            });
            ((FloatingActionsMenu) findViewById(R.id.multiple_actions)).addButton(actionC);

            final FloatingActionButton removeAction = (FloatingActionButton) findViewById(R.id.button_remove);
            removeAction.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
                }
            });

            ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
            drawable.getPaint().setColor(getResources().getColor(R.color.white));
            ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);

            final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
            actionA.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionA.setTitle("Action A clicked");
                }
            });

            // Test that FAMs containing FABs with visibility GONE do not cause crashes
            findViewById(R.id.button_gone).setVisibility(View.GONE);
        }
    }
