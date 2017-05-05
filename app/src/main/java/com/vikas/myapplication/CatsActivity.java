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

public class CatsActivity extends AppCompatActivity {

    private Picasso picasso;
    private LayoutInflater inflater;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        b1= (Button) findViewById(R.id.b1);

        picasso = Picasso.with(this);
        inflater = getLayoutInflater();



        ArrayList<String> imageList = new ArrayList<String>();
        imageList.add("https://files.graphiq.com/stories/t2/tiny_cat_12573_8950.jpg");
        imageList.add("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/30423_pets-products_january-site-flip_3-cathealth_short-tile_592x304._CB286975940_.jpg");
        imageList.add("http://media.salon.com/2015/05/kitten.jpg");
        showImages(imageList);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CatsActivity.this,Cats1.class);
                startActivity(i);
            }
        });

    }

    private void showImages(final ArrayList<String> imageList) {
        CarouselView imageCarousel = (CarouselView) findViewById(R.id.carousel);

        imageCarousel.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View customView = inflater.inflate(R.layout.simple_image, null, false);


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
        d1.setHeading("Fleas");
        d1.setDetail("\tFleas are a very common external feline health problem. But it's one you can easily treat. Signs your cat has fleas include:");
        d1.addDetail("· Flea dirt on its skin (they look like tiny black dots");
        d1.addDetail("· Constant scratching");
        d1.addDetail("· Frequent licking");
        d1.addDetail("· Red or irritated skin");
        d1.addDetail("· Hair loss");
        d1.addDetail("· Skin infections or hot spots");
        d1.addDetail("\tFleas can live for more than a year, and your cat risks anaemia if the problem becomes serious, so be sure to treat your cat's flea problem and prevent future infestations. Talk to your vet about which flea control would be best for your cat. Treatments include oral medication, powders, foams, and topical medication.");

        Disease d2=new Disease();
        d2.setHeading("Tapeworms");
        d2.setDetail("\tOne of the most common feline health problems inside your cat, tapeworms live in kitty's small intestine and sometimes grow as long as 2 feet. that said, tapeworms are segmented and usually break apart when expelled. It's very unlikely to see a full worm. You will usually see the segments. Symptoms of a tapeworm infection can be subtle but may include vomiting and weight loss. The easiest way to tell if your cat has tapeworms is to look at its faeces, around its anus and in bedding. Usually tapeworms come out of your cat's anus while it is sleeping or relaxed. If you see small white worms or what look like grains of rice or sesame seeds, your cat likely has tapeworms. Treatment options include injection, oral, or topical medication. But because cats almost always get tapeworms as a result of swallowing a flea, be sure to handle any flea problems your cat has before tackling tapeworms.");

        Disease d3=new Disease();
        d3.setHeading("Diarrhoea");
        d3.setDetail("\tMany things can cause diarrhoea in cats, including intestinal parasites, spoiled food, allergies, infection, liver disease, cancer, and more. Symptoms of diarrhoea are loose, watery, or liquid stool. Depending on its cause, diarrhea can last for a day, a week, or months. If your cat has diarrhoea, offer kitty plenty of fresh, clean water to prevent dehydration. Then remove kitty's food for no more than 12 to 24 hours. Take your cat to the vet if he or she still has diarrhoea after a day or immediately if you notice vomiting, dark, or bloody stools, fever, lethargy, or loss of appetite or if your cat is straining to defecate.");

        Disease d4=new Disease();
        d4.setHeading("Eye Problems");
        d4.setDetail("\tEye problems in cats can be caused by a number of things, including conjunctivitis, cataracts, glaucoma, trauma, viruses, inflammation, and retinal disease. A few symptoms that may mean your cat has eye problems include watery eyes, tear-stained fur, cloudiness, red or white eyelid linings, gunk in the corners of the eye, squinting, pawing at the eye, or a visible third eyelid. Unless you know what's causing your cat's eye problems, there isn't much you can do other than call your vet. Eye problems should be considered an emergency so make appointment immediately.");

        Disease d5=new Disease();
        d5.setHeading("Vomiting");
        d5.setDetail("\tVomiting is a very common problem with cats with a multitude of causes. They range from eating something poisonous or inedible (like string), to infection, urinary tract disease, or diabetes to hairballs. Symptoms are usually obvious, and include drooling and abdominal heaving. Vomiting can quickly leave your cat dehydrated, so if kitty continues vomiting or acts ill, call your vet right away. It may help to collect a sample of your cat's vomit and take it with you to the vet.");

        Disease d6=new Disease();
        d6.setHeading("Feline Lower Urinary Tract Diseases (FLUTD)");
        d6.setDetail("\tSome estimates say as many as 3% of cats seen by vets have feline lower urinary tract disease (FLUTD), which is actually a group of feline diseases with multiple causes. Female and male cats can get FLUTD, and it often occurs in cats that are overweight or unfit or who eat dry food. Stress, a multi-cat household, and sudden changes can all raise a cat's risk of FLUTD, and treatment depends on the type of FLUTD your cat has. FLUTD symptoms include:");
        d6.addDetail("· Straining to urinate");
        d6.addDetail("· Bloody urine");
        d6.addDetail("· Urinating in unusual places");
        d6.addDetail("· Crying when urinating");
        d6.addDetail("· Licking around the urinary area (often because of pain)");
        d6.addDetail("· Depression");
        d6.addDetail("· Dehydration");
        d6.addDetail("· Lack of appetite");
        d6.addDetail("· Vomiting");
        d6.addDetail("\tIt's always an emergency if your cat can't urinate. Call your vet immediately if you suspect your cat has a urinary tract problem");

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
        rv.setAdapter(new DiseaseAdapter(this,list));
    }
}*/
