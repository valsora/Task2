public class Task2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
    }

    public static String duplicateChars(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String outputString = "";
        for (int i = 0; i < s1.length(); i++) {
            outputString += s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    outputString = outputString.substring(0, outputString.length() - 1);
                    break;
                }
            }
        }
        return outputString;
    }
}