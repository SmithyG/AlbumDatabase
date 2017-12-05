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

    //pinkFloyd is a method that identifies any album in the albumCollection object with the artist of "Pink Floyd"
    //Once all albums have been found, the duration of all tracks are added up to produce a runtime
    public String pinkFloyd() {
        //A blank array of Track objects is made to hold all the tracks with the artist "Pink Floyd"
        Track[] track = null;
        //An ArrayList is created to hold tracks that need to be added
        ArrayList<Track> totalTime = new ArrayList<>();
        String finalTime = null;
        //This for loop iterates through albums to find "Pink Floyd" albums
        for (int i = 0; i < albums.length; i++) {
            //When a "Pink Floyd" album is found, it's tracks are added to track
            if (albums[i].getArtist().equals("Pink Floyd")) {
                track = albums[i].getTracks();
                for (int t = 1; t < track.length; t++) {
                    //The tracks of a "Pink Floyd" album are added together using the add method from Duration
                    track[0].getDuration().add(track[t].getDuration());
                }
                //The runtime of one album is added to an ArrayList
                totalTime.add(track[0]);
            }
        }
        //Once all album run times have been calculated and added to the ArrayList, all the run times are added up
        for (int i = 1; i < totalTime.size(); i++) {
            totalTime.get(0).getDuration().add(totalTime.get(i).getDuration());
        }
        //The final duration is turned into a string and returned as finalTime
        finalTime = totalTime.get(0).getDuration().toString();
        return finalTime;
    }

    //The largest track method looks at each album object in the array and compares the total number of tracks
    public String largestTracks() {
        //An album object is made and populated with the first array item for comparison
        Album largestNo = albums[0];
        //This for loop iterates through the album array
        for (int i = 0; i < albums.length - 1; i++) {
            //Here the current item in the arrays number of tracks is compared with the comparison object
            if (albums[i].getNoTracks() > largestNo.getNoTracks()) {
                //If the current item has more tracks than the comparison object, it becomes the comparison object
                largestNo = albums[i];
            }
        }
        //Details about the largest albums are returned as a String
        return largestNo.toString();
    }

    //the longestTrack method compares the length of each track of every album
    //It finds the track with the largest duration
    public String longestTrack(){
        //A blank array of Track objects is made in order for comparisons to take place
        Track[] track = null;
        //A blank track object is created to act as the first comparative object
        Track longestTrack = new Track("","00:00:00");
        //A for loop iterates through the album array
        for(int i = 0; i < albums.length; i++)
        {
            //The current album objects tracks are assigned to track
            track = albums[i].getTracks();
            //A for loop iterates through an albums tracks
            for (int t = 0; t < track.length; t++)
            {
                //The current track in the array is compared with the longestTrack object
                if(track[t].getDuration().getTotal() > longestTrack.getDuration().getTotal()){
                    //If the current track has a longer duration than the longestTrack, it becomes longestTrack
                    longestTrack = track[t];
                }
            }
        }
        //The longestTrack is returned as a String
        return longestTrack.toString();
    }
}
