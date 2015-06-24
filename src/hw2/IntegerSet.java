package hw2;

/**
 * @author Russ Forstall
 */
public class IntegerSet {
    private static final int SET_SIZE = 101;
    private boolean[] set;

    IntegerSet() {
        set = new boolean[SET_SIZE];
    }

    public IntegerSet union(IntegerSet iSet) {
        IntegerSet integerSet = new IntegerSet();

        for (int i = 0; i < SET_SIZE; i++) {
            if (iSet.set[i] || set[i]) {
                integerSet.insertElement(i);
            }
        }
        return integerSet;
    }

    public IntegerSet intersection(IntegerSet iSet) {
        IntegerSet integerSet = new IntegerSet();

        for (int i = 0; i < SET_SIZE; i++) {
            if (iSet.set[i] && set[i]) {
                integerSet.insertElement(i);
            }
        }
        return integerSet;
    }

    public IntegerSet insertElement(int data) {
        set[data] = true;
        return this;
    }

    public IntegerSet deleteElement(int data) {
        set[data] = false;
        return this;
    }

    public boolean isEqualTo(IntegerSet iSet) {
        for (int i = 0; i < SET_SIZE; i++) {
            if (iSet.set[i] != set[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isEmpty = true;
        for (int i = 0; i < SET_SIZE; i++) {
            if (set[i]) {
                sb.append(i).append(" ");
                isEmpty = false;
            }
        }
        if (isEmpty) {
            return "---";
        }
        return sb.toString();
    }

}
