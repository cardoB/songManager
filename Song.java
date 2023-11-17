package songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song
{

    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    // Getters
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    // Setters
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }
}
