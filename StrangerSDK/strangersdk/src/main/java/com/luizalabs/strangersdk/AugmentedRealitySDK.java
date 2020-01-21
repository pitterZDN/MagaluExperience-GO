package com.luizalabs.strangersdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class AugmentedRealitySDK {
    public static void openAugmentedRealityProduct(@NonNull Activity activity,
                                                   @NonNull String compositeCode,
                                                   @NonNull String productName)  {

        Intent intent = getAugmentedRealityIntent(activity,compositeCode,productName);

        activity.startActivity(intent);
    }

    private static Intent getAugmentedRealityIntent(Context context,
                                                    String compositeCode,
                                                    String productName) {

        Intent intent = new Intent(context, AugmentedRealityActivity.class);
        intent.putExtra(AugmentedRealityActivity.EXTRA_PRODUCT_NAME, productName);
        intent.putExtra(AugmentedRealityActivity.EXTRA_COMPOSITE_CODE,compositeCode);

        return intent;

    }
}
