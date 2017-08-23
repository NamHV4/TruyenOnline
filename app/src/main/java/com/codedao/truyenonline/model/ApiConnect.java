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
    public static final String GET_SUCCSES_LIST_TYPE="GET_SUCCSES_LIST_TYPE";
    public static final String GET_SUCCSES_LIST_STORY="GET_SUCCSES_LIST_STORY";
    ApiInterface mApi =
            ApiClient.getClient().create(ApiInterface.class);

    public void getAllTitleStory() {


        Call<StoryResponse> call = mApi.getAllTitle();
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
               List<Truyen> truyenList = response.body().getmTruyenList();
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setmTruyens(truyenList);
                messageEvent.setmEvent("GET_SUCCSESS_LIST");
                EventBus.getDefault().post(messageEvent);
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
            public void onResponse(Call<TypeResponse> call, Response<TypeResponse> response) {
                List<Type> typeList = response.body().getmTypeList();
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setmTypeList(typeList);
                messageEvent.setmEvent(GET_SUCCSES_LIST_TYPE);
                EventBus.getDefault().post(messageEvent);

            }

            @Override
            public void onFailure(Call<TypeResponse> call, Throwable t) {

            }
        });

    }

    public void getTopNewStory() {

        Call<StoryResponse> call = mApi.getTopNew();
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                List<Truyen> storyList = response.body().getmTruyenList();
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setmTruyens(storyList);
                messageEvent.setmEvent(GET_SUCCSES_LIST_STORY);
                EventBus.getDefault().post(messageEvent);

            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {

            }
        });

    }
}
