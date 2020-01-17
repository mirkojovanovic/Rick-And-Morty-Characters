package com.example.android.mj_rickandmorty;

import com.example.android.mj_rickandmorty.models.Characters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("character")
    Call<Characters> getCharacters();

    @GET("character/{name}")
    Call<Characters> getCharactersByQuery(String name);
}
