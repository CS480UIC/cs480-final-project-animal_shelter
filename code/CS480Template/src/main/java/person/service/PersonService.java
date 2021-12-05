package person.service;


import person.dao.PersonDao;
import person.domain.Person;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PersonService {
	private PersonDao personDao = new PersonDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Person form) throws PersonException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
//		Medical medical = medicalDao.findByAnimalId(form.getAnimal_id());
//		if(medical.getAnimal_id()!=null && medical.getAnimal_id().equals(form.getAnimal_id())) throw new MedicalException("This medical record has been registered!");
		personDao.add(form);
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
//	public void login(Medical form) throws MedicalException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Medical user = entity1Dao.findByUsername(form.getUsername());
//		if(user.getUsername()==null) throw new MedicalException("The user is not in the database");
//		
//		String password = user.getPassword();
//		
//		if(password!=null && !password.equals(form.getPassword()))
//			throw new MedicalException(" The password is not right");
//		
//	}
}
