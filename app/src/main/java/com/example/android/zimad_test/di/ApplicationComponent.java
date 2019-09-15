package com.example.android.zimad_test.di;

import com.example.android.zimad_test.ui.post_list.PostListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiModule.class)
public interface ApplicationComponent {
    PostListPresenter getPostListPresenter();
}
