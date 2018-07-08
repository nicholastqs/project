package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.activities.successful;

public class RegisterActivity extends AppCompatActivity {

    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        button = (Button) findViewById(R.id.bcreateacc);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                opensuccessful(view);
            }
        });
    }

    public void opensuccessful(View v) {
        Intent intent = new Intent(this, successful.class);
        startActivity(intent);
    }
}
