package com.vikas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Rabbit1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit1);
        storeDiseases();
    }

    private void storeDiseases()
    {
        ArrayList<Disease> list=new ArrayList<Disease>();

        Disease d1=new Disease();
        d1.setHeading("OVERGROWN TEETH");
        d1.setDetail("Cause and Clinical Signs\n" +
                "A rabbit’s teeth continually grow throughout its life and if a rabbit is not constantly grinding their teeth down by eating fibre we start to see their molar teeth forming sharp spikes that damage their cheeks and tongue. This causes pain that makes them reluctant or unable to eat. The incisors at the front of the mouth can, in severe cases grow around in a curl meaning rabbits cannot close their mouth or eat at all. Once a rabbit stops eating their gut stops working and they can die.");
        d1.addDetail("Prevention\n" +
                "80-90% of your rabbit’s diet needs to be fibre in the form of oaten or grass hay. The rest of the diet should be leafy greens, with pellets and other treats being minimal to non-existent.");
        d1.addDetail("Treatment\n" +
                "A general anaesthetic and burring the teeth flat is the only treatment that can correct overgrown teeth.");

        Disease d2=new Disease();
        d2.setHeading("SNUFFLES (PASTEURELLOSIS)");
        d2.setDetail("Cause and Clinical Signs\n" +
                "Close contact with an infected rabbit can easily transfer the Pasteurella multocida bacterium to your rabbit. The bacteria can affect the eyes (discharge, redness, squinting) and/or nose (sneezing, discharge), thus giving the disease its name “snuffles.” Pasteurellacan infect other areas of the body as well, including ears (resulting in a head tilt), abscesses (seen as lumps on the body) and uterine infections.");
        d2.addDetail("Prevention\n" +
                "Some strains of the bacteria remain latent in the rabbit’s nasal tract until the immune system is placed under stress, such as when a new diet or pet is introduced or if overcrowding occurs. Reducing stress for rabbits that are infected and the quarantine of new rabbits are good ways of preventing introduction of the disease or recurrence of signs.");
        d2.addDetail("Treatment\n" +
                "Treatment involves a long and sometimes repeated course of antibiotics. Occasionally surgery is required if an abscess forms.");

        Disease d3=new Disease();
        d3.setHeading("HAIRBALLS (TRICHOBEZOARS)");
        d3.setDetail("Cause and Clinical Signs\n" +
                "Hair can normally be found in a rabbit’s stomach as they self-groom. However, as rabbits cannot vomit, hair must be able to pass through the gut. If it can’t then it will form an obstruction and serious complications. Hairballs are so common that they should always be considered as a problem in any rabbit that is lethargic and not eating.");
        d3.addDetail("Prevention\n" +
                "Hairballs are more likely to become a problem if there is an issue with the gastrointestinal tract (gut stasis) or they are not receiving enough fibre in their diet, so a high fibre diet is a great preventative measure.");
        d3.addDetail("Treatment\n" +
                "Sometimes surgery is the only treatment if the hairball causes a blockage in the gut. Medication to get the gut working again can also help.");

        Disease d4=new Disease();
        d4.setHeading("UTERINE TUMOURS");
        d4.setDetail("Cause and Clinical Signs\n" +
                "Entire female rabbits can develop a cancer called uterine adenocarcinoma and it should be suspected anytime an un-desexed female rabbit becomes sick. Some of the more common clinical signs include blood stained vaginal discharge, aggressive behaviour, mammary gland cysts and lethargy.");
        d4.addDetail("Prevention\n" +
                "Desexing early at 4-6 months of age.");
        d4.addDetail("Treatment\n" +
                "Desexing, hopefully prior to the cancer spreading through the body.");

        Disease d5=new Disease();
        d5.setHeading("MYXOMATOSIS");
        d5.setDetail("Cause and Clinical Signs\n" +
                "Myxomatosis is a virus that is transmitted by mosquitoes, fleas or by close contact between an infected rabbit and a susceptible rabbit. The disease is recognised by swelling and discharge from the eyes, nose and anogenital region.");
        d5.addDetail("Prevention\n" +
                "Unfortunately there is no vaccination available in Australia. Invest in a mosquito proof rabbit hutch or bring your rabbit inside at dawn and dusk when mosquito levels are higher. Flea control can help and when introducing new rabbits keep them isolated for at least 2 weeks.");
        d5.addDetail("Treatment\n" +
                "The disease is invariably fatal.");

        Disease d6=new Disease();
        d6.setHeading("CALICIVIRUS");
        d6.setDetail("Cause and Clinical Signs\n" +
                "Calicivirus is spread by mosquito or through direct contact with an infected rabbit. This is a disease that damages the rabbit’s internal organs such as the liver and gut, and can also cause haemorrhage or bleeding. The symptoms include going off food, being depressed and quiet, and you may notice some bleeding from the nose. The disease can progress very quickly and is often fatal.");
        d6.addDetail("Prevention\n" +
                "Luckily there is a vaccination against calicivirus. It should be given annually to ensure your rabbit’s immunity against it is maintained. Mosquito proof housing as well as avoiding infected rabbits is also advised.");
        d6.addDetail("Treatment\n" +
                "There is no treatment available.");
        d6.addDetail("NOTE: Often there are subtle changes in your rabbit’s behaviour that may be a clue to a disease process occurring. If you have noticed any changes or are concerned about something your bunny has been doing then it is advised to get them checked by your vet. The earlier problems are detected the better your rabbit’s chances are of living a healthy life");

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
}
