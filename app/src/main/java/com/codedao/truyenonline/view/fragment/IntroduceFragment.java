package com.codedao.truyenonline.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Truyen;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceFragment extends Fragment {

    private Truyen mTruyen;
    private View mView;
    private TextView mTextViewIntro;

    public IntroduceFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public IntroduceFragment(Truyen truyen) {
        this.mTruyen = truyen;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_introduce, container, false);
        mTextViewIntro = mView.findViewById(R.id.txtIntro);
        mTextViewIntro.setText(Html.fromHtml(mTruyen.getmNoiDung()));
        return mView;
    }

}
