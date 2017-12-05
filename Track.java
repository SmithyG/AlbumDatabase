public class Track {
    private String title;
    private Duration duration;

    public static void main(String[] args) {
        //TEST HARNESS
        Track t1 = new Track("Test Track","00:03:45");
        Track t2 = new Track();
        t1.getTitle();
        t1.getDuration();
        t1.toString();
    }

    //Returns the title of the Track
    public String getTitle() {
        return title;
    }

    //Returns the duration of the Track
    public Duration getDuration() {
        return duration;
    }

    //Constructor for Track object that takes title and duration as String arguments
    public Track(String title, String duration) {
        this.title = title;
        this.duration = new Duration(duration);
    }

    //Default constructor for Track
    public Track() {
        this.title = null;
        this.duration = null;
    }

    //toString method in order to return details about a Track in String format
    public String toString() {
        String stringDuration = this.duration.toString();
        return title + " : " + stringDuration;
    }
}
