package org.cgiar.ciat.model;

import java.io.Serializable;

/**
 * Model for an institution
 * 
 * @author vulcano
 *
 */
public class Institution implements Serializable {

	/**
	 * Generated serial version
	 */
	private static final long serialVersionUID = -7019787550951838172L;
	
	/**
	 * Default constructor
	 */
	public Institution() {
	}
	
	/**
	 * Constructor with fields
	 * 
	 * @param acronym
	 * @param name
	 * @param type
	 * @param country
	 * @param city
	 * @param headquarter
	 */
	public Institution(String acronym, String name, String type, String country, String city,
			String headquarter) {
		super();
		this.acronym = acronym;
		this.name = name;
		this.type = type;
		this.country = country;
		this.city = city;
		this.headquarter = headquarter;
	}

	/**
	 * Acronym for the institution
	 */
	private String acronym = null;
	
	/**
	 * Name for the institution
	 */
	private String name = null;
	
	/**
	 * Type of institution
	 */
	private String type = null;
	
	/**
	 * Contry of the institution
	 */
	private String country = null;
	
	/**
	 * City of the institution
	 */
	private String city = null;
	
	/**
	 * If the institution is a branch, this field points to the headquarter institition
	 */
	private String headquarter = null;

	/**
	 * Get method for acronym 
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Set method for acronym
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * Get method for name 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get method for type 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set method for type
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get method for country 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set method for country
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get method for city 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set method for city
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get method for headquarter 
	 * @return the headquarter
	 */
	public String getHeadquarter() {
		return headquarter;
	}

	/**
	 * Set method for headquarter
	 * @param headquarter the headquarter to set
	 */
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
}
