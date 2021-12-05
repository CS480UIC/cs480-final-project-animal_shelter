package person.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.domain.Person;
import person.service.PersonException;
import person.service.PersonService;


/**
 * Servlet implementation class UserServlet
 */

public class PersonServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServletCreate() {
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
		PersonService personservice = new PersonService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Person form = new Person();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setId(info.get(0));
		form.setFirst_name(info.get(1));
		form.setLast_name(info.get(2));	
		form.setDob(java.sql.Date.valueOf(info.get(3)));
		form.setEmail(info.get(4));
		form.setPhone(info.get(5));
		form.setStreet_address(info.get(6));
		form.setZip_code(info.get(7));
		form.setHousing_status(info.get(8));
		form.setKids(Integer.parseInt(info.get(9)));
		form.setAdoption_history(info.get(10));
		
		try {
			personservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | PersonException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
