package com.example.android.mj_rickandmorty.ui.episodes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.adapters.EpisodeAdapter;
import com.example.android.mj_rickandmorty.models.Episode;
import com.example.android.mj_rickandmorty.models.Episodes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.mj_rickandmorty.ApiClient.apiService;

public class EpisodesFragment extends Fragment {

    private EpisodesViewModel mViewModel;
    private EpisodeAdapter episodeAdapter;
    private List<Episode> episodeList = new ArrayList<>();

    public static EpisodesFragment newInstance() {
        return new EpisodesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EpisodesViewModel.class);
        // TODO: Use the ViewModel

        RecyclerView episodesRecyclerView = getView().findViewById(R.id.episodes_rv);
        episodeAdapter = new EpisodeAdapter(getContext(), episodeList);
        episodesRecyclerView.setAdapter(episodeAdapter);
        episodesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        getEpisodes();
    }

    private void getEpisodes() {
        apiService.getEpisodes().enqueue(new Callback<Episodes>() {
            @Override
            public void onResponse(Call<Episodes> call, Response<Episodes> response) {
                if (response.isSuccessful()) {
                    if (episodeList.size() == 0) {
                        episodeList.addAll(response.body().getResults());
                        episodeAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<Episodes> call, Throwable t) {

            }
        });
    }

}
