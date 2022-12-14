package br.com.beganinha.calc.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
	
	public Calculator() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
