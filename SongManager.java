package songs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SongManager
{

    private List<SongSpecs> songs;
    private int numSongs = 5;
    private String filePath;

    // Constructor: initializes members 'filePath' and 'songs'
    public SongManager(String filePath)
    {
        songs = new ArrayList<>();
        this.filePath = filePath;
    }

    // Getter
    public String getFilePath()
    {
        return filePath;
    }

    // Adds a song to member List 'songs'
    public void addSong(SongSpecs song)
    {
        if (isDuplicateSong(song))
        {
            System.out.println("Duplicate song. Cannot add.");
        }
        else
        {
            songs.add(song);
            numSongs = songs.size();
            System.out.println();
            System.out.println("Song added successfully.");
        }
    }

    // Checks to see whether a song has an exact match in the initial file
    // bpm needs to be exact
    // All other fields (Title, Artist, Feel) ignores punctuation
    // (Ex: My Song Title == my song title)
    private boolean isDuplicateSong(SongSpecs song)
    {
        for (SongSpecs existingSong : songs)
        {
            if (    existingSong.getTitle().equalsIgnoreCase(song.getTitle()) &&
                    existingSong.getArtist().equalsIgnoreCase(song.getArtist()) &&
                    existingSong.getBpm().equals(song.getBpm()) &&
                    existingSong.getFeel().equalsIgnoreCase(song.getFeel()))
            {
                return true;
            }
        }
        return false;
    }

    // Removes a song from member 'songs'
    public void removeSong(int index)
    {
        if (index >= 0 && index < numSongs)
        {
            songs.remove(index);
            numSongs--;
            System.out.println();
            System.out.println("Song removed successfully.");
        }
        else
        {
            System.out.println("Invalid song index.");
        }
    }

    // Prints all songs to the console, formatted to fit in tabular form
    public void displayAllSongs()
    {
        if (songs.isEmpty())
        {
            System.out.println("No songs available.");
        }
        else
        {
            final int TITLE_WIDTH = 34;
            final int ARTIST_WIDTH = 20;
            final int BPM_WIDTH = 10;
            final int FEEL_WIDTH = 18;

            //set the display string
            StringBuilder list = new StringBuilder();
            list.append("\n");
            list.append(StringUtil.pad("i    Title", TITLE_WIDTH));
            list.append(StringUtil.pad("     Artist", ARTIST_WIDTH));
            list.append(StringUtil.pad("     Bpm", BPM_WIDTH));
            list.append(StringUtil.pad("     Feel", FEEL_WIDTH));
            list.append("\n");
            list.append(StringUtil.pad("===  =================================", TITLE_WIDTH));
            list.append(StringUtil.pad("===  ===================", ARTIST_WIDTH));
            list.append(StringUtil.pad("===  =========", BPM_WIDTH));
            list.append(StringUtil.pad("===  ===============", FEEL_WIDTH));
            list.append("\n");

            for (int i = 0; i < songs.size(); i++)
            {
                SongSpecs theSong = songs.get(i);
                list.append(i);
                if (i < 10)
                {
                    list.append(".   ");
                }
                else
                {
                    list.append(".  ");
                }
                list.append(StringUtil.pad(theSong.getTitle(), TITLE_WIDTH));
                list.append(StringUtil.pad(theSong.getArtist(), ARTIST_WIDTH));
                list.append(StringUtil.pad(theSong.getBpm(), BPM_WIDTH));
                list.append(StringUtil.pad(theSong.getFeel(), FEEL_WIDTH));
                list.append("\n");
            }
            System.out.println(list);
        }
    }

    // Prints any song containing given keyword in title OR artist
    public void searchSong(String keyword)
    {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : songs)
        {
            if (song.getTitle().toLowerCase().contains(keyword.toLowerCase()) || song.getArtist().toLowerCase().contains(keyword.toLowerCase()))
            {
                matchingSongs.add(song);
            }
        }
        if (matchingSongs.isEmpty())
        {
            System.out.println();
            System.out.println("No matching songs found.");
        }
        else
        {
            System.out.println();
            System.out.println("Matching Songs:");
            for (Song song : matchingSongs)
            {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        }
    }

    // Opens the file and copies every song into the member List 'songs'
    public void loadSongsFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            // read file into member List songs
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] songData = line.split(",");

                String title = songData[0].trim();
                String artist = songData[1].trim();
                String bpm = songData[2].trim();
                String feel = songData[3].trim();

                SongSpecs song = new SongSpecs();
                song.setTitle(title);
                song.setArtist(artist);
                song.setBpm(bpm);
                song.setFeel(feel);

                songs.add(song);
            }
//            System.out.println("Songs loaded from file successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error reading songs from file: " + e.getMessage());
        }
    }

    // save: copies every song in member 'songs' to the file "Songs.txt"
    public void saveSongsToFile()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath)))
        {
            for (SongSpecs song : songs)
            {
                writer.println(song.getTitle() + "," + song.getArtist() + "," + song.getBpm() + "," + song.getFeel());
            }
            System.out.println("Songs saved to file successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error saving songs to file: " + e.getMessage());
        }
    }
}
