package com.equifax.automation.dataObject;

public class StateInfo {
	
	private String id;
	private String country;
	private String name;
	private String abbr;
	private String area;
	private String largest_city;
	private String capital;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLargest_city() {
		return largest_city;
	}
	public void setLargest_city(String largest_city) {
		this.largest_city = largest_city;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@Override
	public String toString() {
		return "StateInfo [id=" + id + ", country=" + country + ", name=" + name + ", abbr=" + abbr + ", area=" + area
				+ ", largest_city=" + largest_city + ", capital=" + capital + "]";
	}

	
}
