package com.vikas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class FishActivity extends AppCompatActivity {

    private Picasso picasso;
    private LayoutInflater inflater;

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        b1= (Button) findViewById(R.id.b1);
        picasso = Picasso.with(this);
        inflater = getLayoutInflater();

        ArrayList<String> imageList = new ArrayList<String>();
        imageList.add("http://www.petanim.com/wp-content/uploads/2013/02/Angel-Fish.jpg");
        imageList.add("http://www.in.all.biz/img/in/catalog/594734.jpeg");
        imageList.add("https://www.sierrafishandpets.com/wp-content/uploads/2016/03/one.jpg");
        showImages(imageList);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FishActivity.this,Fishes1.class);
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

  /*  private void storeDiseases()
    {
        ArrayList<Disease> list=new ArrayList<Disease>();

        Disease d1=new Disease();
        d1.setHeading("FISH ICK");
        d1.setDetail("Physical/Behavioural Signs/Symptoms: \n" +
                "Spots that resemble grains of salt or white sand on the skin. \n" +
                "May be slightly-raised. \n" +
                "Scratching against objects due to irritated skin \n" +
                "Clamped fins. \n" +
                "Gasping at the water’s surface.");
        d1.addDetail("Cause:\n" +
                "Usually attacks fish that are stressed, which can be caused by factors including rapid temperature and pH fluctuations.");

        Disease d2=new Disease();
        d2.setHeading("RAGGED TAIL FIN");
        d2.setDetail("Physical/Behavioural Signs or Symptoms:\n" +
                "A progressive deterioration of the tail and/or fins. \n" +
                "Fins become frayed or their color may fade.");
        d2.addDetail("Cause:\n" +
                "A bacterial infection may cause this tail and fin rot in susceptible fish—those who are bullied or injured by fin-nipping tank mates—especially in aquariums with poor conditions.");

        Disease d3=new Disease();
        d3.setHeading("TAIL, FIN, AND MOUTH ROT");
        d3.setDetail("Physical/Behavioural Signs or Symptoms:\n" +
                "A progressive deterioration of the tail and/or fins.\n" +
                "Fins become frayed or their color may fade.");
        d3.addDetail("Cause:\n" +
                "A bacterial infection may cause tail, fin and mouth rot in susceptible fish—those who are bullied or injured by fin-nipping tank mates—especially in aquariums with poor conditions.");

        Disease d4=new Disease();
        d4.setHeading("CLAMPED FIN");
        d4.setDetail("Physical/Behavioral Signs or Symptoms:\n" +
                "Fins are folded against the body and not fanned out as they should be.\n" +
                "Listless behavior.");
        d4.addDetail("Cause:\n" +
                "Not indicative of one specific disease. Can be a reflection of various problems, including bad water quality and/or parasites. Important to first determine the specific problem in order to treat fish properly.");
        d4.addDetail("Note: Always remove activated carbon before administering any treatments.");

        Disease d5=new Disease();
        d5.setHeading("DROPSY");
        d5.setDetail("Physical/Behavioral Signs or Symptoms:\n" +
                "Bloating.\n" +
                "Protruding scales.");
        d5.addDetail("Cause:\n" +
                "A bacterial infection of the kidneys, which causes fluid accumulation or renal failure. It appears to create problems only in weakened fish. May stem from untidy aquarium conditions.");


        Disease d6=new Disease();
        d6.setHeading("FUNGUS");
        d6.setDetail("Physical/Behavioural Signs or Symptoms:\n" +
                "Initially, you’ll notice a gray or whitish growth in and on the skin and/or fins.\n" +
                "Untreated fungus resembles a cottony growth. \n" +
                "Eventually, as fungus continues to eat away at the fish’s body, the fish will die.");
        d6.addDetail("Cause:\n" +
                "Fish who develop fungus are already in a vulnerable state, the result of other serious health problems or attacks, such as parasites, a physical injury or a bacterial infection.");

        Disease d7=new Disease();
        d7.setHeading("ANCHOR WORMS");
        d7.setDetail("Physical/Behavioral Signs or Symptoms:\n" +
                "Scratching against objects by the affected fish. \n" +
                "A protuberance of whitish-green threads from the fish's skin.\n" +
                "Points of attachment are marked by inflammation.");
        d7.addDetail("Cause:\n" +
                "Introduced into aquariums by infected fish, young anchor worms are small crustaceans that burrow into the fish’s skin and enter the muscles. Here they begin to develop and release eggs before they die—leaving behind damage, which can become infected.\n" +
                "Common methods of treatment include physically removing the parasite and cleaning the wound with an antiseptic like iodine, also common is bathing freshwater fish in a seawater bath (35ppt) for about 5 minutes for multiple days until the parasite falls off.");

        Disease d8=new Disease();
        d8.setHeading("BODY FLUKES & GILL FLUKES (flatworms approximately 1 mm long)");
        d8.setDetail("Physical/Behavioral Signs or Symptoms of BODY FLUKES:\n" +
                "Scratching against objects by the affected fish. \n" +
                "Layer of mucus covering gills or body. \n" +
                "Gills moving rapidly. \n" +
                "Chewed on or eaten-away gills or fins. \n" +
                "Reddened skin.");
        d8.addDetail("NOTE: Pale fish with drooping fins, rapid respiration and/or hollow bellies indicate more extensive infestation.");
        d8.addDetail("\nPhysical/Behavioral Signs or Symptoms of GILL FLUKES:\n" +
                "Infected gills and skin \n" +
                "Similar to ick, but telltale sign is movement and possibly eyespots, something that is not found in ick. Use magnification lens to observe. \n" +
                "Once gills are destroyed, fish will die.");
        d8.addDetail("Cause:\n" +
                "Undesirable environmental conditions—including poor water quality, overcrowding, and/or stress by incompatible species—creates conditions that can lead to destructive outbreaks. Flukes are often present in aquariums but remain harmless under ideal conditions. Avoiding stressful conditions is a key to prevention, but once an outbreak occurs, prompt treatment is critical.");


        Disease d9=new Disease();
        d9.setHeading("LICE");
        d9.setDetail("Physical/Behavioral Signs or Symptoms:\n" +
                "Red spots on fish indicating an inflammation.\n" +
                "Fish are aggravated and restless. \n" +
                "Usually fish will rub skin against aquarium glass or other objects in an effort to remove lice.\n" +
                "Other telltale signs: Lice have eight legs—and resemble tiny pale crabs. They appear as flat, dark oval dots crawling on fish. Lice use suckers to attach to fish. Then they pierce the skin and feed on the host.");
        d9.addDetail("Cause:\n" +
                "Usually from fish that were living in an outdoor pond at one time and bringing them into an indoor aquarium. Also, fish lice can be introduced from wild fish that are added to an aquarium. Lice travel from one host fish to another, spreading bacteria and viruses, so once they’re in your aquarium, you must get rid of them.\n" +
                "Common methods of treatment include physically removing the parasite and cleaning the wound with an antiseptic like iodine, as well as bathing freshwater fish in a seawater bath (35ppt) for about 5 minutes for multiple days until the parasite falls off, or using a formalin bath.");

        Disease d10=new Disease();
        d10.setHeading("GILL MITES");
        d10.setDetail("Physical/Behavioral Signs or Symptoms: \n" +
                "Gasping at the water’s surface. \n" +
                "Gill covers that are partially open.");
        d10.addDetail("Cause:\n" +
                "Fish that are already infested by gill mites are brought into aquariums. The tiny mites stay on the fish’s gills, and attack the fish by feeding on blood and living flesh.");


        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);
        list.add(d7);
        list.add(d8);
        list.add(d9);
        list.add(d10);

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
