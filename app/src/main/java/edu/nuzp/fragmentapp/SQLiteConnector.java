package edu.nuzp.fragmentapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConnector extends SQLiteOpenHelper
{
    public SQLiteConnector(Context context)
    {
        super(context, "myDB1", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL("create table desk (_id integer primary key autoincrement, imgval integer)");
        db.execSQL("insert into desk (imgval) values(0), ("+ R.drawable.white1 +") ,(0), ("+ R.drawable.white2 +"), (0), ("+ R.drawable.white3 +")," +
                "            (0), ("+ R.drawable.white4 +"), ("+ R.drawable.white5 +"), (0), ("+ R.drawable.white6 +"), (0), ("+ R.drawable.white7 +"), (0)," +
                "            ("+ R.drawable.white8 +"), (0), (0), (0), (0), (0), (0), (0)," +
                "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                "            (0), (0), (0), ("+ R.drawable.black1 +"), (0), ("+ R.drawable.black2 +"), (0), ("+ R.drawable.black3 +")," +
                "            (0), ("+ R.drawable.black4 +"), ("+ R.drawable.black5 +"), (0), ("+ R.drawable.black6 +"), (0), ("+ R.drawable.black7 +"), (0), ("+ R.drawable.black8 +"), (0)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(oldVersion==1 && newVersion==2)
        {
        }
        //else if
    }
}
