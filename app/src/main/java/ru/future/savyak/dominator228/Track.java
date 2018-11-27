
package ru.future.savyak.dominator228;

import java.util.Objects;

public class Track {
    private long id;
    private String name;
    private String path;
    private String image;

    public Track(String name, String path, String image) {
        this(0, name, path, image);
    }

    public Track(long id, String name, String path, String image) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.image = image;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id &&
                Objects.equals(name, track.name) &&
                Objects.equals(path, track.path) &&
                Objects.equals(image, track.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, path, image);
    }
}