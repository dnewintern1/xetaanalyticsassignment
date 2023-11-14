package com.base.xetaanalyticsassignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("homepage_v2")
    Call<Post> getposts();

}
