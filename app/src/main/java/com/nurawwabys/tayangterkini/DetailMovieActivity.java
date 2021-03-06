package com.nurawwabys.tayangterkini;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    String img, judul, desc;
    ImageView tvImg;
    TextView tvJudul, tvDesc;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        tvImg = findViewById(R.id.poster);
        tvJudul = findViewById(R.id.judul);
        tvDesc = findViewById(R.id.desc);

        img = getIntent().getStringExtra("poster_path");
        judul = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("overview");

        Glide.with(getApplicationContext())
                .load("http://image.tmdb.org/t/p/w185"+img)
                .placeholder(R.drawable.img_default_bg)
                .into(tvImg);
        tvJudul.setText(judul);
        tvDesc.setText(desc);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        FloatingActionButton fab = findViewById(R.id.love);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "I Love This!", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detail Movie");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(DetailMovieActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailMovieActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
