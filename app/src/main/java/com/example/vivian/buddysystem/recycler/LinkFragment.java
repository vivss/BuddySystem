package com.example.vivian.buddysystem.recycler;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        Log.d("FRAG", " make a frag");

        View view = inflater.inflate(R.layout.fragment_link_list, container, false);

        mView = (RecyclerView)view.findViewById(R.id.list_link_re);
        mView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUList = UserList.getsUsers(getContext());
        Log.d("FRAG", " we got userlist");
        mList = new LinkList(getContext());
        Log.d("FRAG", " we got listist");

        ArrayList<Link> list = mList.getLinks(mUList.getCurrentUser());
        Log.d("FRAG", " we got list");
        if(mAdapter == null){
            Log.d("FRAG", " Adapter is null");
            mAdapter = new MyLinkRecyclerViewAdapter(list);
            mView.setAdapter(mAdapter);
        }

        Log.d("FRAG", " end of frag make");

        return view;
    }


}
