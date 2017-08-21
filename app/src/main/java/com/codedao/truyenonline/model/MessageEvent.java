package com.codedao.truyenonline.model;

import java.util.List;

/**
 * Created by utnam on 8/21/2017.
 */

public class MessageEvent {
    public String mEvent;
    public List<Truyen> mTruyens;

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
