package animal.domain;

/**
 * animal object
 * 
 * @author Ameesha Saxena
 * 
 */
public class animal {
	/*
	 * Correspond to the user table
	 */
	
	private String id;
	private String name; 
	private String species;
	private Integer age;
	private String physical_description;
	private String microchip_id;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}




	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}




	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}




	/**
	 * @return the physical_description
	 */
	public String getPhysical_description() {
		return physical_description;
	}




	/**
	 * @param physical_description the physical_description to set
	 */
	public void setPhysical_description(String physical_description) {
		this.physical_description = physical_description;
	}




	/**
	 * @return the microchip_id
	 */
	public String getMicrochip_id() {
		return microchip_id;
	}




	/**
	 * @param microchip_id the microchip_id to set
	 */
	public void setMicrochip_id(String microchip_id) {
		this.microchip_id = microchip_id;
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
