package com.bawei.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView) findViewById(R.id.imageview);
    }

    public void btnimage(View view) {

        ImageLoader.getInstance().displayImage("https://img3.doubanio.com/img/celebrity/medium/53186.jpg", imageview, IAPP.display());
    }
}
