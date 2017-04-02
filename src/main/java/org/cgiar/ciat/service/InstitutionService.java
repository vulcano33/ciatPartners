package org.cgiar.ciat.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.cgiar.ciat.model.Institution;
import org.cgiar.ciat.util.FileUtil;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author vulcano
 *
 */
public class InstitutionService {

	/**
	 * Field for singleton pattern
	 */
	private static InstitutionService instance = null;

	/**
	 * Private constructor to force the use of singleton pattern
	 */
	private InstitutionService() {

	}

	/**
	 * Return just one instance of this class using the singleton pattern
	 * 
	 * @return Current instance of this class
	 */
	public static InstitutionService getInstance() {
		if (instance == null)
			instance = new InstitutionService();
		return instance;
	}

	/**
	 * Retrieve all saved institutions
	 * 
	 * @return {@link ArrayList} of {@link Institution} saved in file
	 * @throws IOException
	 */
	public ArrayList<Institution> readInstitutions(InputStream is) throws IOException {
		return FileUtil.getInstance().readInstitutions();
	}
	
	/**
	 * Save the institution in file
	 * 
	 * @param institution {@link Institution} to be saved
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public void saveInstitution(Institution institution) throws JsonGenerationException, JsonMappingException, IOException {
		FileUtil.getInstance().saveInstitution(institution);
	}

}
