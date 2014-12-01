package model;

import java.awt.Point;

public enum Direction {
	UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0);

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
