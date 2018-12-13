package ru.future.savyak.dominator228;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class TrackDetails extends AppCompatActivity {

    private static final String EXTRA_TRACK_ID = "ru.future.savyak.dominator228.extras.EXTRA_TRACK_ID";

    private FloatingActionButton fab;
    private MediaPlayer mediaPlayer;
    private PlayerState playerState;

    public static Intent getStartIntent(Context context, long personId) {
        return new Intent(context, TrackDetails.class).putExtra(EXTRA_TRACK_ID, personId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);
        initUi();
        initFab();
    }

    @Override
    protected void onStart() {
        super.onStart();
        playerState = PlayerState.STOPPED;
        updateFabUi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void initFab() {
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            if (PlayerState.STARTED.equals(playerState)) {
                stopPlayer();
            } else {
                startPlayer();
            }
        });
    }

    private void startPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.believer);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mp -> stopPlayer());
        playerState = PlayerState.STARTED;
        updateFabUi();
    }

    private void stopPlayer() {
        mediaPlayer.stop();
        playerState = PlayerState.STOPPED;
        updateFabUi();
    }

    private void updateFabUi() {
        if (PlayerState.STARTED.equals(playerState)) {
            fab.setImageResource(R.drawable.ic_stop_black_24dp);
        } else {
            fab.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        }
    }

    private void initUi() {
        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvName);

        final long personId = getIntent().getLongExtra(EXTRA_TRACK_ID, 0);
        final Track person = AppDatabase.getInstance(this).TrackDao().getById(personId);
        Picasso.get().load(person.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivAvatar);
        tvName.setText(person.getName());
    }

    private enum PlayerState {
        STARTED,
        STOPPED
    }
}
