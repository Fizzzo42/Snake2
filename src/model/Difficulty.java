package model;

public enum Difficulty {
	EASY(7), MEDIUM(3), HARD(2), EXTREME(1);

	int difficulty;
	final static public Difficulty DEFAULT = MEDIUM;

	private Difficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDifficulty() {
		return difficulty;
	}

}
