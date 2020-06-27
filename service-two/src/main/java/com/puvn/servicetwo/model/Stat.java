package com.puvn.servicetwo.model;

import io.swagger.models.auth.In;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
public class Stat {

	private Integer oftenCategoryId;
	private Integer rareCategoryId;
	private Integer maxAmountCategoryId;
	private Integer minAmountCategoryId;

	public Stat() {}

	public Stat(Integer oftenCategoryId, Integer rareCategoryId, Integer maxAmountCategoryId,
				Integer minAmountCategoryId) {
		this.oftenCategoryId = oftenCategoryId;
		this.rareCategoryId = rareCategoryId;
		this.maxAmountCategoryId = maxAmountCategoryId;
		this.minAmountCategoryId = minAmountCategoryId;
	}

	public Integer getOftenCategoryId() {
		return oftenCategoryId;
	}

	public void setOftenCategoryId(Integer oftenCategoryId) {
		this.oftenCategoryId = oftenCategoryId;
	}

	public Integer getRareCategoryId() {
		return rareCategoryId;
	}

	public void setRareCategoryId(Integer rareCategoryId) {
		this.rareCategoryId = rareCategoryId;
	}

	public Integer getMaxAmountCategoryId() {
		return maxAmountCategoryId;
	}

	public void setMaxAmountCategoryId(Integer maxAmountCategoryId) {
		this.maxAmountCategoryId = maxAmountCategoryId;
	}

	public Integer getMinAmountCategoryId() {
		return minAmountCategoryId;
	}

	public void setMinAmountCategoryId(Integer minAmountCategoryId) {
		this.minAmountCategoryId = minAmountCategoryId;
	}

	@Override
	public String toString() {
		return "Stat{" +
				"oftenCategoryId=" + oftenCategoryId +
				", rareCategoryId=" + rareCategoryId +
				", maxAmountCategoryId=" + maxAmountCategoryId +
				", minAmountCategoryId=" + minAmountCategoryId +
				'}';
	}
}
