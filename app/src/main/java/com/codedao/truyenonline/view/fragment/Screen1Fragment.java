package com.codedao.truyenonline.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.adapter.HorizontalAdapter;
import com.codedao.truyenonline.adapter.IndexAdapter;
import com.codedao.truyenonline.model.ApiConnect;
import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.MessageEvent;
import com.codedao.truyenonline.model.Truyen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen1Fragment extends Fragment implements HorizontalAdapter.IOnItemClickListener, IndexAdapter.IOnItemClickListener {

    private RecyclerView mRecyclerView;
    private HorizontalAdapter horizontalAdapter;
    private ArrayList<String> horizontalList;
    private RecyclerView mRecyclerViewIndex;
    private IndexAdapter mIndexAdapter;
    private ArrayList<Index> mIndexArrayListl;

    public Screen1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);


        mRecyclerViewIndex = view.findViewById(R.id.rcIndex);
        mRecyclerView = view.findViewById(R.id.rcView);


        mIndexArrayListl = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            mIndexArrayListl.add(new Index("Truỵện mới nhất", listtruen()));
        }
        mIndexAdapter = new IndexAdapter(mIndexArrayListl, getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerViewIndex.setLayoutManager(linearLayoutManager);
        mRecyclerViewIndex.setAdapter(mIndexAdapter);
        EventBus eventBus = EventBus.getDefault();
        eventBus.register(this);

        ApiConnect apiConnect = new ApiConnect();
        apiConnect.getAllTitleStory();



//        ApiInterface apiService =
//                ApiClient.getClient().create(ApiInterface.class);
//
//        Call<StoryResponse> call = apiService.getAllTitle();
//        call.enqueue(new Callback<StoryResponse>() {
//            @Override
//            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
//                List<Truyen> typeList = response.body().getmTruyenList();
//                for (Truyen truyen : typeList) {
//                   truyen.trace();
//                }
////                horizontalAdapter = new HorizontalAdapter(typeList, Screen1Fragment.this);
////
////                LinearLayoutManager horizontalLayoutManagaer
////                        = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
////                mRecyclerView.setLayoutManager(horizontalLayoutManagaer);
////                mRecyclerView.setAdapter(horizontalAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<StoryResponse> call, Throwable t) {
//                // Log error here since request failed
//                Log.e("NAMHV4", t.toString());
//            }
//        });

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
        truyen.setmAvatar("AAA");
        for (int i = 0; i <= 100; i++) {
            truyens.add(truyen);
        }
        return truyens;
    }

    @Override
    public void onClickItem(int position) {
        transitScreen(new Screen2Fragment());
    }

    private void transitScreen(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.conten, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.getmEvent().equals("GET_SUCCSESS_LIST")) {
            Log.d("onMessageEvent", "Size" + event.getmTruyens().size());
        }
    }
};
