package com.codedao.truyenonline.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codedao.truyenonline.model.Chuong;
import com.codedao.truyenonline.model.TheLoai;
import com.codedao.truyenonline.model.Truyen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUNG-PTIT on 20/08/2017.
 */

public class TruyenDatabaseHepler extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "TRUYEN_ONLINE";
    private static int DATABASE_VERSION = 1;

    // Create table THE_LOAI
    public static String TABLE_THE_LOAI = "THE_LOAI";

    public static String ID_THE_LOAI = "ID_THE_LOAI";
    public static String TEN_THE_LOAI = "TEN_THE_LOAI";

    // Create table TRUYEN
    public static String TABLE_TRUYEN = "TRUYEN";

    public static String ID_TRUYEN = "ID_TRUYEN";
    public static String TEN_TRUYEN = "TEN_TRUYEN";
    public static String TAC_GIA = "TAC_GIA";
    //public static String ID_THE_LOAI = "ID_THE_LOAI";
    public static String NGAY = "NGAY";
    public static String GIOI_THIEU = "GIOI_THIEU";
    public static String SO_CHUONG = "SO_CHUONG";
    public static String SO_LIKE = "SO_LIKE";
    public static String LUOT_XEM = "LUOT_XEM";
    public static String AVATAR = "AVATAR";
    public static String DANH_GIAU = "DANH_GIAU";

    // Create table CHUONG
    public static String TABLE_CHUONG = "CHUONG";

    public static String ID_CHUONG = "ID_CHUONG";
    //public static String ID_TRUYEN = "ID_TRUYEN";
    public static String NOI_DUNG = "NOI_DUNG";


    public TruyenDatabaseHepler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_THE_LOAI = "CREATE TABLE " + TABLE_THE_LOAI + " (" +
                ID_THE_LOAI + " TEXT PRIMARY KEY," +
                TEN_THE_LOAI + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_THE_LOAI);

        String CREATE_TABLE_TRUYEN = "CREATE TABLE " + TABLE_TRUYEN + " (" +
                ID_TRUYEN + " TEXT PRIMARY KEY, " +
                TEN_TRUYEN + " TEXT, " +
                TAC_GIA + " TEXT, " +
                ID_THE_LOAI + " TEXT, " +
                NGAY + " TEXT, " +
                GIOI_THIEU + " TEXT, " +
                SO_CHUONG + " TEXT, " +
                SO_LIKE + " TEXT, " +
                LUOT_XEM + " TEXT, " +
                AVATAR + " TEXT, " +
                DANH_GIAU + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_TRUYEN);

        String CREATE_TABLE_CHUONG = "CREATE TABLE " + TABLE_CHUONG + " (" +
                ID_CHUONG + " TEXT PRIMARY KEY, " +
                ID_TRUYEN + " TEXT, " +
                NOI_DUNG + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_CHUONG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addTheLoai(TheLoai theLoai) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_THE_LOAI, theLoai.getmIdTheLoai());
        values.put(TEN_THE_LOAI, theLoai.getmTenTheLoai());
        db.insert(TABLE_THE_LOAI, null, values);
        db.close();
    }

    public void addTruyen(Truyen truyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Push gia tri bang contenvalues
        ContentValues values = new ContentValues();
        values.put(ID_TRUYEN, truyen.getmIdTruyen());
        values.put(TEN_TRUYEN, truyen.getmTenTruyen());
        values.put(TAC_GIA, truyen.getmTacGia());
        values.put(ID_THE_LOAI, truyen.getmIdTheLoai());
        values.put(NGAY, truyen.getmNgay());
        values.put(GIOI_THIEU, truyen.getmNoiDung());
        values.put(SO_CHUONG, truyen.getmSoChuong());
        values.put(SO_LIKE, truyen.getmSoLike());
        values.put(LUOT_XEM, truyen.getmLuotXem());
        values.put(AVATAR, truyen.getmAvatar());
        values.put(DANH_GIAU, truyen.getmDanhGiau());
        db.insert(TABLE_TRUYEN, null, values);
        db.close();
    }

    public void addChuong(Chuong chuong) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_CHUONG, chuong.getmIdChuong());
        values.put(ID_TRUYEN, chuong.getmIdTruyen());
        values.put(NOI_DUNG, chuong.getmNoiDung());
        db.insert(TABLE_CHUONG, null, values);
        db.close();
    }

    public void deteleTruyen(Truyen truyen) {

    }

    public List<Truyen> getAllTruyen() {
        List<Truyen> truyens = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_TRUYEN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            Truyen truyen;
            do {
                truyen = new Truyen();
                truyen.setmIdTruyen(cursor.getString(0));
                truyen.setmTenTruyen(cursor.getString(1));
                truyen.setmTacGia(cursor.getString(2));
                truyen.setmIdTheLoai(cursor.getString(3));
                truyen.setmNgay(cursor.getString(4));
                truyen.setmNoiDung(cursor.getString(5));
                truyen.setmSoChuong(cursor.getString(6));
                truyen.setmSoLike(cursor.getString(7));
                truyen.setmLuotXem(cursor.getString(8));
                truyen.setmAvatar(cursor.getString(9));
                truyen.setmDanhGiau(cursor.getString(10));
                truyens.add(truyen);
            } while (cursor.moveToNext());
        }
        return truyens;
    }

    public List<Truyen> getListTruyenByIdType(int idTheLoai) {
        List<Truyen> truyens = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_TRUYEN + " WHERE ID_THE_LOAI = " + idTheLoai + "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            Truyen truyen;
            do {
                truyen = new Truyen();
                truyen.setmIdTruyen(cursor.getString(0));
                truyen.setmTenTruyen(cursor.getString(1));
                truyen.setmTacGia(cursor.getString(2));
                truyen.setmIdTheLoai(cursor.getString(3));
                truyen.setmNgay(cursor.getString(4));
                truyen.setmNoiDung(cursor.getString(5));
                truyen.setmSoChuong(cursor.getString(6));
                truyen.setmSoLike(cursor.getString(7));
                truyen.setmLuotXem(cursor.getString(8));
                truyen.setmAvatar(cursor.getString(9));
                truyen.setmDanhGiau(cursor.getString(10));
                truyens.add(truyen);
            } while (cursor.moveToNext());
        }
        return truyens;
    }

}
