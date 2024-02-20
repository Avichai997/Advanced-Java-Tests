package test13;

import java.util.function.Consumer;

public class ListBuilder<E> {

	ImmutableList<E> list;

	// [{1, }, {2, null}]
	public ListBuilder<E> push(E e) {
		if(list == null)
			list = new ImmutableList<E>(e, null);
		else 
			list = new ImmutableList<E>(e, list);
		return this;
	}
	
	public ImmutableList<E> build() {
		return list;
	}

	public static <E> void forEach(ImmutableList<E> list, Consumer<E> consumer) {
		consumer.accept(list.head);
		if(list.tail != null)
			forEach(list.tail, consumer);
	}
	
	public ListBuilder<E> reverse() {
		ListBuilder<E> newList = new ListBuilder<>();
		forEach(list, e -> newList.push(e));
		newList.build();
		return newList;
	}

}
