package model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

	// Head is always at Position 0
	private Deque<Point> snakeBody;
	private Direction walkingDirection;
	private Direction nextDirection;
	private final static int FATNESS = 10;
	private Difficulty difficulty;
	private int diffCounter = 0;

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
	public Snake(Point startingPoint, Direction direction, int lenght, Difficulty difficulty) {
		snakeBody = new LinkedList<Point>();
		snakeBody.addFirst(startingPoint);
		for (int i = 1; i < lenght; i++)
			snakeBody.addLast(addPoints(snakeBody.getLast(), Direction.getOpposite(direction).getPoint()));
		walkingDirection = direction;
		nextDirection = direction;
		this.difficulty = difficulty;
	}

	private Point addPoints(Point p1, Point p2) {
		int x, y;
		x = p1.x;
		y = p1.y;
		x += p2.x;
		y += p2.y;
		return new Point(x, y);
	}

	public Deque<Point> getSnakeBody() {
		return snakeBody;
	}

	public void doStep() {
		diffCounter++;
		if (diffCounter >= difficulty.getDifficulty()) {
			walkingDirection = nextDirection;
			snakeBody.addFirst(addPoints(snakeBody.getFirst(), walkingDirection.getPoint()));
			snakeBody.removeLast();
			diffCounter = 0;
		}
	}

	public void paint(Graphics2D g2) {
		for (Point bodyPart : snakeBody)
			g2.fillRect(bodyPart.x * FATNESS, bodyPart.y * FATNESS, FATNESS, FATNESS);

	}

	public void setNextDirection(Direction direction) {
		nextDirection = direction;
	}

	public Direction getWalkingDirection() {
		return walkingDirection;
	}

}
