package com.example.lenovo.jnoor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LENOVO on 10/1/2017.
 */

class Todays_Meal_Adapter extends RecyclerView.Adapter<Todays_Meal_Adapter.VersionViewHolder_today> {

    String[] today_meals;
    Button sms,callus;
    Context context;
    //Constructor To Receive the Today's Menu in String
    public Todays_Meal_Adapter(String[] meals, Context context){
        this.context = context;
        this.today_meals = meals;
    }

    @Override
    public VersionViewHolder_today onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todays_meal, parent, false);

        VersionViewHolder_today viewHolder = new VersionViewHolder_today(view);
        callus = (Button) view.findViewById(R.id.btn_callus);
        sms = (Button) view.findViewById(R.id.btn_sendsms);
        callus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03333667743"));
                context.startActivity(intent);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "HelloWorld!";
                String phoneNumber = "02134610981";
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", phoneNumber);
                smsIntent.putExtra("sms_body", text);
                context.startActivity(Intent.createChooser(smsIntent, "SMS:"));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VersionViewHolder_today holder, int position) {
        holder.title.setText(today_meals[position]);
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class VersionViewHolder_today extends RecyclerView.ViewHolder{
        CardView cardItemLayout;
        TextView title;

        public VersionViewHolder_today(View itemView){
            super(itemView);
            cardItemLayout = (CardView)itemView.findViewById(R.id.card_view3);
            title = (TextView)itemView.findViewById(R.id.today_tv);
        }

    }
}
