package com.codedao.truyenonline.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codedao.truyenonline.R;
import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.JellyTypes.Jelly;
import com.nightonke.jellytogglebutton.State;

public class ReaderActivity extends AppCompatActivity {
    JellyToggleButton jellyToggleButton;
    RelativeLayout mRelativeLayout;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        getSupportActionBar().hide();
        jellyToggleButton = findViewById(R.id.toggle);
        mRelativeLayout = findViewById(R.id.relativeLayout);
        mTextView = findViewById(R.id.txtConten);

        jellyToggleButton.setJelly(Jelly.RANDOM);
        jellyToggleButton.setRightText("Night");
        jellyToggleButton.setLeftText("Day");

        jellyToggleButton.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                Toast lastToast = new Toast(getApplicationContext());
                if (state.equals(State.LEFT)) {
                    if (lastToast != null) lastToast.cancel();
                    lastToast = Toast.makeText(getApplicationContext(), "Day mode reader activated", Toast.LENGTH_SHORT);
                    lastToast.show();
                    mRelativeLayout.setBackgroundColor(Color.parseColor("#f7f6f6"));
                    mTextView.setTextColor(Color.parseColor("#2d2b2b"));


                }
                if (state.equals(State.RIGHT)) {
                    if (lastToast != null) lastToast.cancel();
                    lastToast = Toast.makeText(getApplicationContext(), "Night mode reader activated", Toast.LENGTH_SHORT);
                    lastToast.show();
                    mRelativeLayout.setBackgroundColor(Color.parseColor("#4e4646"));
                    mTextView.setTextColor(Color.parseColor("#e4e2e2"));
                }
            }
        });
    }
}
