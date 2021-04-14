package com.example.udacityadvanced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.telephony.mbms.MbmsErrors;

import com.example.udacityadvanced.data.AndriodImageAssets;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            // create a new head bodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();
            int headIndex=getIntent().getIntExtra("headIndex",0);
            //Set the list of image id's for the fragment and set the position to thee second image in the list
            headFragment.setImageIds(AndriodImageAssets.getHeads());
            headFragment.setListIndex(headIndex);

            //Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();



            BodyPartFragment bodyFragment = new BodyPartFragment();
            int bodyIndex=getIntent().getIntExtra("bodyIndex",0);
            bodyFragment.setImageIds(AndriodImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();



            BodyPartFragment legFragment = new BodyPartFragment();
            int legIndex=getIntent().getIntExtra("legIndex",0);
            legFragment.setImageIds(AndriodImageAssets.getLegs());
            legFragment.setListIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }


}