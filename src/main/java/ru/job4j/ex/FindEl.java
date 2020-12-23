package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        /* for-each */
        for (String allElements : value) {
            if (allElements.equals(key)) {
                rsl = index;
                break;
            }
            index++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("not such element found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array ={"aa","ss","dd"};
        try {
            indexOf(array, "ff");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
