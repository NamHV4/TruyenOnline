package com.codedao.truyenonline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Truyen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Utnam on 8/16/2017.
 */

public class SubIndexAdapter extends RecyclerView.Adapter<SubIndexAdapter.SuggestionViewholder> {
    ArrayList<Truyen> suggestionList;
    Context context;
    LayoutInflater layoutInflater;
    IClickAvata mIClickAvata;

    public SubIndexAdapter(ArrayList<Truyen> suggestionList, Context context, IClickAvata iClickAvata) {
        this.suggestionList = suggestionList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.mIClickAvata = iClickAvata;
    }

    @Override
    public SubIndexAdapter.SuggestionViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_item_subindex, parent, false);
        return new SuggestionViewholder(view);
    }

    @Override
    public void onBindViewHolder(SubIndexAdapter.SuggestionViewholder holder, int position) {
        final Truyen truyen = suggestionList.get(position);

        holder.tvSoDiem.setText(truyen.getmSoLike());
        holder.tvTrangThai.setText(truyen.getmDanhGiau());
        holder.tvTenTruyen.setText(truyen.getmTenTruyen());
        Picasso.with(context).load(truyen.getmAvatar()).into(holder.imgAvatar);
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIClickAvata.onclickAvt(truyen);
            }
        });
    }

    @Override
    public int getItemCount() {
        return suggestionList.size();
    }

    public class SuggestionViewholder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvTenTruyen;
        private TextView tvSoDiem;
        private TextView tvTrangThai;

        public SuggestionViewholder(View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvTenTruyen = itemView.findViewById(R.id.tvName);
            tvSoDiem = itemView.findViewById(R.id.tvMark);
            tvTrangThai = itemView.findViewById(R.id.tvStatus);
        }
    }

    public interface IClickAvata {
        void onclickAvt(Truyen truyen);
    }

}

