package com.example.vivian.buddysystem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class LinkDbHelper extends SQLiteOpenHelper {
    private static int VERSION = 1;

    public LinkDbHelper(Context context) {
        super(context, LinkDbSchema.LinkTable.TABLENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + LinkDbSchema.LinkTable.TABLENAME
                + "(_id integer primary key autoincrement, "
                + LinkDbSchema.LinkTable.Cols.ID + ", "
                + LinkDbSchema.LinkTable.Cols.BUDDYA + ", "
                + LinkDbSchema.LinkTable.Cols.BUDDYB + ", "
                + LinkDbSchema.LinkTable.Cols.STARTTIME + ", "
                + LinkDbSchema.LinkTable.Cols.ENDTIME + ")"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
