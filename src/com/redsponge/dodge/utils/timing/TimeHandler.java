package com.redsponge.dodge.utils.timing;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import com.redsponge.dodge.Handler;

public class TimeHandler {

	private ArrayList<TaskOneTime> oneTimeTasks;
	@SuppressWarnings("unused")
	private Handler handler;

	public TimeHandler(Handler handler) {
		this.handler = handler;
		oneTimeTasks = new ArrayList<TaskOneTime>();
	}

	public void tick() {
		tickOneTimeTasks();
	}

	public void tickOneTimeTasks() {
		try {
			if (oneTimeTasks.isEmpty()) {
				return;
			}
			for (TaskOneTime t : oneTimeTasks) {
				t.tick();
				if (t.toBeDeleted) {
					oneTimeTasks.remove(t);
				}
			}
		} catch (ConcurrentModificationException e) {
			return;
		}
	}

	public void scheduleOneTimeTask(TaskOneTime task) {
		oneTimeTasks.add(task);
	}

	public void clearOneTimeTasks() {
		oneTimeTasks.clear();
	}
}
