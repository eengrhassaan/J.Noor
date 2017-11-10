package com.example.lenovo.jnoor.RegisterScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.jnoor.LoginScreen.LoginScreen;
import com.example.lenovo.jnoor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LENOVO on 11/7/2017.
 */

public class IndividualRegisterScreen extends AppCompatActivity {
    @BindView(R.id.link_individual_login) TextView _login;
    @BindView(R.id.btn_individual_signup) Button _signup_individual;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_individual);
        ButterKnife.bind(this);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IndividualRegisterScreen.this, LoginScreen.class);
                finish();
                startActivity(i);
            }
        });
    }
}
