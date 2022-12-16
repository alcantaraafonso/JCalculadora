package br.com.beganinha.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private static final Memory instance = new Memory();
	private enum CommandType {
		AC, NUMBER, DIV, MULT, SUB, SUM, EQUALS, COMMA;
	};
	private final List<MemoryObserver> observers = new ArrayList<>();
	
	private String currentText = "";
	private String bufferText = "";
	private boolean replacement = false;
	private CommandType lastOperation = null;
	
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
		
//		System.out.println(commandType);
		
		if(commandType == null) {
			return;
		} else if (commandType == CommandType.AC) {
			currentText = "";
			bufferText = "";
			replacement = false;
			lastOperation = null;
		} else if (commandType == CommandType.NUMBER || commandType == CommandType.COMMA) {
			currentText = replacement ? value : currentText + value;
			replacement = false;
		} else {
			replacement = true;
			currentText = processOperation();
			bufferText = currentText;
			lastOperation = commandType;
		}
		observers.forEach(o -> o.valeuUpdated(getCurrentText()));
	}

	private String processOperation() {
		if (lastOperation == null || lastOperation == CommandType.EQUALS)
			return currentText;
		
		double bufferNumber = Double.parseDouble(bufferText.replace(",", "."));
		double currentNumber = Double.parseDouble(currentText.replace(",", "."));
		double result = 0;
		
		if(lastOperation == CommandType.SUM)
			result = bufferNumber + currentNumber;
		if(lastOperation == CommandType.SUB)
			result = bufferNumber - currentNumber;
		if(lastOperation == CommandType.MULT)
			result = bufferNumber * currentNumber;
		if(lastOperation == CommandType.DIV)
			result = bufferNumber / currentNumber;
		
		String resultString = Double.toString(result).replace(".", ",");
		boolean inteiro = resultString.endsWith(",0");
			
		return inteiro ? resultString.replace(",0", "") : resultString;
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
			else if (",".equals(value) && !currentText.contains(","))
				return CommandType.COMMA;
		
		}
		
		return null;
	}


}
