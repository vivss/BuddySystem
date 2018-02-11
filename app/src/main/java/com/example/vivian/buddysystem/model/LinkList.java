package com.example.vivian.buddysystem.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.vivian.buddysystem.database.LinkCursorWrapper;
import com.example.vivian.buddysystem.database.LinkDbHelper;
import com.example.vivian.buddysystem.database.LinkDbSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlotte on 2/11/2018.
 */

public class LinkList {
    private final SQLiteDatabase mLinkDatabase;

    public LinkList(Context context){

        mLinkDatabase = new LinkDbHelper(context).getWritableDatabase();
    }

    public void addLink(Link link){
        ContentValues values = getLinkValues(link);
        mLinkDatabase.insert(LinkDbSchema.LinkTable.TABLENAME, null, values);
    }

    public ArrayList<Link> getLinks(User current){ //Get links of user
        LinkCursorWrapper wrapper = queryLinks(LinkDbSchema.LinkTable.Cols.BUDDYA + "=?", new String[]{current.getUsername()});
        Log.d("LinkList", " did the query");
        ArrayList<Link> llll = new ArrayList<Link>();
        try {
            Log.d("LinkList", " try");
            wrapper.moveToFirst();
            while (!wrapper.isAfterLast()){
                Link link = wrapper.getLink();
                llll.add(link);
                wrapper.moveToNext();
            }
        }finally {
            wrapper.close();
        }

        return llll;
    }

    private LinkCursorWrapper queryLinks(String where, String[] args){
        Cursor cursor = mLinkDatabase.query(
                LinkDbSchema.LinkTable.TABLENAME, //Table name
                null,               //which columns
                where,              //where clause
                args,               //where arguments
                null,               //group by
                null,               //having
                LinkDbSchema.LinkTable.Cols.DISTANCE + " DESC"   //order by
        );

        return new LinkCursorWrapper(cursor);
    }


    public static ContentValues getLinkValues(Link link){
        ContentValues values = new ContentValues();

        values.put(LinkDbSchema.LinkTable.Cols.ID, link.getId().toString());
        values.put(LinkDbSchema.LinkTable.Cols.BUDDYA, link.getBuddyA());
        values.put(LinkDbSchema.LinkTable.Cols.BUDDYB, link.getBuddyB());
        values.put(LinkDbSchema.LinkTable.Cols.STARTTIME, link.getStart().getTime());
        values.put(LinkDbSchema.LinkTable.Cols.ENDTIME, link.getEnd().getTime());
        values.put(LinkDbSchema.LinkTable.Cols.DISTANCE, link.getDistance());

        return values;
    }
}
