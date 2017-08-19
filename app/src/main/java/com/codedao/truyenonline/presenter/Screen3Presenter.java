package com.codedao.truyenonline.presenter;

import android.content.Context;
import android.widget.Toast;

import com.codedao.truyenonline.adapter.TruyenAdapter;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUNG-PTIT on 19/08/2017.
 */

public class Screen3Presenter implements TruyenAdapter.IOnItemTruyenListener {
    private TruyenAdapter mTruyenAdapter;
    private List<Truyen> mTruyens;
    private Context mContext;

    public Screen3Presenter(Context context) {
        this.mContext = context;
        init();
    }

    public TruyenAdapter getmTruyenAdapter() {
        return mTruyenAdapter;
    }

    public void init(){
        mTruyens = new ArrayList<>();
        Truyen truyen;
        for (int i = 1; i < 10; i++) {
            truyen = new Truyen();
            truyen.setmIdTruyen(i);
            truyen.setmTenTruyen("7 Chiến lược thịnh vượng");
            truyen.setmTacGia("Jim Rohn");
            truyen.setmSoLike(4500 + i);
            mTruyens.add(truyen);
        }

        mTruyenAdapter = new TruyenAdapter(mTruyens, mContext, this);
    }

    @Override
    public void onItemClick() {
        Toast.makeText(mContext, "Doc Truyen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOfflineClick() {
        Toast.makeText(mContext, "Da add offline", Toast.LENGTH_SHORT).show();
    }
}
