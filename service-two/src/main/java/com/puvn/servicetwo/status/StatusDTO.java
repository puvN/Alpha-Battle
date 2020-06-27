package com.puvn.servicetwo.status;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
public class StatusDTO {

	private String status = "UP";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StatusDTO{" +
				"status='" + status + '\'' +
				'}';
	}
}
