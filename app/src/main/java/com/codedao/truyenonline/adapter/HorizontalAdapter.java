package com.codedao.truyenonline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Type;

import java.util.List;

/**
 * Created by utnam on 8/9/2017.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private IOnItemClickListener mIOnItemClickListener;
    private List<Type> mHorizontalList;


    public HorizontalAdapter(List<Type> horizontalList, IOnItemClickListener iOnItemClickListener) {
        this.mHorizontalList = horizontalList;
        this.mIOnItemClickListener = iOnItemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item_view, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mHorizontalList.get(position).getTenTL());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIOnItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHorizontalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtText);
            linearLayout = itemView.findViewById(R.id.linear_item);
        }
    }

    public interface IOnItemClickListener {

        public void onClick(int position);
    }
}
