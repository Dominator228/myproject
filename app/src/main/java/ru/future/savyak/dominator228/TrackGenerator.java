package ru.future.savyak.dominator228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TrackGenerator {

    private static final String[] names = new String[]{"Believer", "Birds", "Radioactive", "Sad!", "Shots", "Smoke and Mirrors", "Thunder", "Love", "Roots", "Natural"};
    private static final String[] images = new String[]{
            "https://is5-ssl.mzstatic.com/image/thumb/Music118/v4/55/c4/7d/55c47dec-56b9-4f9b-fab4-0f7f394a10a8/00602577199219.rgb.jpg/600x600bf.png",
            "https://i.pinimg.com/originals/55/db/21/55db21c2c9ea48e469a98f43732e5b18.jpg",
            "https://avatars.yandex.net/get-music-content/28589/aba9e76b.a.1597165-1/m1000x1000",
            "https://avatars.yandex.net/get-music-content/32236/1faf5b50.a.2933483-1/m1000x1000",
            "https://muzonov.net/uploads/posts/2018-07/medium/1531827677_resized_37tipbmqqai.jpg",
            "https://t2.genius.com/unsafe/220x220/https%3A%2F%2Fimages.genius.com%2Fcefcf70065cf258281a354367542be42.1000x1000x1.jpg",
            "https://ukutabs.com/uploads/2015/08/Smoke-Mirrors.jpg",
            "https://is5-ssl.mzstatic.com/image/thumb/Music32/v4/5f/65/26/5f652628-5a41-70dd-c75b-ea50f40c419f/mzm.twcleubd.jpg/600x600bf.png",
            "https://upload.wikimedia.org/wikipedia/ru/thumb/2/28/Imagine_Dragons_Thunder.jpg/270px-Imagine_Dragons_Thunder.jpg"};
    private static final Map<String, Integer> songs;

    static {
        Map<String, Integer> map = new HashMap<>();
         map.put(names[0], R.raw.believer);
         map.put(names[1], R.raw.birds);
         map.put(names[2], R.raw.radioactive);
         map.put(names[3], R.raw.sad);
         map.put(names[4], R.raw.shots);
         map.put(names[5], R.raw.smoke_and_mirrors);
         map.put(names[6], R.raw.thunder);
         map.put(names[7], R.raw.love);
         map.put(names[8], R.raw.roots);
         map.put(names[9], R.raw.natural);
        songs = Collections.unmodifiableMap(map);
    }

    private Random random = new Random();

    public int getSong(String name){
        return songs.get(name);
    }

    public Track getTrack() {
        final String name = names[random.nextInt(names.length)];
        final String image = images[random.nextInt(images.length)];
        return new Track(name, "", image);
    }

    public List<Track> getTracks(final int count){
        List<Track> people = new ArrayList<>(count);
        for(int i=0; i < count; i++) {
            people.add(getTrack());
        }
        return people;
    }

    public String getImageLink(){
        return images[random.nextInt(images.length)];
    }

}
