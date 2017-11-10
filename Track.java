package albumdatabase;

public class Track
{
    private String title;
    private Duration duration;
    
    public static void main(String[] args) {
        Track t1 = new Track();
        System.out.println(t1.getDuration());
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
        this.title = "";
        this.duration = null;
    }
}
