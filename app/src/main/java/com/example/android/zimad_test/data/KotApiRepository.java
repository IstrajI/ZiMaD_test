package com.example.android.zimad_test.data;

import com.example.android.zimad_test.data.entities.Response;


import javax.inject.Inject;

import io.reactivex.Observable;

public class KotApiRepository {
    private KotApi kotApi;

    private Observable<Response> catPosts;
    private Observable<Response> dogsPosts;

    @Inject
    KotApiRepository(final KotApi kotApi) {
        this.kotApi = kotApi;
    }

    public Observable<Response> getCatPosts() {
        if (catPosts == null) {
            catPosts = kotApi.getPetPosts("cat");
        }
        return catPosts;
    }

    public Observable<Response> getDogPosts()
    {
        if (dogsPosts == null) {
            dogsPosts = kotApi.getPetPosts("dog");
        }
        return dogsPosts;
    }
}
