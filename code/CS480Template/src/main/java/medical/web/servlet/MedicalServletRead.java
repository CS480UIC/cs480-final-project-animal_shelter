package medical.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.dao.PersonDao;
import medical.domain.Person;


/**
 * Servlet implementation class UserServlet
 */

public class MedicalServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalServletRead() {
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
		Person medical = null;
		PersonDao medicalDao = new PersonDao();
		
		try {
			System.out.print(request.getParameter("animal_id"));
			medical = medicalDao.findByAnimalId(request.getParameter("animal_id"));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(medical.getAnimal_id()!=null){
					System.out.println(medical);
					request.setAttribute("medical", medical);
					request.getRequestDispatcher("/jsps/medical/medical_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "medical not found");
			request.getRequestDispatcher("/jsps/medical/medical_read_output.jsp").forward(request, response);
		}
	}
}



