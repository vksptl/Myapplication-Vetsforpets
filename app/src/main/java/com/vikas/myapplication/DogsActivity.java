package com.vikas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class DogsActivity extends AppCompatActivity {

    private Picasso picasso;
    private LayoutInflater inflater;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        b1= (Button) findViewById(R.id.b1);
        picasso = Picasso.with(this);
        inflater = getLayoutInflater();

        ArrayList<String> imageList = new ArrayList<String>();
        imageList.add("http://r.ddmcdn.com/s_f/o_1/cx_633/cy_0/cw_1725/ch_1725/w_720/APL/uploads/2014/11/too-cute-doggone-it-video-playlist.jpg");
        imageList.add("http://blog.petmeds.com/wp-content/uploads/2015/12/Dogs-scoot-for-a-variety-of-reasons.jpg");
        imageList.add("http://cdn3-www.dogtime.com/assets/uploads/gallery/goldador-dog-breed-pictures/puppy-1.jpg");
        showImages(imageList);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(DogsActivity.this,Dogs1.class);
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
}

 /*   private void storeDiseases()
    {
        ArrayList<Disease> list=new ArrayList<Disease>();

        Disease d1=new Disease();
        d1.setHeading("Dogs and Ear Infections:");
        d1.setDetail("\tEar infections are a common canine health problem, and they can be caused by allergies, yeast, ear mites, bacteria, hair growth deep in the ear canal, and more. Symptoms your dog may have with an ear infection include:");
        d1.addDetail("· Ear odour");
        d1.addDetail("· Vigorous scratching");
        d1.addDetail("· Lack of balance");
        d1.addDetail("· Unusual back-and-forth eye movements");
        d1.addDetail("· Redness of the ear canal");
        d1.addDetail("· Swelling of the outer portion of the ear");
        d1.addDetail("· Brown, yellow, or bloody discharge");
        d1.addDetail("\tAlways take your dog to the veterinarian if you think he has an ear infection. In most cases, cleaning and medicating the ear canal will quickly clear up an infection. However, surgery can be needed for chronic infections or if forceful head shaking results in the rupture of a vessel within the outer part of the ear.");

        Disease d2=new Disease();
        d2.setHeading("Dogs and Worms");
        d2.setDetail("\tTapeworms, roundworms, hookworms, and whipworms are common internal parasites in dogs. And although any worm infestation can make your pooch uncomfortable, some, like hookworms, can be fatal in puppies. Signs your dog may have worms include:");
        d2.addDetail("· Diarrhoea (may be bloody)");
        d2.addDetail("· Weight loss");
        d2.addDetail("· A change in appetite");
        d2.addDetail("· A rough, dry coat");
        d2.addDetail("· Scooting on his bottom");
        d2.addDetail("· Vomiting (with roundworms in particular)");
        d2.addDetail("· An overall poor appearance");
        d2.addDetail("\tThe best way to diagnose a worm problem is with a visit to the vet. Treatment depends on which type of worm your dog has, but generally includes an oral medication and may require follow-up. Don't try treating worms yourself: A medication that kills roundworms, for example, doesn't kill tapeworms.");


        Disease d3=new Disease();
        d3.setHeading("When Fleas Find Your Dog");
        d3.setDetail("\tIt takes just three weeks for one flea to turn into an infestation of 1,000 biting bugs. A very common canine health problem, fleas are easy for your dog to pick up, but they're also easy to treat. Signs your dog may have fleas include:");
        d3.addDetail("· Excessive scratching, licking, or biting at the skin");
        d3.addDetail("· Hair loss");
        d3.addDetail("· Hot spots");
        d3.addDetail("· Allergic dermatitis (allergic response caused by contact)");
        d3.addDetail("· Tapeworms (which are carried by fleas)");
        d3.addDetail("· Flea dirt (looks like small black dots) against your dog's skin");
        d3.addDetail("\tUntreated, fleas not only make your dog intensely uncomfortable, they can also cause allergic reactions, infections, and even lead to anaemia from blood loss. Talk to your vet about the right flea medicine for your dog, which may include collars, oral medicine, shampoos, sprays, or topical liquids.");


        Disease d4=new Disease();
        d4.setHeading("Vomiting");
        d4.setDetail("\tVomiting is a common dog health problem, with dozens of possible causes, from infection or intestinal parasites to pancreatitis, kidney failure, heatstroke, or poisoning.");
        d4.addDetail("Symptoms are basic: abdominal heaving and drooling caused by nausea. If your dog also has diarrhoea, blood in the vomit, seems lethargic, continues vomiting, or can't hold down liquids, contact your vet right away to prevent life-threatening dehydration.");
        d4.addDetail("Treatment depends on what's causing a dog's distress, and may include fluid therapy, drugs to control vomiting, and homemade foods like well-cooked skinless chicken, boiled potatoes, and rice.");

        Disease d5=new Disease();
        d5.setHeading("Vomiting");
        d5.setDetail("\tVomiting is a very common problem with cats with a multitude of causes. They range from eating something poisonous or inedible (like string), to infection, urinary tract disease, or diabetes to hairballs. Symptoms are usually obvious, and include drooling and abdominal heaving. Vomiting can quickly leave your cat dehydrated, so if kitty continues vomiting or acts ill, call your vet right away. It may help to collect a sample of your cat's vomit and take it with you to the vet.");

        Disease d6=new Disease();
        d6.setHeading("Doggy Diarrhoea");
        d6.setDetail("\tDiarrhoea in dogs, as with vomiting, can have lots of causes, including stress, infections like parvo virus, intestinal parasites, and food problems. Diarrhoea symptoms are pretty obvious - look for loose, watery, or liquid stool. Diarrhoea can easily lead to dehydration, be sure your dog has plenty of clean water available, then take your pooch to the vet if the diarrhoea persists for more than a day, or immediately if there's also fever, lethargy, vomiting, dark or bloody stools, or loss of appetite.");

        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);

        showDiseases(list);
    }

    private void showDiseases(ArrayList<Disease> list)
    {
        RecyclerView rv=(RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(llm);
        rv.setAdapter(new DiseaseAdapter(this, list));
    }
}*/
