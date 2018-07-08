package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.activities.LoginActivity;

public class successful extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);

        button = (Button) findViewById(R.id.bcontinue);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                opensignIn(view);
            }
        });
    }
    public void opensignIn (View v){
        Intent intent = new Intent(this , LoginActivity.class);
        startActivity(intent);
    }
}
