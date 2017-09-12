package com.codedao.truyenonline.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.HorizontalAdapter;
import com.codedao.truyenonline.adapter.IndexAdapter;
import com.codedao.truyenonline.adapter.ViewpagerAdapter;
import com.codedao.truyenonline.base.BaseFragment;
import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.model.Type;
import com.codedao.truyenonline.presenter.Screen1PresenterLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen1Fragment extends BaseFragment implements HorizontalAdapter.IOnItemClickListener
        , IndexAdapter.IOnItemClickListener, IScreen1View {

    private RecyclerView mRecyclerView;
    private HorizontalAdapter mHorizontalAdapter;
    private RecyclerView mRecyclerViewIndex;
    private IndexAdapter mIndexAdapter;
    private ArrayList<Index> mIndexArrayListl;
    private Screen1PresenterLogic mScreen1PresenterLogic;
    private ViewpagerAdapter mViewpagerAdapter;


    public Screen1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view);
        mScreen1PresenterLogic = new Screen1PresenterLogic(this);
        mScreen1PresenterLogic.getListType();
        mScreen1PresenterLogic.getListStoryIndex();


        return view;
    }


    private void initView(View view) {
        mRecyclerViewIndex = view.findViewById(R.id.rcIndex);
        mRecyclerView = view.findViewById(R.id.rcView);
    }

    @Override
    public void onClick(int position) {
        transitFragment(new Screen3Fragment(getContext(), 1));
    }

    @Override
    public void onClickItem(int position) {
        transitFragment(new Screen2Fragment());
    }

    @Override
    public void onClickavata(Truyen truyen) {
        if (Integer.parseInt(truyen.getmSoChuong()) == 0) {
            transitFragment(new ReaderFragment(truyen));
        } else {
            transitFragment(new StoryChapterFragment(truyen));
        }
    }


    @Override
    public void setAdapterType(List<Type> type) {

        mHorizontalAdapter = new HorizontalAdapter(type, Screen1Fragment.this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        mRecyclerView.setAdapter(mHorizontalAdapter);
    }

    @Override
    public void setAdapterIndex(List<Index> index) {

        mIndexAdapter = new IndexAdapter(index, getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerViewIndex.setLayoutManager(linearLayoutManager);
        mRecyclerViewIndex.setAdapter(mIndexAdapter);
    }
}
