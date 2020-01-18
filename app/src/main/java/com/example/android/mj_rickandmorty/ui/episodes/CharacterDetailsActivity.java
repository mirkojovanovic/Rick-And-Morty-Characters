package com.example.android.mj_rickandmorty.ui.episodes;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.adapters.EpisodeAdapter;
import com.example.android.mj_rickandmorty.models.Character;
import com.example.android.mj_rickandmorty.models.Episode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.mj_rickandmorty.ApiClient.apiService;

public class CharacterDetailsActivity extends AppCompatActivity {

    private TextView mSpeciesTextView;
    private TextView mGenderTextView;
    private ImageView mImageView;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private EpisodeAdapter episodeAdapter;
    private List<Episode> episodeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        Character character = getIntent().getParcelableExtra("character");

        findViewsById();

        mToolbar.setTitle(character.getName());

        mSpeciesTextView.setText(Html.fromHtml(
                getString(R.string.species_property, character.getSpecies())
        ));
        mGenderTextView.setText(Html.fromHtml(
                getString(R.string.gender_property, character.getGender())
        ));
        Glide.with(this)
                .load(character.getImage())
                .into(mImageView);

        for (int i = 0; i < character.getEpisode().size(); i++) {
            getEpisode(i + 1);
        }
        episodeAdapter = new EpisodeAdapter(this, episodeList);
        mRecyclerView.setAdapter(episodeAdapter);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );

    }

    private void findViewsById() {
        mSpeciesTextView = findViewById(R.id.character_detail_species);
        mGenderTextView = findViewById(R.id.character_detail_gender);
        mImageView = findViewById(R.id.character_detail_image);
        mToolbar = findViewById(R.id.character_detail_toolbar);
        mRecyclerView = findViewById(R.id.episodes_rv);
    }

    public void getEpisode(int id) {
        apiService.getEpisode(id).enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                if (response.isSuccessful()) {
                    episodeList.add(response.body());
                    episodeAdapter.notifyItemInserted(episodeList.size() - 1);
                }
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {

            }
        });
    }
}
