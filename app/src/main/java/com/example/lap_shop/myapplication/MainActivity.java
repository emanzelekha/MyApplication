package com.example.lap_shop.myapplication;


import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lap_shop.myapplication.Activity.Home;



public class MainActivity extends AppCompatActivity {
    Thread splashTread;
     int height = 0, width = 0;
    TextView textView;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        System.out.println(width+" "+height+"ffffjh");
        textView = (TextView) findViewById(R.id.text);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        params.setMargins(0, height / 6, 0, 0);
        textView.setLayoutParams(params);

        StartAnimations();


    }


    private void StartAnimations() {

        anim = AnimationUtils.loadAnimation(this, R.anim.alph);
        anim.reset();
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);

        textView.clearAnimation();
        textView.startAnimation(anim);


        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {

                        sleep(100);
                        waited += 100;
                    }
                    anim.cancel();
                    Intent intent = new Intent(MainActivity.this,
                            Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    MainActivity.this.finish();


                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                    //iv.clearAnimation();
                    anim.cancel();
                }

            }
        };
        splashTread.start();

    }




//    public String getHeght(){
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        width = size.x;
//        height = size.y;
//        return  width+" "+height;
//    }

}
