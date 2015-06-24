package hw4;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Russ Forstall
 */
public class DirectoryInfo {
    private static final String USAGE_MESSAGE = "\nusage:  java -jar hw4.jar [directory] [-a | -l | -s]\n" +
            "          (current directory is default)\n" +
            "          -a alphabetical sorting\n" +
            "          -l last time modified sorting\n" +
            "          -s file size";

    private static final String INVALID_DIRECTORY_MESSAGE = "Invalid directory name";

    public static void main(String[] args) {

        if (args.length > 2) {
            System.out.println(USAGE_MESSAGE);
            return;
        }

        String path = ".";
        String sortOption = "";

        if (args.length == 1) {
            if (args[0].startsWith("-")) {
                sortOption = args[0];
            } else {
                path = args[0];
            }
        }

        if (args.length == 2) {
            if (args[0].startsWith("-")) {
                System.out.println(USAGE_MESSAGE);
                return;
            } else if (!args[1].startsWith("-")) {
                System.out.println(USAGE_MESSAGE);
                return;
            } else {
                path = args[0];
                sortOption = args[1];
            }
        }

        File dir = new File(path);

        if (!dir.isDirectory()) {
            System.out.println(INVALID_DIRECTORY_MESSAGE);
            System.out.println(USAGE_MESSAGE);
            return;
        }

        ArrayList<File> files = new ArrayList<File>(Arrays.asList(dir.listFiles()));

        if (!sortOption.isEmpty()) {
            Comparator<File> comparator = null;

            switch (sortOption) {
                case "-l":
                    comparator = new Comparator<File>() {
                        @Override
                        public int compare(File file1, File file2) {
                            if (file1.lastModified() > file2.lastModified()) {
                                return 1;
                            } else if (file1.lastModified() < file2.lastModified()) {
                                return -1;
                            }
                            return 0;
                        }
                    };
                    break;

                case "-s":
                    comparator = new Comparator<File>() {
                        @Override
                        public int compare(File file1, File file2) {
                            if (file1.length() > file2.length()) {
                                return 1;
                            } else if (file1.length() < file2.length()) {
                                return -1;
                            }
                            return 0;
                        }
                    };
                    break;

                case "-a":
                    comparator = new Comparator<File>() {
                        @Override
                        public int compare(File file1, File file2) {
                            int i = String.CASE_INSENSITIVE_ORDER.compare(file1.getName(), file2.getName());
                            if (i == 0) {
                                i = file1.getName().compareTo(file2.getName());
                            }
                            return i;
                        }
                    };
                    break;

                default:
                    System.out.println(USAGE_MESSAGE);
                    return;
            }

            Collections.sort(files, comparator);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss");

        for (File file : files) {
            System.out.printf(
                    "%6s  %10s  %2s\n",
                    file.length(),
                    dateFormat.format(file.lastModified()),
                    file.getName()
            );
        }
    }
}
