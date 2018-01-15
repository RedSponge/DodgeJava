package com.redsponge.dodge.waves.parsing;

public class EnemyIdNotFoundException extends Exception {

	private static final long serialVersionUID = 7654142297810011144L;

	public EnemyIdNotFoundException() {
		super("Enemy ID could not be found!");
	}

	public EnemyIdNotFoundException(String id) {
		super("Enemy ID " + id + " could not be found!");
	}

}
