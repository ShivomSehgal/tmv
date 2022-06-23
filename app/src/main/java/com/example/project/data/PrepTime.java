package com.example.project.data;

import android.provider.BaseColumns;

public final class PrepTime {

    private PrepTime(){}

    public static final class PrepEntry implements BaseColumns{

        public final static String TABLE_NAME = "INTERVIEW_PREP";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "DATE";
        public final static String COLUMN_PROBLEM_SOLVING = "PROBLEM_SOLVING";
        public final static String COLUMN_PROJECT = "PROJECT";
        public final static String COLUMN_TASK = "TASK";

        public static final int TASK_NOT_DONE = 0;
        public static final int TASK_INCOMPLETE = 1;
        public static final int TASK_COMPLETE = 2;

    }

}
