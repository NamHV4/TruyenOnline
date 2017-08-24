package com.codedao.truyenonline.base;

import android.content.Context;
import android.util.AttributeSet;

import com.codedao.materialsearchview.MaterialSearchView;


/**
 * Created by utnam on 8/8/2017.
 */

public class BaseFragment extends MaterialSearchView {

    public BaseFragment(Context context) {
        super(context);
    }

    public BaseFragment(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFragment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
