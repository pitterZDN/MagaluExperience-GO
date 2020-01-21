package com.luizalabs.strangersdk;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.luizalabs.strangersdk.shared.base.ActivityBase;

public class AugmentedRealityActivity extends ActivityBase {

    public static final String EXTRA_COMPOSITE_CODE = "com.luizalabs.strangersdk.augmentedrealityactivity.compositeCode";
    public static final String EXTRA_PRODUCT_NAME = "com.luizalabs.strangersdk.augmentedrealityactivity.productName";
    private String compositeCode,productName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.strangersdk_activity_augmented_reality);
        getExtras(getIntent().getExtras());
        createToolbar();

    }

    private void getExtras(Bundle extras){
        compositeCode = extras.getString(EXTRA_COMPOSITE_CODE);
        productName = extras.getString(EXTRA_PRODUCT_NAME);
    }

    private void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(productName);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
