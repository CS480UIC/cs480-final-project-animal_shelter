package person.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Person {
	/*
	 * Correspond to the user table
	 */
	
	private String id;
	private String first_name;
	private String last_name;
	private Date dob;
	private String email;
	private String phone;
	private String street_address;
	private String zip_code;
	private String housing_status;
	private Integer kids;
	private String adoption_history;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the street_address
	 */
	public String getStreet_address() {
		return street_address;
	}
	/**
	 * @param street_address the street_address to set
	 */
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}
	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	/**
	 * @return the housing_status
	 */
	public String getHousing_status() {
		return housing_status;
	}
	/**
	 * @param housing_status the housing_status to set
	 */
	public void setHousing_status(String housing_status) {
		this.housing_status = housing_status;
	}
	/**
	 * @return the kids
	 */
	public Integer getKids() {
		return kids;
	}
	/**
	 * @param kids the kids to set
	 */
	public void setKids(Integer kids) {
		this.kids = kids;
	}
	/**
	 * @return the adoption_history
	 */
	public String getAdoption_history() {
		return adoption_history;
	}
	/**
	 * @param adoption_history the adoption_history to set
	 */
	public void setAdoption_history(String adoption_history) {
		this.adoption_history = adoption_history;
	}
	
}
