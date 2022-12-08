package telran.chiper;

public class BaseCipher {

	private static final int MAXVALUE = 94;
	private static final int MINVALUE = 2;
	private String key = getKey();

	public byte[] cipher(String key) {
		key = getKey();
		char[] kitNumbers = key.toCharArray();
		byte[] res = new byte[kitNumbers.length];
		if (kitNumbers.length <= MAXVALUE && kitNumbers.length >= MINVALUE) {
			for (int i = 0; i < kitNumbers.length; i++) {
				if (kitNumbers[i] != kitNumbers[i++]) {
					res[i] = (byte) kitNumbers[i];

				}
			}
		} else {
			res = null;
		}
		return res;

	}

	public String decipher(byte[] cipher) {
		byte[] forDecipher = cipher(key);
		char[] charSymb = new char[forDecipher.length];
		for (int i = 0; i < charSymb.length; i++) {
			charSymb[i] = (char) charSymb[i];
		}
		String res = charSymb.toString();
		return res;

	}

	public static String getKey() {

		return "[a-zA-Z0-9\\p{Punct}]*";

	}

}