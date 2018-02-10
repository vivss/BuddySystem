package com.example.vivian.buddysystem.database;

/**
 * Created by Charlotte on 2/10/2018.
 * Schema for the User Database
 */

public class UserDbSchema {
    public static final String DATABASE_NAME = "users.db";

    public static final class UserTable {
        public static final String TABLENAME = "users";

        public static final class Cols {
            public static final String ID = "id";
            public static final String USERNAME = "username";
            public static final String NAME = "name";
            public static final String PHONE = "phone";
            public static final String PASSWORD = "password";

        }
    }
}
