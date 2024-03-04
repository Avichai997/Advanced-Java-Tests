package test;

import java.util.Observable;
import java.util.Observer;

public class Smurf extends Observable implements Observer {

	private boolean working;

	public Smurf() {
		working = false;
	}

	public boolean isWorking() {
		return working;
	}

	public void workWhen(Smurf... smurfs) {
		for (Smurf smurf : smurfs) {
			smurf.addObserver(this);
		}
	}

	public void work() {
		if (working)
			return;

		working = true;
		setChanged();
		notifyObservers();
	}

	@Override
	public void update(Observable o, Object arg) {
		work();
	}
}
