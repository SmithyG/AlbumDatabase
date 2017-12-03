import java.util.Arrays;
import java.util.ArrayList;

public class AlbumCollection {
    private Album[] albums;

    public static void main(String[] args) {
        /* ArrayList<Album> albums = new ArrayList<>();
        //POPULATE WITH ARRAY LIST, THEN EMPTY ARRAY LIST INTO PERFECT ARRAY
        Track t1 = new Track("GnarlyGuyAnthem", "02:20:12");
        Track t2 = new Track("Joyclen Flores", "04:20:13");
        Track[] tracks = new Track[5];
        Album a1 = new Album("Test Album", "Oh fuck", tracks);
        albums.add(a1); */
    }

    //Constructor for AlbumCollection with no arguments
    public AlbumCollection() {
        albums = new Album[0];
    }

    //Constructor for AlbumCollection with arguments
    public AlbumCollection(Album[] albums) {
        this.albums = albums;
    }

    //Returns the albums object in AlbumCollection
    public Album[] getAlbums() {
        return albums;
    }

    //toString method to print attributes of albums rather than printing a memory location
    public String toString() {
        return "\nAlbums: " + Arrays.toString(albums);
    }

    public String pinkFloyd() {
        Track[] track = null;
        ArrayList<Track> totalTime = new ArrayList<>();
        String finalTime = null;
        for (int i = 0; i < albums.length; i++) {
            if (albums[i].getArtist().equals("Pink Floyd")) {
                track = albums[i].getTracks();
                for (int t = 1; t < track.length; t++) {
                    track[0].getDuration().add(track[t].getDuration());
                }
                totalTime.add(track[0]);
            }
        }
        for (int i = 1; i < totalTime.size(); i++) {
            totalTime.get(0).getDuration().add(totalTime.get(i).getDuration());
        }
        finalTime = totalTime.get(0).getDuration().toString();
        return finalTime;
    }

    public String largestTracks() {
        Album largestNo = albums[0];
        for (int i = 0; i < albums.length - 1; i++) {
            if (albums[i].getNoTracks() > largestNo.getNoTracks()) {
                largestNo = albums[i];
            }
        }
        return largestNo.toString();
    }

    public String longestTrack(){
        Track[] track = null;
        Track longestTrack = new Track("","00:00:00");
        for(int i = 0; i < albums.length; i++)
        {
            track = albums[i].getTracks();
            for (int t = 0; t < track.length; t++)
            {
                if(track[t].getDuration().getTotal() > longestTrack.getDuration().getTotal()){
                    longestTrack = track[t];
                }
            }
        }
        return longestTrack.toString();
    }
}
