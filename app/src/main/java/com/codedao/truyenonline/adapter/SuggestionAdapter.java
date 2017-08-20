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

import java.util.ArrayList;

/**
 * Created by MinhQuang on 8/16/2017.
 */

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.SuggestionViewholder> {
    ArrayList<Truyen> suggestionList;
    Context context;
    LayoutInflater layoutInflater;

    public SuggestionAdapter(ArrayList<Truyen> suggestionList, Context context) {
        this.suggestionList = suggestionList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public SuggestionAdapter.SuggestionViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_item_screen2,parent, false);
        return new SuggestionViewholder(view);
    }

    @Override
    public void onBindViewHolder(SuggestionAdapter.SuggestionViewholder holder, int position) {
        Truyen truyen = suggestionList.get(position);

        holder.tvSoDiem.setText(truyen.getmSoLike()+"");
        holder.tvTrangThai.setText(truyen.getmDanhGiau());
        holder.tvTenTruyen.setText(truyen.getmTenTruyen());
        holder.imgAvatar.setImageResource(R.drawable.avata);
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
            imgAvatar=itemView.findViewById(R.id.imgAvatar);
            tvTenTruyen=itemView.findViewById(R.id.tvName);
            tvSoDiem=itemView.findViewById(R.id.tvMark);
            tvTrangThai=itemView.findViewById(R.id.tvStatus);
        }
    }
}
