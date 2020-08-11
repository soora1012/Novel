package com.gmail.soora1012.Novel.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NovelDatabaseManager {
    static final String DB_NOVEL = "Nobel.db";   //DB이름
    static final String TABLE_NOVEL = "Noards"; //Table 이름
    static final int DB_VERSION = 1;			//DB 버전
    Context myContext = null;

    private static NovelDatabaseManager novelDatabaseManager = null;
    private SQLiteDatabase mydatabase = null;



    public static NovelDatabaseManager getInstance(Context context)
    {
        if(novelDatabaseManager == null)
        {
            novelDatabaseManager = new NovelDatabaseManager(context);
        }
        return novelDatabaseManager;
    }


    private NovelDatabaseManager(Context context)
    {
        myContext = context;
        mydatabase = context.openOrCreateDatabase(DB_NOVEL, context.MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NOVEL +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "context TEXT," +
                "date TEXT," +
                "last_continue INTEGER," +
                "views INTEGER);");
    }


    public long insert(ContentValues addRowValue)
    {
        return mydatabase.insert(TABLE_NOVEL, null, addRowValue);
    }



    public Cursor query(String[] colums, String selection, String[] selectionArgs, String groupBy, String having, String orderby)
    {
        return mydatabase.query(TABLE_NOVEL, colums,  selection, selectionArgs, groupBy,  having, orderby);
    }


    public void updateData(int index, int view){
        String sql = "update " + TABLE_NOVEL + " set views = '" + view +"' where _id = "+index +";";
        mydatabase.execSQL(sql);
    }

    public void removeData(int index){
        String sql = "delete from " + TABLE_NOVEL + " where _id = "+index+";";
        mydatabase.execSQL(sql);
    }


}
