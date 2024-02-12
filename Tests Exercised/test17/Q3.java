package test17;

public class Q3 {

    public static int getCheckDigit(String id) {
        int[] weights = { 1, 2, 1, 2, 1, 2, 1, 2 };
        char[] digits = id.toCharArray(); // ['5', '4', '3', '7', '0', '0', '4', '2']
        int checkDigit = 0;

        for (int i = 0; i < digits.length; i++) {
            int multiply = digits[i] * weights[i];
            checkDigit += multiply >= 10 ? (multiply % 10 + multiply / 10) : multiply;
        }

        return checkDigit;
    }

    public static void main(String[] args) {
        String id = "54370042";
        int checkDigit = getCheckDigit(id);
        System.out.println("Check Digit: " + checkDigit);
    }

    // public static List<String> checkFile(String fileName) {
    // return null;
    // }

}
