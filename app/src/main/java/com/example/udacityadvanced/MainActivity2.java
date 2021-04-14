package com.example.udacityadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements MasterListfragment.OnImageClickListner{

    //Variable to store the value for the list index of the selected images
    // The default value will be index=0

    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked="+position, Toast.LENGTH_SHORT).show();

        //bodypartNumber will be 0 for head,1 for body and 2 for leg fragment
        //Divided by 12 gives us these integer value because each list of images resources has a size of 12

       int bodyPartNumber=position/12;

       //Store the correct list index no matter where in image list has been clicked
        //this ensure that the index will alaways be a value between 0-11
       int listIndex=position-12*bodyPartNumber;


       //Set the currently displayed item for the correct body part fragment
        switch (bodyPartNumber){
            case 0:headIndex=listIndex;
            break;
            case 1:bodyIndex=listIndex;
            break;
            case 2:legIndex=listIndex;
            break;
            default:break;
        }
        //Put this information in bundle and attach to an intent that will launch an MainActivity
        Bundle b=new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        //Attach the Bundle to an Intent
        final Intent intent=new Intent(this,MainActivity.class);
        intent.putExtras(b);

        //The "Next Button " launches a new MainActivity
        Button nextButton=findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }
}