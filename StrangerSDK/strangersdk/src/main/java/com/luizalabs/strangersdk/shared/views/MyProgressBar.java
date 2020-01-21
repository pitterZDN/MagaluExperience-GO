package com.luizalabs.strangersdk.shared.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.ArrayRes;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class MyProgressBar extends SmoothProgressBar {
    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void loadProgress(@ArrayRes int resColors) {
        int[] colors = getResources().getIntArray(resColors);
        setSmoothProgressDrawableSectionsCount(colors.length);
        setSmoothProgressDrawableUseGradients(true);
        setSmoothProgressDrawableColors(colors);
    }
}
