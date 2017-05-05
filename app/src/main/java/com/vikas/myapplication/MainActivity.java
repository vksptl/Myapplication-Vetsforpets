package com.vikas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Picasso picasso;
    private LayoutInflater inflater;
    Integer img[]={R.drawable.slide1,R.drawable.slide1,R.drawable.slide1};
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        email=intent.getStringExtra("email");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Blogs.class);
                startActivity(intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        picasso= Picasso.with(this);
        inflater=getLayoutInflater();

        ArrayList<String> imageList=new ArrayList<String>();
        imageList.add("http://r.ddmcdn.com/s_f/o_1/cx_633/cy_0/cw_1725/ch_1725/w_720/APL/uploads/2014/11/too-cute-doggone-it-video-playlist.jpg");
        imageList.add("http://blog.petmeds.com/wp-content/uploads/2015/12/Dogs-scoot-for-a-variety-of-reasons.jpg");
        imageList.add("https://files.graphiq.com/stories/t2/tiny_cat_12573_8950.jpg");
        imageList.add("http://www.petanim.com/wp-content/uploads/2013/02/Angel-Fish.jpg");
        imageList.add("http://www.in.all.biz/img/in/catalog/594734.jpeg");
        imageList.add("http://finsnfeathers.co.in/wp-content/uploads/2016/01/cute-white-rabbit-lanjee-chee-1.jpg");
        imageList.add("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/30423_pets-products_january-site-flip_3-cathealth_short-tile_592x304._CB286975940_.jpg");
        showImages(imageList);


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

    public class MyCustomView extends BaseAdapter {

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i=new ImageView(MainActivity.this);
            i.setImageResource(img[position]);
            return i;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.signin) {
            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.signup) {
            Intent i=new Intent(MainActivity.this,SignupActivity.class);
            startActivity(i);

        } else if (id == R.id.account) {
            Intent i=new Intent(MainActivity.this,Account.class);
            i.putExtra("email",email);
            startActivity(i);

        }else if (id == R.id.query) {
            Intent i=new Intent(MainActivity.this,Query.class);
            startActivity(i);

        }
        else if (id == R.id.about_vets) {
            Intent i=new Intent(MainActivity.this,Vets.class);
            startActivity(i);

        }else if (id == R.id.appoint) {
            Intent i=new Intent(MainActivity.this,CardMainActivity.class);
            startActivity(i);

        }else if (id == R.id.about_us) {
            Intent i=new Intent(MainActivity.this,Team.class);
            startActivity(i);

        }

        else if (id == R.id.Contact_us) {
            Intent i = new Intent(MainActivity.this,Contact.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
