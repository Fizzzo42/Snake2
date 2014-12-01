package model;

import java.awt.Point;

public enum Direction {
	UP(-1, 0), RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1);

	private final Point point;

	Direction(int x, int y) {
		point = new Point(x, y);
	}

	public Point getPoint() {
		return point;
	}

	public static Direction getOpposite(Direction direc) {
		switch (direc) {
		case UP:
			return DOWN;
		case RIGHT:
			return LEFT;
		case DOWN:
			return UP;
		case LEFT:
			return RIGHT;
		}
		return direc;
	}
}
