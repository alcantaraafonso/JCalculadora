package br.com.beganinha.calc.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
	
	public Calculator() {
		
		organizeLayout();
		
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void organizeLayout() {
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		Display display = new Display();
		add(display, BorderLayout.NORTH);
		
		KeyBoard kb = new KeyBoard();
		add(kb, BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
