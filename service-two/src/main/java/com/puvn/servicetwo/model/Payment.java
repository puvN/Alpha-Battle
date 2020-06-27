package com.puvn.servicetwo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

	private String ref;
	private Integer categoryId;
	private String userId;
	private String recipientId;
	private String desc;
	private Double amount;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"ref='" + ref + '\'' +
				", categoryId=" + categoryId +
				", userId='" + userId + '\'' +
				", recipientId='" + recipientId + '\'' +
				", desc='" + desc + '\'' +
				", amount=" + amount +
				'}';
	}
}
