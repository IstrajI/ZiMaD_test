package com.example.android.zimad_test.data;

import com.example.android.zimad_test.data.entities.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface KotApi {

    @GET("api.php?")
    Observable<Response> getPetPosts(@Query("query") String query);
}
