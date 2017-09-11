package com.codedao.truyenonline.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.codedao.truyenonline.R;

/**
 * Created by DUNG-PTIT on 24/08/2017.
 */

public class CustomSettingView extends LinearLayout {


    private ViewGroup mViewGroup;
    private boolean isOutsite = true;
    private SeekBar mSeekBarText;
    private Context mContext;
    //private ICustomSettingView mICustomSettingView;



    public CustomSettingView(Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public CustomSettingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
    }

    public CustomSettingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }


    public void initViews() {
        ViewGroup viewGroup = (ViewGroup) inflate(getContext(), R.layout.custom_setting_view, this);
        mViewGroup = (ViewGroup) viewGroup.getChildAt(0);
        mSeekBarText = mViewGroup.findViewById(R.id.seekbar_text);
        mSeekBarText.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            float size;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                size = 15 + (float) (i * 10) / 100;
                Toast.makeText(mContext, "" + size, Toast.LENGTH_SHORT).show();
                //mICustomSettingView.onSizeText(size);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("VIETNAM", "dispatchTouchEvent: vchhhhhhh");
        isOutsite = false;
        return super.dispatchTouchEvent(ev);
    }

    public boolean isOutsite() {
        return isOutsite;
    }

    public void setOutsite(boolean outsite) {
        isOutsite = outsite;
    }

    public interface ICustomSettingView {
        public void onSizeText(float size);
        public void onNigheMode(boolean isOn);
    }

}
