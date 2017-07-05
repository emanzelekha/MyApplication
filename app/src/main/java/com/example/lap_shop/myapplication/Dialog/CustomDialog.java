package com.example.lap_shop.myapplication.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lap_shop.myapplication.R;
import com.github.siyamed.shapeimageview.HeartImageView;

import java.io.File;

public class CustomDialog extends Dialog {


    private TextView messageTextView;
    int MODE = 0;

    public CustomDialog(Activity activity, String message) {
        super(activity);

        setContentView(R.layout.dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;

        messageTextView = (TextView) findViewById(R.id.dialog_message_textView);

        messageTextView.setText(message);
        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public CustomDialog(Activity activity, final Bitmap Photo) {
        super(activity);

        setContentView(R.layout.dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        ((ImageView) findViewById(R.id.heart)).setImageBitmap(Photo);
        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dismiss();

                if (MODE != 0) {
                    dismiss();
                    MODE=0;
                } else {
                    ((ImageView) findViewById(R.id.heart)).setVisibility(View.GONE);
                    ((ImageView) findViewById(R.id.square)).setImageBitmap(Photo);
                    ((ImageView) findViewById(R.id.square)).setVisibility(View.VISIBLE);

                }
                MODE++;
            }
        });


    }

    public CustomDialog setMessage(String text) {
        // okButton.setText(text);
        return this;
    }


}