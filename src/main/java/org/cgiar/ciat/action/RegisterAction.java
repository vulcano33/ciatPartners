package org.cgiar.ciat.action;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.cgiar.ciat.model.Institution;
import org.cgiar.ciat.service.InstitutionService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vulcano
 *
 */
@Action(value = "register", //
		results = { //
				@Result(name = "success", location = "/index.jsp"), //
				@Result(name = "input", location = "/savePartner.jsp") } //
)
public class RegisterAction extends ActionSupport {

	/**
	 * Generated serial version
	 */
	private static final long serialVersionUID = 4980089964642610081L;

	/**
	 * Institution to be saved
	 */
	private Institution institution = null;
	
	/**
	 * Option for the radio button in savePartner view
	 */
	private static final String YES = "Yes";

	/**
	 * Option for the radio button in savePartner view
	 */
	private static final String NO = "No";
	
	/**
	 * List of options available
	 */
	private ArrayList<String> options = null;
	
	/**
	 * List of headquarter institutions available
	 */
	private ArrayList<String> institutionsList = null;
	
	/**
	 * List of institution types
	 */
	private ArrayList<String> institutionTypes = null;
	
	/**
	 * Option for the institution types control
	 */
	private static final String INSTITUTION_TYPE_1 = "Academic Institution";

	/**
	 * Option for the institution types control
	 */
	private static final String INSTITUTION_TYPE_2 = "Donor";

	/**
	 * Option for the institution types control
	 */
	private static final String INSTITUTION_TYPE_3 = "Non-Governmental Organisation";

	/**
	 * Option for the institution types control
	 */
	private static final String INSTITUTION_TYPE_4 = "Research Institution";
	
	/**
	 * List of countries
	 */
	private ArrayList<String> countries = null;

	/**
	 * Default constructor
	 * @throws IOException 
	 */
	public RegisterAction() throws IOException {
		
		// If all is correct, return showList, in other case return save
		// Add options for the radio control
		options = new ArrayList<>();
		options.add(YES);
		options.add(NO);
		
		// Add headquarter institutions list
		institutionsList = new ArrayList<>();
		ArrayList<Institution> institutions = InstitutionService.getInstance().readInstitutions();
		if (institutions.size() > 0) {
			for (Institution institution : institutions) {
				institutionsList.add(institution.getName());
			}
		}

		// Add institutions types
		institutionTypes = new ArrayList<>();
		institutionTypes.add(INSTITUTION_TYPE_1);
		institutionTypes.add(INSTITUTION_TYPE_2);
		institutionTypes.add(INSTITUTION_TYPE_3);
		institutionTypes.add(INSTITUTION_TYPE_4);

		// Add countries
		countries = new ArrayList<>();
		countries = InstitutionService.getInstance().readCountries();
	}

	@Override
	public String execute() throws JsonGenerationException, JsonMappingException, IOException {

		// Save institution
		InstitutionService.getInstance().saveInstitution(institution);
		
		addActionMessage("The request for a new institution has been succesfully created");
		
		return "success";
	}

	/**
	 * Get method for institution
	 * 
	 * @return the institution
	 */
	public Institution getInstitution() {
		return institution;
	}

	/**
	 * Set method for institution
	 * 
	 * @param institution
	 *            the institution to set
	 */
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	/**
	 * Get method for options 
	 * @return the options
	 */
	public ArrayList<String> getOptions() {
		return options;
	}
	
	/**
	 * Set method for options
	 * @param options the options to set
	 */
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	/**
	 * Get method for institutionsList 
	 * @return the institutionsList
	 */
	public ArrayList<String> getInstitutionsList() {
		return institutionsList;
	}
	
	/**
	 * Set method for institutionsList
	 * @param institutionsList the institutionsList to set
	 */
	public void setInstitutionsList(ArrayList<String> institutionsList) {
		this.institutionsList = institutionsList;
	}
	
	/**
	 * Get method for institutionTypes 
	 * @return the institutionTypes
	 */
	public ArrayList<String> getInstitutionTypes() {
		return institutionTypes;
	}
	
	/**
	 * Set method for institutionTypes
	 * @param institutionTypes the institutionTypes to set
	 */
	public void setInstitutionTypes(ArrayList<String> institutionTypes) {
		this.institutionTypes = institutionTypes;
	}
	
	/**
	 * Get method for countries 
	 * @return the countries
	 */
	public ArrayList<String> getCountries() {
		return countries;
	}
	
	/**
	 * Set method for countries
	 * @param countries the countries to set
	 */
	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}
	
	/* 
	 * Method for form validations
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	public void validate() {

		if (institution.getAcronym().length() > 10) {

			addFieldError("institution.acronym", "It must be less than 10 characters.");

		}
	}
}
