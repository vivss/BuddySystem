package com.example.vivian.buddysystem.recycler;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vivian.buddysystem.CreateLink;
import com.example.vivian.buddysystem.R;
import com.example.vivian.buddysystem.model.Link;
import com.example.vivian.buddysystem.model.LinkList;
import com.example.vivian.buddysystem.model.UserList;

public class RecyclerActivity extends AppCompatActivity {

    public static String TAG = "REACT";

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_add_person:
                Intent intent = new Intent(RecyclerActivity.this, CreateLink.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//
//        }
//    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Log.d(TAG, " we start");

        UserList uList = UserList.getsUsers(getApplicationContext());
        LinkList lList = new LinkList(getApplicationContext());
        Intent intent = getIntent();

        Link link = new Link(uList.getCurrentUser().getUsername(),
                intent.getStringExtra("buddy"),
                intent.getIntExtra("duration", 0),
                intent.getIntExtra("distance", 0));

        Log.d(TAG, " Link is created");

        lList.addLink(link);
        Log.d(TAG, " Link is added");

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_re_layout);
        if(fragment == null){
            fragment = new LinkFragment();
            manager.beginTransaction().add(R.id.frame_re_layout, fragment).commit();
        }
    }
}
