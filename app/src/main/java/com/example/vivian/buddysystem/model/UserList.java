package com.example.vivian.buddysystem.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.vivian.buddysystem.database.UserCursorWrapper;
import com.example.vivian.buddysystem.database.UserDbHelper;
import com.example.vivian.buddysystem.database.UserDbSchema;

import java.util.ArrayList;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class UserList{
    private static UserList sUsers;
    public ArrayList<User> userList;

    private static final String TAG = "USERLIST";
    private final SQLiteDatabase mUserDatabase;


    public UserList(Context context) {
        this.mUserDatabase = new UserDbHelper(context).getWritableDatabase();
        userList = getAllUsers();

    }

    public static synchronized UserList getsUsers(Context context){
        if(sUsers == null){
            sUsers = new UserList(context);
        }

        return sUsers;
    }

    public void addUser(User user){
        Log.d(TAG,"ADD " + user);

        ContentValues values = getUserValues(user);
        mUserDatabase.insert(UserDbSchema.DATABASE_NAME, null, values);
    }

    public User getUserById(String id){
        UserCursorWrapper wrapper = queryUsers(UserDbSchema.UserTable.Cols.ID + "=?", new String[]{id});
        User user;
        try {
            wrapper.moveToFirst();
            user = wrapper.getUser();
            Log.e(TAG, "GET " + user);
        }finally {
            wrapper.close();
        }

        return user;
    }

    public User getUserByUsername(String username){
        UserCursorWrapper wrapper = queryUsers(UserDbSchema.UserTable.Cols.USERNAME + "=?", new String[]{username});
        User user;
        try {
            wrapper.moveToFirst();
            user = wrapper.getUser();
            Log.e(TAG, "GET " + user);
        }finally {
            wrapper.close();
        }

        return user;
    }

    public ArrayList<User> getAllUsers() {
        UserCursorWrapper wrapper = queryUsers(null, null);
        ArrayList<User> list = new ArrayList<User>();

        try {
            wrapper.moveToFirst();
            while(!wrapper.isAfterLast()){
                User user = wrapper.getUser();
                list.add(user);
                wrapper.moveToNext();
            }
        }finally {
            wrapper.close();
        }

        userList = list;
        return list;
    }


    private UserCursorWrapper queryUsers(String where, String[] args){
        Cursor cursor = mUserDatabase.query(
                UserDbSchema.UserTable.TABLENAME, //Table name
                null,               //which columns
                where,              //where clause
                args,               //where arguments
                null,               //group by
                null,               //having
                UserDbSchema.UserTable.Cols.USERNAME + " DESC"   //order by
        );

        return new UserCursorWrapper(cursor);
    }

    public static ContentValues getUserValues(User user){
        ContentValues values = new ContentValues();

        values.put(UserDbSchema.UserTable.Cols.ID, user.getId().toString());
        values.put(UserDbSchema.UserTable.Cols.USERNAME, user.getUsername());
        values.put(UserDbSchema.UserTable.Cols.NAME, user.getName());
        values.put(UserDbSchema.UserTable.Cols.PHONE, user.getPhone());
        values.put(UserDbSchema.UserTable.Cols.PASSWORD, user.getPassword());

        Log.d(TAG, "Values");
        return values;

    }
}
