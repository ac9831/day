package project.hackerton.day.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kye_won on 2015-08-08.
 */
public class TagDBHelper extends SQLiteOpenHelper {

    private final String TAG = "DBHelper";

    public TagDBHelper(Context context) {
        super(context, "daytag.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQLiteOpenHelper가 최초 실행 되었을 때
        Log.i(TAG, "In onCreate");
        String sql = "create table mainTag(" +
                "_id integer primary key autoincrement," +
                "whentext text," +
                "maintext text);" ;
        db.execSQL(sql);

        String sql1 = "create table whoTag(" +
                "_id integer primary key autoincrement," +
                "whoT text);" ;
        db.execSQL(sql1);

        String sql2 = "create table whatTag(" +
                "_id integer primary key autoincrement," +
                "whatT text);" ;
        db.execSQL(sql2);

        String sql3 = "create table whyTag(" +
                "_id integer primary key autoincrement," +
                "whyT text);" ;
        db.execSQL(sql3);

        String sql4 = "create table whenTag(" +
                "_id integer primary key autoincrement," +
                "whenT text);" ;
        db.execSQL(sql4);

        String sql5 = "create table whereTag(" +
                "_id integer primary key autoincrement," +
                "whereT text);" ;
        db.execSQL(sql5);

        String sql6 = "create table howTag(" +
                "_id integer primary key autoincrement," +
                "howT text);" ;
        db.execSQL(sql6);

        String sql7 = "create table munjang(" +
                "id integer primary key autoincrement," +
                "dayT text, whereT text, whoT text, whatT text, howT text);" ;
        db.execSQL(sql7);

        String sql7_ = "insert into munjang values(1,null,null,null,null,null)";
        db.execSQL(sql7_);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "In onUpgrade");
        db.execSQL("DROP TABLE IF EXISTS mainTag");
        db.execSQL("DROP TABLE IF EXISTS whoTag");
        db.execSQL("DROP TABLE IF EXISTS whatTag");
        db.execSQL("DROP TABLE IF EXISTS whyTag");
        db.execSQL("DROP TABLE IF EXISTS whenTag");
        db.execSQL("DROP TABLE IF EXISTS whereTag");
        db.execSQL("DROP TABLE IF EXISTS howTag");
        db.execSQL("DROP TABLE IF EXISTS munjang");
        onCreate(db);
    }
}
