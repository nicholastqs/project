package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nicholas.cinebox.MainActivity;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.utils.Constants;

public class WelcomeActivity extends AppCompatActivity {

    private Button button ;

    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Constants.initSharedPref(this);

        button = findViewById(R.id.bsignup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                opensignUp(view);
            }
        });

        button = findViewById(R.id.bsignin);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                opensignIn(v);
            }
        });

    }
    public void opensignUp(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void opensignIn (View v){
        Intent intent = new Intent(this , LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isLoggedIn = Constants.getLoggedInUserPref();
        if (isLoggedIn) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
