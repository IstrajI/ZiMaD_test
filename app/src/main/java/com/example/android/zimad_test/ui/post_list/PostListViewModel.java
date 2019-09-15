package com.example.android.zimad_test.ui.post_list;

import androidx.lifecycle.ViewModel;

import com.example.android.zimad_test.data.entities.Model;

import java.util.ArrayList;
import java.util.List;

public class PostListViewModel extends ViewModel {
    private List<Model> model = new ArrayList<>();

    public List<Model> getDogsModel() {
        return model;
    }

    public void setDogsModel(final List<Model> dogsModel) {
        this.model = dogsModel;
    }
}
