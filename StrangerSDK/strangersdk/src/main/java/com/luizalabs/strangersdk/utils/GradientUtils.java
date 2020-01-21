package com.luizalabs.strangersdk.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.annotation.ArrayRes;

public class GradientUtils {
    public static void setGradientOnLayout(Context context,
                                           View view,
                                           @ArrayRes int resColors){
        int[] colors = context.getResources().getIntArray(resColors);
        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                colors);
        view.setBackground(drawable);
    }
}