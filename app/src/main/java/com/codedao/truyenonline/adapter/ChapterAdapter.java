package com.codedao.truyenonline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Chapter;

import java.util.List;

/**
 * Created by utnam on 9/11/2017.
 */

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {

    private List<Chapter> mChapterList;


    public ChapterAdapter(List<Chapter> mIndexList) {
        this.mChapterList = mIndexList;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitleChapter);

        }
    }

    @Override
    public ChapterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chapter, parent, false);
        return new ChapterAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChapterAdapter.MyViewHolder holder, final int position) {
        Chapter index = mChapterList.get(position);
        holder.txtTitle.setText(index.getmTenC());


    }

    @Override
    public int getItemCount() {
        return mChapterList != null ? mChapterList.size() : 0;
    }
}
