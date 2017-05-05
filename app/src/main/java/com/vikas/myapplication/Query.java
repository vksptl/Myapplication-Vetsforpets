package com.vikas.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Query extends AppCompatActivity {
    private Picasso picasso;
    private LayoutInflater inflater;
    @Bind(R.id.qnam)
    EditText t1;
    @Bind(R.id.quer)
    EditText t2;
    @Bind(R.id.qemail)
    EditText t3;
    @Bind(R.id.qphone)
    EditText t4;
    @Bind(R.id.qsubmit)
    Button sub;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        image1= (ImageView) findViewById(R.id.img1);
        image2= (ImageView) findViewById(R.id.img2);
        image3= (ImageView) findViewById(R.id.img3);
        image4= (ImageView) findViewById(R.id.img4);
        picasso = Picasso.with(this);
        inflater = getLayoutInflater();
        ButterKnife.bind(this);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();

            }
        });


        ArrayList<String> imageList = new ArrayList<String>();
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

    private void showImages(final ArrayList<String> imageList) {
        CarouselView imageCarousel = (CarouselView) findViewById(R.id.carousel);

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

    protected void sendEmail() {

        if (!validate()) {
            onSignupFailed();
            return;
        }
        String value = t2.getText().toString();
        String value2 = t4.getText().toString();

        Log.i("Send email", "");
        String[] TO = {"vetsforpets7@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Query regarding pet");
        emailIntent.putExtra(Intent.EXTRA_TEXT,value+"-----------------------------"+value2);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Query.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

  /*  public void signup() {

        if (!validate()) {
            onSignupFailed();
            return;
        }

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

    }*/

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Please try again..", Toast.LENGTH_LONG).show();

        sub.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = t1.getText().toString();
        String email = t3.getText().toString();
        String mobile = t4.getText().toString();
        String query = t2.getText().toString();
        if (name.isEmpty() || name.length() < 3) {
            t1.setError("at least 3 characters");
            valid = false;
        } else {
            t1.setError(null);
        }

        if (query.isEmpty() || query.length() < 10) {
            t2.setError("at least 10 characters");
            valid = false;
        } else {
            t2.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            t3.setError("enter a valid email address");
            valid = false;
        } else {
            t3.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() < 10 || mobile.length() >10) {
            t4.setError("only 10 digits.");
            valid = false;
        } else {
            t4.setError(null);
        }

        return valid;
    }
}
