import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GameView;

public class Main extends JPanel {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new GameView().setVisible(true);
			}
		});
	}

}
