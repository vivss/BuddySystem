package com.example.vivian.buddysystem.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.vivian.buddysystem.model.User;

import java.util.UUID;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class UserCursorWrapper extends CursorWrapper{

    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser(){
        User user = new User(UUID.fromString(getString(getColumnIndex(UserDbSchema.UserTable.Cols.ID))));

        user.setName(getString(getColumnIndex(UserDbSchema.UserTable.Cols.NAME)));
        user.setUsername(getString(getColumnIndex(UserDbSchema.UserTable.Cols.USERNAME)));
        user.setPhone(getString(getColumnIndex(UserDbSchema.UserTable.Cols.PHONE)));
        user.setPassword(getString(getColumnIndex(UserDbSchema.UserTable.Cols.PASSWORD)));

        return user;
    }
}
