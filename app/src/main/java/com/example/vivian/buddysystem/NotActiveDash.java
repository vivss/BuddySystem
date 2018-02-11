package com.example.vivian.buddysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vivian.buddysystem.R;

public class NotActiveDash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_active_dash);

        Button mCreate = (Button) findViewById(R.id.btn_inactive_start);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(NotActiveDash.this, CreateLink.class);
                startActivityForResult(myIntent, 2);
            }
        });

    }
}
