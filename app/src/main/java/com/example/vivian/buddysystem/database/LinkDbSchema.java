package com.example.vivian.buddysystem.database;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class LinkDbSchema {
    public static final String DATABASE_NAME = "link.db";

    public static final class LinkTable {
        public static final String TABLENAME = "link";

        public static final class Cols {
            public static final String ID = "id";
            public static final String BUDDYA = "buddyA";
            public static final String BUDDYB = "buddyB";
            public static final String STARTTIME = "startTime";
            public static final String ENDTIME = "endTime";

        }
    }
}
