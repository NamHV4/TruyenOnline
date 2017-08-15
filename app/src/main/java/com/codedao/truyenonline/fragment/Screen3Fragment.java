package com.codedao.truyenonline.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.TruyenAdapter;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen3Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TruyenAdapter mTruyenAdapter;
    private List<Truyen> mTruyens;


    public Screen3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen3, container, false);
        mRecyclerView = view.findViewById(R.id.rv_items_truyen);
        mTruyens = new ArrayList<>();
        Truyen truyen;
        for (int i = 1; i < 10; i++) {
            truyen = new Truyen();
            truyen.setmIdTruyen(i);
            truyen.setmTenTruyen("7 Chiến lược thịnh vượng");
            truyen.setmTacGia("Jim Rohn");
            truyen.setmSoLike(4500 + i);
            mTruyens.add(truyen);
        }

        mTruyenAdapter = new TruyenAdapter(mTruyens, getContext());
        mRecyclerView.setAdapter(mTruyenAdapter);

        //RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

}
