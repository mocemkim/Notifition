package com.example.mylibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KIM on 10/23/2018.
 */

public class ManagerDatabase extends SQLiteOpenHelper {
    private final String TIME="time";
    private final String CONTENT ="content";
    private final String ID="id";
    private final String TITLE="title";
    private final String TYPE ="type";
    private static final String TABLE_NAME ="Notification";
    private static final String DATABASE_NAME="ManagerNotification";
    private Context context;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery =  "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                TIME + " TEXT, "+
                TITLE+ " TEXT, "+
                CONTENT +" TEXT, "+
                TYPE +" TEXT "+  "CHECK (" + TYPE +" IN" +"('New','Message')" +")"+
                ")";
        sqLiteDatabase.execSQL(sqlQuery);
    }

    public ManagerDatabase(Context context) {
        super(context,DATABASE_NAME,null,1);
        this.context = context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public ManagerDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public void addNotification(DataNotification dataNotification){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, dataNotification.getTime());
        values.put(TITLE,dataNotification.getTitle());
        values.put(CONTENT, dataNotification.getContent());
        values.put(TYPE,dataNotification.getType());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public List<DataNotification> getAllNotification()
    {
        List<DataNotification> listDataNotifition = new ArrayList<DataNotification>();
        String SQLQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQLQuery,null);
        if(cursor.moveToFirst())
        {
            while(true){
                DataNotification dataNotification = new DataNotification();
                dataNotification.setTime(cursor.getString(1));
                dataNotification.setTitle(cursor.getString(2));
                dataNotification.setContent(cursor.getString(3));
                dataNotification.setType(cursor.getString(4));
                listDataNotifition.add(dataNotification);
                if(cursor.moveToNext()==false)
                {
                    break;
                }
            }
        }
        cursor.close();
        db.close();
        return listDataNotifition;
    }
    public void dropTable()
    {
        String sqlQuery = "DROP TABLE "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sqlQuery);
    }
}
