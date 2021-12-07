package animal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import animal.domain.adopterView;

//import java.util.ArrayList;
//import java.util.List;

import animal.domain.animal;
import animal.domain.animalView;
import animal.domain.healthyAnimal;
import user.domain.User;

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
		    preparestatement.setString(4,String.valueOf(form.getAge()));
		    preparestatement.setString(5,form.getPhysical_description());
		    preparestatement.setString(6,form.getMicrochip_id());
		    preparestatement.setString(7,form.getAdoption_history());
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
	public void update(animal form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "UPDATE animal SET name = ?, species = ?, age = ?, physical_description = ?, microchip_id = ?, adoption_history = ? where id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,form.getPassword());
//			preparestatement.setString(2,form.getEmail());
//		    preparestatement.setString(3,form.getUsername());
		    
		    preparestatement.setString(1,form.getName());
		    preparestatement.setString(2,form.getSpecies());
		    preparestatement.setString(3,String.valueOf(form.getAge()));
		    preparestatement.setString(4,form.getPhysical_description());
		    preparestatement.setString(5,form.getMicrochip_id());
		    preparestatement.setString(6,form.getAdoption_history());
		    preparestatement.setString(7,form.getId());
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
	public void delete(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			
			String sql = "delete from animal where id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findAnimals() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			String sql = "select * from animalView";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				animalView user = new animalView();
				user.setName(resultSet.getString("name"));
//	    		user.setPassword(resultSet.getString("password"));
//	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public Object findHealthyAnimals() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			String sql = "select * from healthyAnimal";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				healthyAnimal user = new healthyAnimal();
				user.setAnimal_id(resultSet.getString("animal_id"));
//	    		user.setPassword(resultSet.getString("password"));
//	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public Object findAdopters() throws ClassNotFoundException, IllegalAccessException, ClassNotFoundException{
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animal_shelter", MySQL_user, MySQL_password);
			String sql = "select * from adoptorView";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				adopterView user = new adopterView();
				user.setAnimal_name(resultSet.getString("animal_name"));
	    		user.setFirst_name(resultSet.getString("first_name"));
	    		user.setLast_name(resultSet.getString("last_name"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
