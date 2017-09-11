package com.codedao.truyenonline.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by utnam on 9/11/2017.
 */

public class Chapter {

    @SerializedName("IDC")
    private String mIDC;
    @SerializedName("IdTruyen")
    private String mIdTruyen;
    @SerializedName("TenC")
    private String mTenC;
    @SerializedName("Noidung")
    private String mNoidung;

    public Chapter() {
    }

    public Chapter(String mIDC, String mIdTruyen, String mTenC, String mNoidung) {
        this.mIDC = mIDC;
        this.mIdTruyen = mIdTruyen;
        this.mTenC = mTenC;
        this.mNoidung = mNoidung;
    }

    public String getmIDC() {
        return mIDC;
    }

    public void setmIDC(String mIDC) {
        this.mIDC = mIDC;
    }

    public String getmIdTruyen() {
        return mIdTruyen;
    }

    public void setmIdTruyen(String mIdTruyen) {
        this.mIdTruyen = mIdTruyen;
    }

    public String getmTenC() {
        return mTenC;
    }

    public void setmTenC(String mTenC) {
        this.mTenC = mTenC;
    }

    public String getmNoidung() {
        return mNoidung;
    }

    public void setmNoidung(String mNoidung) {
        this.mNoidung = mNoidung;
    }
}
