package person.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import person.domain.Person;

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

	public Person findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Person person = new Person();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
		    String sql = "select * from person where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String pid = resultSet.getString("id");
		    	if(id.equals(pid)){
		    		person.setId(resultSet.getString("id"));
		    		person.setFirst_name(resultSet.getString("first_name"));
		    		person.setLast_name(resultSet.getString("last_name"));
		    		person.setDob(java.sql.Date.valueOf(resultSet.getString("dob")));
		    		person.setEmail(resultSet.getString("email"));
		    		person.setPhone(resultSet.getString("phone"));
		    		person.setStreet_address(resultSet.getString("street_address"));
		    		person.setZip_code(resultSet.getString("zip_code"));
		    		person.setHousing_status(resultSet.getString("housing_status"));
		    		person.setKids(Integer.parseInt(resultSet.getString("kids")));
		    		person.setAdoption_history(resultSet.getString("adoption_history"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return person;
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
			
			String sql = "insert into person values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getId());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,String.valueOf(form.getDob()));
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getPhone());
		    preparestatement.setString(7,form.getStreet_address());
		    preparestatement.setString(8,form.getZip_code());
		    preparestatement.setString(9,form.getHousing_status());
		    preparestatement.setString(10,String.valueOf(form.getKids()));
		    preparestatement.setString(11,form.getAdoption_history());
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
			
			String sql = "UPDATE person SET clinic_id = ?, vet_id = ?, date_of_visit = ?, diagnosis = ?, prescription = ?, total_due = ? where animal_id = ?;";
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
	
//	
//	/**
//	 * @param username
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	public void delete(String animal_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
//			
//			String sql = "delete from medical where animal_id = ?";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,animal_id);
//		    System.out.println(preparestatement);
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
