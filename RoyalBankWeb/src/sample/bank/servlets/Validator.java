/*
 * Created on Dec 21, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sample.bank.servlets;

import javax.servlet.http.HttpServletRequest;


import sample.bank.bean.CustomerBean;
import sample.bank.data.Customers;

/**
 * @author rb0012152
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Validator {
	HttpServletRequest request;

	
	public Validator(HttpServletRequest request){
		this.request = request;
		
	}
	
	public boolean validate(){
		boolean allOk = false;
		CustomerBean customer = (CustomerBean)request.getSession().getAttribute("addCustomer");
		Customers customers = (Customers)request.getSession().getServletContext().getAttribute("customers");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String openingBalance = request.getParameter("openingBalance");
		
		customer.setUserId(userId);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setOpeningBalance(openingBalance);
		
		if(customer.validate())
		{
			
			if(customers.newUserId(userId)){
				allOk = true;
				System.out.println("new baal");
				customers.addCustomers(userId,customer);
			}
			else 
			{
				customer.setErrUserId("User Name Already Exists");
				//customer.setUserId("");
				allOk = false;
			}
			
		}
		return allOk ;
	}

}
