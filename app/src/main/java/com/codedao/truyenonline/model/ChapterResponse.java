package com.codedao.truyenonline.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by utnam on 9/12/2017.
 */

public class ChapterResponse {
    @SerializedName("chapter")
    private List<Chapter> mChapters;

    public List<Chapter> getmChapters() {
        return mChapters;
    }

    public void setmChapters(List<Chapter> mChapters) {
        this.mChapters = mChapters;
    }
}
