import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import model.Direction;
import view.GameView;
import view.OptionsView;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class Main extends JFrame {

	final static int GAMESIZE = 300;

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

	public Main() {

		setTitle("Snake 2.0");
		setSize(GAMESIZE + 400, GAMESIZE + 50);
		setMinimumSize(getSize());

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, GAMESIZE, 0 };
		gridBagLayout.rowHeights = new int[] { 0, GAMESIZE, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		JPanel gameview = GameView.getInstance();
		GridBagConstraints gbc_gameview = new GridBagConstraints();
		gbc_gameview.insets = new Insets(0, 0, 5, 5);
		gbc_gameview.fill = GridBagConstraints.BOTH;
		gbc_gameview.gridx = 1;
		gbc_gameview.gridy = 1;
		getContentPane().add(gameview, gbc_gameview);

		JPanel options = OptionsView.getInstance();
		GridBagConstraints gbc_options = new GridBagConstraints();
		gbc_options.insets = new Insets(0, 0, 5, 5);
		gbc_options.fill = GridBagConstraints.BOTH;
		gbc_options.gridx = 0;
		gbc_options.gridy = 1;
		getContentPane().add(options, gbc_options);

		JLabel lblMadeByzhan = new JLabel("made by Özhan Kaya");
		GridBagConstraints gbc_lblMadeByzhan = new GridBagConstraints();
		gbc_lblMadeByzhan.gridx = 1;
		gbc_lblMadeByzhan.gridy = 2;
		getContentPane().add(lblMadeByzhan, gbc_lblMadeByzhan);

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
						if (GameView.getInstance().getSnake().getWalkingDirection() != Direction.DOWN)
							GameView.getInstance().getSnake().setNextDirection(Direction.UP);
						break;
					case KeyEvent.VK_RIGHT:
						if (GameView.getInstance().getSnake().getWalkingDirection() != Direction.LEFT)
							GameView.getInstance().getSnake().setNextDirection(Direction.RIGHT);
						break;
					case KeyEvent.VK_DOWN:
						if (GameView.getInstance().getSnake().getWalkingDirection() != Direction.UP)
							GameView.getInstance().getSnake().setNextDirection(Direction.DOWN);
						break;
					case KeyEvent.VK_LEFT:
						if (GameView.getInstance().getSnake().getWalkingDirection() != Direction.RIGHT)
							GameView.getInstance().getSnake().setNextDirection(Direction.LEFT);
						break;
					}
				}
				return false;
			}
		});
	}

}
