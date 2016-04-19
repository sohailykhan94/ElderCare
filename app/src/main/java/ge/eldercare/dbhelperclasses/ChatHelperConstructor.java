package ge.eldercare.dbhelperclasses;

import android.provider.BaseColumns;

/**
 * Created by flazer on 20/4/2016.
 */
public final class ChatHelperConstructor {

    public ChatHelperConstructor(){

    }

    public static abstract class ChatHelperEntry implements BaseColumns{
        public static final String TABLE_NAME ="ChatLog";
        public static final String COLUMN_NAME_FROM_PERSON ="fromPerson";
        public static final String COLUMN_NAME_TO_PERSON = "toPerson";
        public static final String COLUMN_NAME_MESSAGE = "message";
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ", ";
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+ChatHelperEntry.TABLE_NAME+" ("+ChatHelperEntry._ID+
                " INTEGER PRIMARY KEY, "+ChatHelperEntry.COLUMN_NAME_FROM_PERSON+ TEXT_TYPE+COMMA_SEP+COLUMN_NAME_TO_PERSON+TEXT_TYPE+COMMA_SEP
                +COLUMN_NAME_MESSAGE+TEXT_TYPE+COMMA_SEP+ ")";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + ChatHelperEntry.TABLE_NAME;
    }
}
