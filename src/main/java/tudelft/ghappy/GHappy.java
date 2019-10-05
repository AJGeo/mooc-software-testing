package tudelft.ghappy;

public class GHappy {

    public boolean gHappy(String str) {
        assert str != null;

//        // If the input string does not contain any "gg" why bother looking any further, using java string function
//        if(!str.contains("gg"))
//            return false;

        // if input string length is less than 2, then true condition is impossible
        if (str.length() < 2)
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i - 1) == 'g') {
                    continue;
                }
                if (i + 1 < str.length() && str.charAt(i + 1) == 'g') {
                    continue;
                }
                return false;
            }
        }

        return true;

    }
}
