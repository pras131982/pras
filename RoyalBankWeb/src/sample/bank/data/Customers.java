package sample.bank.data;

import java.util.HashMap;

import sample.bank.bean.CustomerBean;








public class Customers {
	
	private HashMap customers = new HashMap();

	public void addCustomers(String userId, CustomerBean customer){
		try{
		customers.put(userId, customer);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean newUserId(String userId){
		if (customers.containsKey(userId)){
			System.out.println("contains yaar");
			return false;
			
		}
		else {
			System.out.println("doesnt contain");
			return true;
			}
		}
	
	public CustomerBean getCustomers(String userId, String password){
		CustomerBean customer;
		if ((customer = (CustomerBean)customers.get(userId))!= null ) {
			
			if ( customer.getPassword().equals(password))
				return customer;
		}
		return null;
	}
}