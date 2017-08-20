package com.codedao.truyenonline.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by utnam on 8/20/2017.
 */

public class Type {

    @SerializedName("ID")
    private String ID;
    @SerializedName("TenTL")
    private String TenTL;

    public void trace(){
        Log.e("TAG", "id: " + ID +"\nname: " + TenTL);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }
}
