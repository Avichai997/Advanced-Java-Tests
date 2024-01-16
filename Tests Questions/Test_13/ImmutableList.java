package test;

public final class ImmutableList<E> {
	public final E head;
	public final ImmutableList<E> tail;
	
	public ImmutableList(E head,ImmutableList<E> tail) {
		this.head=head;
		this.tail=tail;
	}
}
