package test;

import test.Moveable.Direction;

public class PushableAdapter implements Pushable {
	
	private Moveable m;

	public PushableAdapter(Moveable m) {
		this.m=m;
	}

	public void push(int heading) {
		if(heading>=45 && heading<=134)
			m.moveMe(Direction.right);
		if(heading>=135 && heading<=224)
			m.moveMe(Direction.down);
		if(heading>=225 && heading<=314)
			m.moveMe(Direction.left);
		if(heading>=315 || heading<=44)
			m.moveMe(Direction.up);
	}

}
