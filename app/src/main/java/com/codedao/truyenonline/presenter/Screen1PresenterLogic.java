package com.codedao.truyenonline.presenter;

import android.util.Log;

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
import static com.codedao.truyenonline.model.ApiConnect.GET_SUCCSES_LIST_STORY_TOPLIKE;
import static com.codedao.truyenonline.model.ApiConnect.GET_SUCCSES_LIST_STORY_TOPVIEW;
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
    public void getListStoryIndex() {
        mApiConnect.getTopNewStory();
        mApiConnect.getTopLikeStory();
        mApiConnect.getTopViewStory();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getmEvent()) {
            case GET_SUCCSES_LIST_TYPE:
                mIScreen1View.setAdapterType(event.getmTypeList());
                break;
            case GET_SUCCSES_LIST_STORY:
                list.add(new Index("Truyện Mới Nhất", event.getmTruyens()));
                Log.d("NamHV4","GET_SUCCSES_LIST_STORY");
                if (list.size() >= 3) {
                    Log.d("NamHV4","GET_SUCCSES_LIST_STORY_OK_LIST");
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmEvent("OK_LIST");
                    mEventBus.post(messageEvent);
                }
                break;
            case GET_SUCCSES_LIST_STORY_TOPLIKE:
                list.add(new Index("Truyện Nhiều Lượt Like", event.getmTruyens()));
                Log.d("NamHV4","GET_SUCCSES_LIST_STORY_TOPLIKE");
                if (list.size() >= 3) {
                    Log.d("NamHV4","GET_SUCCSES_LIST_STORY_TOPLIKE_OK_LIST");
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmEvent("OK_LIST");
                    mEventBus.post(messageEvent);
                }
                break;
            case GET_SUCCSES_LIST_STORY_TOPVIEW:
                list.add(new Index("Truyện Nhiều Lượt Xem", event.getmTruyens()));
                Log.d("NamHV4","GET_SUCCSES_LIST_STORY_TOPVIEW");
                if (list.size() >= 3) {
                    Log.d("NamHV4","GET_SUCCSES_LIST_STORY_TOPVIEW_OK_LIST");
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmEvent("OK_LIST");
                    mEventBus.post(messageEvent);
                }
                break;
            case "OK_LIST":
                mIScreen1View.setAdapterIndex(list);
            default:
                break;
        }
    }

}
