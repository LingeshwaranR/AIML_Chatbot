package com.example.useri.chatbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class firstpage extends AppCompatActivity {
 TextView text;
 ImageView img;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.FragmentManager fragmetManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmetManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_story:
                    transaction.replace(R.id.frame,new storyBoardFragment()).commit();
                    text.setText("Storyboard");

                    return true;

                case R.id.navigation_analysis:
                    transaction.replace(R.id.frame,new analysisFragment()).commit();
                    text.setText("Analysis");

                    return true;
                case R.id.navigation_marketplace:

                    transaction.replace(R.id.frame,new marketplaceFragment()).commit();
                    text.setText("Marketplace");

                    return true;

                case R.id.navigation_profile:

                    transaction.replace(R.id.frame,new priceFragment()).commit();
                    text.setText("Profile");

                    return true;

                case R.id.navigation_aiVision:

                    transaction.replace(R.id.frame,new aiVisionragment()).commit();
                    text.setText("AI Vision");

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        text=findViewById(R.id.message);
        img=findViewById(R.id.chat);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(firstpage.this,MainActivity.class);
                startActivity(i);
            }
        });


        android.support.v4.app.FragmentManager fragmetManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmetManager.beginTransaction();
        transaction.replace(R.id.frame,new storyBoardFragment()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
