package com.example.lenovo.jnoor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by LENOVO on 9/25/2017.
 */

public class Todays_Meal extends android.support.v4.app.Fragment {
    Button sms,callus;
    public static Todays_Meal newInstance() {
        Todays_Meal fragment = new Todays_Meal();
        return fragment;
    }

    public Todays_Meal(){
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
//        Animation imgs = AnimationUtils.loadAnimation(getContext(),R.anim.slide_out);
//        Animation tvs = AnimationUtils.loadAnimation(getContext(),R.anim.slide_in);
//        rgq1.startAnimation(imgs);
//        tv1.startAnimation(tvs);
    }

    @Override
    public void onResume() {
        super.onResume();
//        Animation imgs = AnimationUtils.loadAnimation(getContext(),R.anim.slide_out);
//        Animation tvs = AnimationUtils.loadAnimation(getContext(),R.anim.slide_in);
//        rgq1.startAnimation(imgs);
//        tv1.startAnimation(tvs);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.todays_meal, container, false);
        callus = (Button) rootView.findViewById(R.id.btn_callus);
        sms = (Button) rootView.findViewById(R.id.btn_sendsms);
        callus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03333667743"));
                startActivity(intent);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = (Context) getActivity().getApplicationContext();
                String text = "HelloWorld!";
                String phoneNumber = "02134610981";
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", phoneNumber);
                smsIntent.putExtra("sms_body", text);
                context.startActivity(Intent.createChooser(smsIntent, "SMS:"));
            }
        });

        return rootView;
    }

}
