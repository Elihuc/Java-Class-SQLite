package com.elihu.sqlitepro;

public class Student {

    //DEFINE TABLE AND TABLE COLUMNS
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "student_id";
    public static final String COLUMN_NAME = "student_name";
    public static final String COLUMN_EMAIL = "student_email";
    public static final String COLUMN_PHONE = "student_phone";
    public static final String COLUMN_AVATAR = "student_avatar";

    private String student_name;
    private String student_email;
    private String student_phone;
    private String student_avatar;
    private int id;

    //CREATE TABLE
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_PHONE + " TEXT,"
                    + COLUMN_AVATAR + " TEXT)";

    //CONSTRUCTOR
    public Student(){

    }

    public Student(String student_name, String student_email, String student_phone, int id, String student_avatar) {
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_phone = student_phone;
        this.id = id;
        this.student_avatar = student_avatar;
    }


    //VARIABLES
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_avatar() {
        return student_avatar;
    }

    public void setStudent_avatar(String student_avatar) {
        this.student_avatar = student_avatar;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
