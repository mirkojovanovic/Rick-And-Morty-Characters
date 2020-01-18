package com.example.android.mj_rickandmorty.adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.models.Character;
import com.example.android.mj_rickandmorty.ui.episodes.CharacterDetailsActivity;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private Context context;
    private List<Character> characterList;

    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.character_rv_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Character character = characterList.get(position);

        Glide.with(context)
                .load(character.getImage())
                .into(holder.thumbImageView);

        holder.nameTextView.setText(character.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CharacterDetailsActivity.class);
                intent.putExtra("character", character);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbImageView;
        TextView nameTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbImageView = itemView.findViewById(R.id.thumb_image_view);
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }
    }

}
