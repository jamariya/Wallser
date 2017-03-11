package thenextvoyager.wallser.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Abhiroj on 3/9/2017.
 */

public class ImageDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "image.db";

    public ImageDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DB Helper", "Constructor Called");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        addImage(sqLiteDatabase);
        Log.d(ImageDBHelper.class.getSimpleName(), "New Table created");

    }

    private void addImage(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ImageContract.ImageEntry.TABLE_NAME + " ("
                + ImageContract.ImageEntry._ID + " integer PRIMARY KEY," + ImageContract.ImageEntry.COLUMN_NAME + " text NOT NULL UNIQUE,"
                + ImageContract.ImageEntry.COLUMN_REGURL + " text NOT NULL," + ImageContract.ImageEntry.COLUMN_DLDURL + " text NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i(ImageDBHelper.class.getSimpleName(), "Old version = " + i + " New version = " + i1);
    }
}