package com.puvn.servicetwo.model;

import java.text.DecimalFormat;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
public class SumData {

	private Double min;
	private Double max;
	private Double sum;

	public SumData() {}

	public SumData(Double min, Double max, Double sum) {
		this.min = min;
		this.max = max;
		this.sum = sum;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SumData{" +
				"min=" + min +
				", max=" + max +
				", sum=" + sum +
				'}';
	}
}
