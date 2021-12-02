package animal.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import animal.dao.animalDao;
import animal.domain.animal;

/**
 * Servlet implementation class UserServlet
 */

public class animalServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public animalServletUpdate() {
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
		animalDao entity1dao = new animalDao();
		animal entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findById(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getId()!=null){
				request.setAttribute("animal", entity1);
				request.getRequestDispatcher("/jsps/animal/animal_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "animal not found");
				request.getRequestDispatcher("/jsps/animal/animal_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			animal form = new animal();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			form.setId(info.get(1));
			form.setName(info.get(2));
			form.setSpecies(info.get(3));	
			form.setAge(Integer.parseInt(info.get(4)));
			form.setPhysical_description(info.get(5));
			form.setMicrochip_id(info.get(6));
			form.setAdoption_history(info.get(7));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "animal Updated");
			request.getRequestDispatcher("/jsps/animal/animal_read_output.jsp").forward(request, response);
		}
	}
}



