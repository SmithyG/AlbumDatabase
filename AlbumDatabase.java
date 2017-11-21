import java.io.*;
import java.util.ArrayList;

public class AlbumDatabase
{
    public static void main(String[] args)
    {
        String fileName = "src/albums.txt";
        String line = null;

        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Album> albumList = new ArrayList<>();
            ArrayList<Track> trackList = new ArrayList<>();
            Track[] tracks;
            Album[] albums;

            while((line = bufferedReader.readLine()) != null) {
                if(Character.isAlphabetic(line.charAt(0))){
                    String[] album = line.split(" : ");
                }
                if (Character.isDigit(line.charAt(0))) {
                    String[] track = line.split(" - ");
                    for (int i = 0; i < track.length -1; i++) {
                        trackList.add(new Track(track[i+1],track[i]));
                    }
                    tracks = new Track[trackList.size()];
                    tracks = trackList.toArray(tracks);
                }

            }

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
