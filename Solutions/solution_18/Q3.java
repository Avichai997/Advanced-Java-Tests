package test;

public class Q3 {

	public static int getCheckDigit(String id) {
		int sum = 0;
		int i = 1;
		for (char c : id.toCharArray()) {
			int x = i * (c - '0');
			if (x >= 10) // e.g. 14
				x = 1 + x % 10; // 1 + 4
			sum += x;
			i = 2 - (i + 1) % 2; // alternate between 1 and 2
		}
		return (sum % 10 > 0 ? 10 - sum % 10 : 0);
	}

	public static int calcMissingDigit(String id) {
		int checkDigit = id.charAt(8) - '0';
		String id8 = id.substring(0, 8);
		char[] chrs = id8.toCharArray();
		int m = id.indexOf('_');
		for (char c = '0'; c < '9'; c++) {
			chrs[m] = c;
			String idTest = new String(chrs);
			int cd = getCheckDigit(idTest);
			if (cd == checkDigit)
				return c - '0';
		}
		return 0;
	}
}
