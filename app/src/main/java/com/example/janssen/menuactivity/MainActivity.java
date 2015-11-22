package com.example.janssen.menuactivity;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class MainActivity extends Activity implements ExpandableListView.OnChildClickListener {

    private DrawerLayout drawer;
    private ExpandableListView drawerList;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ArrayList<String> groupItem;
    private HashMap<String, List<String>> childItem;
    public final static String DEBUG_TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        setGroupData();
        setChildGroupData();

        initDrawer();
    }


    private void initDrawer() {

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerList = (ExpandableListView) findViewById(R.id.left_drawer);

        drawerList.setAdapter(new MyExpandableListAdapter(this, groupItem, childItem));

        drawerList.setOnChildClickListener(this);

        drawerList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, "Clicked On " + groupPosition, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setGroupData() {

        groupItem = new ArrayList<String>();
        groupItem.add("Meat");
        groupItem.add("Sidedish");
        groupItem.add("Drink");
        groupItem.add("Extras");
    }



    public void setChildGroupData() {

        childItem = new HashMap<String, List<String>>();

        ArrayList<String> child = new ArrayList<String>();
        child.add("Chicken");
        child.add("Pork");
        childItem.put(groupItem.get(0), child);


        child = new ArrayList<String>();
        child.add("Rice");
        childItem.put(groupItem.get(1), child);


        child = new ArrayList<String>();
        child.add("Juice");
        child.add("Milk");
        child.add("Softdink");
        child.add("Water");
        childItem.put(groupItem.get(2), child);


        child = new ArrayList<String>();
        child.add("Pogi ako");
        child.add("Ganda ko");
        childItem.put(groupItem.get(3), child);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        Toast.makeText(this, "Clicked On Child " + groupPosition + "-" + childPosition,
                Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected void centerActionBarTitle()
    {
        int titleId;
        titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView titleTextView = (TextView) findViewById(titleId);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        LinearLayout.LayoutParams txvPars = (LinearLayout.LayoutParams) titleTextView.getLayoutParams();
        txvPars.gravity = Gravity.CENTER_HORIZONTAL;
        txvPars.width = metrics.widthPixels;
        titleTextView.setLayoutParams(txvPars);
        titleTextView.setGravity(Gravity.CENTER);
    }
}
