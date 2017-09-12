package com.codedao.truyenonline.presenter;

import com.codedao.truyenonline.model.ApiConnect;
import com.codedao.truyenonline.model.MessageEvent;
import com.codedao.truyenonline.view.fragment.IChapterFragmentView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.codedao.truyenonline.model.ApiConnect.GET_SUCCSES_LIST_CHAPTER;

/**
 * Created by utnam on 9/12/2017.
 */

public class ScreenChapterPresenterLogic implements IScreenChapterPresenterImp {
    private IChapterFragmentView mIChapterFragmentView;
    private ApiConnect mApiConnect;

    public ScreenChapterPresenterLogic(IChapterFragmentView mIChapterFragmentView) {
        this.mIChapterFragmentView = mIChapterFragmentView;
        EventBus.getDefault().register(this);
        mApiConnect = new ApiConnect();
    }

    @Override
    public void getListChapter(String id) {
        mApiConnect.getChapterByIdStory(id);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getmEvent()) {
            case GET_SUCCSES_LIST_CHAPTER:
                mIChapterFragmentView.setAdapterChapter(event.getmChapters());
                break;
            default:

        }
    }
}
