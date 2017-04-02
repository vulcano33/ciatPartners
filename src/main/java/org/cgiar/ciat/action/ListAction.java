package org.cgiar.ciat.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

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
	
	@Override
	public String execute() {
		return "showList";
		
	}
	
}
