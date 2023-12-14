package sr.unasat.crudv2;

import static sr.unasat.crudv2.DatabaseHelper.COLUMN_DATE;
import static sr.unasat.crudv2.DatabaseHelper.COLUMN_ID;
//import static sr.unasat.crudv2.DatabaseHelper.COLUMN_LATITUDE;
//import static sr.unasat.crudv2.DatabaseHelper.COLUMN_LONGITUDE;
import static sr.unasat.crudv2.DatabaseHelper.COLUMN_TIME;
import static sr.unasat.crudv2.DatabaseHelper.TABLE_NAME;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataDAO {


    public static final String COLUMN_CUSTOM_DATA = "custom_data";

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DataDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertData(DataModel data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, data.getDate());
        values.put(COLUMN_TIME, data.getTime());
        values.put(DatabaseHelper.COLUMN_CUSTOM_DATA, data.getCustomData());
        //values.put(COLUMN_LATITUDE, data.getLatitude()); //locatie
        //values.put(COLUMN_LONGITUDE, data.getLongitude()); //locatie

        return database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }



    @SuppressLint("Range")
    public List<DataModel> getAllData() {
        List<DataModel> dataList = new ArrayList<>();

        /*String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DataModel data = new DataModel();
                data.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
                data.setDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)));
                data.setTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIME)));
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return dataList;
    }*/
        /*SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                DataModel data = new DataModel();
                data.setId((int) cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                data.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                data.setTime(cursor.getString(cursor.getColumnIndex(COLUMN_TIME)));
                data.setCustomData(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOM_DATA)));  // Gebruik de juiste kolomnaam hier
                dataList.add(data);
            } while (cursor.moveToNext());

            cursor.close();
        }

        db.close();
        return dataList;
    }*/

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                DataModel data = new DataModel();
                data.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
                data.setDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)));
                data.setTime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIME)));
                data.setCustomData(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOM_DATA)));
                //data.setLatitude(cursor.getDouble(cursor.getColumnIndex(COLUMN_LATITUDE)));
                //data.setLongitude(cursor.getDouble(cursor.getColumnIndex(COLUMN_LONGITUDE)));
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return dataList;
    }
}
