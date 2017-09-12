package com.codedao.truyenonline.rest;

import com.codedao.truyenonline.model.ChapterResponse;
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

    @GET("get_all_title.php")
    Call<StoryResponse> getAllTitle();

    @GET("get_all_theloai.php")
    Call<TypeResponse> getAllType();

    @GET("get_truyen_new.php")
    Call<StoryResponse> getTopNew(@Query("limit") int limit);

    @GET("get_truyen_toplike.php")
    Call<StoryResponse> getTopLike(@Query("limit") int limit);

    @GET("get_truyen_topview.php")
    Call<StoryResponse> getTopView(@Query("limit") int limit);

    @GET("get_chuong.php")
    Call<ChapterResponse> getChapterByIdStory(@Query("IdTruyen") String id);
}
