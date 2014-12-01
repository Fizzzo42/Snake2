package view;

import java.awt.Color;

import javax.swing.JPanel;

public class OptionsView extends JPanel {

	private static OptionsView instance = null;

	public static OptionsView getInstance() {
		if (instance == null) {
			instance = new OptionsView();
		}
		return instance;
	}

	public OptionsView() {
		setBackground(Color.LIGHT_GRAY);
	}
}
