package com.vikas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Blogs extends AppCompatActivity {

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);

        text1= (TextView) findViewById(R.id.dogs);
        text2= (TextView) findViewById(R.id.cats);
        text3= (TextView) findViewById(R.id.rabbits);
        text4= (TextView) findViewById(R.id.fish);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Blogs.this,DogsActivity.class);
                startActivity(i);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Blogs.this,CatsActivity.class);
                startActivity(i);
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Blogs.this,RabbitActivity.class);
                startActivity(i);
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Blogs.this,FishActivity.class);
                startActivity(i);
            }
        });
    }


}
