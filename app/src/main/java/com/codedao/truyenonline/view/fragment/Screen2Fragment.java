package com.codedao.truyenonline.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.SuggestionAdapter;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen2Fragment extends Fragment {
    RecyclerView rcvScreen2;
    ArrayList<Truyen> listSuggestion;
    SuggestionAdapter suggestionAdapter;

    public Screen2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_screen2,container,false);
        rcvScreen2=view.findViewById(R.id.rcvScreen2);
        listSuggestion=new ArrayList<>();
        for (int i=0;i<20;i++){
            Truyen truyen=new Truyen();
            truyen.setmTenTruyen("69 tư thế");
            truyen.setmSoLike("4");
            //truyen.setmTrangThai("free");
            listSuggestion.add(truyen);
        }

        suggestionAdapter=new SuggestionAdapter(listSuggestion,getContext());
        rcvScreen2.setAdapter(suggestionAdapter);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        rcvScreen2.setLayoutManager(layoutManager);
        return view;
    }

}
