package com.example.vivian.buddysystem.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivian.buddysystem.R;
import com.example.vivian.buddysystem.model.Link;
import com.example.vivian.buddysystem.model.LinkList;


import java.util.ArrayList;
import java.util.List;


public class MyLinkRecyclerViewAdapter extends RecyclerView.Adapter<LinkHolder> {

    private ArrayList<Link> mValueList;

    public MyLinkRecyclerViewAdapter(ArrayList<Link> list) {
        mValueList = list;
    }

    @Override
    public LinkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_link, parent, false);
        return new LinkHolder(view);
    }

    @Override
    public void onBindViewHolder(LinkHolder holder, int position) {
        holder.bindLink(mValueList.get(position));
    }

    @Override
    public int getItemCount() {
        return mValueList.size();
    }

}
