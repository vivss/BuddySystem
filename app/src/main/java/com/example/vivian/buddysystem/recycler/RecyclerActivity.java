package com.example.vivian.buddysystem.recycler;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vivian.buddysystem.R;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_re_layout);
        if(fragment == null){
            fragment = new LinkFragment();
            manager.beginTransaction().add(R.id.frame_re_layout, fragment).commit();
        }
    }
}
