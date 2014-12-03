import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Direction;
import model.Snake;
import view.GameView;
import view.OptionsView;

public class Main extends JFrame {

	final static int GAMESIZE = 300;
	final static int OPTIONSSIZE = 100;
	final static int TEXTVIEWHEIGHT = 30;
	JLabel labelInstruction;

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

	public Main() {

		setTitle("Snake 2.0");
		setSize(GAMESIZE + OPTIONSSIZE, TEXTVIEWHEIGHT + GAMESIZE + TEXTVIEWHEIGHT + 20);
		setMinimumSize(getSize());

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { OPTIONSSIZE, GAMESIZE, 0 };
		gridBagLayout.rowHeights = new int[] { TEXTVIEWHEIGHT, GAMESIZE, TEXTVIEWHEIGHT };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
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

		labelInstruction = new JLabel("Please press a button to start...");
		GridBagConstraints gbc_labelInstruction = new GridBagConstraints();
		gbc_labelInstruction.insets = new Insets(0, 0, 5, 0);
		gbc_labelInstruction.gridx = 0;
		gbc_labelInstruction.gridwidth = 2;
		gbc_labelInstruction.gridy = 0;
		getContentPane().add(labelInstruction, gbc_labelInstruction);

		JLabel lblMadeByzhan = new JLabel("made by Özhan Kaya");
		GridBagConstraints gbc_lblMadeByzhan = new GridBagConstraints();
		gbc_lblMadeByzhan.gridx = 0;
		gbc_lblMadeByzhan.gridwidth = 2;
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
					Snake mySnake = GameView.getInstance().getSnake();

					if (mySnake.isRunning()) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_UP:
							if (mySnake.getWalkingDirection() != Direction.DOWN)
								mySnake.setNextDirection(Direction.UP);
							break;
						case KeyEvent.VK_RIGHT:
							if (mySnake.getWalkingDirection() != Direction.LEFT)
								mySnake.setNextDirection(Direction.RIGHT);
							break;
						case KeyEvent.VK_DOWN:
							if (mySnake.getWalkingDirection() != Direction.UP)
								mySnake.setNextDirection(Direction.DOWN);
							break;
						case KeyEvent.VK_LEFT:
							if (mySnake.getWalkingDirection() != Direction.RIGHT)
								mySnake.setNextDirection(Direction.LEFT);
							break;
						}
					} else {
						mySnake.setRunning(true);
						labelInstruction.setText("");
					}
				}
				return false;
			}
		});
	}
}
