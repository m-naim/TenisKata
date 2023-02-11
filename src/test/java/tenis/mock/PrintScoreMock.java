package tenis.mock;

import java.util.ArrayList;
import java.util.List;

import org.kata.tenis.PrintScore;

public class PrintScoreMock implements PrintScore {
	
	List<String> prints= new ArrayList<String>();
	
	public void print(String score) {
		prints.add(score);
	}
	
	public List<String> getPrints() {
		return prints;
	}

}
