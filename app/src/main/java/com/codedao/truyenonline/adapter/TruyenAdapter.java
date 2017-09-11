package com.codedao.truyenonline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Truyen;

import java.util.List;


/**
 * Created by DUNG-PTIT on 14/08/2017.
 */

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.TruyenViewHolder> {
    private List<Truyen> mTruyens;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private IOnItemAdapterTruyenListener mIOnItemAdapterTruyenListener;

    public TruyenAdapter(List<Truyen> mTruyens, Context mContext, IOnItemAdapterTruyenListener iOnItemAdapterTruyenListener) {
        this.mTruyens = mTruyens;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        mIOnItemAdapterTruyenListener = iOnItemAdapterTruyenListener;
    }

    @Override
    public TruyenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_item_screen3,parent, false);
        return new TruyenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TruyenViewHolder holder, final int position) {
        Truyen truyen = mTruyens.get(position);

        holder.tvIdTruyen.setText(String.valueOf(truyen.getmIdTruyen()));
        holder.tvTenTruyen.setText(truyen.getmTenTruyen());
        holder.tvSoLike.setText(String.valueOf(truyen.getmSoLike()));
        holder.tvTacGia.setText(truyen.getmTacGia());
        holder.ivAvatar.setImageResource(R.drawable.icon_truyen);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIOnItemAdapterTruyenListener.onItemAdapterClick(position);
            }
        });
        holder.imgAddOffine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIOnItemAdapterTruyenListener.onOfflineAdapterClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTruyens.size();
    }

    public class TruyenViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdTruyen;
        private ImageView ivAvatar;
        private TextView tvTenTruyen;
        private TextView tvTacGia;
        private TextView tvSoLike;
        private LinearLayout linearLayout;
        private ImageView imgAddOffine;


        public TruyenViewHolder(View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linear_screen3);
            tvIdTruyen = itemView.findViewById(R.id.tv_id_truyen);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTenTruyen = itemView.findViewById(R.id.tv_ten_truyen);
            tvTacGia = itemView.findViewById(R.id.tv_tac_gia);
            tvSoLike = itemView.findViewById(R.id.tv_so_like);
            imgAddOffine = itemView.findViewById(R.id.img_add_offline);
        }
    }

    public Truyen getItemById(int position){
        Truyen truyen = mTruyens.get(position);
        return truyen;
    }
    public interface IOnItemAdapterTruyenListener {

        public void onItemAdapterClick(int position);
        public void onOfflineAdapterClick(int position);
    }


}
