package com.example.useri.chatbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class firstpage extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView chatbot;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {


                case R.id.navigation_story:
                    mTextMessage.setText("Storyboard");
                    transaction.replace(R.id.frame,new storyBoardFragment()).commit();

                    return true;
                case R.id.navigation_analysis:
                    mTextMessage.setText("Analysis");
                    transaction.replace(R.id.frame,new analysisFragment()).commit();

                    return true;
                case R.id.navigation_marketplace:
                    mTextMessage.setText("Marketplace");
                    transaction.replace(R.id.frame,new marketplaceFragment()).commit();

                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText("Profile");
                    transaction.replace(R.id.frame,new priceFragment()).commit();

                    return true;
                case R.id.navigation_aiVision:
                    mTextMessage.setText("AiVison");
                    transaction.replace(R.id.frame,new aiVisionragment()).commit();

                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
       final Intent i = new Intent(this, MainActivity.class);


        mTextMessage = (TextView) findViewById(R.id.message);
        chatbot=findViewById(R.id.chat);
        android.support.v4.app.FragmentManager fragmetManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmetManager.beginTransaction();
        transaction.replace(R.id.frame,new storyBoardFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

}
