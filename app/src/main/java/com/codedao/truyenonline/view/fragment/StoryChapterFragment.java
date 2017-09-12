package com.codedao.truyenonline.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.ViewpagerAdapter;
import com.codedao.truyenonline.model.Truyen;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryChapterFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private View mView;
    public static ViewpagerAdapter adapter;
    public Truyen mTruyen;

    public StoryChapterFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public StoryChapterFragment(Truyen truyen) {
        this.mTruyen = truyen;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_chuong, container, false);
        mViewPager = mView.findViewById(R.id.view_pager);
        mTabLayout = mView.findViewById(R.id.tab_layout);
        addTab();
        return mView;
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void addTab() {
        FragmentManager manager = getFragmentManager();
        adapter = new ViewpagerAdapter(manager);
        adapter.addFragment(new IntroduceFragment(mTruyen), "Giới Thiệu");
        adapter.addFragment(new ChapterFragment(mTruyen), "Chương");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
