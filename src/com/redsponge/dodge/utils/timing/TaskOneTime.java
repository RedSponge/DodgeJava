package com.redsponge.dodge.utils.timing;

import com.redsponge.dodge.Handler;

public abstract class TaskOneTime extends Task {

	private int time;
	private int counter;

	public TaskOneTime(Handler handler, int timeUntilExecution) {
		super(handler);
		time = timeUntilExecution;
	}

	public void tick() {
		counter++;
		if (counter >= time) {
			toBeDeleted = true;
			execute();
		}
	}

}
