package com.elihu.sqlitepro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText student_name_et, student_email_et, student_phone_et, student_avatar_et;
    Button submit, gotolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_name_et = findViewById(R.id.student_name_et);
        student_email_et = findViewById(R.id.student_email_et);
        student_phone_et = findViewById(R.id.student_phone_et);
        student_avatar_et = findViewById(R.id.student_avatar_et);
        submit = findViewById(R.id.submit);
        gotolist = findViewById(R.id.gotolist);

        submit.setOnClickListener(this);
        gotolist.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                String sName = student_name_et.getText().toString();
                String sEmail = student_email_et.getText().toString();
                String sPhone = student_phone_et.getText().toString();
                String sAvatar = student_avatar_et.getText().toString();
                CreateStudent(sName,sEmail,sPhone,sAvatar);
                break;
            case R.id.gotolist:
                Intent intent = new Intent(this, StudentsActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void CreateStudent(String sName, String sEmail, String sPhone, String sAvatar) {
        DatabaseHelper db = new DatabaseHelper(this);
        long id = db.createNewStudent(sName,sEmail,sPhone,sAvatar);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("The new student id is: " + id);
        builder.show();
        student_name_et.setText("");
        student_email_et.setText("");
        student_phone_et.setText("");
        student_avatar_et.setText("");
    }
}