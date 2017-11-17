package albumdatabase;

public class Track
{
    private String title;
    private Duration duration;
    
    public static void main(String[] args) {
    }

    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    public Track(String title, String duration) {
        this.title = title;
        this.duration = new Duration(duration);
    }

    public Track() {
        this.title = null;
        this.duration = null;
    }
    
    public String toString()
    {
        String stringDuration = this.duration.toString();
        return title + " : " + stringDuration;
    }
}
