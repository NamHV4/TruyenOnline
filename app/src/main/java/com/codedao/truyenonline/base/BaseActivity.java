package com.codedao.truyenonline.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by utnam on 8/8/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContenView();
        registerEventView();
    }
    protected abstract void setContenView();

    protected abstract void registerEventView();

}
