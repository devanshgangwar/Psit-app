package com.example.psitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.psitapp.faculty.UpdateFaculty;
import com.example.psitapp.notice.DeleteNoticeActivity;
import com.example.psitapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView uploadNotice, addGalleryImage, addEbook , faculty , deleteNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);

        faculty.setOnClickListener(this);
        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.addNotice){
            intent = new Intent(MainActivity.this, UploadNotice.class);
            startActivity(intent);
        }else if(view.getId() == R.id.addGalleryImage){
            intent = new Intent(MainActivity.this,UploadImage.class);
            startActivity(intent);
        }else if(view.getId() == R.id.addEbook){
            intent = new Intent(MainActivity.this,UploadPdfActivity.class);
            startActivity(intent);
        }else if(view.getId() == R.id.faculty){
            intent = new Intent(MainActivity.this, UpdateFaculty.class);
            startActivity(intent);
        }else if(view.getId() == R.id.deleteNotice){
            intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
            startActivity(intent);
        }
//        switch (view.getId()){
//
//            case R.id.addNotice:
//                intent = new Intent(MainActivity.this, UploadNotice.class);
//                startActivity(intent);
//                break;
//            case  R.id.addGalleryImage:
//                intent = new Intent(MainActivity.this,UploadImage.class);
//                startActivity(intent);
//                break;
//            case R.id.addEbook:
//                intent = new Intent(MainActivity.this,UploadPdfActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.faculty:
//                intent = new Intent(MainActivity.this, UpdateFaculty.class);
//                startActivity(intent);
//                break;
//            case R.id.deleteNotice:
//                intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
//                startActivity(intent);
//                break;


    }
}