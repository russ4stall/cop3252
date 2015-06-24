package playground;

/**
 * @author Russ Forstall
 */
public class Bonus {
    public static void main(String[] args) {
        String s1 = "The quick brown fox jumped over the quick dog";
        String s2 = "Concatenate the bobcat with the catapult";

        System.out.println(replace("quick", "hot", s1));
        System.out.println(replace("cat", "bird", s2));

        String word = "";
        word.concat(Character.toString('c'));
        System.out.println(word);
    }

    public static String replace(String oldStr, String newStr, String str) {
        char[] s = str.toCharArray();
        String n = "";
        String word = "";

        for (char c : s) {
            if (c == ' ') { // *mistake* String in written code
                if (word == oldStr) {
                    n = n.concat(newStr + " ");
                } else {
                    n = n.concat(word + " ");
                }
                word = "";
            } else {
                word = word.concat(Character.toString(c));
            }
        }

        return n;
    }
}
