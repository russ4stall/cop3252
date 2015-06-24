package playground;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Russ Forstall
 */
public class Song implements Serializable {


    private String title;
    private int length; // in seconds
    private String artist;

    public Song(String title, int length, String artist) {
        this.title = title;
        this.length = length;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", length=" + length +
                ", artist='" + artist + '\'' +
                '}';
    }

    public static void serializeListToFile(List<Song> songs, File file) throws Exception {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(songs);
        out.close();
        fileOut.close();
    }

    public static List<Song> deserializeListFromFile(File file) throws Exception {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        ArrayList<Song> songs;
        songs = (ArrayList) in.readObject();

        in.close();
        fileIn.close();

        return songs;
    }
}
