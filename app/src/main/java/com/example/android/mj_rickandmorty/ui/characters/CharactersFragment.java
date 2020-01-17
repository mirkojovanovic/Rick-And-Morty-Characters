package com.example.android.mj_rickandmorty.ui.characters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mj_rickandmorty.CharacterAdapter;
import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.models.Character;
import com.example.android.mj_rickandmorty.models.Characters;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.mj_rickandmorty.ApiClient.apiService;

public class CharactersFragment extends Fragment {

    private CharactersViewModel mViewModel;
    private CharacterAdapter characterAdapter;
    private List<Character> characterList = new ArrayList<>();

    public static CharactersFragment newInstance() {
        return new CharactersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.characters_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CharactersViewModel.class);
        // TODO: Use the ViewModel

        RecyclerView charactersRecyclerView = getView().findViewById(R.id.characters_rv);
        characterAdapter = new CharacterAdapter(getContext(), characterList);
        charactersRecyclerView.setAdapter(characterAdapter);
        charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));


        getCharacters();

        SearchView searchView = getView().findViewById(R.id.search_characters_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getCharacters(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //getCharacters(newText);
                return false;
            }
        });
    }

    private void getCharacters() {
        apiService.getCharacters().enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                if (response.isSuccessful()) {
                    characterList.clear();
                    characterList.addAll(response.body().getResults());
                    characterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {

            }
        });
    }

    private void getCharacters(String query) {
        apiService.getCharacters(query).enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                if (response.isSuccessful()) {
                    characterList.clear();
                    characterList.addAll(response.body().getResults());
                    characterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {

            }
        });
    }

}
