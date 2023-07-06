package co.develhope.bugtracker.controller.dto;

public class BaseResponse {

	private Status status = Status.OK;
	
	private String errorMessage;
	
	public Status getStatus() {
		return status;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public enum Status {
		OK, KO;
	}
	
}
