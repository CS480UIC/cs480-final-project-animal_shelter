package medical.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.domain.Person;
import medical.service.MedicalException;
import medical.service.MedicalService;


/**
 * Servlet implementation class UserServlet
 */

public class MedicalServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalServletCreate() {
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
		MedicalService medicalservice = new MedicalService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Person form = new Person();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setAnimal_id(info.get(0));
		form.setClinic_id(info.get(1));
		form.setVet_id(info.get(2));	
		form.setDate_of_visit(java.sql.Date.valueOf(info.get(3)));
		form.setDiagnosis(info.get(4));
		form.setPrescription(info.get(5));
		form.setTotal_due(Integer.parseInt(info.get(6)));
		
		try {
			medicalservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | MedicalException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
