package person.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.dao.PersonDao;
import person.domain.Person;


/**
 * Servlet implementation class UserServlet
 */

public class PersonServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServletRead() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person = null;
		PersonDao personDao = new PersonDao();
		
		try {
			System.out.print(request.getParameter("id"));
			person = personDao.findById(request.getParameter("id"));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(person.getId()!=null){
					System.out.println(person);
					request.setAttribute("person", person);
					request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "person not found");
			request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
		}
	}
}



