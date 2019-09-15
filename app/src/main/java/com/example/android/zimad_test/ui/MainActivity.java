package com.example.android.zimad_test.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import com.example.android.zimad_test.R;
import com.example.android.zimad_test.data.entities.Model;
import com.example.android.zimad_test.ui.post_list.OnPostClickListener;
import com.example.android.zimad_test.ui.post_details.PostDetailsActivity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnPostClickListener {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.post_list_pager)
    NotSwappableViewPager viewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ListPagerAdapter listPagerAdapter = new ListPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(listPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPostClicked(final Model model) {
        PostDetailsActivity.startDetailsFragmentInstance(this, model.getUrl(), 0, model.getTitle());
    }
}
