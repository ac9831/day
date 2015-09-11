package project.hackerton.day.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by kye_won on 2015-08-08.
 */
public class TagDBManager {
    private final String TAG = "DataManager";
    private Context context = null;

    private TagDBHelper helper;
    private TagVO tagVO;
    private HowTagVO howTagVO;
    private WhatTagVO whatTagVO;
    private WhenTagVO whenTagVO;
    private WhereTagVO whereTagVO;
    private WhoTagVO whoTagVO;
    private WhyTagVO whyTagVO;

    public TagDBManager(Context context)
    {
        this.context = context;
        helper = new TagDBHelper(this.context);
    }

    //how 저장
    public void insertHowTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into howTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }
    //what 저장
    public void insertWhatTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into whatTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }
    //when 저장
    public void insertWhenTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into whenTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }
    //where 저장
    public void insertWhereTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into whereTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }
    //who 저장
    public void insertWhoTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into whoTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }
    //why 저장
    public void insertWhyTag(String keyword)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into whyTag values(null, '"
                + keyword + "');";
        db.execSQL(sql);
        helper.close();
    }

    //how 삭제
    public void deleteHow(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from howTag where howT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //what 삭제
    public void deleteWhat(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from whatTag where whatT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //when 삭제
    public void deleteWhen(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from WhenTag where whenT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //where 삭제
    public void deleteWhere(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from whereTag where whereT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //who 삭제
    public void deleteWho(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        if(key.equals("")){
            key = " ";
        }
        String sql = "delete from whoTag where whoT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //why 삭제
    public void deleteWhy(String key)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from whyTag where whyT = '" + key + "';";
        db.execSQL(sql);
        helper.close();
    }

    //화면에 뿌릴 How keyword 조회
    public ArrayList<String> getHowKeywordInfo()
    {
        ArrayList<String> howKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from howTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            howKeywordList.add(ukeyword);
        }
        helper.close();
        cursor.close();

        return howKeywordList;

    }


    public void updateMunjang0(String str){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set dayT = '" + str + "' where id=1";
        db.execSQL(sql);
        helper.close();
    }

    public void updateMunjang1(String str){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set whereT = '" + str + "' where id=1";
        db.execSQL(sql);
        helper.close();
    }

    public void updateMunjang2(String str){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set whoT = '" + str + "' where id=1";
        db.execSQL(sql);
        helper.close();
    }

    public void updateMunjang3(String str){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set whatT = '" + str + "' where id=1";
        db.execSQL(sql);
        helper.close();
    }

    public void updateMunjang4(String str){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set howT = '" + str + "' where id=1";
        db.execSQL(sql);
        helper.close();
    }

    public String selectMunjangD(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select id, dayT from munjang where id = 1";
        Cursor cursor = db.rawQuery(sql, null);
        String uId = "";
        while (cursor.moveToNext()) {
            uId = cursor.getString(1);
        }

        cursor.close();

        return uId;
    }

    public String selectMunjangT(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select whereT,whoT,whatT,howT from munjang where id = 1";
        Cursor cursor = db.rawQuery(sql, null);
        String uId = "";
        while (cursor.moveToNext()) {
            uId = cursor.getString(0) + " ";
            uId = uId +  cursor.getString(1) + " ";
            uId = uId +  cursor.getString(2) + " ";
            uId = uId +  cursor.getString(3) + " ";
        }

        cursor.close();
        return uId;
    }


    //화면에 뿌릴 where keyword 조회
    public ArrayList<String> getWhereKeywordInfo()
    {
        ArrayList<String> whereKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from whereTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            whereKeywordList.add(ukeyword);
        }
        cursor.close();

        return whereKeywordList;

    }

    //화면에 뿌릴 How keyword 조회
    public ArrayList<String> getWhoKeywordInfo()
    {

        ArrayList<String> whoKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from whoTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            whoKeywordList.add(ukeyword);
        }
        cursor.close();

        return whoKeywordList;

    }

    //화면에 뿌릴 When keyword 조회
    public ArrayList<String> getWhenKeywordInfo()
    {
        ArrayList<String> whenKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from whenTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            whenKeywordList.add(ukeyword);
        }
        cursor.close();

        return whenKeywordList;

    }
    //화면에 뿌릴 why keyword 조회
    public ArrayList<String> getWhyKeywordInfo()
    {
        ArrayList<String> whyKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from whyTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            whyKeywordList.add(ukeyword);
        }
        cursor.close();

        return whyKeywordList;

    }


    //화면에 What 뿌릴 keyword 조회
    public ArrayList<String> getWhatKeywordInfo()
    {
        ArrayList<String> whatKeywordList = new ArrayList<String>(); //howKeywordList 생성.
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from whatTag";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String uId = cursor.getString(0);
            String ukeyword = cursor.getString(1);

            whatKeywordList.add(ukeyword);
        }
        cursor.close();

        return whatKeywordList;

    }


    public void initmunjang(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update munjang set howT = '', whereT = '',whoT = '',whatT = ''  where id=1";
        db.execSQL(sql);
        helper.close();
    }

    //main 저장
    public void insertMainTag(String day, String Text)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into mainTag values( null,'"
                + day + "', '"+Text+"');";
        db.execSQL(sql);
        helper.close();
    }


}
