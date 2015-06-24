package hw3;

import static hw3.Piggifier.piggifyWord;

/**
 * Unit tests for Piggifier methods.
 *
 * @author Russ Forstall
 */
public class PiggifierTest {
    final static String FAILURE = "Test Failed";

    public static void main(String[] args) {

        try {
            System.out.println("34 : " + piggifyWord("34"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        assert Piggifier.containsDigit("34"): FAILURE;
        assert Piggifier.containsDigit("sdlkj67ll"): FAILURE;
        assert !Piggifier.containsDigit("Russell"): FAILURE;

        ////assert Piggifier.piggifyLine("The attentive, brilliant Java student's friend was happy.")
        ////        .equals("Ethay attentiveway, illiantbray Avajay udent'sstay iendfray asway appyhay.");

        assert piggifyWord("Flower").equals("Owerflay"): FAILURE;
        assert piggifyWord("yellow").equals("ellowyay"): FAILURE;
        assert piggifyWord("apple").equals("appleway"): FAILURE;
        assert piggifyWord("bypass").equals("ypassbay"): FAILURE;
        assert piggifyWord("Igloo").equals("Iglooway"): FAILURE;
        assert piggifyWord("string").equals("ingstray"): FAILURE;
        assert piggifyWord("Hamburger").equals("Amburgerhay"): FAILURE;
        assert piggifyWord("Rhythm").equals("Ythmrhay"): FAILURE;
        assert piggifyWord("queen").equals("ueenqay"): FAILURE;
        assert piggifyWord("zippity").equals("ippityzay"): FAILURE;
        assert piggifyWord("boo").equals("oobay"): FAILURE;
        assert piggifyWord("You").equals("Ouyay"): FAILURE;
        assert piggifyWord("You're").equals("Ou'reYay"): FAILURE;
        assert piggifyWord("Student's").equals("Udent'sstay"): FAILURE;
        assert piggifyWord("PBR").equals("PBR"): FAILURE;
        assert piggifyWord("YRPL").equals("YRPL"): FAILURE;

        assert Piggifier.isVowel('a'): FAILURE;
        assert Piggifier.isVowel('A'): FAILURE;
        assert Piggifier.isVowel('e'): FAILURE;
        assert Piggifier.isVowel('E'): FAILURE;
        assert Piggifier.isVowel('I'): FAILURE;
        assert Piggifier.isVowel('i'): FAILURE;
        assert Piggifier.isVowel('O'): FAILURE;
        assert Piggifier.isVowel('o'): FAILURE;
        assert Piggifier.isVowel('U'): FAILURE;
        assert Piggifier.isVowel('u'): FAILURE;
        assert Piggifier.isVowel('Y'): FAILURE;
        assert Piggifier.isVowel('y'): FAILURE;
        assert !Piggifier.isVowel('f'): FAILURE;
        assert !Piggifier.isVowel('h'): FAILURE;
        assert !Piggifier.isVowel('G'): FAILURE;
        assert !Piggifier.isVowel('Z'): FAILURE;
        assert !Piggifier.isVowel('z'): FAILURE;

        assert Piggifier.indexOfFirstVowel("queen") == 1: FAILURE;
        assert Piggifier.indexOfFirstVowel("Upwards") == 0: FAILURE;
        assert Piggifier.indexOfFirstVowel("Blastoise") == 2: FAILURE;
        assert Piggifier.indexOfFirstVowel("freaky") == 2: FAILURE;
        assert Piggifier.indexOfFirstVowel("You") == 1: FAILURE;
        assert Piggifier.indexOfFirstVowel("scratch") == 3: FAILURE;
        assert Piggifier.indexOfFirstVowel("Yvonne") == 2: FAILURE;
        assert Piggifier.indexOfFirstVowel("Yvonne") != 0: FAILURE;
    }
}
