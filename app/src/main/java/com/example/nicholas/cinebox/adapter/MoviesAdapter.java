package com.example.nicholas.cinebox.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.activities.DetailActivity;
import com.example.nicholas.cinebox.model.MoviesModel;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MoviesModel> movies;
    private Context mContext;

    public MoviesAdapter(List<MoviesModel> movies, Context context) {
        this.movies = movies;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviesModel model = movies.get(position);
        holder.title.setText(model.getTitle());
        holder.genre.setText(model.getGenre());
        holder.pg.setText(model.getPg());
        holder.description.setText(model.getDescription());
        Glide.with(mContext).load(model.getImage()).into(holder.avatar);

        String title = model.getTitle();
        String genre = model.getGenre();
        String pg = model.getPg();
        String description = model.getDescription();
        String image = model.getImage();
        String duration = model.getDuration();
        String release_date = model.getRelease_date();
        String background = model.getBackground();
        String trailer = model.getTrailer();
        String language = model.getLanguage();
        String rating = model.getRating();

        holder.movie_card.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("genre", genre);
            intent.putExtra("pg",pg);
            intent.putExtra("description", description);
            intent.putExtra("image", image);
            intent.putExtra("duration", duration);
            intent.putExtra("release_date", release_date);
            intent.putExtra("background", background);
            intent.putExtra("trailer", trailer);
            intent.putExtra("language", language);
            intent.putExtra("rating", rating);
            mContext.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        //movies.clear();
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre, pg, description;
        public ImageView avatar;
        public CardView movie_card;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movie_title);
            genre = itemView.findViewById(R.id.movie_genre);
            pg = itemView.findViewById(R.id.movie_pg);
            description = itemView.findViewById(R.id.movie_description);
            avatar = itemView.findViewById(R.id.movie_img);
            //background = itemView.findViewById(R.id.movie_background);
            movie_card = itemView.findViewById(R.id.movie_card);
        }
    }
}
