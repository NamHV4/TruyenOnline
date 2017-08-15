package com.codedao.truyenonline.view.fragment;


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
import com.codedao.truyenonline.adapter.HorizontalAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment implements HorizontalAdapter.IOnItemClickListener {

    private RecyclerView mRecyclerView;
    private HorizontalAdapter horizontalAdapter;
    private ArrayList<String> horizontalList;
    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        mRecyclerView = view.findViewById(R.id.rcView);
        horizontalList=new ArrayList<>();
        horizontalList.add("TRUYỆN NGƯỜI LỚN");
        horizontalList.add("TRUYỆN TRANH");
        horizontalList.add("TRUYỆN NGÔN LÙ");
        horizontalList.add("ITEM 4");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("TRUYỆN DÂN GIAN");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("ITEM 5");
        horizontalList.add("TRUYỆN CƯỜI");
        horizontalList.add("ITEM 5");
        horizontalAdapter=new HorizontalAdapter(horizontalList, this);



        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManagaer);


        mRecyclerView.setAdapter(horizontalAdapter);
        return view;
    }


    @Override
    public void onClick(int position) {
        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.conten,new Screen3Fragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
