package test;

import java.util.LinkedList;
import java.util.List;

public class Event{
	
	public interface Delegate{
		void action(Event invoker, Object about);
	}

	List<Delegate> list;
	String name;
	public Event(String name) {
		list=new LinkedList<>();
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public void addDelegate(Delegate d){
		list.add(d);
	}
	
	public void apply(){
		list.forEach(d->d.action(this, null));
	}
	
	public void apply(Object about){
		list.forEach(d->d.action(this, about));
	}
	
	public void bindTo(Event e){
		e.addDelegate((i,a)->apply(a));
	}
}
