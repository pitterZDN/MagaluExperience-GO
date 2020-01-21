package com.luizalabs.strangersdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openAugmentedReality(View view) {
        AugmentedRealitySDK.openAugmentedRealityProduct(
                this,
                "PML0579984-217080800",
                "Boneca Peppa Pig Princesa"
        );
    }
}
