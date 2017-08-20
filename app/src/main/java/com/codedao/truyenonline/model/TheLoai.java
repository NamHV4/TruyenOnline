package com.codedao.truyenonline.model;

/**
 * Created by DUNG-PTIT on 20/08/2017.
 */

public class TheLoai {
    private int mIdTheLoai;
    private String mTenTheLoai;

    public TheLoai() {
    }

    public TheLoai(int mIdTheLoai, String mTenTheLoai) {
        this.mIdTheLoai = mIdTheLoai;
        this.mTenTheLoai = mTenTheLoai;
    }

    public int getmIdTheLoai() {
        return mIdTheLoai;
    }

    public void setmIdTheLoai(int mIdTheLoai) {
        this.mIdTheLoai = mIdTheLoai;
    }

    public String getmTenTheLoai() {
        return mTenTheLoai;
    }

    public void setmTenTheLoai(String mTenTheLoai) {
        this.mTenTheLoai = mTenTheLoai;
    }
}
