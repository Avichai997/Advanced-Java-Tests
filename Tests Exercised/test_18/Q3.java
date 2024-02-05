

public class Q3 {

	public static int checkMissingDigit(String id) {
		int[] weights = { 1, 2, 1, 2, 1, 2, 1, 2 };
		int sum = 0;
		for (int i = 0; i < id.length(); i++) {
			int res = weights[i] * Character.getNumericValue(id.charAt(i));
			if (res >= 10)
				res = 1 + res % 10;
			sum += res;
		}

		return sum % 10 > 0 ? 10 - sum % 10 : 0;
	}

	public static int calcMissingDigit(String id) {
		int checkDigit = id.charAt(8) - '0';

		String id8 = id.substring(0, 8);
		char[] chars = id8.toCharArray();

		// fix missing number
		int missingId = id.indexOf('_');
		for (char c = '0'; c < '9'; c++) {
			chars[missingId] = c;
			// id = "120456789"
			int result = checkMissingDigit(new String(chars));

			if (result == checkDigit)
				return c - '0';
		}

		return 0;
	}

	// public static void main(String[] args) {
	// String id = "_23456782";
	// int missingDigit = Q3.calcMissingDigit(id);
	// System.out.println(missingDigit);
	// }
}
