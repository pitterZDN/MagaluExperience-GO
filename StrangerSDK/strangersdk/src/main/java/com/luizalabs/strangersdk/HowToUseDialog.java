package com.luizalabs.strangersdk;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class HowToUseDialog extends Dialog {

    private Button mBtnClose;

    public HowToUseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

        setContentView(R.layout.strangersdk_dialog_how_to_use);

        loadUIDialog();
        setListener();

    }

    private void loadUIDialog() {
        mBtnClose = findViewById(R.id.buttonCloseModal);
    }

    private void setListener() {
        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
