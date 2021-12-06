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

import person.dao.PersonDao;
import person.domain.Person;

/**
 * Servlet implementation class UserServlet
 */

public class PersonServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonServletUpdate() {
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

		String method = request.getParameter("method");
		PersonDao persondao = new PersonDao();
		Person person = null;

		if(method.equals("search"))
		{
			try {
				person = persondao.findById(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(person.getId()!=null){
				request.setAttribute("person", person);
				request.getRequestDispatcher("/jsps/person/person_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "person not found");
				request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Person form = new Person();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setId(info.get(1));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));	
			form.setDob(java.sql.Date.valueOf(info.get(4)));
			form.setEmail(info.get(5));
			form.setPhone(info.get(6));
			form.setStreet_address(info.get(7));
			form.setZip_code(info.get(8));
			form.setHousing_status(info.get(9));
			form.setKids(Integer.parseInt(info.get(10)));
			form.setAdoption_history(info.get(11));
			try {
				persondao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "person Updated");
			request.getRequestDispatcher("/jsps/person/person_read_output.jsp").forward(request, response);
		}
	}
}



