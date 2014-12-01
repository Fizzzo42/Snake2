package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Direction;
import model.Snake;

public class GameView extends JPanel {

	private Snake snake;
	private static GameView instance = null;

	public static GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		return instance;
	}

	private GameView() {
		setVisible(true);
		snake = new Snake(new Point(3, 3), Direction.DOWN, 3);
		for (Point bodyPart : snake.getSnakeBody()) {
			System.out.println("X: " + bodyPart.x + " Y: " + bodyPart.y);
		}
		Timer timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.doStep();
				repaint();
			}
		});
		timer.start();
	}

	public Snake getSnake() {
		return snake;
	}

	@Override
	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g; //Clear

		g2.clearRect(0, 0, getWidth(), getHeight());

		// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//		Font font = new Font("Serif", Font.PLAIN, 96);
		//		g2.setFont(font);
		//		g2.drawString("Text", 40, 120);

		//		g2.draw(mySnake);
		snake.paint(g2);
	}

}
