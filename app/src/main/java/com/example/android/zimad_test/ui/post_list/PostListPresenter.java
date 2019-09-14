package com.example.android.zimad_test.ui.post_list;

import com.example.android.zimad_test.data.KotApiRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostListPresenter {
    PostListView postListView;
    KotApiRepository kotApiRepository;

    @Inject
    PostListPresenter(KotApiRepository kotApiRepository) {
        this.kotApiRepository = kotApiRepository;
    }

    public void setPostListView(final PostListView postListView) {
        this.postListView = postListView;
    }

    public void loadPosts() {
        kotApiRepository.getCatPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(response -> {
                postListView.showList(response.getData());
            }, throwable -> {
                postListView.showError(throwable.getMessage());
            });

    }
}
