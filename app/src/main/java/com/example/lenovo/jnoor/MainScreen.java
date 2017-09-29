package com.example.lenovo.jnoor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.lenovo.jnoor.R.drawable.cell_shape;

/**
 * Created by LENOVO on 9/17/2017.
 */

public class MainScreen extends AppCompatActivity {
//    String companies[] = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
//    String os[]       =  {"Android","Mango","iOS","Symbian","Bada"};

    public String TAG = "Calender View";
    String companies[] = { "Week1", "Week2", "Week3", "Week4"};
    String os[] = { "Android", "Mango", "iOS", "Symbian", "Tizen"};

    String months[] = {"January", "February", "March", "April", "May", "June", "Jule", "August", "September", "October", "November", "December"};
    String days[] = {"Mon", "Tue", "Wed", "Thurs", "Fri"};

    //Section Adapter
    private SectionsPagerAdapter mSectionsPagerAdapter;

    //ViewPager Variable
    private ViewPager mViewPager;

    TableLayout menuData;
    TextView companyTV,valueTV,monthTV,valueTV1;
    TableRow tr;
    Button callus,sms;
    @RequiresApi(api = Build.VERSION_CODES.N)

    int currentWeek=0, currenMonth=0, currentYear=0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.collapsing_toolbar);

        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Tab Layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        monthTV = (TextView) findViewById(R.id.months);
//        menuData = (TableLayout) findViewById(R.id.menuData);
//        menuData.setWeightSum(4);

//
//        //Calender Variable to fetch the Calender values
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2017, Calendar.OCTOBER, 31);
//        calendar.setFirstDayOfWeek(2);
//        currentYear = calendar.get(Calendar.YEAR);
//        Log.d(TAG, "# thisYear : " + currentYear);
//        currenMonth = calendar.get(Calendar.MONTH);
//        Log.d(TAG, "@ thisMonth : " + currenMonth);
//        monthTV.setText(months[currenMonth] + ", " + currentYear);
//
//        int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
//        Log.d(TAG, "$ thisDay : " + thisDay);
//        calendar.setFirstDayOfWeek(2);
//        Log.d(TAG, "$ Calender Week Data : " +  calendar.getFirstDayOfWeek());
//        currentWeek = calendar.get(Calendar.WEEK_OF_MONTH);
//
//        for (int i=1;i<calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);i++){
//            Log.d(TAG,"Months Weeks: " + calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));
//            addWeekHeaders(i);
//            addHeaders();
//            addData();
//        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addWeekHeaders(int weeksnumber) {
        TableRow.LayoutParams trParam = new TableRow.LayoutParams();
        trParam.column= 0;
        trParam.span = 4;
        TableRow row = new TableRow(this);
        TextView content = new TextView(this);
        content.setLayoutParams(trParam);

        content.setText("Week: " + (weeksnumber));
        content.setBackgroundDrawable(getResources().getDrawable(R.drawable.cell_shape));
        content.setTextColor(Color.WHITE);
        content.setTextSize(20);
        content.setGravity(Gravity.CENTER);
        content.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        content.setPadding(5, 5, 5, 0);
        row.addView(content);
        menuData.addView(row, new TableLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.FILL_PARENT));
    }

    public void addHeaders(){
         /** Create a TableRow dynamically **/
        TableRow tr1 = new TableRow(this);

        /** Creating a TextView to add to the row **/
        TextView companyTV = new TextView(this);
//        companyTV.setLayoutParams(trParam);
        companyTV.setBackgroundDrawable(getResources().getDrawable(R.drawable.cell_shape));
        companyTV.setText("Days");
        companyTV.setTextColor(Color.WHITE);
        companyTV.setTextSize(20);
        companyTV.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        companyTV.setPadding(5, 5, 5, 5);
        companyTV.setGravity(Gravity.CENTER);
        TextView valueTV = new TextView(this);
//        valueTV.setLayoutParams(trParam);
        valueTV.setBackgroundDrawable(getResources().getDrawable(R.drawable.cell_shape));
        valueTV.setTextColor(Color.WHITE);
        valueTV.setTextSize(20);
        valueTV.setPadding(5, 5, 5, 5);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        valueTV.setGravity(Gravity.CENTER);
        valueTV.setText("Meals");
        TableRow.LayoutParams trParam = new TableRow.LayoutParams();
        trParam.span = 3;
        valueTV.setLayoutParams(trParam);
        tr1.addView(companyTV);
        tr1.addView(valueTV);
        // Add the TableRow to the TableLayout
        menuData.addView(tr1, new TableLayout.LayoutParams(
                ActionBar.LayoutParams.FILL_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT));
    }

    /** This function add the data to the table **/
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addData(){
        TableRow.LayoutParams trParam = new TableRow.LayoutParams();
        for (int r = 0; r < days.length; r++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.FILL_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            companyTV = new TextView(this);
            companyTV.setBackgroundDrawable(getResources().getDrawable(R.drawable.cell_shape));
            companyTV.setText(days[r]);
            companyTV.setTextColor(Color.WHITE);
            companyTV.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            companyTV.setPadding(20, 5, 5, 5);
            companyTV.setTextSize(12);
            tr.addView(companyTV);  // Adding textView to tablerow.

            for (int c=0;c<os.length-2;c++) {
                /** Creating another textview **/

                valueTV = new TextView(this);
                valueTV.setBackgroundDrawable(getResources().getDrawable(R.drawable.cell_shape));
                valueTV.setText(os[c]);
                valueTV.setTextColor(Color.WHITE);
                valueTV.setTextSize(12);
                valueTV.setPadding(20, 5, 5, 5);
//              valueTV.setPadding(10, 5, 5, 5);
                valueTV.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                tr.addView(valueTV); // Adding textView to tablerow.
            }


            // Add the TableRow to the TableLayout
            menuData.addView(tr, new TableLayout.LayoutParams(
                    ActionBar.LayoutParams.FILL_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter{
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return Todays_Meal.newInstance();
                case 1:
                    return Weekly_details.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Today's Meal";
                case 1:
                    return "Monthly Package";
                default:
                    return "Details";
            }
        }
    }
}
