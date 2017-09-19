/*
 * Created on Dec 24, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sample.bank.servlets;

import javax.servlet.http.HttpServletRequest;

import sample.bank.bean.CustomerBean;
import sample.bank.bean.Login;
import sample.bank.data.Customers;

/**
 * @author rb0012152
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidUser {

	private HttpServletRequest req;
	private String userId;
	private String password;
	public Login login;
	public Customers customers;
	
	public ValidUser(HttpServletRequest req){
		this.req = req;
	}
	
	public boolean validate(){
		boolean allOk = true;
		userId = req.getParameter("userId");
		password = req.getParameter("password");
		login = (Login) req.getSession().getAttribute("login");
		customers = (Customers) req.getSession().getServletContext().getAttribute("customers");
		
		if((userId.equals("")) || (password.equals(""))){
			login.setErrMsg("Missing username/password");
			allOk = false;
		}
		else {
			CustomerBean customer = customers.getCustomers(userId, password);
			
			if ( customer == null){
				login.setErrMsg("Invalid username/password");
				allOk = false;
			}
			else{
				req.getSession().setAttribute("loggedCustomer", customer);
				req.getSession().setAttribute("login",null);
			}
		}
		return allOk;
	}
}
