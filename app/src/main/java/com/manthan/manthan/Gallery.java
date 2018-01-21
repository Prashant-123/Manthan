package com.manthan.manthan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Gallery extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_gallery);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gallery");

        showImage("0", R.id.pic_1);
        showImage("1", R.id.pic_2);
        showImage("2", R.id.pic_3);
        showImage("3", R.id.pic_4);
        showImage("4", R.id.pic_5);
        showImage("5", R.id.pic_6);
        showImage("6", R.id.pic_7);
        showImage("7", R.id.pic_8);
        showImage("8", R.id.pic_9);
        showImage("9", R.id.pic_10);
    }

    public void showImage(String no, int id)
    {
        final ImageView image = (ImageView) findViewById(id);
        reference = database.getReference("Pics/" + no);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);
                Picasso.with(Gallery.this).load(url).into(image);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
