package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import butterknife.BindView;
import com.example.nicholas.cinebox.MainActivity;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.utils.Constants;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.username)
    TextInputEditText mUsername;
    @BindView(R.id.password)
    TextInputEditText mPassword;
    @BindView(R.id.remember_me)
    CheckBox mRemember;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.register_btn)
    Button mRegistration;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Constants.initSharedPref(this);

        mRegistration.setOnClickListener(view -> opensignUp(view));

        mLogin.setOnClickListener(view -> {
            if (mUsername.getText().toString().isEmpty()) {
                errorToast(getString(R.string.error_username_required));
                return;
            }
            if (mPassword.getText().toString().isEmpty()) {
                errorToast(getString(R.string.error_password_required));
                return;
            }
            if (!mUsername.getText().toString().equals("User1")) {
                errorToast(getString(R.string.error_username_incorrect));
                return;
            }
            if (!mPassword.getText().toString().equals("123")) {
                errorToast(getString(R.string.error_password_incorrect));
                return;
            }

            validate(mUsername.getText().toString(), mPassword.getText().toString());
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("User1")) && (userPassword.equals("123"))) {
            if (mRemember.isChecked()) {
                Constants.storeLoggedInUserPref(true);
                Constants.storeUser(Constants.PREF_USERNAME);
                successToast(getString(R.string.login_successful));
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                successToast(getString(R.string.login_successful));
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
