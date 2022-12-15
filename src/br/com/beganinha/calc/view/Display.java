package br.com.beganinha.calc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.beganinha.calc.model.Memory;
import br.com.beganinha.calc.model.MemoryObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoryObserver {
	
	private final JLabel label;

	public Display() {
		Memory.getInstance().addObservers(this);
		
		setPreferredSize(new Dimension(233, 60));
		setBackground(new Color(46, 49, 50));
		
		label = new JLabel(Memory.getInstance().getCurrentText());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("curier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		add(label);
		
	}
	
	@Override
	public void valeuUpdated(String newValue) {
		label.setText(newValue);
		
	}
	
}
