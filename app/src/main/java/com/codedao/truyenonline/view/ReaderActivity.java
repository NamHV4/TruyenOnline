package com.codedao.truyenonline.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codedao.truyenonline.R;

public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        getSupportActionBar().hide();
    }
}
