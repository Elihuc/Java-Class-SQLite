package com.elihu.sqlitepro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "kobi_db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Student.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    //CREATE
    public long createNewStudent(String studentName, String studentEmail, String studentPhone, String studentAvatar){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.COLUMN_NAME, studentName);
        contentValues.put(Student.COLUMN_EMAIL, studentEmail);
        contentValues.put(Student.COLUMN_PHONE, studentPhone);
        contentValues.put(Student.COLUMN_AVATAR, studentAvatar);

        long id = db.insert(Student.TABLE_NAME, null, contentValues);
        db.close();
        return id;
    }


    //READ
    public ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();

        String query = "SELECT * FROM " + Student.TABLE_NAME + " ORDER BY "
                + Student.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Student.COLUMN_ID)));
                student.setStudent_name(cursor.getString(cursor.getColumnIndexOrThrow(Student.COLUMN_NAME)));
                student.setStudent_email(cursor.getString(cursor.getColumnIndexOrThrow(Student.COLUMN_EMAIL)));
                student.setStudent_phone(cursor.getString(cursor.getColumnIndexOrThrow(Student.COLUMN_PHONE)));
                student.setStudent_avatar(cursor.getString(cursor.getColumnIndexOrThrow(Student.COLUMN_AVATAR)));
                students.add(student);
            } while (cursor.moveToNext());
        }
        db.close();
        return students;
    }



    //DELETE
    public void deleteStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Student.TABLE_NAME, Student.COLUMN_ID + " = ?",
                new String[]{String.valueOf(student.getId())});
        db.close();
    }

    //UPDATE
    public int updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.COLUMN_NAME, student.getStudent_name());
        contentValues.put(Student.COLUMN_EMAIL, student.getStudent_email());
        contentValues.put(Student.COLUMN_PHONE, student.getStudent_phone());
        contentValues.put(Student.COLUMN_AVATAR, student.getStudent_avatar());

        int id = db.update(Student.TABLE_NAME, contentValues, Student.COLUMN_ID + " = ?",
                new String[]{String.valueOf(student.getId())});

        db.close();
        return id;
    }



}