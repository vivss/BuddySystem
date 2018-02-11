package com.example.vivian.buddysystem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charlotte on 2/10/2018.
 *
 */

public class UserDbHelper extends SQLiteOpenHelper{
    private static int VERSION = 2;

    public UserDbHelper(Context contextor) {
        super(contextor, UserDbSchema.DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL("create table " + UserDbSchema.UserTable.TABLENAME
                + "(_id integer primary key autoincrement, "
                + UserDbSchema.UserTable.Cols.ID + ", "
                + UserDbSchema.UserTable.Cols.USERNAME + ", "
                + UserDbSchema.UserTable.Cols.NAME + ", "
                + UserDbSchema.UserTable.Cols.PHONE + ", "
                + UserDbSchema.UserTable.Cols.PASSWORD + ", "
                + UserDbSchema.UserTable.Cols.LATITUDE + ", "
                + UserDbSchema.UserTable.Cols.LONGITUDE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
