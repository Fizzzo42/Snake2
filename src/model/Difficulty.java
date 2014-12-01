package model;

public enum Difficulty {
	EASY(7), MEDIUM(3), HARD(2), EXTREME(1);

	int difficulty;

	private Difficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDifficulty() {
		return difficulty;
	}

}
