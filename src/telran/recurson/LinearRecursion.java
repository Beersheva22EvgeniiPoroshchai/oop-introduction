package telran.recurson;

public class LinearRecursion {

	public static long factorial(int n) {
		long res = 0;
		if (n < 0) {
			res = factorial(-n);
		} else if (n < 2) {
			res = 1;
		} else {
			res = n * factorial(n - 1);

		}
		return res;

	}

	public static int power(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b == 1) {
			res = a;

		} else if (b > 1) {
			res = a * power(a, b - 1);
		}
		return res;

	}

	public static int newPower(int a, int b) {

		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b == 0) {
			return res;
		}
		if (a == 0) {
			res = 0;
		}
		if (b == 1) {
			res = a;
		}
		res = multiply(a, newPower(a, b - 1));

		return res;
	}

	private static int multiply(int a, int b) {
		if (b > 0) {
			return (a + multiply(a, b - 1));
		} else {
			return 0;
		}

	}

	public static boolean isSubstring(String string, String substr, int strInd, int substrInd) {
		boolean res = false;
		if (strInd == string.length()) {
			return res;
		}
		if (string.charAt(strInd) == substr.charAt(substrInd)) {
			if (exMatch(string, substr, strInd + 1, substrInd + 1)) {
				return true;
			}
		}

		res = isSubstring(string, substr, strInd + 1, substrInd);
		return res;
	}

	private static boolean exMatch(String string, String substr, int strInd, int substrInd) {
		boolean res = false;
		if (strInd == string.length() && substrInd != substr.length()) {
			res = false;
		}
		if (substrInd == substr.length()) {
			return true;
		}

		if (substr.charAt(substrInd) == string.charAt(strInd)) {
			res = exMatch(string, substr, strInd + 1, substrInd + 1);
		}

		return res;
	}

	public static long sum(int ar[]) {
		return sum(0, ar);
	}

	private static long sum(int firstInd, int[] ar) {
		long res = 0;
		if (firstInd < ar.length) {
			res = ar[firstInd] + sum(firstInd + 1, ar);

		}

		return res;
	}

	public static long square(int x) {
		long res = 0;
		if (x < 0) {
			throw new IllegalArgumentException();
		} else if (x > 0) {
			res = square(x - 1) + (x + x - 1);
		}
		return res;
	}

	public static void reverse(int ar[]) {
		reverse(0, ar.length - 1, ar);
	}

	private static void reverse(int firstInd, int lastInd, int[] ar) {
		if (firstInd < lastInd) {
			swap(ar, firstInd, lastInd);
			reverse(firstInd + 1, lastInd - 1, ar);
		}

	}

	private static void swap(int[] ar, int firstInd, int lastInd) {
		int tmp = ar[firstInd];
		ar[firstInd] = ar[lastInd];
		ar[lastInd] = tmp;

	}
}
