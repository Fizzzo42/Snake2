package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Difficulty;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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

		JComboBox<Difficulty> comboBox = new JComboBox<Difficulty>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Difficulty newDifficulty = (Difficulty) e.getItem();
					GameView.getInstance().getSnake().setDifficulty(newDifficulty);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<Difficulty>(Difficulty.values()));
		comboBox.setSelectedItem(Difficulty.DEFAULT);
		comboBox.setFocusable(false);

		add(comboBox);
	}
}
