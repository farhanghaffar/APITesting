package com.bond.utilities;

import com.aventstack.extentreports.Status;

public class TestSteps {
	String step;
	Status status;
	
	public TestSteps(String step, Status status) {
		this.step = step;
		this.status = status;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
