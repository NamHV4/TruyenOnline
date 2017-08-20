package com.codedao.truyenonline.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by utnam on 8/20/2017.
 */

public class TypeResponse {
    @SerializedName("theloai")
    private List<Type> mTypeList;

    public List<Type> getmTypeList() {
        return mTypeList;
    }

    public void setmTypeList(List<Type> mTypeList) {
        this.mTypeList = mTypeList;
    }
}
