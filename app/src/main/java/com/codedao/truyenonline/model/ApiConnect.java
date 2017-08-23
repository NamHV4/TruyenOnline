package com.codedao.truyenonline.model;

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
    public static List<Truyen> truyenList;

    public void getAllTitleStory() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<StoryResponse> call = apiService.getAllTitle();
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                truyenList = response.body().getmTruyenList();
                MessageEvent messageEvent=new MessageEvent();
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
}
