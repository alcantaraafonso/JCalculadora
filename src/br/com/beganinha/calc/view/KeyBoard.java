package br.com.beganinha.calc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyBoard extends JPanel {
	
	private final Color DARK_GRAY = new Color(68, 68, 68);
	private final Color LIGHT_GRAY = new Color(99, 99, 99);
	private final Color ORANGLE = new Color(242, 163, 60);
	
	public KeyBoard() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		addButton("AC", DARK_GRAY, c, 0, 0);
		addButton("+/-", DARK_GRAY, c, 1, 0);
		addButton("%", DARK_GRAY, c, 2, 0);
		addButton("/", ORANGLE, c, 3, 0);

		addButton("7", DARK_GRAY, c, 0, 1);
		addButton("8", DARK_GRAY, c, 1, 1);
		addButton("9", DARK_GRAY, c, 2, 1);
		addButton("*", ORANGLE, c, 3, 1);
		
		addButton("4", DARK_GRAY, c, 0, 2);
		addButton("5", DARK_GRAY, c, 1, 2);
		addButton("6", DARK_GRAY, c, 2, 2);
		addButton("-", ORANGLE, c, 3, 2);

		addButton("1", DARK_GRAY, c, 0, 3);
		addButton("2", DARK_GRAY, c, 1, 3);
		addButton("3", DARK_GRAY, c, 2, 3);
		addButton("+", ORANGLE, c, 3, 3);

		addButton("0", DARK_GRAY, c, 0, 4);
		addButton("0", DARK_GRAY, c, 1, 4);
		addButton(",", DARK_GRAY, c, 2, 4);
		addButton("=", ORANGLE, c, 3, 4);
	}

	private void addButton(String text, Color color, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		
		Button button = new Button(text, color);
		add(button, c);
	}

}
