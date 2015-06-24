package hw3;

/**
 * @author Russ Forstall
 */
public class Piggifier {
    /**
     * Translates a word into pig latin. Words with no vowels remain unchanged.
     * If a word ends with punction([?!.]), it keeps it at the end.
     * @param word The word to piggify.
     * @return The piggified word
     */
    public static String piggifyWord(String word) throws RuntimeException {
        if (containsDigit(word)) {
            throw new IllegalArgumentException("Can't piggify a word that contains digits!");
        }

        int firstVowel = indexOfFirstVowel(word);
        if (firstVowel < 0) {
            return word;
        }

        String punctuation = "";

        if (!Character.isAlphabetic(word.charAt(word.length()-1))) {
            punctuation = word.substring(word.length()-1);
            word = word.substring(0, word.length()-1);
        }

        if (firstVowel == 0 && !(word.startsWith("y") || word.startsWith("Y"))) {
            return word + "way" + punctuation;
        }

        String prefix = word.substring(firstVowel);
        String suffix = word.substring(0, firstVowel);
        Character c = (Character.toLowerCase(suffix.charAt(0)));
        suffix = suffix.replaceFirst("[" + suffix.charAt(0) + "]", c.toString());
        String piggifiedWord = prefix + suffix + "ay";

        if (Character.isUpperCase(word.charAt(0))) {
            Character ch = piggifiedWord.charAt(0);
            ch = Character.toUpperCase(ch);
            return piggifiedWord.replaceFirst("[" + prefix.charAt(0) + "]", ch.toString()) + punctuation;
        }

        return piggifiedWord + punctuation;
    }

    /**
     * Determines if a character is a vowel.
     * 'Y' is considered a vowel.
     * @param c The character to test.
     * @return True if the character is a vowel.
     */
    public static boolean isVowel(Character c) {
        c = Character.toUpperCase(c);
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
    }

    /**
     * Finds and returns the index of the first vowel in a word. If a 'y'(or 'Y')
     * is at the beginning of a word, it is considered a consonant.
     * @param word
     * @return The index of the first vowel in the word.
     */
    public static int indexOfFirstVowel(String word) {
        char[] chars = word.toCharArray();
        int indexOfVowel = -1;
        int i = 0;

        if (word.startsWith("y") || word.startsWith("Y")) {
            i++;
        }

        while (indexOfVowel == -1 && i != (chars.length)) {
            if (isVowel(chars[i])) {
                indexOfVowel = i;
            }

            i++;
        }

        return indexOfVowel;
    }

    public static boolean containsDigit(String word) {
        boolean containsDigit = false;

        if(word != null && !word.isEmpty()){
            for(char c : word.toCharArray()){
                if(containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
