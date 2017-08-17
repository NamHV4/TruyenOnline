package com.codedao.truyenonline.model;

import java.util.List;

/**
 * Created by utnam on 8/17/2017.
 */

public class Index {
    private String mTitle;
    private List<Truyen> mTruyens;

    public Index(String mTitle, List<Truyen> mTruyens) {
        this.mTitle = mTitle;
        this.mTruyens = mTruyens;
    }

    public Index() {
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public List<Truyen> getmTruyens() {
        return mTruyens;
    }

    public void setmTruyens(List<Truyen> mTruyens) {
        this.mTruyens = mTruyens;
    }
}
