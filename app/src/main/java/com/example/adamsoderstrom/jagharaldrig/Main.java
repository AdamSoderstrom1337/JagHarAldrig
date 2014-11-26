package com.example.adamsoderstrom.jagharaldrig;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.widget.Button.*;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnStart = (ImageButton) findViewById(R.id.startButton);
        ImageView logo = (ImageView) findViewById(R.id.imageView);

        logo.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.fade_in1));
        btnStart.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.fade_in2 ));

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wooden_stick_fast_swipe_through_air_version_2);

        btnStart.setOnClickListener(new OnClickListener() {

            //Skickar till runActivity onClick
            public void onClick(View v) {
                Intent i = new Intent(Main.this, runActivity.class);
                startActivity(i);

                mp.start();

                overridePendingTransition(R.anim.right_in, R.anim.left_out);


            }
        });

    }


    @Override
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
