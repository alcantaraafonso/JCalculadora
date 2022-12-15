package br.com.beganinha.calc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel{
	
	private final JLabel label;

	public Display() {
		setPreferredSize(new Dimension(233, 60));
		setBackground(new Color(46, 49, 50));
		
		label = new JLabel("1234");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("curier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		add(label);
	}
	
}
