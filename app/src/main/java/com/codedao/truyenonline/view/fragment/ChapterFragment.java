package com.codedao.truyenonline.view.fragment;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChapterFragment extends Fragment {

    private RecyclerView mRecyclerView;
    List<Chapter> chapters;
    public ChapterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("NamHV1","onCreateView");
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        mRecyclerView=view.findViewById(R.id.rcListStory);
        fakedata();
        ChapterAdapter chapterAdapter = new ChapterAdapter(chapters);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(chapterAdapter);
        return view;
    }

    @Override
    public void onStart() {
        Log.d("NamHV1","onStart");
        super.onStart();
    }


    @Override
    public void onPause() {
        Log.d("NamHV1","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("NamHV1","onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("NamHV1","onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("NamHV1","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("NamHV1","onDetach");
        super.onDetach();
    }

    @Override
    public void onResume() {
        Log.d("NamHV1","onResume");
        super.onResume();
    }

    private void fakedata() {
        chapters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            chapters.add(new Chapter("1", "1", "Truyen" + i, "noidung"));
        }

    }


}
