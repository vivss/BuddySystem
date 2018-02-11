package com.example.vivian.buddysystem.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.vivian.buddysystem.model.Link;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class LinkCursorWrapper extends CursorWrapper{

    public LinkCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Link getLink(){
        Link link = new Link(UUID.fromString(getString(getColumnIndex(LinkDbSchema.LinkTable.Cols.ID))));

        link.setBuddyA(getString(getColumnIndex(LinkDbSchema.LinkTable.Cols.BUDDYA)));
        link.setBuddyB(getString(getColumnIndex(LinkDbSchema.LinkTable.Cols.BUDDYB)));
        link.setStart(new Date(getLong(getColumnIndex(LinkDbSchema.LinkTable.Cols.STARTTIME))));
        link.setEnd(new Date(getLong(getColumnIndex(LinkDbSchema.LinkTable.Cols.ENDTIME))));
        link.setDistance(getInt(getColumnIndex(LinkDbSchema.LinkTable.Cols.DISTANCE)));

        return link;
    }
}
