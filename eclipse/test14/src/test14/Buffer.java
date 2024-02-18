package test14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Buffer<T> {
	ArrayList<T> buff;

	public Buffer() {
		buff = new ArrayList<>();
	}

	public Buffer(T... ts) {
		buff = new ArrayList<>();
		for (T t : ts)
			buff.add(t);
	}

	public Buffer<T> append(T item) {
		buff.add(item);
		return this;
	}

	public Buffer<T> reverese() {
		ArrayList<T> newBuff = new ArrayList<>(buff.size());
		for (int i = buff.size() - 1; i >= 0; i--)
			newBuff.add(buff.get(i));

		buff = newBuff;

		return this;
	}

	public Buffer<T> apply(UnaryOperator<T> uop) {
		ArrayList<T> oldBuff = buff;
		buff = new ArrayList<>();
		for (int i = 0; i < oldBuff.size(); i++)
			buff.add(uop.apply(oldBuff.get(i)));

		return this;
	}

	public List<T> toList() {
		return buff;
	}

}
