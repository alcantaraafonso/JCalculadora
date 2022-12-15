package br.com.beganinha.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private static final Memory instance = new Memory();
	private String currentText = "";
	private final List<MemoryObserver> observers = new ArrayList<>();
	
	private enum CommandType {
		AC, NUMBER, DIV, MULT, SUB, SUM, EQUALS, COMMA;
	};
	
	/*
	 * Padrão Singleton
	 */
	private Memory() {
		// TODO Auto-generated constructor stub
	}

	public static Memory getInstance() {
		return instance;
	}

	public String getCurrentText() {
		return currentText.isEmpty() ? "0" : currentText ;
	}
	
	public void addObservers(MemoryObserver mo) {
		observers.add(mo);
	}
	
	public void ProcessCommand(String value) {
		CommandType commandType = identityCommandType(value);
		
		System.out.println(commandType);
		
		if("AC".equals(value)) 
			currentText = "";
		else
			currentText += value;
		
		observers.forEach(o -> o.valeuUpdated(getCurrentText()));
	}

	private CommandType identityCommandType(String value) {
		if (currentText.isEmpty() && value == "0")
			return null;
		
		try {
			Integer.parseInt(value);
			return CommandType.NUMBER;
		} catch (NumberFormatException e) {
			//quanndo nçao for número
			if("AC".equals(value)) 
				return CommandType.AC;
			else if ("/".equals(value))
				return CommandType.DIV;
			else if ("*".equals(value))
				return CommandType.MULT;
			else if ("-".equals(value))
				return CommandType.SUB;
			else if ("+".equals(value))
				return CommandType.SUM;
			else if ("=".equals(value))
				return CommandType.EQUALS;
			else if (",".equals(value))
				return CommandType.COMMA;
		
		}
		
		return null;
	}


}
