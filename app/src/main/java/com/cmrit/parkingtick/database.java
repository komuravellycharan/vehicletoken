package com.cmrit.parkingtick;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cmrit.parkingtick.parkingdetails.tableschema;

public class database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "parkingdetails.db";
    private static final int DATABASE_VERSION = 1;

    private final String SQL_CREATE_TABLE
            = "CREATE TABLE " + tableschema.TABLE_NAME
            + " (" + tableschema._ID + " TEXT PRIMARY KEY , "
            + tableschema.IN_TIME + " TEXT NOT NULL, "
            + tableschema.VEHICLE_TYPE + " TEXT NOT NULL, "
            + tableschema.SPACE_TAKEN+" TEXT NOT NULL "+");";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ideally we wouldn't want to delete all of our entries!
        db.execSQL("DROP TABLE IF EXISTS " + tableschema.TABLE_NAME);
        onCreate(db);	// Call to create a new db with upgraded schema and version
    }
}