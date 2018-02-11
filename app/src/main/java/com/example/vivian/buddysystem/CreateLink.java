package com.example.vivian.buddysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.vivian.buddysystem.R;
import com.example.vivian.buddysystem.model.User;
import com.example.vivian.buddysystem.model.UserList;
import com.example.vivian.buddysystem.recycler.RecyclerActivity;

import java.util.ArrayList;

public class CreateLink extends AppCompatActivity {

    private UserList mList; //UserList

    private Spinner sFriends;
    private Spinner sDuration;
    private Spinner sDistance;

    private Button sButtonOfLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_link);

        mList = UserList.getsUsers(getApplicationContext());

        sFriends = (Spinner)findViewById(R.id.spinner_friends);

        ArrayList<User> userList = mList.getAllUsers();

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item,  userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sFriends.setAdapter(adapter);

        sDuration = (Spinner)findViewById(R.id.spinner_duration);
        ArrayAdapter<CharSequence> adap1 = ArrayAdapter.createFromResource(this,
                R.array.duration_array, android.R.layout.simple_spinner_item);
        adap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDuration.setAdapter(adap1);

        sDistance = (Spinner)findViewById(R.id.spinner_distance);
        ArrayAdapter<CharSequence> adap2 = ArrayAdapter.createFromResource(this,
                R.array.distance_array, android.R.layout.simple_spinner_item);
        adap2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDistance.setAdapter(adap2);

        sButtonOfLife = (Button)findViewById(R.id.btn_create_link);
        sButtonOfLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CREATE", " button clicked!");
                String buddy = sFriends.getSelectedItem().toString();
                int distance = Integer.valueOf(sDistance.getSelectedItem().toString());
                int duration = Integer.valueOf(sDuration.getSelectedItem().toString());
                Intent intent = new Intent(CreateLink.this, RecyclerActivity.class);
                intent.putExtra("buddy", buddy);
                intent.putExtra("distance", distance);
                intent.putExtra("duration", duration);
                startActivity(intent);
            }
        });

    }


}
