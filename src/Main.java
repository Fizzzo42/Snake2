import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import model.Direction;
import view.GameView;

public class Main extends JFrame {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

	public Main() {

		setTitle("Snake 2.0");
		setSize(700, 300);
		add(GameView.getInstance());
		setVisible(true);
		KeyBoardListener();
	}

	private void KeyBoardListener() {
		KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		focusManager.addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						GameView.getInstance().getSnake().setNextDirection(Direction.UP);
						break;
					case KeyEvent.VK_RIGHT:
						GameView.getInstance().getSnake().setNextDirection(Direction.RIGHT);
						break;
					case KeyEvent.VK_DOWN:
						GameView.getInstance().getSnake().setNextDirection(Direction.DOWN);
						break;
					case KeyEvent.VK_LEFT:
						GameView.getInstance().getSnake().setNextDirection(Direction.LEFT);
						break;
					}
				}
				return false;
			}
		});
	}

}
