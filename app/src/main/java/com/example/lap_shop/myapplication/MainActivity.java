package com.example.lap_shop.myapplication;

import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Thread splashTread;
    TextView textView;
    View iv;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        int width = size.x;
//        int height = size.y;
//        View square = findViewById(R.id.wight);
//        textView = (TextView) findViewById(R.id.text);
//
//        square.setLayoutParams(new RelativeLayout.LayoutParams(width / 6, width / 6));
//        textView.setTextSize(width / 70);
//        StartAnimations();


    }


    private void StartAnimations() {
//       anim = AnimationUtils.loadAnimation(this, R.anim.alph);
//        anim.reset();
//        RelativeLayout l = (RelativeLayout) findViewById(R.id.lin_lay);
//        l.clearAnimation();
//        l.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        anim.reset();
//       // anim.setRepeatCount(Animation.INFINITE);
//
//        iv = findViewById(R.id.wight);
//
//
//        iv.clearAnimation();
//        iv.startAnimation(anim);

//
//        splashTread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    int waited = 0;
//                    // Splash screen pause time
//                    while (waited < 3500) {
//
//                        sleep(100);
//                        waited += 100;
//                    }
//                 anim.cancel();
//
//                    // MainActivity.this.finish();
//
//
//                } catch (InterruptedException e) {
//                    // do nothing
//                } finally {
//                    // MainActivity.this.finish();
//                    //iv.clearAnimation();
//                    anim.cancel();
//                }
//
//            }
//        };
//        splashTread.start();

    }

}
