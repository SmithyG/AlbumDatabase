import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AlbumDatabase {
    public static void main(String[] args) {
        //Local variables are defined to handle file reading
        //The name of the file the program is going to read from is defined as fileName
        String fileName = "src/albums.txt";
        //the "line" variable allows the buffered reader to keep track of what line it is reading
        String line = null;
        //These two variables are created to allow for a split method to be used when an Album is found in the file
        String albumArtist = null;
        String albumTitle = null;

        try {

            //FileReader object is created and is given the file to read from
            FileReader fileReader = new FileReader(fileName);
            //BufferedReader object is created and is given the fileReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Two ArrayLists are created that allow albums and tracks to be added without the use of a fixed size array
            ArrayList<Album> albumList = new ArrayList<>();
            ArrayList<Track> trackList = new ArrayList<>();
            //Two Arrays are created that act as the final method of storage of Track and Album objects
            Track[] tracks;
            Album[] albums;

            //Start of the file reading process
            //A while loop checks that the current line is not empty
            while ((line = bufferedReader.readLine()) != null) {
                //If the first character of the line is alphabetic then the start of an album has been found
                if (Character.isAlphabetic(line.charAt(0))) {
                    //If the trackList is not empty this means that trackList is already populated with Track objects
                    //However this means that these Track objects belong to the last read Album
                    if (trackList.isEmpty() == false) {
                        //Therefore, the trackList is turned into an Array of Tracks and added to the album
                        tracks = new Track[trackList.size()];
                        tracks = trackList.toArray(tracks);
                        albumList.add(new Album(albumArtist, albumTitle, tracks));
                        //The trackList and albumTitle/Artist variables are cleared to make way for the new Album
                        trackList.clear();
                        albumArtist = null;
                        albumTitle = null;
                    }
                    //The line being read is split by a colon surrounded by spaces into an Array of String objects
                    String[] albumSplit = line.split(" : ");
                    //The contents before the colon is stored as albumArtist
                    albumArtist = albumSplit[0];
                    //The contents after the colon is stored as albumTitle
                    albumTitle = albumSplit[1];
                }
                //If the first character of the line is a digit then the start of a track has been found
                if (Character.isDigit(line.charAt(0))) {
                    //The line is split by a hyphen surrounded by spaces
                    String[] track = line.split(" - ");
                    //A for loop can be used to assign variables for a Track object
                    //This is because a Track object only takes two arguments whereas an Album object takes three
                    //One of those being an array of Track objects
                    //Therefore an Album object cannot be created until all Track objects have been created
                    for (int i = 0; i < track.length - 1; i++) {
                        //A new Track object is created with contents from the line and added to trackList
                        trackList.add(new Track(track[i + 1], track[i]));
                    }
                }
            }
            //This code is necessary as the last album does not pass through the if empty block
            tracks = new Track[trackList.size()];
            tracks = trackList.toArray(tracks);
            //Here the final album object is created
            albumList.add(new Album(albumArtist, albumTitle, tracks));

            //The final list of albums is sorted alphabetically by implementing the compareTo method found in the Album class
            Collections.sort(albumList);

            //the ArrayList of album objects is converted into a fixed size Array
            albums = new Album[albumList.size()];
            albums = albumList.toArray(albums);

            //An AlbumCollection object is created, containing all the albums from the text file
            AlbumCollection albumCollection = new AlbumCollection(albums);

            //The sorted collection of Albums is printed
            System.out.println(albumCollection);
            //The track with the longest duration is printed using the longestTrack method
            System.out.println("\nThe Track With The Longest Duration Is: " + albumCollection.longestTrack());
            //The total duration of all Pink Floyd albums is printed with the pinkFloyd method
            System.out.println("\nTotal Playtime Of All Pink Floyd Albums: " + albumCollection.pinkFloyd());
            //The album with the largest number of tracks is printed with the largestTracks method
            System.out.println("\nAlbum With The Greatest Number Of Tracks Is: " + albumCollection.largestTracks());
            //The buffered reader object is closed
            bufferedReader.close();
        }
        //Here an exception will be caught if the file that the file reader is using cannot be found
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        }
        //Any IO related exceptions thrown by the file reader will be caught here
        catch (IOException ex) {
            System.out.println("Error reading file: " + fileName);
        }

    }
}
