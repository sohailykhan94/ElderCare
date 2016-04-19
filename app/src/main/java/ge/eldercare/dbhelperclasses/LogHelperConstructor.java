package ge.eldercare.dbhelperclasses;

import android.provider.BaseColumns;

/**
 * Created by flazer on 20/4/2016.
 */
public final class LogHelperConstructor {

    public LogHelperConstructor(){

    }

    public static abstract class LogHelperEntry implements BaseColumns{
        public static final String TABLE_NAME ="ActivityLog";
        public static final String COLUMN_NAME_TYPE ="type";
        public static final String COLUMN_NAME_MESSAGE = "message";
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+LogHelperEntry.TABLE_NAME+" ("+LogHelperEntry._ID+
                " INTEGER PRIMARY KEY, "+LogHelperEntry.COLUMN_NAME_TYPE+ TEXT_TYPE+COMMA_SEP+LogHelperEntry.COLUMN_NAME_MESSAGE+TEXT_TYPE+ ")";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + LogHelperEntry.TABLE_NAME;
    }
}

