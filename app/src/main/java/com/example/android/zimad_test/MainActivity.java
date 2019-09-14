package com.example.android.zimad_test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.zimad_test.data.entities.Model;
import com.example.android.zimad_test.ui.OnPostClickListener;
import com.example.android.zimad_test.ui.post_details.PostDetailsActivity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnPostClickListener {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
    }

    @Override
    public void onPostClicked(final Model model) {
        PostDetailsActivity.startDetailsFragmentInstance(this, model.getUrl(), 0, model.getTitle());
    }
}
