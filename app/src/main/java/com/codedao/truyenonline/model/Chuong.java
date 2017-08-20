package com.codedao.truyenonline.model;

/**
 * Created by DUNG-PTIT on 20/08/2017.
 */

public class Chuong {

    private int mIdChuong;
    private int mIdTruyen;
    private String mNoiDung;

    public Chuong() {
    }

    public Chuong(int mIdChuong, int mIdTruyen, String mNoiDung) {
        this.mIdChuong = mIdChuong;
        this.mIdTruyen = mIdTruyen;
        this.mNoiDung = mNoiDung;
    }

    public int getmIdChuong() {
        return mIdChuong;
    }

    public void setmIdChuong(int mIdChuong) {
        this.mIdChuong = mIdChuong;
    }

    public int getmIdTruyen() {
        return mIdTruyen;
    }

    public void setmIdTruyen(int mIdTruyen) {
        this.mIdTruyen = mIdTruyen;
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }
}
