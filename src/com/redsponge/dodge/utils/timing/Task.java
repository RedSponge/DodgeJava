package com.redsponge.dodge.utils.timing;

import com.redsponge.dodge.Handler;

public abstract class Task {

	public abstract void execute();

	public abstract void tick();

	public boolean toBeDeleted;
	protected Handler handler;

	public Task(Handler handler) {
		toBeDeleted = false;
		this.handler = handler;
	}

}
