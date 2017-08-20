package com.codedao.truyenonline.rest;

import com.codedao.truyenonline.model.StoryResponse;
import com.codedao.truyenonline.model.TypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by utnam on 8/20/2017.
 */

public interface ApiInterface {
    @GET("get_truyen_tl.php")
    Call<StoryResponse> getTruyenTL(@Query("IdTL") String theloai);

    @GET("get_all_theloai.php")
    Call<TypeResponse> getAllType();
}