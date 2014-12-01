package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

	// Head is always at Position 0
	private Deque<Point> snakeBody;
	private Direction walkingDirection;
	private final static int FATNESS = 30;

	/**
	 * You have to make sure yourself that you don't draw out of your initial area
	 * 
	 * @param startingPoint
	 * 
	 * @param direction
	 *            Direction in which the Snake should walk to (Tailparts will be added in the opposite direction)
	 * @param lenght
	 *            1 = Only the head
	 */
	public Snake(Point startingPoint, Direction direction, int lenght) {
		snakeBody = new LinkedList<Point>();
		snakeBody.addFirst(startingPoint);
		for (int i = 1; i < lenght; i++)
			snakeBody.addLast(addPoints(snakeBody.getLast(), Direction.getOpposite(direction).getPoint()));
		walkingDirection = direction;
	}

	private Point addPoints(Point p1, Point p2) {
		int x, y;
		x = p1.x;
		y = p1.y;
		x += p2.x;
		x += p2.y;
		return new Point(x, y);
	}

	public Deque<Point> getSnakeBody() {
		return snakeBody;
	}

	public void doStep() {
		snakeBody.addFirst(addPoints(snakeBody.getFirst(), walkingDirection.getPoint()));
		snakeBody.removeLast();
	}

}
