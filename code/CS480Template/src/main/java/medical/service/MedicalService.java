package medical.service;


import medical.dao.MedicalDao;
import medical.domain.Medical;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class MedicalService {
	private MedicalDao medicalDao = new MedicalDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Medical form) throws MedicalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
//		Medical medical = medicalDao.findByAnimalId(form.getAnimal_id());
//		if(medical.getAnimal_id()!=null && medical.getAnimal_id().equals(form.getAnimal_id())) throw new MedicalException("This medical record has been registered!");
		medicalDao.add(form);
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
