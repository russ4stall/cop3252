package hw3;

/**
 * Helper methods to assist in dealing with HTML.
 *
 * @author Russ Forstall
 */
public class Html {

    /**
     * Separates HTML tags and symbols from content.
     * @param s
     * @return A string array containing the separated parts.
     */
    public static String[] tokenizeHtml(String s) {
        final String delimiter = "&&##&&";

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(delimiter);
        boolean inTag = false;
        boolean inSymbol = false;
        for (char c : chars) {
            if (c == '<' && !inTag) {
                if (!sb.substring(sb.length() - delimiter.length()).equals(delimiter)) {
                    sb.append(delimiter);
                }

                sb.append(c);
                inTag = true;
            } else if (inTag) {
                if (c == '>') {
                    inTag = false;
                    sb.append(c);
                    if (!sb.substring(sb.length() - delimiter.length()).equals(delimiter)) {
                        sb.append(delimiter);
                    }

                } else {
                    sb.append(c);
                }
            } else if (c == '&' && !inSymbol) {
                if (!sb.substring(sb.length() - delimiter.length()).equals(delimiter)) {
                    sb.append(delimiter);
                }

                sb.append(c);
                inSymbol = true;
            } else if (inSymbol) {
                if (c == ';') {
                    inSymbol = false;
                    sb.append(c);
                    if (!sb.substring(sb.length() - delimiter.length()).equals(delimiter)) {
                        sb.append(delimiter);
                    }
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

    return sb.substring(delimiter.length()).split(delimiter);
    }

    /*public static void main(String[] args) {
        String s = "<html><body><h1>This is &quote;header&quote;.</h1><p>This is content in paragraph</p></body></html>";

        String[] sa = tokenizeHtml(s);

        for (String a : sa) {
            System.out.println(a);
        }
    }*/
}
