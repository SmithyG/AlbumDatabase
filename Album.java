import java.util.Arrays;

public class Album 
{    
    private String artist,albumTitle;
    private Track[] tracks;
    
    public static void main(String[] args) {

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

    public Track[] getTracks() {
        return tracks;
    }

    public void addAlbumTracks() {
        for(int i = 0; i < tracks.length - 1; i++){
            tracks[0].getDuration().add(tracks[i+1].getDuration());
        }
    }

    public String toString(){
        return "\nArtist: " + artist + "\nAlbum Title: " + albumTitle + "\nTracks: " + Arrays.toString(tracks);
    }
    
}
