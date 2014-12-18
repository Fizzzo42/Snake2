package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Difficulty;
import model.Direction;
import model.Snake;
import errors.UnsupportedViewSizeError;

public class GameView extends JPanel implements ComponentListener {

	private Snake snake;
	private static GameView instance = null;

	public static GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		return instance;
	}

	private GameView() {
		this.addComponentListener(this);
		snake = new Snake(new Point(3, 3), Direction.DOWN, 3, Difficulty.DEFAULT);

		setBackground(Color.GRAY);
		setVisible(true);

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

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(getBackground());
		g2.fillRect(0, 0, getWidth(), getHeight()); // Clear

		// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		// Font font = new Font("Serif", Font.PLAIN, 96);
		// g2.setFont(font);
		// g2.drawString("Text", 40, 120);

		// g2.draw(mySnake);
		g2.setColor(Color.BLACK);
		snake.paint(g2);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		if (getWidth() % Snake.FATNESS != 0 || getHeight() % Snake.FATNESS != 0) {
			throw new UnsupportedViewSizeError("Snake won't fit perfectly into GameView");
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

}
