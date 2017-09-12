package com.codedao.truyenonline.model;

import android.support.annotation.NonNull;

import com.codedao.truyenonline.rest.ApiClient;
import com.codedao.truyenonline.rest.ApiInterface;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MinhQuang on 8/19/2017.
 */

public class ApiConnect {
    public static final String GET_SUCCSES_LIST_TYPE = "GET_SUCCSES_LIST_TYPE";
    public static final String GET_SUCCSES_LIST_STORY = "GET_SUCCSES_LIST_STORY";
    public static final String GET_SUCCSES_LIST_STORY_TOPLIKE = "GET_SUCCSES_LIST_STORY_TOPLIKE";
    public static final String GET_SUCCSES_LIST_STORY_TOPVIEW = "GET_SUCCSES_LIST_STORY_TOPVIEW";
    public static final String GET_SUCCSES_LIST_STORY_BYTYPE = "GET_SUCCSES_LIST_STORY_BYTYPE";
    ApiInterface mApi =
            ApiClient.getClient().create(ApiInterface.class);


    public void getAllTitleStory() {


        Call<StoryResponse> call = mApi.getAllTitle();
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    List<Truyen> truyenList = response.body().getmTruyenList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTruyens(truyenList);
                    messageEvent.setmEvent("GET_SUCCSESS_LIST");
                    EventBus.getDefault().post(messageEvent);
                } else {
                    getAllTitleStory();
                }
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    public void getAllType() {

        Call<TypeResponse> call = mApi.getAllType();
        call.enqueue(new Callback<TypeResponse>() {
            @Override
            public void onResponse(@NonNull Call<TypeResponse> call, @NonNull Response<TypeResponse> response) {
                if (response.isSuccessful()) {
                    List<Type> typeList = response.body().getmTypeList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTypeList(typeList);
                    messageEvent.setmEvent(GET_SUCCSES_LIST_TYPE);
                    EventBus.getDefault().post(messageEvent);
                } else {
                    getAllType();
                }

            }

            @Override
            public void onFailure(Call<TypeResponse> call, Throwable t) {

            }
        });

    }

    public void getTopNewStory(final int limit) {

        Call<StoryResponse> call = mApi.getTopNew(limit);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    List<Truyen> storyList = response.body().getmTruyenList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTruyens(storyList);
                    messageEvent.setmEvent(GET_SUCCSES_LIST_STORY);
                    EventBus.getDefault().post(messageEvent);

                } else {
                    getTopNewStory(limit);
                }
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {

            }
        });

    }

    public void getTopLikeStory(final int limit) {

        Call<StoryResponse> call = mApi.getTopLike(limit);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    List<Truyen> storyList = response.body().getmTruyenList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTruyens(storyList);
                    messageEvent.setmEvent(GET_SUCCSES_LIST_STORY_TOPLIKE);
                    EventBus.getDefault().post(messageEvent);
                } else {
                    getTopLikeStory(limit);
                }
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {

            }
        });

    }

    public void getTopViewStory(final int limit) {

        Call<StoryResponse> call = mApi.getTopView(limit);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    List<Truyen> storyList = response.body().getmTruyenList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTruyens(storyList);
                    messageEvent.setmEvent(GET_SUCCSES_LIST_STORY_TOPVIEW);
                    EventBus.getDefault().post(messageEvent);
                } else {
                    getTopViewStory(limit);
                }

            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {

            }
        });

    }

    public void getStoryByType(final String idtl) {

        Call<StoryResponse> call = mApi.getTruyenTL(idtl);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    List<Truyen> storyList = response.body().getmTruyenList();
                    MessageEvent messageEvent = new MessageEvent();
                    messageEvent.setmTruyens(storyList);
                    messageEvent.setmEvent(GET_SUCCSES_LIST_STORY_BYTYPE);
                    EventBus.getDefault().post(messageEvent);
                } else {
                    getStoryByType(idtl);
                }

            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {

            }
        });

    }
}
