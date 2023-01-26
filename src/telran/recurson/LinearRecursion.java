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
		int res = 0;
		if (b < 0) {
			res =  multiply(-a, -b);
			
		} if (b > 0) {
			res = a + multiply (a, b -1);
			
		}
		return res;

	}

	public static boolean isSubstring(String string, String substr) {
		boolean res = false;
		
		if (string.length() >= substr.length()) {
			res = isEqual(string, substr) ? true : isSubstring(string.substring(1), substr);
		}
		
		return res;
	}

	private static boolean isEqual(String string, String substr) {
		boolean res = false;
		if (substr.length() == 0) {
			res = true;
		} else if (string.charAt(0) == substr.charAt(0)) {
			res = isEqual(string.substring(1), substr.substring(1));
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
		} else if (x == 0) {
			res = 0;
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
