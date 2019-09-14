package com.example.android.zimad_test.ui.post_list;

import com.example.android.zimad_test.data.entities.Model;

import java.util.List;

public interface PostListView {
    void showList(List<Model> posts);
    void showError(String errorMsg);
}
