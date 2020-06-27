package com.puvn.servicethree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 23.08.2019.
 */
@Entity
@Table(name = "branches")
public class Branch {

	@Id
	@NotNull
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "lon")
	private Double lon;

	@Column(name = "lat")
	private Double lat;

	@Column(name = "address")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Branch)) return false;
		Branch branch = (Branch) o;
		return getId().equals(branch.getId()) &&
				Objects.equals(getTitle(), branch.getTitle()) &&
				Objects.equals(getLon(), branch.getLon()) &&
				Objects.equals(getLat(), branch.getLat()) &&
				Objects.equals(getAddress(), branch.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTitle(), getLon(), getLat(), getAddress());
	}
}
