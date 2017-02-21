package adams.ui;

public class StringUtil {

    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
    
    // Pad a string with dots, like a phone book does.
    public static String padWithDots(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(".");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
}
