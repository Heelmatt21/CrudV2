package sr.unasat.crudv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "YourDatabaseName";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "YourTableName";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    public static final String COLUMN_CUSTOM_DATA = "custom_data";
    //public static final String COLUMN_LATITUDE = "latitude"; //locatie
    //public static final String COLUMN_LONGITUDE = "longitude"; //locatie




    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_CUSTOM_DATA + " TEXT);";
                    //COLUMN_LATITUDE + " REAL, " + //Locatie
                    //COLUMN_LONGITUDE + " REAL);";  //Locatie





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertData(DataModel data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, data.getDate());
        values.put(COLUMN_TIME, data.getTime());
        values.put(COLUMN_CUSTOM_DATA, data.getCustomData());
        //values.put(COLUMN_LATITUDE, data.getLatitude()); //locatie
        //values.put(COLUMN_LONGITUDE, data.getLongitude()); //locatie

        SQLiteDatabase db = getWritableDatabase(); // <-- Verander deze regel
        long result = db.insert(TABLE_NAME, null, values);

        db.close(); // <-- Verander deze regel
        return result;
    }


}

