package hw3;

import java.io.*;
import java.util.Scanner;

/**
 * @author Russ Forstall
 */
public class WebToPigLatin {

    public static void main(String[] args) throws IOException{
        // Validate usage.
        if (args.length < 2) {
            System.out.println("Usage: java WebToPigLatin inputFile outputFile");
            System.out.println("Must have two command-line parameters");
        }
        String inputFile = args[0];
        String outputFile = args[1];

        Reader in = new BufferedReader(new FileReader(new File(inputFile)));

        try (Scanner fileScanner =  new Scanner(new File(inputFile));
            Writer out = new BufferedWriter(new FileWriter(new File(outputFile)))
        ) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String piggified = piggifyLineOfHtml(line);
                out.write(piggified);
                out.write('\n');
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String piggifyLineOfHtml(String s) {
        String[] html = Html.tokenizeHtml(s);
        StringBuilder sb = new StringBuilder();

        for (String s1 : html) {
            if (s1.startsWith("<") || s1.startsWith("&")) {
                sb.append(s1);
            } else {
                Scanner scanner = new Scanner(s1);
                while (scanner.hasNext()) {
                    String s2 = scanner.next();
                    try {
                        s2 = Piggifier.piggifyWord(s2);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }

                    sb.append(s2);
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}










