package com.codedao.truyenonline.view.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Chapter;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.view.CustomSettingView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReaderFragment extends Fragment {

    private FrameLayout mFrameLayout;
    private TextView mTxtNoiDungTruyen;
    private TextView mTitle;
    private TextView mTacgia;
    private FrameLayout mFrameLayoutSetting;
    private CustomSettingView mCustomSettingView;
    private SeekBar mSeekBar;
    private ImageView mImgSetting;
    private float mCurrentSize;
    private ToggleButton mToggleButton;
    private Truyen mTruyen;
    private Chapter mChapter;

    public ReaderFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ReaderFragment(Truyen truyen) {
        this.mTruyen = truyen;
    }

    @SuppressLint("ValidFragment")
    public ReaderFragment(Truyen mTruyen, Chapter chapter) {
        this.mTruyen = mTruyen;
        this.mChapter = chapter;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reader, container, false);
        mFrameLayout = view.findViewById(R.id.rl_doc_truyen);
        mTxtNoiDungTruyen = view.findViewById(R.id.txt_noi_dung);
        mTxtNoiDungTruyen.setText(Html.fromHtml(mTruyen.getmNoiDung()));
        mTacgia = view.findViewById(R.id.txt_tacgia);
        mTitle = view.findViewById(R.id.txt_title);
        mTacgia.setText(mTruyen.getmTacGia());
        mTitle.setText(mTruyen.getmTenTruyen());
        mSeekBar = view.findViewById(R.id.seekbar_text);
        mImgSetting = view.findViewById(R.id.img_setting);
        mFrameLayoutSetting = view.findViewById(R.id.frame_setting);
        mCustomSettingView = view.findViewById(R.id.float_setting);
        mSeekBar.setProgress(50);
        mCurrentSize = 15 + (float)(50*10)/100;
        mTxtNoiDungTruyen.setTextSize(mCurrentSize);
        mToggleButton = view.findViewById(R.id.activate_toggle);

        mImgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFrameLayoutSetting.setVisibility(View.VISIBLE);
            }
        });




        mFrameLayoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCustomSettingView.isOutsite()){
                    mFrameLayoutSetting.setVisibility(View.GONE);
                }else {
                    mCustomSettingView.setOutsite(true);
                    mFrameLayoutSetting.setVisibility(View.GONE);
                }
            }
        });


        
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            float size;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                size = 15 + (float)(i*10)/100;
                mTxtNoiDungTruyen.setTextSize(size);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    mFrameLayout.setBackgroundColor(Color.parseColor("#4e4646"));
                    mTxtNoiDungTruyen.setTextColor(Color.parseColor("#e4e2e2"));
                }else {
                    mFrameLayout.setBackgroundColor(Color.parseColor("#f7f6f6"));
                    mTxtNoiDungTruyen.setTextColor(Color.parseColor("#2d2b2b"));
                }
            }
        });
        return view;
    }
}
