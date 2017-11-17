package albumdatabase;
import java.util.Arrays;
import java.util.ArrayList;

public class Album 
{    
    private String artist,albumTitle;
    private Track tracks[];
    
    public static void main(String[] args) {
        Track t1 = new Track("GnarlyGuyAnthem","02:20:12");
        Track t2 = new Track("Joyclen Flores","04:20:13");
        Track[] trackList = new Track[5];
        trackList[0] = t1;
        trackList[1] = t2;
        Album a1 = new Album("XXXTentacion","17",trackList);
        System.out.println(a1);
    }

    public Album() {
        artist = "";
        albumTitle = "";
        tracks = new Track[0];
    }

    public Album(String artist, String albumTitle, Track[] tracks) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.tracks = tracks;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public Track[] getTrack() {
        return tracks;
    }
    
    public String toString(){
        return "\nArtist: " + artist + "\nAlbum Title: " + albumTitle + "\nTracks: " + Arrays.toString(tracks);
    }
    
}
