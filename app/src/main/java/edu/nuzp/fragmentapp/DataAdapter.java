package edu.nuzp.fragmentapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.concurrent.ExecutionException;

public class DataAdapter extends BaseAdapter {
    public class TableForSaveAsincTask extends AsyncTask<Void,Void,Void>//1   2   3
    {
        @Override
        protected Void doInBackground(Void... voids)//
        {
            dbHelper = new SQLiteConnector(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS "+"saveddesk");
            db.execSQL("create table saveddesk (_id integer primary key autoincrement, imgval integer)");
            db.execSQL("insert into saveddesk (imgval) values(0), ("+ R.drawable.white1 +") ,(0), ("+ R.drawable.white2 +"), (0), ("+ R.drawable.white3 +")," +
                    "            (0), ("+ R.drawable.white4 +"), ("+ R.drawable.white5 +"), (0), ("+ R.drawable.white6 +"), (0), ("+ R.drawable.white7 +"), (0)," +
                    "            ("+ R.drawable.white8 +"), (0), (0), (0), (0), (0), (0), (0)," +
                    "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                    "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                    "            (0), (0), (0), (0), (0), (0), (0), (0)," +
                    "            (0), (0), (0), ("+ R.drawable.black1 +"), (0), ("+ R.drawable.black2 +"), (0), ("+ R.drawable.black3 +")," +
                    "            (0), ("+ R.drawable.black4 +"), ("+ R.drawable.black5 +"), (0), ("+ R.drawable.black6 +"), (0), ("+ R.drawable.black7 +"), (0), ("+ R.drawable.black8 +"), (0)");
            dbHelper.close();
            return null;
        }
    }
    public class FillDeskAsincTask extends AsyncTask<Integer,Void,Integer>//1   2   3
    {
        @Override
        protected Integer doInBackground(Integer... integers)//
        {
            dbHelper = new SQLiteConnector(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int value=0;
            Cursor c = db.query("desk", null, null, null, null, null, null);
            c.moveToPosition(integers[0]);
            int valColIndex = c.getColumnIndex("imgval");
            value = c.getInt(valColIndex);
            c.close();
            dbHelper.close();
            return value;
        }
    }
    public class FillSavedDeskAsincTask extends AsyncTask<Integer,Void,Integer>//1   2   3
    {
        @Override
        protected Integer doInBackground(Integer... integers)//
        {
            dbHelper = new SQLiteConnector(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int value=0;
            Cursor c = db.query("saveddesk", null, null, null, null, null, null);
            c.moveToPosition(integers[0]);
            int valColIndex = c.getColumnIndex("imgval");
            value = c.getInt(valColIndex);
            c.close();
            dbHelper.close();
            return value;
        }
    }
    public class SaveDeskAsincTask extends AsyncTask<Integer,Void,Void>//1   2   3
    {
        @Override
        protected Void doInBackground(Integer... integers)//
        {
            dbHelper = new SQLiteConnector(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("update saveddesk set imgval="+integers[1] +" where _id="+ (integers[0]+1));
            dbHelper.close();
            return null;
        }
    }
    public Integer[] mThumbIds = new Integer[64];
    private Context mContext;
    ImageView imageView;
    SQLiteConnector dbHelper;
    private Fragment2 fragment2;
    public DataAdapter(Context c,boolean fl) {
        mContext = c;
        dbHelper = new SQLiteConnector(mContext);
        fragment2 = new Fragment2();
        if(fl==true) {
            TableForSaveAsincTask crMass = new TableForSaveAsincTask();
            crMass.execute();
            for (int i = 0; i < 64; i++) {
                FillDeskAsincTask filMass = new FillDeskAsincTask();
                filMass.execute(i);
                try {
                    mThumbIds[i] = filMass.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            for (int i = 0; i < 64; i++) {
                FillSavedDeskAsincTask filsMass = new FillSavedDeskAsincTask();
                filsMass.execute(i);
                try {
                    mThumbIds[i] = filsMass.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(117, 112));
        } else {
            imageView = (ImageView) convertView;
        }
            imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    public void updateSaved(int pos, int val) {
        SaveDeskAsincTask updDesk = new SaveDeskAsincTask();
        updDesk.execute(pos,val);
    }
    public void changeItem(int pos,int val) {
        this.mThumbIds[pos] = val;
        notifyDataSetChanged();
    }
    public int getGridItem(int position) {
        return mThumbIds[position];
    }

}