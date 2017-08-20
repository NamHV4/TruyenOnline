package com.codedao.truyenonline.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by utnam on 8/20/2017.
 */

public class StoryResponse {

    @SerializedName("truyen")
    private List<Truyen> mTruyenList;
    public List<Truyen> getmTruyenList() {
        return mTruyenList;
    }

    public void setmTruyenList(List<Truyen> mTruyenList) {
        this.mTruyenList = mTruyenList;
    }
}
