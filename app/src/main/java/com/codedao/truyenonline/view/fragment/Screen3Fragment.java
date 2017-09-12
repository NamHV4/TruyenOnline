package com.codedao.truyenonline.view.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.TruyenAdapter;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.presenter.Screen3Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen3Fragment extends Fragment implements IScreen3View ,TruyenAdapter.IOnItemAdapterTruyenListener{

    private RecyclerView mRecyclerView;
    private Screen3Presenter mScreen3Presenter;
    private TruyenAdapter mTruyenAdapter;

    public Screen3Fragment() {
    }

    @SuppressLint("ValidFragment")
    public Screen3Fragment(Context context, int idTheLoai) {
        mScreen3Presenter = new Screen3Presenter(context, idTheLoai,  this);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen3, container, false);
        mRecyclerView = view.findViewById(R.id.rv_items_truyen);
        mTruyenAdapter = new TruyenAdapter(mScreen3Presenter.getmTruyens(), getContext(), this);
        mRecyclerView.setAdapter(mTruyenAdapter);

        //RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }


    @Override
    public void onDataStateChange() {
        mTruyenAdapter = new TruyenAdapter(mScreen3Presenter.getmTruyens(), getContext(), this);
        mRecyclerView.setAdapter(mTruyenAdapter);
    }

    @Override
    public void onItemAdapterClick(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Truyen truyen = mTruyenAdapter.getItemById(position);
        int sochương = Integer.parseInt(truyen.getmSoChuong());
        if(sochương>0){
            transitScreen(new StoryChapterFragment(truyen));
        }else {
            transitScreen(new ReaderFragment(truyen));
        }

    }

    private void transitScreen(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack("SSSS");
        fragmentTransaction.commit();
    }

    @Override
    public void onOfflineAdapterClick(int position) {
        Toast.makeText(getActivity(), "Dung "+position, Toast.LENGTH_SHORT).show();
    }
}
