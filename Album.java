import java.util.Arrays;

public class Album implements Comparable<Album> {
    private String artist, albumTitle;
    private Track[] tracks;

    public static void main(String[] args) {
        //TEST HARNESS
        Album a1 = new Album();
        Track[] tracksTest = new Track[1];
        Track t1 = new Track("Test Track","00:03:23");
        tracksTest[0] = t1;
        Album a2 = new Album("Test Artist","Test Album",tracksTest);
        a2.getArtist();
        a2.getAlbumTitle();
        a2.getTracks();
        a2.getNoTracks();
        a2.toString();
        a2.compareTo(a1);
    }

    //Default constructor
    public Album() {
        artist = "";
        albumTitle = "";
        tracks = new Track[0];
    }

    //Constructor for Album object that takes artist, albumTitle and an array of Track objects as arguments
    public Album(String artist, String albumTitle, Track[] tracks) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.tracks = tracks;
    }

    //Returns the title of an album object
    public String getAlbumTitle() {
        return albumTitle;
    }

    //Returns the artists of an album object
    public String getArtist() {
        return artist;
    }

    //Returns an array of Track objects belonging to an album object
    public Track[] getTracks() {
        return tracks;
    }

    public int getNoTracks()
    {
        return tracks.length;
    }

    //toString method to print out attributes of an album object
    //A toString method is used to convert tracks into a understandable format rather than a memory reference
    public String toString() {
        return "\nArtist: " + artist + "\nAlbum Title: " + albumTitle + "\nTracks: " + Arrays.toString(tracks);
    }

    //compareTo method to allow for a collection of Album objects to be sorted alphabetically
    @Override
    public int compareTo(Album t) {
        //Here a comparison is made, if the artist of one Album object does not equal the artist of a second Album object
        //Then a comparison of each Album objects artist is returned
        if (!this.artist.equals(t.artist)) {
            return this.artist.compareTo(t.artist);
        }
        //However if this is not the case (Both Album objects have the same artist)
        //A comparison of each Album objects albumTitle is returned
        else {
            return this.albumTitle.compareTo(t.albumTitle);
        }
    }
}
