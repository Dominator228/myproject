package ru.future.savyak.dominator228;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Music extends AppCompatActivity {

    TrackAdapter adapter;
    TrackGenerator generator = new TrackGenerator();

    private static final String TAG = Music.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddTrackActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

    private void updateList() {
        List<Track> tracks = AppDatabase.getInstance(this).TrackDao().getAll();
        adapter.update(tracks);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        updateList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void initList(){
        RecyclerView rvTracks = findViewById(R.id.rvTrack);
        rvTracks.setHasFixedSize(true);
        rvTracks.setLayoutManager(new GridLayoutManager(this, 2));
        List<Track> tracks = AppDatabase.getInstance(this).TrackDao().getAll();
        adapter = new TrackAdapter(tracks, item -> {
            Toast.makeText(this, item.getName(), Toast.LENGTH_LONG).show();
        });
        rvTracks.setAdapter(adapter);

    }
}
