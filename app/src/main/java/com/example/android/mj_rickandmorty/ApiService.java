package com.example.android.mj_rickandmorty;

import com.example.android.mj_rickandmorty.models.Characters;
import com.example.android.mj_rickandmorty.models.Episodes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("character")
    Call<Characters> getCharacters();

    @GET("character")
    Call<Characters> getCharacters(@Query("name") String name);

    @GET("episode")
    Call<Episodes> getEpisodes();
}
