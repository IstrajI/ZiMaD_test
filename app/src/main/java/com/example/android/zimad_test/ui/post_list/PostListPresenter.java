package com.example.android.zimad_test.ui.post_list;

import androidx.lifecycle.ViewModel;

import com.example.android.zimad_test.data.KotApiRepository;
import com.example.android.zimad_test.data.entities.Response;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostListPresenter {
    PostListView postListView;
    KotApiRepository kotApiRepository;
    PostListViewModel postListViewModel;

    @Inject
    PostListPresenter(KotApiRepository kotApiRepository) {
        this.kotApiRepository = kotApiRepository;
    }

    public void setPostListView(final PostListView postListView) {
        this.postListView = postListView;
    }

    public void setViewModel(final PostListViewModel viewModel) {
        postListViewModel = viewModel;
    }

    public void loadPosts(final @PostListFragment.ListMode int mode) {
        if (!postListViewModel.getDogsModel().isEmpty()) {
            postListView.showList(postListViewModel.getDogsModel());
        } else {
            final Observable<Response> apiResponse = (mode == PostListFragment.ListMode.CATS_MODE) ?
                    kotApiRepository.getCatPosts() : kotApiRepository.getDogPosts();

            apiResponse
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        postListView.showList(response.getData());
                        postListViewModel.setDogsModel(response.getData());
                    }, throwable -> {
                        postListView.showError(throwable.getMessage());
                    });
        }
    }
}
