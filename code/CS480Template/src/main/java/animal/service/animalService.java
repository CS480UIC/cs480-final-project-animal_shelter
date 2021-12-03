package animal.service;


import java.util.List;

import animal.dao.animalDao;
import animal.domain.animal;

/**
 * logic functions such as register, login
 * @author ameesha
 *
 */
public class animalService {
	private animalDao entity1Dao = new animalDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(animal form) throws animalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		animal entity1 = entity1Dao.findById(form.getId());
		if(entity1.getId()!=null && entity1.getId().equals(form.getId())) throw new animalException("This animal has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws InitException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(animal form) throws animalException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		animal user = entity1Dao.findById(form.getId());
		if(user.getId()==null) throw new animalException("The user is not in the database");
		
		String password = user.getId();
		
		if(password!=null && !password.equals(form.getId()))
			throw new animalException(" The password is not right");
		
	}
	
	public List<Object> findAnimals() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entity1Dao.findAnimals();
		
	}
	public Object findHealthyAnimals() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return entity1Dao.findHealthyAnimals();
	}
	public Object findAdopters() {
		// TODO Auto-generated method stub
		return null;
	}
}
