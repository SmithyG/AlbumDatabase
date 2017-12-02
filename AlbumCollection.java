import java.util.Arrays;

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
}
