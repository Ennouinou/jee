package org.mql.jee.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.jee.web.actions.CompanyAction;

import com.mysql.fabric.xmlrpc.base.Param;

@WebServlet({"/Controller","/MQL/*"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyAction companyAction;
	private String prefix = "/views/";
	private String suffix = ".jsp";
	public void init() throws ServletException {
		companyAction = new CompanyAction();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String view= "Error";
		System.out.println(uri);
		ParametersResolver paramResolver = new ParametersResolver(request);
		// -- Company 
		if(uri.endsWith("Companies")) {
			view = companyAction.listCompanies();
			request.setAttribute("companies",companyAction.getCompanies());
		}
		else if(uri.endsWith("addCompany")) {
			view = companyAction.addCompany();
			request.setAttribute("cities",companyAction.getCities());
		}
		else if(uri.endsWith("saveCompany")) {
			companyAction.setCompany(paramResolver.getCompany(companyAction.getChoosedCity(paramResolver.getInt("idc")))); 
			view = companyAction.saveCompany();
			request.setAttribute("company",companyAction.getCompany());
			request.setAttribute("message","Entreprise bien ajoutée");
		}
		// -- City
		else if(uri.endsWith("Cities")) {
			view = companyAction.listCities();
			request.setAttribute("cities",companyAction.getCities());
		}
		else if(uri.endsWith("addCity")) {
			view = companyAction.addCity();
		}
		else if(uri.endsWith("saveCity")) {
			companyAction.setCity(paramResolver.getCity());
			view = companyAction.saveCity();
			request.setAttribute("city", companyAction.getCity());
			request.setAttribute("message", "Ville bien ajoutée");
		}
		getServletContext().getRequestDispatcher(prefix+view+suffix).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
