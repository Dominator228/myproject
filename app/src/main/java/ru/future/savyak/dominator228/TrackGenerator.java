package ru.future.savyak.dominator228;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrackGenerator {

    private static final String[] names = new String[]{"Mumbl", "Love", "Machine", "Gold", "Radioactive", "I'm so sorry"};
    private static final String[] images = new String[]{
            "https://c.pxhere.com/photos/bb/fa/mixer_knobs_panel_sound_music_recording_equipment_audio-714083.jpg!d",
            "https://is3-ssl.mzstatic.com/image/thumb/Music2/v4/ac/7d/de/ac7dded0-b96c-b4db-d722-f35cef03dcfb/UMG_cvrart_00602537293308_01_RGB72_1500x1500_12UMGIM46900.jpg/1200x630bb.jpg",
            "https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F83b230ddf46af020cbd9688ac178190f.1000x1000x1.png",
            "https://yt3.ggpht.com/a-/AJLlDp13bM8yFuEE7HVlYHFt7zvZPSMWbGEz4OrxOw=s900-mo-c-c0xffffffff-rj-k-no",
            "http://comic-cons.xyz/wp-content/uploads/Star-Wars-avatar-icon-Ewok.png",
            "https://cdn.dribbble.com/users/588874/screenshots/2249423/dribbble_1x.png",
            "https://avatarko.ru/img/kartinka/32/Star_Wars_pistolet_31680.jpg",
            "http://weclipart.com/gimg/31A72F8B8986D00C/obiwan_kenobi_rots_by_kaal_jhyy.jpg"};

    private Random random = new Random();

    public Track getPerson() {
        final String name = names[random.nextInt(names.length)];
        final String image = images[random.nextInt(images.length)];
        return new Track(name, "", image);
    }

    public List<Track> getTracks(final int count){
        List<Track> people = new ArrayList<>(count);
        for(int i=0; i < count; i++) {
            people.add(getPerson());
        }
        return people;
    }

    public String getImageLink(){
        return images[random.nextInt(images.length)];
    }

}
