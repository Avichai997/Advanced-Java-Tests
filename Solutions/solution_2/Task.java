package test;

public class Task implements Comparable<Task>{
	
	int frequency;
	int duration;
	String name;
	
	public Task(int frequency, int duration, String name) {
		this.frequency=frequency;
		this.duration=duration;
		this.name=name;
	}
	
	@Override
	public int compareTo(Task t) {
		if(frequency==t.frequency){
			if(duration==t.duration){
				return name.compareTo(t.name);
			}else
				return duration-t.duration;			
		}else			
			return t.frequency-frequency;
	}
}
