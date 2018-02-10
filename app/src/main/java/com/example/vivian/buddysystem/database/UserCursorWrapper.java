package com.example.vivian.buddysystem.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class UserCursorWrapper extends CursorWrapper{

    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }
}
