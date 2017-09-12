package com.codedao.truyenonline.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.ChapterAdapter;
import com.codedao.truyenonline.model.Chapter;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.presenter.ScreenChapterPresenterLogic;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChapterFragment extends Fragment implements IChapterFragmentView {

    private RecyclerView mRecyclerView;
    private Truyen mTruyen;
    private ScreenChapterPresenterLogic mScreenChapterPresenterLogic;

    public ChapterFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ChapterFragment(Truyen truyen) {
        this.mTruyen = truyen;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("NamHV1", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        mScreenChapterPresenterLogic = new ScreenChapterPresenterLogic(this);
        mScreenChapterPresenterLogic.getListChapter(mTruyen.getmIdTruyen());
        mRecyclerView = view.findViewById(R.id.rcListStory);

        return view;
    }


    @Override
    public void setAdapterChapter(List<Chapter> chapterList) {
        ChapterAdapter chapterAdapter = new ChapterAdapter(chapterList);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(chapterAdapter);
    }
}