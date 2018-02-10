package com.example.vivian.buddysystem.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class LinkCursorWrapper extends CursorWrapper{

    public LinkCursorWrapper(Cursor cursor) {
        super(cursor);
    }
}
