package org.cgiar.ciat.model;

import java.io.Serializable;

/**
 * @author vulcano
 *
 */
public class Country implements Serializable {

	/**
	 * Generated serial version
	 */
	private static final long serialVersionUID = -399009882282225815L;
	
	/**
	 * Country code
	 */
	private String code = null;
	
	/**
	 * Country name
	 */
	private String name = null;

	/**
	 * Get method for code 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set method for code
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
}
