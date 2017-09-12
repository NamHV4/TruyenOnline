package com.codedao.truyenonline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.model.Chapter;

import java.util.List;

/**
 * Created by utnam on 9/11/2017.
 */

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {

    private List<Chapter> mChapterList;
    private IOnClickItemChapter mIOnClickItemChapter;


    public ChapterAdapter(List<Chapter> mIndexList, IOnClickItemChapter iOnClickItemChapter) {
        this.mChapterList = mIndexList;
        this.mIOnClickItemChapter = iOnClickItemChapter;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitleChapter);
            linearLayout = itemView.findViewById(R.id.layout);

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
        final Chapter chapter = mChapterList.get(position);
        holder.txtTitle.setText(chapter.getmTenC());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIOnClickItemChapter.onItemClickChapter(chapter);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mChapterList != null ? mChapterList.size() : 0;
    }
}

