package com.example.android.zimad_test.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.android.zimad_test.MyApplication;
import com.example.android.zimad_test.R;
import com.example.android.zimad_test.data.entities.Model;
import com.example.android.zimad_test.di.DaggerApplicationComponent;
import com.example.android.zimad_test.ui.post_list.OnPostClickListener;
import com.example.android.zimad_test.ui.post_details.PostDetailsActivity;
import com.example.android.zimad_test.ui.post_list.PostListFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnPostClickListener, MainActivityView {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    MainActivityPresenter mainActivityPresenter;

    private Fragment dogsListFragment;
    private Fragment catsListFragment;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityPresenter = MyApplication.getComponent().getMainActivityPresenter();
        mainActivityPresenter.setMainActivityView(this);

        final TabLayout.Tab catsTab = tabLayout.newTab().setText("Cats");
        final TabLayout.Tab dogsTab = tabLayout.newTab().setText("Dogs");

        tabLayout.addTab(catsTab);
        tabLayout.addTab(dogsTab);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                mainActivityPresenter.tabSelected(tab.getPosition());
            }

            @Override
            public void onTabUnselected(final TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(final TabLayout.Tab tab) {

            }
        });

        catsTab.select();
        mainActivityPresenter.tabSelected(0);
    }

    @Override
    public void onPostClicked(final Model model) {
        PostDetailsActivity.startDetailsFragmentInstance(this, model.getUrl(), 0, model.getTitle());
    }

    @Override
    public void showDogsPostListFragment() {
        if (dogsListFragment == null) {
            dogsListFragment = PostListFragment.createPostListFragment(PostListFragment.ListMode.DOGS_MODE);
        }

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.post_list_fragment_container, dogsListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showCatsPostListFragment() {
        if (catsListFragment == null) {
            catsListFragment = PostListFragment.createPostListFragment(PostListFragment.ListMode.CATS_MODE);
        }

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.post_list_fragment_container, catsListFragment);
        fragmentTransaction.commit();
    }
}
