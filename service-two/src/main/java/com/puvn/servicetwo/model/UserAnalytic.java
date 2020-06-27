package com.puvn.servicetwo.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
public class UserAnalytic {

	private String userId;
	private Double totalSum;
	Map<Integer, SumData> analyticInfo = new HashMap<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(Double totalSum) {
		this.totalSum = totalSum;
	}

	public Map<Integer, SumData> getAnalyticInfo() {
		return analyticInfo;
	}

	public void setAnalyticInfo(Map<Integer, SumData> analyticInfo) {
		this.analyticInfo = analyticInfo;
	}

	@Override
	public String toString() {
		return "UserAnalytic{" +
				"userId='" + userId + '\'' +
				", totalSum=" + totalSum +
				", analyticInfo=" + analyticInfo +
				'}';
	}
}
