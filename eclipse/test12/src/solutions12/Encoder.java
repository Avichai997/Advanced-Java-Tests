package solutions12;

import java.util.HashMap;
import java.util.function.Function;

public class Encoder {

	HashMap<Character, Character> ekey;
	HashMap<Character, Character> dkey;

	public Encoder(HashMap<Character, Character> key) {
		ekey = key;
		dkey = new HashMap<>();
		key.forEach((k, v) -> dkey.put(v, k));
	}

	public Encoder(Function<Character, Character> func) {
		ekey = new HashMap<>();
		dkey = new HashMap<>();
		for (char e = 0; e < 256; e++) {
			char d = func.apply(e);
			ekey.put(e, d);
			dkey.put(d, e);
		}
	}

	public String encode(String text) {
		return code(text, ekey);
	}

	public String decode(String text) {
		return code(text, dkey);
	}

	private String code(String text, HashMap<Character, Character> key) {
		char[] msg = text.toCharArray();
		for (int i = 0; i < msg.length; i++)
			msg[i] = key.get(msg[i]);
		return new String(msg);
	}

}
