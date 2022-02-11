package com.example.tourapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.tourapp.databinding.ActivityDetailBinding;
import com.example.tourapp.model.TurModel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    TurModel model;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_detail);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);



        model= (TurModel) getIntent().getSerializableExtra("data");
        binding.detailinfo.setText(model.getInfo());
        binding.detailName.setText(model.getName());
        binding.ucret.setText("Ücret : "+model.getPrice()+" TL");
        Picasso.get().load(model.getImage()).into(binding.imageView);


        String ucret=(model.getPrice());
        System.out.println(ucret);
        String a=model.getPrice().trim();
        System.out.println(a);


    }
}