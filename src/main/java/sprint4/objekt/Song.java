package sprint4.objekt;

import java.util.Objects;

public class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return title.equals(song.title) && artist.equals(song.artist) && songwriter.equals(song.songwriter);
    }

}
