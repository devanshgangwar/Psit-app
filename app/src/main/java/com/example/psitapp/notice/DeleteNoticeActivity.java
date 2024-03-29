package com.example.psitapp.notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.psitapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DeleteNoticeActivity extends AppCompatActivity {

    private RecyclerView deleteNoticeRecycler;
    private ProgressBar progreeBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_notice);
        deleteNoticeRecycler = findViewById(R.id.deleteNoticeRecycler);
        progreeBar = findViewById(R.id.progresBar);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");
        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(this));
        deleteNoticeRecycler.setHasFixedSize(true);
        getNotice();

    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    NoticeData data = snapshot.getValue(NoticeData.class);
                    list.add(data);
                }
                adapter = new NoticeAdapter(DeleteNoticeActivity.this , list);
                adapter.notifyDataSetChanged();
                progreeBar.setVisibility(View.GONE);
                deleteNoticeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                progreeBar.setVisibility(View.GONE);
                Toast.makeText(DeleteNoticeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}