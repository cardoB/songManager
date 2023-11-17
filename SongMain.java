package songs;

import java.util.Scanner;

public class SongMain
{

    public static void main(String[] args)
    {
        String fileName = "Songs.txt";
        // Fixed file name and location for simplicity.
        // The file must be in the project folder and it must be called "Songs.txt"
        SongManager songManager = new SongManager(fileName);

        // Load songs from the file and shows title and data in file
        songManager.loadSongsFromFile();
        intro(songManager);
        int choice;
        do
        {
            showMenu();
            choice = Console.getInt("Enter your choice: ");

            switch (choice)
            {
                case 1:
                    SongSpecs newSong = new SongSpecs();

                    newSong.setTitle(Console.getString("Enter the song title: "));
                    newSong.setArtist(Console.getString("Enter the artist name: "));
                    newSong.setBpm(Console.getString("Enter the song BPM: "));
                    newSong.setFeel(Console.getString("Enter the song feel: "));
                    songManager.addSong(newSong);
                    break;
                case 2:
                    int index = Console.getInt("Enter the index of the song to remove: ");
                    songManager.removeSong(index);
                    break;
                case 3:
                    songManager.displayAllSongs();
                    break;
                case 4:
                    String keyword = Console.getString("Enter a keyword to search for: ");
                    songManager.searchSong(keyword);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 5);

        // Saves whatever the user did
        songManager.saveSongsToFile();
    }

    // Shows menu
    public static void showMenu()
    {
        System.out.println("Menu:");
        System.out.println("1. Add a song");
        System.out.println("2. Remove a song");
        System.out.println("3. Display all songs");
        System.out.println("4. Search for a song");
        System.out.println("5. Exit");
    }

    // Shows title and initial file
    public static void intro(SongManager songManager)
    {

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Song Manager Program");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("The file \"" + songManager.getFilePath() + "\" contains the following songs: ");
        songManager.displayAllSongs();
    }
}