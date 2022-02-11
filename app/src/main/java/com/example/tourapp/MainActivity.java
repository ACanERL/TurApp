package com.example.tourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tourapp.adapter.CustomAdapter;
import com.example.tourapp.api.ApiService;
import com.example.tourapp.api.OnClick;
import com.example.tourapp.api.RetrofitInstance;
import com.example.tourapp.databinding.ActivityMainBinding;
import com.example.tourapp.model.TurModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements OnClick {
    private ActivityMainBinding binding;
    CustomAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Yükleniyor...");
        progressDialog.show();

        ApiService apiService=RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<List<TurModel>>call=apiService.getAll();
        call.enqueue(new Callback<List<TurModel>>() {
            @Override
            public void onResponse(Call<List<TurModel>> call, Response<List<TurModel>> response) {
                if(response.isSuccessful()){
                    dataList(response.body());
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this,"Veri Bulunamadı.",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<TurModel>> call, Throwable t) {

            }
        });
    }
    private void dataList(List<TurModel>list){
        adapter=new CustomAdapter(this,list,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(TurModel model) {
        startActivity(new Intent(MainActivity.this,DetailActivity.class).putExtra("data",model));
    }
}