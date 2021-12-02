package init.service;

import java.util.List;

import init.dao.InitDao;
import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class InitService {
	private InitDao initDao = new InitDao();
	
	/**
	 * Register a user
	 */
	public void initializeDB() throws InitException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		initDao.initialize();
	}
	
	
//	/**
//	 * Login function
//	 */
//	public void login(User form) throws InitException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		User user = userDao.findByUsername(form.getUsername());
//		if(user.getUsername()==null) throw new InitException("The user is not in the database");
//		
//		String password = user.getPassword();
//		
//		if(password!=null && !password.equals(form.getPassword()))
//			throw new InitException(" The password is not right");
//		
//	}
//	
//	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//		return userDao.findall();
//		
//	}
}
