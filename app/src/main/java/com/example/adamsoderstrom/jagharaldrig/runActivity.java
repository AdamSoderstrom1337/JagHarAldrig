package com.example.adamsoderstrom.jagharaldrig;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Vector;


public class runActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        final Vector<String> statementVec = new Vector<String>();

        statementVec.add("1");
        statementVec.add("2");
        statementVec.add("3");
        statementVec.add("4");
        statementVec.add("5");

        ImageButton btnNext = (ImageButton)this.findViewById(R.id.nextButton);
        btnNext.setOnClickListener(new View.OnClickListener() {

            int i=0;
            public void onClick(View v) {
                String output;

                if(i != statementVec.size()) {
                    output = statementVec.get(i);

                    ((TextView) findViewById(R.id.statementText)).setText(output);
                    i++;
                }
                else{
                    i=0;
                    ((TextView) findViewById(R.id.statementText)).setText("Kulkul");

                }

            }
        });
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
