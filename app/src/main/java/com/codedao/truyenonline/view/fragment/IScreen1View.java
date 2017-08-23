package com.codedao.truyenonline.view.fragment;

import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.Type;

import java.util.List;

/**
 * Created by utnam on 8/23/2017.
 */

public interface IScreen1View {
    void setAdapterType(List<Type> type);
    void setAdapterIndex(List<Index> index);
}
