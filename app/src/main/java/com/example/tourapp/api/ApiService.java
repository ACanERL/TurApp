package com.example.tourapp.api;

import com.example.tourapp.model.TurModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/react-tours-project")
    Call<List<TurModel>>getAll();
}
