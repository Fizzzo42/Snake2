package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CyclicBarrier;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.Direction;
import model.Snake;

public class GameView extends JFrame {

	Snake mySnake;
	CyclicBarrier syncPoint;

	public GameView() {
		setSize(700, 300);
		mySnake = new Snake(new Point(30, 30), Direction.RIGHT, 30);
		for (Point bodyPart : mySnake.getSnakeBody()) {
			System.out.println("X: " + bodyPart.x + " Y: " + bodyPart.y);
		}
		Timer timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mySnake.doStep();
				repaint();
			}
		});
		timer.start();

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//		Font font = new Font("Serif", Font.PLAIN, 96);
		//		g2.setFont(font);
		//		g2.drawString("Text", 40, 120);

		//		g2.draw(mySnake);
		Polygon square = new Polygon();
		
		for (Point bodyPart : mySnake.getSnakeBody())
			square.addPoint(bodyPart.x, bodyPart.y);
		g2.draw(square);
	}

}
