package com.codedao.truyenonline.presenter;

import com.codedao.truyenonline.model.ApiConnect;
import com.codedao.truyenonline.model.Index;
import com.codedao.truyenonline.model.MessageEvent;
import com.codedao.truyenonline.view.fragment.IScreen1View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import static com.codedao.truyenonline.model.ApiConnect.GET_SUCCSES_LIST_STORY;
import static com.codedao.truyenonline.model.ApiConnect.GET_SUCCSES_LIST_TYPE;

/**
 * Created by utnam on 8/23/2017.
 */

public class Screen1PresenterLogic implements IScreen1PresenterImp {
    private IScreen1View mIScreen1View;
    private ApiConnect mApiConnect;
    private EventBus mEventBus;
    private List<Index> list = new ArrayList<>();
    //register EventBus


    public Screen1PresenterLogic(IScreen1View mIScreen1View) {
        this.mIScreen1View = mIScreen1View;
        mApiConnect = new ApiConnect();
        mEventBus = EventBus.getDefault();
        mEventBus.register(this);
    }

    @Override
    public void getListType() {
        mApiConnect.getAllType();
    }

    @Override
    public void getListStoryNew() {
        mApiConnect.getTopNewStory();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getmEvent()) {
            case GET_SUCCSES_LIST_TYPE:
                mIScreen1View.setAdapterType(event.getmTypeList());
                break;
            case GET_SUCCSES_LIST_STORY:
                list.add(new Index("Truyện Mới Nhất", event.getmTruyens()));
                break;
            default:
                break;
        }
    }

}
