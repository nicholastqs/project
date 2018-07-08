package com.example.nicholas.cinebox.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.nicholas.cinebox.MainActivity;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private Button button ;
    EditText Name;
    EditText Password;
    @BindView(R.id.remember_me)
    CheckBox mRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        Constants.initSharedPref(this);

        Name = findViewById(R.id.etn);
        Password = findViewById(R.id.etp);

        button = findViewById(R.id.bsignup2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                opensignUp(view);
            }
        });
        button = findViewById(R.id.bhome);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
               validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("User1")) && (userPassword.equals("123"))){
            if (mRemember.isChecked()) {
                Constants.storeLoggedInUserPref(true);
                Constants.storeUser(Constants.PREF_USERNAME);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void opensignUp(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}
