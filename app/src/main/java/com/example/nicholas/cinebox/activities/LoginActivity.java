package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nicholas.cinebox.MainActivity;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    /**
     * It's very important you follow the links below to understand how to work with Firebase Authentication
     * */

    /*https://firebase.google.com/docs/auth/android/password-auth#sign_in_a_user_with_an_email_address_and_password*/

    /*https://github.com/firebase/quickstart-android/blob/6b85671ca1fc9403b1f0bf5fbb473dd6509516b4/auth/app/src/main/java/com/google/firebase/quickstart/auth/EmailPasswordActivity.java#L66-L66*/

    private Button button;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignUp(view);
            }
        });
        button = findViewById(R.id.bhome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Name.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, getString(R.string.error_username_required), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, getString(R.string.error_password_required), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Name.getText().toString().equals("User1")) {
                    Toast.makeText(LoginActivity.this, getString(R.string.error_username_incorrect), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Password.getText().toString().equals("123")) {
                    Toast.makeText(LoginActivity.this, getString(R.string.error_password_incorrect), Toast.LENGTH_SHORT).show();
                    return;
                }

                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("User1")) && (userPassword.equals("123"))) {
            if (mRemember.isChecked()) {
                Constants.storeLoggedInUserPref(true);
                Constants.storeUser(Constants.PREF_USERNAME);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
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
