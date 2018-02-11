package com.example.vivian.buddysystem.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vivian.buddysystem.R;
import com.example.vivian.buddysystem.model.Link;
import com.example.vivian.buddysystem.model.User;

/**
 * Created by Charlotte on 2/11/2018.
 */

public class LinkHolder extends RecyclerView.ViewHolder{

    private TextView mBuddyB;
    private TextView mDistance;

    public LinkHolder(View itemView) {
        super(itemView);
        mBuddyB = (TextView)itemView.findViewById(R.id.r_buddy);
        mDistance = (TextView)itemView.findViewById(R.id.r_distance);
    }

    public void bindLink(Link link){
        mBuddyB.setText(link.getBuddyB());
        mDistance.setText(link.getSpace());
    }
}
