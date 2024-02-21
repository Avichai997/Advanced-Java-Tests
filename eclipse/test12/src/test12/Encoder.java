package test12;

import java.util.HashMap;
import java.util.function.Function;

public class Encoder {
	HashMap<Character, Character> eKey;
	HashMap<Character, Character> dKey;

	public Encoder(HashMap<Character, Character> key) {
		eKey = key;
		dKey = new HashMap<>();
		key.forEach((k, v) -> dKey.put(v, k));
	}

	public Encoder(Function<Character, Character> func) {
		eKey = new HashMap<>();
		dKey = new HashMap<>();
		for (char c = 0; c < 256; c++) {
			char d = func.apply(c);
			eKey.put(c, d);
			dKey.put(d, c);
		}
	}

	public String encode(String text) {
		return code(text, eKey);
	}

	public String decode(String text) {
		return code(text, dKey);
	}

	private String code(String text, HashMap<Character, Character> key) {
		char[] msg = text.toCharArray();
		for (int i = 0; i < msg.length; i++)
			msg[i] = key.get(msg[i]);
		return new String(msg);
	}

}
