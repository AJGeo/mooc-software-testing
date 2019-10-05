package tudelft.mirror;

public class Mirror {

    public String mirrorEnds(String string) {
        String mirror = "";

        // If null string return empty string
        if (string == null)
            return mirror;

        int begin = 0;
        int end = string.length() - 1;
        for (; begin < end; begin++, end--) {
            if (string.charAt(begin) == string.charAt(end)) {
                mirror += String.valueOf(string.charAt(end));
            } else {
                break;
            }
        }

        // If begin==end an uneven length string and every char was tested to the middle of string with all matching
        // If begin>=end an even length string and every char was tested to the past the middle of string with all matching
        return begin >= end ? string : mirror;
    }
}
