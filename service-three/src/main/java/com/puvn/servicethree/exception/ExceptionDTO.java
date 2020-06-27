package com.puvn.servicethree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
public class ExceptionDTO {

	private String status = "branch not found";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExceptionDTO{" +
				"status='" + status + '\'' +
				'}';
	}
}
