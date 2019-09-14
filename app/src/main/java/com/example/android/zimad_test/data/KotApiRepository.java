package com.example.android.zimad_test.data;

import com.example.android.zimad_test.data.entities.Response;


import javax.inject.Inject;

import io.reactivex.Observable;

public class KotApiRepository {
    private KotApi kotApi;

    @Inject
    KotApiRepository(final KotApi kotApi) {
        this.kotApi = kotApi;
    }

    public Observable<Response> getCatPosts() {
        return kotApi.getPetPosts("cat");
    }

    public Observable<Response> getDogPosts() {
        return kotApi.getPetPosts("dog");
    }
}
