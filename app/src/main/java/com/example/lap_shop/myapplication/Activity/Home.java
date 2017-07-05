package com.example.lap_shop.myapplication.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.lap_shop.myapplication.Dialog.CustomDialog;
import com.example.lap_shop.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Home extends AppCompatActivity {
    ArrayList<String> itemList = new ArrayList<>();
    ArrayList<String> Messages = new ArrayList<>();
    ArrayList<String> search = new ArrayList<>();
    ArrayList<String> prisents = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    BufferedReader reader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();

        String targetPath = ExternalStorageDirectoryPath + "/Pictures/JarMessage/";
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        if (files != null) {
            for (File file : files) {
                itemList.add(file.getAbsolutePath());
            }
        }
        final Random r = new Random();
//        System.out.println(targetPath + "vwahdfgwhsfdg" + targetDirector + "gyty " + files.length + "  " + files);

        findViewById(R.id.messages).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(Home.this, Messages.get(r.nextInt(Messages.size()) + 0)).show();
            }
        });

        findViewById(R.id.dates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(Home.this, dates.get(r.nextInt(dates.size()) + 0)).show();
            }
        });

        findViewById(R.id.prisents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(Home.this, prisents.get(r.nextInt(prisents.size()) + 0)).show();
            }
        });


        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(Home.this, search.get(r.nextInt(search.size()) + 0)).show();
            }
        });
        findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemList.size() != 0) {
                    final Bitmap bm = decodeSampledBitmapFromUri(itemList.get(r.nextInt(itemList.size()) + 0), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                    new CustomDialog(Home.this, bm).show();
                }
            }
        });
        ReadDoc();
    }


    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }


    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }

        return inSampleSize;
    }


    public void ReadDoc() {

        try {

            final InputStream file = getAssets().open("Love1");
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));

            String line = reader.readLine();
            while (line != null) {
                Log.d("StackOverflow", line);
                line = reader.readLine();
                Messages.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        try {

            final InputStream file = getAssets().open("search");
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));

            String line = reader.readLine();
            while (line != null) {
                Log.d("StackOverflow", line);
                line = reader.readLine();
                search.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        try {

            final InputStream file = getAssets().open("prisents");
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));

            String line = reader.readLine();
            while (line != null) {
                Log.d("StackOverflow", line);
                line = reader.readLine();
                prisents.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        try {

            final InputStream file = getAssets().open("dates");
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));

            String line = reader.readLine();
            while (line != null) {
                Log.d("StackOverflow", line);
                line = reader.readLine();
                dates.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

}


