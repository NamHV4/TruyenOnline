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
import com.codedao.truyenonline.adapter.IndexAdapter;
import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment implements HorizontalAdapter.IOnItemClickListener,IndexAdapter.IOnItemClickListener {

    private RecyclerView mRecyclerView;
    private HorizontalAdapter horizontalAdapter;
    private ArrayList<String> horizontalList;
    private RecyclerView mRecyclerViewIndex;
    private IndexAdapter mIndexAdapter;
    private ArrayList<Index> mIndexArrayListl;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);


        mRecyclerViewIndex = view.findViewById(R.id.rcIndex);
        mRecyclerView = view.findViewById(R.id.rcView);
        horizontalList = new ArrayList<>();
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
        horizontalAdapter = new HorizontalAdapter(horizontalList, this);


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        mRecyclerView.setAdapter(horizontalAdapter);


        mIndexArrayListl = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            mIndexArrayListl.add(new Index("Truỵện mới nhất", listtruen()));
        }
        mIndexAdapter=new IndexAdapter(mIndexArrayListl,getContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerViewIndex.setLayoutManager(linearLayoutManager);
        mRecyclerViewIndex.setAdapter(mIndexAdapter);


        return view;
    }




    @Override
    public void onClick(int position) {
        transitScreen(new Screen3Fragment(getContext()));
    }

    private ArrayList<Truyen> listtruen() {
        ArrayList<Truyen> truyens = new ArrayList<>();
        Truyen truyen = new Truyen();
        truyen.setmTenTruyen("Hen Tai");
        truyen.setmAvatar(R.drawable.avata);
        for (int i = 0; i <= 100; i++) {
            truyens.add(truyen);
        }
        return truyens;
    }

    @Override
    public void onClickItem(int position) {
       transitScreen(new Screen2Fragment());
    }

    private void transitScreen(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.conten, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
