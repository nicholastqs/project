package com.example.nicholas.cinebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.bsignup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                opensignUp(view);
            }
        });

        button = (Button) findViewById(R.id.bsignin);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                opensignIn(v);
            }
        });

    }
    public void opensignUp(View v) {
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }

    public void opensignIn (View v){
        Intent intent = new Intent(this , signIn.class);
        startActivity(intent);
    }
}
