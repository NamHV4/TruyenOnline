package com.codedao.truyenonline.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utnam on 8/17/2017.
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.MyViewHolder> implements SubIndexAdapter.IClickAvata {

    private Context mContext;
    private List<Index> mIndexList;
    private SubIndexAdapter mSuggestionAdapter;
    private IndexAdapter.IOnItemClickListener mIOnItemClickListener;

    public IndexAdapter(List<Index> mIndexList, Context context, IOnItemClickListener iOnItemClickListener) {
        this.mIndexList = mIndexList;
        this.mContext = context;
        this.mIOnItemClickListener = iOnItemClickListener;
    }

    @Override
    public void onclickAvt(Truyen truyen) {
        mIOnItemClickListener.onClickavata(truyen);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public TextView txtMore;
        public RecyclerView rcView;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            rcView = itemView.findViewById(R.id.rcItem);
            txtMore = itemView.findViewById(R.id.txtMore);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rc_conten, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Index index = mIndexList.get(position);
        mSuggestionAdapter = new SubIndexAdapter((ArrayList<Truyen>) index.getmTruyens(), this.mContext, this);
        holder.txtTitle.setText(index.getmTitle());
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this.mContext,
                LinearLayoutManager.HORIZONTAL, false);
        holder.rcView.setLayoutManager(linearLayoutManager);
        holder.rcView.setAdapter(mSuggestionAdapter);
        holder.txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIOnItemClickListener.onClickItem(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mIndexList.size();
    }

    public interface IOnItemClickListener {

        void onClickItem(int position);

        void onClickavata(Truyen truyen);
    }

}
