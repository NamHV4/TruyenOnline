package com.codedao.truyenonline.view.fragment;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryChapterFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private View mView;
    public static ViewpagerAdapter adapter;

    public StoryChapterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_chuong, container, false);
        mViewPager = mView.findViewById(R.id.view_pager);
        mTabLayout = mView.findViewById(R.id.tab_layout);
        return mView;
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    @Override
    public void onResume() {
        addTab();
        super.onResume();
    }

    private void addTab() {
        FragmentManager manager = getFragmentManager();
        adapter = new ViewpagerAdapter(manager);
        adapter.addFragment(new IntroduceFragment(), "Giới Thiệu");
        adapter.addFragment(new ChapterFragment(), "Chương");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
