package com.luizalabs.strangersdk.shared.base;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.luizalabs.strangersdk.R;
import com.luizalabs.strangersdk.utils.GradientUtils;
import com.luizalabs.strangersdk.shared.views.MyProgressBar;


public class ActivityBase extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        setBackgroundGradientProgressbar();
    }
    private void setBackgroundGradientProgressbar() {
        View containerProgress = findViewById(R.id.containerGradient);
        MyProgressBar myProgressBar = findViewById(R.id.progressbarLoad);
        if (containerProgress != null)
            GradientUtils.setGradientOnLayout(this, containerProgress, R.array.strangersdk_colors);
        if(myProgressBar != null)
            myProgressBar.loadProgress(R.array.strangersdk_colors);
    }

}
