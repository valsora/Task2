import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("1. " + duplicateChars("Barack", "Obama"));
        System.out.println("2. " + dividedByThree(new int[] {3, 12, 7, 81, 52}));
        System.out.println("3. " + getInitials("simonov sergei evgenievich"));
        System.out.println("4. " + Arrays.toString(normalizator(new double[] {3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println("5. " + Arrays.toString(compressedNums(new double[] {1.6, 0, 212.3, 34.8, 0, 27.5})));
        System.out.println("6. " + camelToSnake("helloWorld"));
        System.out.println("7. " + secondBiggest(new int[] {3, 5, 8, 1, 2, 4}));
        System.out.println("8. " + localReverse("Hello, I'm under the water, please help me", 'e'));
        System.out.println("9. " + equal(8, 1, 8));
        System.out.println("10. " + isAnagram("LISTEN", "silent"));
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

    public static int dividedByThree(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1 && arr[i] % 3 == 0) counter++;
        }
        return counter;
    }

    public static String getInitials(String name) {
        String[] nameArr = name.split(" ");
        return nameArr[1].toUpperCase().charAt(0) + "." + nameArr[2].toUpperCase().charAt(0) + "." + nameArr[0].toUpperCase().charAt(0) + nameArr[0].substring(1);
    }

    public static double[] normalizator(double[] arr) {
        double[] normalizedArr = arr.clone();
        Arrays.sort(arr);
        if (arr[arr.length - 1] == arr[0]) return new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            normalizedArr[i] = (normalizedArr[i] - arr[0]) / (arr[arr.length - 1] - arr[0]);
        }
        return normalizedArr;
    }

    public static int[] compressedNums(double[] arr) {
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroCount += 1;
        }
        Arrays.sort(arr);
        int[] compressedArr = new int[arr.length - zeroCount];
        for (int i = zeroCount; i < arr.length; i++) {
            compressedArr[i - zeroCount] = ((int)arr[i]);
        }
        return compressedArr;
    }

    public static String camelToSnake(String camelString) {
        String snakeString = "";
        for (int i = 0; i < camelString.length(); i++) {
            char ch = camelString.charAt(i);
            if (Character.isLowerCase(ch)) snakeString += ch;
            else snakeString += "_" + Character.toLowerCase(ch);
        }
        return snakeString;
    }

    public static int secondBiggest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static String localReverse(String s, char ch) {
        String outputString = "";
        String substr = "";
        boolean isFirst = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch) substr += s.charAt(i);
            else {
                isFirst = !isFirst;
                if (!isFirst) outputString += reverseString(substr);
                else outputString += substr;
                substr = "";
                outputString += ch;
            }
        }
        outputString += substr;
        return outputString;
    }

    public static String reverseString(String s) {
        String reversedS = "";
        for (int i = s.length() - 1; i >= 0; i --) {
            reversedS += s.charAt(i);
        }
        return reversedS;
    }

    public static int equal(int a, int b, int c) {
        if (a == b && b == c) return 3;
        else {
            if (a != b && a != c && b != c) return 0;
            else return 2;
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            boolean isFound = false;
            for (int j = 0; j < s2.length(); j++) {
                if (ch == s2.charAt(j)) {
                    s2 = s2.substring(0, j) + s2.substring(j + 1);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) return false;
        }
        return true;
    }
}