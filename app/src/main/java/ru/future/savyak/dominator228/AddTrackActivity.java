package ru.future.savyak.dominator228;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

public class AddTrackActivity extends AppCompatActivity {

    private ImageView ivImage;
    private TextInputLayout tilName;

    private TrackGenerator generator = new TrackGenerator();
    private String avatarLink = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddTrackActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        ivImage= findViewById(R.id.ivImage);
        tilName = findViewById(R.id.tilName);

        loadImage(generator.getImageLink());
        ivImage.setOnClickListener(view -> loadImage(generator.getImageLink()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Track person = generator.getPerson();
            loadImage(person.getImage());
            tilName.getEditText().setText(person.getName());

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_track, menu);
        return super.onCreateOptionsMenu(menu)
;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            String name = tilName.getEditText().getText().toString();


            Track track = new Track(name, "",avatarLink);
            AppDatabase.getInstance(this).TrackDao().insertTrack(track);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage(String link) {
        avatarLink = link;
        Picasso.get().load(avatarLink)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivImage);
    }
}
