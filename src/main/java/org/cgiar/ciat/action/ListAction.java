package org.cgiar.ciat.action;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.cgiar.ciat.model.Institution;
import org.cgiar.ciat.util.FileUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vulcano
 *
 */
@Action(value = "list", //
results = { //
        @Result(name = "showList", location = "/partners.jsp"), //
} //
)
public class ListAction extends ActionSupport {

	/**
	 * Generated serial version
	 */
	private static final long serialVersionUID = 6637686349952317587L;
	
	private ArrayList<Institution> institutions = null;
	
	@Override
	public String execute() throws JsonGenerationException, JsonMappingException, IOException {
		
		// Get the institutions data
		ArrayList<Institution> institutions = FileUtil.getInstance().readInstitutions();
		this.setInstitutions(institutions);
		
		return "showList";
	}
	
	/**
	 * Get method for institutions 
	 * @return the institutions
	 */
	public ArrayList<Institution> getInstitutions() {
		return institutions;
	}
	
	/**
	 * Set method for institutions
	 * @param institutions the institutions to set
	 */
	public void setInstitutions(ArrayList<Institution> institutions) {
		this.institutions = institutions;
	}
}
