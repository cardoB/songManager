package songs;

public class SongSpecs extends Song
{

    private String bpm;
    private String feel;

    // Constructors
    public SongSpecs()
    {
        super("no-title", "no-artist");
        bpm = "no-bpm";
        feel = "no-feel";
    }

    public SongSpecs(String title, String artist, String bpm, String feel)
    {
        super(title, artist);
        this.bpm = bpm;
        this.feel = feel;
    }

    // Getters
    public String getBpm()
    {
        return bpm;
    }

    public String getFeel()
    {
        return feel;
    }

    // Setters
    public void setBpm(String bpm)
    {
        this.bpm = bpm;
    }

    public void setFeel(String feel)
    {
        this.feel = feel;
    }
}