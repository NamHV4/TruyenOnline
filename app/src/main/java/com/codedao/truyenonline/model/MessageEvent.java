package com.codedao.truyenonline.model;

import java.util.List;

/**
 * Created by utnam on 8/21/2017.
 */

public class MessageEvent {
    private String mEvent;
    private List<Truyen> mTruyens;
    private List<Type> mTypeList;

    public List<Type> getmTypeList() {
        return mTypeList;
    }

    public void setmTypeList(List<Type> mTypeList) {
        this.mTypeList = mTypeList;
    }

    public List<Truyen> getmTruyens() {
        return mTruyens;
    }

    public void setmTruyens(List<Truyen> mTruyens) {
        this.mTruyens = mTruyens;
    }

    public String getmEvent() {
        return mEvent;
    }

    public void setmEvent(String mEvent) {
        this.mEvent = mEvent;
    }
}
