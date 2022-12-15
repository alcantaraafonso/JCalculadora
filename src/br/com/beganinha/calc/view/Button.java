package br.com.beganinha.calc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {

	public Button(String text, Color color) {
		setText(text);
		setOpaque(true);
		setFont(new Font("curier", Font.PLAIN, 25));
		setBackground(color);
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}
