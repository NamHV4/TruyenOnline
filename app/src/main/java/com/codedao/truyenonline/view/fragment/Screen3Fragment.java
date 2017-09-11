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

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.presenter.Screen3Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen3Fragment extends Fragment implements IScreen3View{

    private RecyclerView mRecyclerView;
    private Screen3Presenter mScreen3Presenter;

    public Screen3Fragment() {
    }

    @SuppressLint("ValidFragment")
    public Screen3Fragment(Context context) {
        mScreen3Presenter = new Screen3Presenter(context, this);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen3, container, false);
        mRecyclerView = view.findViewById(R.id.rv_items_truyen);

        mRecyclerView.setAdapter(mScreen3Presenter.getmTruyenAdapter());

        //RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onItemClick(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Truyen truyen = mScreen3Presenter.getItemById(position);
        fragmentTransaction.replace(R.id.content, new ReaderFragment(truyen));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onOfflineClick(int position) {

    }
}
