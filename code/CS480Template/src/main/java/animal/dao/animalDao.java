package animal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import animal.domain.animal;

/**
 * DDL functions performed in database
 */
public class animalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ameesha"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "animalshelter480"; //TODO change password

	public animal findById(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		animal entity1 = new animal();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
		    String sql = "select * from animal where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String animal_id = resultSet.getString("id");
		    	if(animal_id.equals(id)){
		    		entity1.setId(resultSet.getString("id"));
		    		entity1.setName(resultSet.getString("name"));
		    		entity1.setSpecies(resultSet.getString("species"));	
		    		entity1.setAge(Integer.parseInt(resultSet.getString("age")));
		    		entity1.setPhysical_description(resultSet.getString("physical_description"));
		    		entity1.setMicrochip_id(resultSet.getString("microchip_id"));
		    		entity1.setAdoption_history(resultSet.getString("adoption_history"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(animal form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "insert into animal values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getId());
		    preparestatement.setString(2,form.getName());
		    preparestatement.setString(3,form.getSpecies());
		    preparestatement.setInt(4,form.getAge());
		    preparestatement.setString(5,form.getPhysical_description());
		    preparestatement.setString(6,form.getMicrochip_id());
		    preparestatement.setString(7,form.getAdoption_history());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
//	/**
//	 * @param form
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	public void update(animal form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
//			
//			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,form.getPassword());
//			preparestatement.setString(2,form.getEmail());
//		    preparestatement.setString(3,form.getUsername());
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	
//	/**
//	 * @param username
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
//			
//			String sql = "delete from entity1 where username = ?";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,username);
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}