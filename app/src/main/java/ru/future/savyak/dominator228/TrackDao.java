package ru.future.savyak.dominator228;

        import java.util.List;

        import androidx.room.Dao;
        import androidx.room.Insert;
        import androidx.room.Query;

@Dao
public interface TrackDao {
    @Query("SELECT * FROM Tracks")
    List<Track> getAll();

    @Query("SELECT * FROM Tracks WHERE id = :id")
    Track getById(long id);

    @Insert
    long insertTrack(Track track);
}