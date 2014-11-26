package com.example.adamsoderstrom.jagharaldrig;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.*;
import java.util.Collections;
import java.util.Vector;


public class runActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Arial MT Bold.ttf");
        TextView statement = (TextView) findViewById(R.id.statementText);
        statement.setTypeface(tf);

        //Holds all statments
        final Vector<String> statementVec = new Vector<String>();

        //Try/Catch read file to statmentVec
        try {
            readDB(statementVec);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(statementVec);

        //Set statment text to first item in statement vec
        ((TextView) findViewById(R.id.statementText)).setText("Tryck för att starta");


        //Loop through the statementVec to display all statments, then shuffle
        ImageButton btnNext = (ImageButton)this.findViewById(R.id.nextButton);





        btnNext.setOnClickListener(new View.OnClickListener() {

            int i=0;
            public void onClick(View v) {

                String output;

                output = statementVec.get(i);

                ((TextView) findViewById(R.id.statementText)).setText(output);
                i++;
                if(i==statementVec.size()){
                    i=0;
                    Collections.shuffle(statementVec);
                }

            }

        });
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();

        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    public void readDB(Vector<String> temp) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("JagHarAldrig.txt")));
        String line = null;

        while ((line = reader.readLine()) != null) {
            temp.add(line);
        }

        reader.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.run, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
