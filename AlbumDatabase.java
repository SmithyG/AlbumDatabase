import java.io.*;
import java.util.ArrayList;

public class AlbumDatabase
{
    public static void main(String[] args)
    {
        String fileName = "src/albums.txt";
        String line = null;
        String albumArtist = null;
        String albumTitle = null;

        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<AlbumCollection> albumList = new ArrayList<>();
            ArrayList<Track> trackList = new ArrayList<>();
            Track[] tracks;
            Album[] albums;

            while((line = bufferedReader.readLine()) != null) {
                if(Character.isAlphabetic(line.charAt(0))) {
                    String[] albumSplit = line.split(" : ");
                    albumArtist = albumSplit[0];
                    albumTitle = albumSplit[1];

                }else if(Character.isDigit(line.charAt(0))) {
                    String[] track = line.split(" - ");
                    for(int i = 0; i < track.length -1; i++){
                        trackList.add(new Track(track[i+1],track[i]));
                    }
                }

            }
            tracks = new Track[trackList.size()];
            tracks = trackList.toArray(tracks);
            Album a1 = new Album(albumArtist,albumTitle,tracks);
            System.out.println(a1.toString());

            /* while((line = bufferedReader.readLine()) != null) {
                while(Character.isDigit(line.charAt(0))) {
                    String[] track = line.split(" - ");
                    for (int i = 0; i < track.length -1; i++) {
                        trackList.add(new Track(track[i+1],track[i]));
                    }
                    tracks = new Track[trackList.size()];
                    tracks = trackList.toArray(tracks);
                    for (int i = 0; i < tracks.length; i++){
                        // System.out.println(tracks[i]);
                    }
                }
                if(Character.isAlphabetic(line.charAt(0))){
                    String[] album = line.split(" : ");
                    for(int i = 0; i < album.length -1; i++){
                        albumList.add(new Album(album[i],album[i+1],tracks[i]));
                        System.out.println(album[i]);
                    }
                }

            } */

            bufferedReader.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to open file: " + fileName);
        }
        catch (IOException ex){
            System.out.println("Error reading file: " + fileName);
        }

    }
}
