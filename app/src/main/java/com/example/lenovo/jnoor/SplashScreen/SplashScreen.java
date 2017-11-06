package com.example.lenovo.jnoor.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lenovo.jnoor.LoginScreen.LoginScreen;
import com.example.lenovo.jnoor.R;

/**
 * Created by LENOVO on 9/17/2017.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Log.d("J.Noor","Here it is!");
        final Intent loginScreen = new Intent(this,LoginScreen.class);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        startActivity(loginScreen);
                        finish();
                    }
                },1500);
    }
}
