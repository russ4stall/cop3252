package playground;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Russ Forstall
 */
public class SerializeTest {
    public static void main(String[] args) throws Exception {
        File file = new File("songs.ser");

        writeTest(file);


        List<Song> readSongs = Song.deserializeListFromFile(file);

        for (Song song : readSongs) {
            System.out.println(song);
        }
    }

    private static void writeTest(File file) throws Exception {
        Song song1 = new Song("GSF", 200, "MXPX");
        Song song2 = new Song("Punk Rawk Show", 140, "MXPX");
        Song song3 = new Song("Secret Weapon", 210, "MXPX");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);

        Song.serializeListToFile(songs, file);
    }
}
