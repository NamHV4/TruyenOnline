package com.codedao.truyenonline.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.codedao.truyenonline.R;
import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.JellyTypes.Jelly;
import com.nightonke.jellytogglebutton.State;

public class ReaderActivity extends AppCompatActivity {
    JellyToggleButton jellyToggleButton;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        getSupportActionBar().hide();
        jellyToggleButton=findViewById(R.id.toggle);

        container=findViewById(R.id.container);

        jellyToggleButton.setJelly(Jelly.RANDOM);
        jellyToggleButton.setRightText("Night");
        jellyToggleButton.setLeftText("Day");

        jellyToggleButton.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                Toast lastToast=new Toast(getApplicationContext());
                if (state.equals(State.LEFT)) {
//                    container.setBackgroundColor(Color.parseColor("#FFF"));
                    if (lastToast != null) lastToast.cancel();
                    lastToast = Toast.makeText(getApplicationContext(), "Day mode reader activated", Toast.LENGTH_SHORT);
                    lastToast.show();

                }
                if (state.equals(State.RIGHT)) {
//                    container.setBackgroundColor(Color.parseColor("FFABA7A7"));
                    if (lastToast != null) lastToast.cancel();
                    lastToast = Toast.makeText(getApplicationContext(), "Night mode reader activated", Toast.LENGTH_SHORT);


                    lastToast.show();
                }
            }
        });
    }
}
