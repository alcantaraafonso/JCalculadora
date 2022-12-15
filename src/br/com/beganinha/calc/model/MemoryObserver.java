package br.com.beganinha.calc.model;

@FunctionalInterface
public interface MemoryObserver {

	public void valeuUpdated(String newValue);
}
