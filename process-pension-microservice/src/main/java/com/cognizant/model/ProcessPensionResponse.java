package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPensionResponse {
	private int processPensionStatusCode;
	
	public ProcessPensionResponse() {
		
	}
	public ProcessPensionResponse(int processPensionStatusCode) {
		super();
		this.processPensionStatusCode = processPensionStatusCode;
	}

	public int getProcessPensionStatusCode() {
		return processPensionStatusCode;
	}

	public void setProcessPensionStatusCode(int processPensionStatusCode) {
		this.processPensionStatusCode = processPensionStatusCode;
	}
	
}
