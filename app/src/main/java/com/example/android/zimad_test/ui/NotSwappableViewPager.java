package com.example.android.zimad_test.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NotSwappableViewPager extends ViewPager {
    public NotSwappableViewPager(@NonNull Context context) {
        super(context);
    }

    public NotSwappableViewPager(final @NonNull Context context, final @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent ev) {
        return false;
    }
}
