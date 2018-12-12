package ru.future.savyak.dominator228;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {
    List<Track> tracks;
    private OnItemClickListener itemClickListener;

    public TrackAdapter(List<Track> tracks, OnItemClickListener itemClickListener) {
        this.tracks = tracks;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        holder.bind(tracks.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void update(List<Track> tracks){
        this.tracks.clear();
        this.tracks.addAll(tracks);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Track item);
    }

    public static class TrackViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvName;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
        }



        public void bind (Track track, final OnItemClickListener itemClickListener){
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(track));
           tvName.setText(track.getName());
            Picasso.get().load(track.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .fit()
                    .centerCrop()
                    .into(ivImage);
        }
    }
}
