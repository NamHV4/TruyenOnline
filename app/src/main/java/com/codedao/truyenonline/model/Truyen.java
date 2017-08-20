package com.codedao.truyenonline.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by utnam on 7/28/2017.
 */

public class Truyen {

    @SerializedName("IDT")
    private String mIdTruyen;
    @SerializedName("Tentruyen")
    private String mTenTruyen;
    @SerializedName("Tacgia")
    private String mTacGia;
    @SerializedName("IdTL")
    private String mIdTheLoai;
    @SerializedName("Ngay")
    private String mNgay;
    @SerializedName("Noidung")
    private String mNoiDung;
    @SerializedName("Sochuong")
    private String mSoChuong;
    @SerializedName("Likecout")
    private String mSoLike;
    @SerializedName("Luotxem")
    private String mLuotXem;
    @SerializedName("Avatar")
    private String mAvatar;
    @SerializedName("Danhdau")
    private String mDanhGiau;

    public void trace(){
        Log.e("TAG", "id: " + mIdTruyen +"\nname: " + mTenTruyen +"\navatar: " + mAvatar);
    }

    public String getmIdTruyen() {
        return mIdTruyen;
    }

    public void setmIdTruyen(String mIdTruyen) {
        this.mIdTruyen = mIdTruyen;
    }

    public String getmTenTruyen() {
        return mTenTruyen;
    }

    public void setmTenTruyen(String mTenTruyen) {
        this.mTenTruyen = mTenTruyen;
    }

    public String getmTacGia() {
        return mTacGia;
    }

    public void setmTacGia(String mTacGia) {
        this.mTacGia = mTacGia;
    }

    public String getmIdTheLoai() {
        return mIdTheLoai;
    }

    public void setmIdTheLoai(String mIdTheLoai) {
        this.mIdTheLoai = mIdTheLoai;
    }

    public String getmNgay() {
        return mNgay;
    }

    public void setmNgay(String mNgay) {
        this.mNgay = mNgay;
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }

    public String getmSoChuong() {
        return mSoChuong;
    }

    public void setmSoChuong(String mSoChuong) {
        this.mSoChuong = mSoChuong;
    }

    public String getmSoLike() {
        return mSoLike;
    }

    public void setmSoLike(String mSoLike) {
        this.mSoLike = mSoLike;
    }

    public String getmLuotXem() {
        return mLuotXem;
    }

    public void setmLuotXem(String mLuotXem) {
        this.mLuotXem = mLuotXem;
    }

    public String getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmDanhGiau() {
        return mDanhGiau;
    }

    public void setmDanhGiau(String mDanhGiau) {
        this.mDanhGiau = mDanhGiau;
    }
}
