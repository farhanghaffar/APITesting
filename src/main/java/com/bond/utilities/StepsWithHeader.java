package com.bond.utilities;

import java.util.ArrayList;

public class StepsWithHeader {
	String header;
	ArrayList<TestSteps> steps;
	
	public StepsWithHeader() {
		
	}
	
	public StepsWithHeader(String header) {
		this.header = header;
	}
	
	public StepsWithHeader(String header, ArrayList<TestSteps> steps) {
		this.header = header;
		this.steps = steps;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public ArrayList<TestSteps> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<TestSteps> steps) {
		this.steps = steps;
	}
	
	
	
}
