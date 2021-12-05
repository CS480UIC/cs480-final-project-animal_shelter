package medical.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Medical {
	/*
	 * Correspond to the user table
	 */
	
	private String animal_id;
	private String clinic_id; 
	private String vet_id;
	private Date date_of_visit;
	private String diagnosis;
	private String prescription;
	private Integer total_due;
	/**
	 * @return the animal_id
	 */
	public String getAnimal_id() {
		return animal_id;
	}
	/**
	 * @param animal_id the animal_id to set
	 */
	public void setAnimal_id(String animal_id) {
		this.animal_id = animal_id;
	}
	/**
	 * @return the clinic_id
	 */
	public String getClinic_id() {
		return clinic_id;
	}
	/**
	 * @param clinic_id the clinic_id to set
	 */
	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}
	/**
	 * @return the vet_id
	 */
	public String getVet_id() {
		return vet_id;
	}
	/**
	 * @param vet_id the vet_id to set
	 */
	public void setVet_id(String vet_id) {
		this.vet_id = vet_id;
	}
	/**
	 * @return the date_of_visit
	 */
	public Date getDate_of_visit() {
		return date_of_visit;
	}
	/**
	 * @param date_of_visit the date_of_visit to set
	 */
	public void setDate_of_visit(Date date_of_visit) {
		this.date_of_visit = date_of_visit;
	}
	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}
	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	/**
	 * @return the prescription
	 */
	public String getPrescription() {
		return prescription;
	}
	/**
	 * @param prescription the prescription to set
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	/**
	 * @return the total_due
	 */
	public Integer getTotal_due() {
		return total_due;
	}
	/**
	 * @param total_due the total_due to set
	 */
	public void setTotal_due(Integer total_due) {
		this.total_due = total_due;
	}

	
	
}
