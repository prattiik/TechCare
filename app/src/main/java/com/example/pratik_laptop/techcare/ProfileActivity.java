package com.example.pratik_laptop.techcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewId, textViewUsername,textViewEmail, textViewGender, textViewWeight, textViewHeight, textViewBlood, textViewDob, textViewAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }


        textViewId = (TextView) findViewById(R.id.textViewId);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewGender = (TextView) findViewById(R.id.textViewGender);
        textViewWeight = (TextView) findViewById(R.id.textViewWeight);
        textViewHeight = (TextView) findViewById(R.id.textViewHeight);
        textViewBlood = (TextView) findViewById(R.id.textViewBlood);
        textViewDob = (TextView) findViewById(R.id.textViewDob);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        //getting the current user
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        textViewId.setText(String.valueOf(user.getId()));
        textViewUsername.setText(user.getUsername());
        textViewEmail.setText(user.getEmail());
        textViewGender.setText(user.getGender());
        textViewWeight.setText(user.getWeight());
        textViewHeight.setText(user.getHeight());
        textViewBlood.setText(user.getBloodgroup());
        textViewDob.setText(user.getDob());
        textViewAddress.setText(user.getAddress());
        //when the user presses logout button
        //calling the logout method
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }
}