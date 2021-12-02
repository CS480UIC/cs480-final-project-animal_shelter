package animal.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import animal.dao.animalDao;
import animal.domain.animal;


/**
 * Servlet implementation class UserServlet
 */

public class animalServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public animalServletDelete() {
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
		animalDao entity1Dao = new animalDao();
		animal ani = null;
		if(method.equals("search"))
		{
			try {
				ani = entity1Dao.findById(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(ani.getId()!=null){
						System.out.println(ani);
						request.setAttribute("animal", ani);
						request.getRequestDispatcher("/jsps/animal/animal_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "animal not found");
				request.getRequestDispatcher("/jsps/animal/animal_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				entity1Dao.delete(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "animal Deleted");
			request.getRequestDispatcher("/jsps/animal/animal_read_output.jsp").forward(request, response);
		}
	}
}



