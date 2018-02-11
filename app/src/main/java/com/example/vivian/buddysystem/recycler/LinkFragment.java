package com.example.vivian.buddysystem.recycler;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivian.buddysystem.R;
import com.example.vivian.buddysystem.model.Link;
import com.example.vivian.buddysystem.model.LinkList;
import com.example.vivian.buddysystem.model.User;
import com.example.vivian.buddysystem.model.UserList;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 *
 */
public class LinkFragment extends Fragment {

    private RecyclerView mView;
    private MyLinkRecyclerViewAdapter mAdapter;
    private UserList mUList;
    private LinkList mList;


    public LinkFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_link_list, container, false);

        mView = (RecyclerView)view.findViewById(R.id.list_link_re);
        mView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUList = UserList.getsUsers(getContext());
        mList = new LinkList(getContext());

        update();

        return view;
    }

    public void update(){
        ArrayList<Link> list = mList.getLinks(mUList.getCurrentUser());
        if(mAdapter == null){
            mAdapter = new MyLinkRecyclerViewAdapter(list);
            mView.setAdapter(mAdapter);
        }

        //update stuff idk
    }


}
