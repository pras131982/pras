package sample.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.bank.data.Customers;

/**
 * Servlet implementation class RoyalBank
 */
public class RoyalBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoyalBank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(arg0, arg1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String userId, password;
		String action = arg0.getParameter("action");
		Dispatcher dispatch = new Dispatcher();
	
		Customers customers = (Customers) getServletContext().getAttribute("customers");
	
		
		if (action.equals("signup"))
			action = "signup";
		
		if (action.equals("login")) {
			ValidUser validUser = new ValidUser(arg0);
			
			action = validUser.validate()?"mypage":"first";
			
		}
		
		if (action.equals("openAccount")) {
			Validator validator = new Validator(arg0);
			
			action = validator.validate()?"success":"signup";
		}
		
		
	
		
		
		dispatch.forward(action, arg0, arg1);
	}

}
