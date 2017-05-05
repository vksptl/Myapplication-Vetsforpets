package com.vikas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {

    ImageView imageview;
    TextView textview;

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_POWER) {
            // Do something here...
            Intent i = new Intent(this, SplashScreen.class);
            startActivity(i);
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);



        imageview = (ImageView) findViewById(R.id.imageView1);
        textview = (TextView) findViewById(R.id.textView1);

        imageview.setVisibility(View.VISIBLE);
        TranslateAnimation slide = new TranslateAnimation(0, 0, 100,0);
        slide.setDuration(4000);
        slide.setFillAfter(true);
        imageview.startAnimation(slide);

        AlphaAnimation anim = new AlphaAnimation(0.1f, 1.0f);
        anim.setDuration(3500);
        textview.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(i);
                SplashScreen.this.finish();
            }
        },5000);
    }
}
