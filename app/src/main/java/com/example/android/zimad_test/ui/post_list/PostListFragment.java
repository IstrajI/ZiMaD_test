package com.example.android.zimad_test.ui.post_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.zimad_test.MyApplication;
import com.example.android.zimad_test.R;
import com.example.android.zimad_test.data.entities.Model;
import com.example.android.zimad_test.di.DaggerApplicationComponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.zimad_test.ui.post_list.PostListFragment.ListMode.CATS_MODE;
import static com.example.android.zimad_test.ui.post_list.PostListFragment.ListMode.DOGS_MODE;

public class PostListFragment extends Fragment implements PostListView {
    @BindView(R.id.list)
    RecyclerView listRecyclerView;

    private PostAdapter postAdapter;
    private PostListPresenter postListPresenter;

    @Nullable
    @Override
    public View onCreateView(final @NonNull LayoutInflater inflater, final @Nullable ViewGroup container, final @Nullable Bundle savedInstanceState) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        postListPresenter = MyApplication.getComponent().getPostListPresenter();
        return view;
    }

    @Override
    public void onViewCreated(final @NonNull View view, final @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postAdapter = new PostAdapter();
        postAdapter.setOnPostClickListener((OnPostClickListener) getActivity());
        listRecyclerView.setAdapter(postAdapter);
        postListPresenter.setPostListView(this);

        postListPresenter.loadPosts(getArguments().getInt(LIST_MODE_KEY, 0));
    }

    @Override
    public void showList(final List<Model> posts) {
        postAdapter.updateItems(posts);
    }

    @Override
    public void showError(final String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_LONG).show();
    }

    private final static String LIST_MODE_KEY = "LIST_MODE_KEY";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({CATS_MODE, DOGS_MODE})
    public @interface ListMode {
        int CATS_MODE = 0;
        int DOGS_MODE = 1;
    }

    public static Fragment createPostListFragment(final @ListMode int mode) {
        final Fragment postListFragment = new PostListFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt(LIST_MODE_KEY, mode);
        postListFragment.setArguments(bundle);
        return postListFragment;
    }
}
