package com.vikas.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {
    private Picasso picasso;
    private LayoutInflater inflater;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        picasso= Picasso.with(this);
        inflater=getLayoutInflater();

        image1= (ImageView) findViewById(R.id.img1);
        image2= (ImageView) findViewById(R.id.img2);
        image3= (ImageView) findViewById(R.id.img3);
        image4= (ImageView) findViewById(R.id.img4);

        ArrayList<String> imageList=new ArrayList<String>();
        imageList.add("http://r.ddmcdn.com/s_f/o_1/cx_633/cy_0/cw_1725/ch_1725/w_720/APL/uploads/2014/11/too-cute-doggone-it-video-playlist.jpg");
        imageList.add("http://blog.petmeds.com/wp-content/uploads/2015/12/Dogs-scoot-for-a-variety-of-reasons.jpg");
        imageList.add("http://cdn3-www.dogtime.com/assets/uploads/gallery/goldador-dog-breed-pictures/puppy-1.jpg");
        showImages(imageList);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vetsforpets1"));
                startActivity(i);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/in/vetsforpets1"));
                startActivity(i);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/vetsforpets143"));
                startActivity(i);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/vetsforpets1"));
                startActivity(i);
            }
        });

    }


    private void showImages(final ArrayList<String> imageList)
    {
        CarouselView imageCarousel=(CarouselView)findViewById(R.id.carousel);

        imageCarousel.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View customView = inflater.inflate(R.layout.simple_image, null);

                ImageView imageView = (ImageView) customView.findViewById(R.id.imageView);

                picasso.load(imageList.get(position))
                        .fit()
                        .centerCrop()
                        .into(imageView);

                return customView;
            }
        });

        imageCarousel.setPageCount(imageList.size());

    }


}
