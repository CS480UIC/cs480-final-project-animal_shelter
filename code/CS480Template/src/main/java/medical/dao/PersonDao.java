package medical.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import medical.domain.Person;

/**
 * DDL functions performed in database
 */
public class PersonDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ameesha"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "animalshelter480"; //TODO change password

	public Person findByAnimalId(String animalId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Person medical = new Person();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
		    String sql = "select * from medical where animal_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,animalId);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String animal_id = resultSet.getString("animal_id");
		    	if(animal_id.equals(animalId)){
		    		medical.setAnimal_id(resultSet.getString("animal_id"));
		    		medical.setClinic_id(resultSet.getString("clinic_id"));
		    		medical.setVet_id(resultSet.getString("vet_id"));
		    		medical.setDate_of_visit(java.sql.Date.valueOf(resultSet.getString("date_of_visit")));
		    		medical.setDiagnosis(resultSet.getString("diagnosis"));
		    		medical.setPrescription(resultSet.getString("prescription"));
		    		medical.setTotal_due(Integer.parseInt(resultSet.getString("total_due")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return medical;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Person form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "insert into medical values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getAnimal_id());
		    preparestatement.setString(2,form.getClinic_id());
		    preparestatement.setString(3,form.getVet_id());
		    preparestatement.setString(4,String.valueOf(form.getDate_of_visit()));
		    preparestatement.setString(5,form.getDiagnosis());
		    preparestatement.setString(6,form.getPrescription());
		    preparestatement.setString(7,String.valueOf(form.getTotal_due()));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Person form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "UPDATE medical SET clinic_id = ?, vet_id = ?, date_of_visit = ?, diagnosis = ?, prescription = ?, total_due = ? where animal_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,form.getPassword());
//			preparestatement.setString(2,form.getEmail());
//		    preparestatement.setString(3,form.getUsername());
		    
		    preparestatement.setString(7,form.getAnimal_id());
		    preparestatement.setString(1,form.getClinic_id());
		    preparestatement.setString(2,form.getVet_id());
		    preparestatement.setString(3,String.valueOf(form.getDate_of_visit()));
		    preparestatement.setString(4,form.getDiagnosis());
		    preparestatement.setString(5,form.getPrescription());
		    preparestatement.setString(6,String.valueOf(form.getTotal_due()));
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String animal_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "delete from medical where animal_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,animal_id);
		    System.out.println(preparestatement);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
