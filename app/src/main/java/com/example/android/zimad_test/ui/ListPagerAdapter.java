package com.example.android.zimad_test.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android.zimad_test.ui.post_list.PostListFragment;

import java.util.ArrayList;
import java.util.List;

public class ListPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> postLists;

    ListPagerAdapter(final @NonNull FragmentManager fm, final int behavior) {
        super(fm, behavior);
        postLists = new ArrayList<>();
        postLists.add(PostListFragment.createPostListFragment(PostListFragment.ListMode.CATS_MODE));
        postLists.add(PostListFragment.createPostListFragment(PostListFragment.ListMode.DOGS_MODE));
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return postLists.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case 0:
                return "Cats";
            case 1:
                return "Dogs";
            default:
                return "None";
        }
    }

    @Override
    public int getCount() {
        return postLists.size();
    }
}
