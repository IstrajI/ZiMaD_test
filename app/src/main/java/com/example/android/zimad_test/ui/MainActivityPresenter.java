package com.example.android.zimad_test.ui;

import javax.inject.Inject;

public class MainActivityPresenter {

    MainActivityView mainActivityView;

    @Inject
    MainActivityPresenter() {

    }

    public void setMainActivityView(final MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    private int currentSelectedTabPosition = -1;

    void tabSelected(final int tabNumber) {
        if (tabNumber == currentSelectedTabPosition) return;

        if (tabNumber == 0) {
            mainActivityView.showCatsPostListFragment();
        } else if (tabNumber == 1){
            mainActivityView.showDogsPostListFragment();
        }

        currentSelectedTabPosition = tabNumber;
    }
}
