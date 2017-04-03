package org.cgiar.ciat.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.cgiar.ciat.model.Country;
import org.cgiar.ciat.model.Institution;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author vulcano
 *
 */
public class FileUtil {

	/**
	 * Location of the partners file
	 */
	private static final String PARTNERS_FILE_LOCATION = System.getProperty("user.home") + "\\";

	/**
	 * File name where partners info is going to be saved
	 */
	private static final String PARTNERS_FILE_NAME = "partners.txt";

	/**
	 * File name where countries are located
	 */
	private static final String COUNTRIES_FILE_NAME = "countries.txt";

	/**
	 * Location of the countries file
	 */
	private static final String COUNTRIES_FILE_LOCATION = "file/";

	/**
	 * Field for singleton pattern
	 */
	private static FileUtil instance = null;

	/**
	 * Private constructor to force the use of singleton pattern
	 */
	private FileUtil() {

	}

	/**
	 * Return just one instance of this class using the singleton pattern
	 * 
	 * @return Current instance of this class
	 */
	public static FileUtil getInstance() {
		if (instance == null)
			instance = new FileUtil();
		return instance;
	}

	/**
	 * Write in a text file the institution as a json form
	 * 
	 * @param institution
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public void saveInstitution(Institution institution)
			throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		File file = new File(PARTNERS_FILE_LOCATION + PARTNERS_FILE_NAME);

		// Verify is the file already exists
		if (file.exists()) {

			// If the file already exits, reads the content and adds the current
			// institution
			ArrayList<Institution> institutions = this.readInstitutions();
			institutions.add(institution);

			try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, false))) {

				// 1. Convert List of Person objects to JSON
				String institutionsString = mapper.writeValueAsString(institutions);
				bf.write(institutionsString);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			// Convert object to JSON string and save into a file directly
			mapper.writeValue(file, institution);
		}
	}

	/**
	 * Read from the file the institutions
	 * 
	 * @return {@link ArrayList} with institutions
	 * @throws IOException
	 */
	public ArrayList<Institution> readInstitutions() throws IOException {

		// List of institutions to retrieve
		ArrayList<Institution> institutions = new ArrayList<>();

		// Object mapper to map the institutions to objects
		ObjectMapper mapper = new ObjectMapper();

		// File with institutions info
		File file = new File(PARTNERS_FILE_LOCATION + PARTNERS_FILE_NAME);

		if (!file.exists()) {

			// If the file does not exist, create it
			new OutputStreamWriter(new FileOutputStream(PARTNERS_FILE_LOCATION + PARTNERS_FILE_NAME),
					Charset.forName("UTF-8"));

		} else {

			// GEt string equivalent from the file
			String institutionsString = this.getStringFromFile(file);

			// Maps institutions only if there are info in the file
			if (institutionsString.length() > 0) {
				institutions = mapper.readValue(institutionsString,
						mapper.getTypeFactory().constructCollectionType(ArrayList.class, Institution.class));
			}
		}

		return institutions;

	}

	/**
	 * Gets the equivalent string from file
	 * 
	 * @param file
	 * @return String
	 */
	private String getStringFromFile(File file) {

		StringBuilder stringBuilder = new StringBuilder();
		String sCurrentLine = null;

		// Read institutions from the file
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((sCurrentLine = br.readLine()) != null) {
				stringBuilder.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Read countries from file in resources folder
	 * 
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public ArrayList<Country> readCountries() throws JsonParseException, JsonMappingException, IOException {

		// List f countries
		ArrayList<Country> countries = new ArrayList<>();

		// Object mapper to map the institutions to objects
		ObjectMapper mapper = new ObjectMapper();

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(COUNTRIES_FILE_LOCATION + COUNTRIES_FILE_NAME).getFile());
		String countriesString = this.getStringFromFile(file);

		// Maps countries only if there are info in the file
		if (countriesString.length() > 0) {
			countries = mapper.readValue(countriesString,
					mapper.getTypeFactory().constructCollectionType(ArrayList.class, Country.class));
		}

		return countries;
	}
}
