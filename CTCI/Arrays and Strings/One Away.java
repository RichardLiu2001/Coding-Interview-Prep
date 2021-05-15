class One Away {

    public static void main(String[] args) {


    }


    public static boolean oneAway(String s1, String s2) {

        if (first.length() == second.length()) {
            return oneEditReplace(s1, s2);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }

        return false;

    }


    public static boolean oneEditInsert(String s1, String s2) {

        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()) {

            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
            } else {
                index1 ++;
            }
            index2 ++;

        }

        return true;

    }



}