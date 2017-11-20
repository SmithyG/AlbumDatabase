import java.util.ArrayList;

public class AlbumCollection {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        //POPULATE WITH ARRAY LIST, THEN EMPTY ARRAY LIST INTO PERFECT ARRAY
        Track t1 = new Track("GnarlyGuyAnthem","02:20:12");
        Track t2 = new Track("Joyclen Flores","04:20:13");
        Track[] tracks = new Track[5];
        Album a1 = new Album("Test Album","Oh fuck",tracks);
        albums.add(a1);
        
    }

    public AlbumCollection() {
    }
}
