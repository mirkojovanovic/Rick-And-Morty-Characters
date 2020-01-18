package com.example.android.mj_rickandmorty.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.models.Episode;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    private Context context;
    private List<Episode> episodeList;

    public EpisodeAdapter(Context context, List<Episode> episodeList) {
        this.context = context;
        this.episodeList = episodeList;
    }

    @NonNull
    @Override
    public EpisodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.episode_rv_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Episode episode = episodeList.get(position);

        holder.nameTextView.setText(episode.getName());
        holder.airDateTextView.setText(episode.getAirDate());
        holder.episodeTextView.setText(episode.getEpisode());
    }

    @Override
    public int getItemCount() {
        return episodeList == null ? 0 : episodeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView airDateTextView;
        TextView episodeTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name_text_view);
            airDateTextView = itemView.findViewById(R.id.airing_date_text_view);
            episodeTextView = itemView.findViewById(R.id.episode_number_text_view);
        }
    }
}
