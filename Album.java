package albumdatabase;

public class Album 
{    
    private String artist,albumTitle;
    private Track tracks[];
    
    public static void main(String[] args) {
        Track t1 = new Track("GnarlyGuyAnthem","02:20:12");
        Track t2 = new Track("Test","00:01:40");
        Track[] t1and2 = new Track[2];
        t1and2[0] = t1;
        t1and2[1] = t2;
        
        Album a = new Album("Pink Floyd","Dark Side Of The Moon", t1and2);
        System.out.println(a.getAlbumTitle());
        System.out.println(a.getArtist());
        System.out.println(a.getTrack());
    }

    public Album() {
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
    
}
