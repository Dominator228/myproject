package ru.future.savyak.dominator228;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackAdapter extends RecyclerView.Adapter {
    public static class TrackViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvName;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
        }
        public void bind (Track track){
           tvName.setText(track.getName());

        }
    }
}
