/*
 * Created on Dec 13, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sample.bank.bean;





/**
 * @author rb0012152
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CustomerBean {
	private String userId ="";
	private String password = "";
	private String address ="";
	private String openingBalance="";
	private float accountBalance;
	
	private String errUserId ="";
	private String errPassword ="";
	private String errOpeningBalance ="";
	
	public boolean validate() {
		boolean allOk = true;
		
		
		if ( userId.equals("") ){
			allOk = false;
			setErrUserId("User Name Is Required");
			
		}
		else{
			setErrUserId("");
		}
		
		
		if ( password.equals("") ){
			allOk = false;
			setErrPassword("Password Is Required");	
		}
		else {
			setErrPassword("");
		}
		
		
		if ( openingBalance.equals("")){
			allOk = false;
			setErrOpeningBalance("Opening Balance Is Required");
			openingBalance="";
		}
		else {
			try {
				float time = Float.parseFloat(openingBalance);
				setAccountBalance(time);
				setErrOpeningBalance("");
			}
			catch(NumberFormatException nfe) {
				setErrOpeningBalance("Correct Opening Balance Required");
				allOk = false;
			}
			
		}
		
		
		
	
		return allOk;
	}
	

	/**
	 * @return Returns the accountBalance.
	 */

	/**
	 * @param accountBalance The accountBalance to set.
	 */
	
	/*
	public void setOpeningBalance(String openingBalance) {
		System.out.println("before");
		this.openingBalance = openingBalance;
	}
	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	
	/**
	 * @return Returns the accountBalance.
	 */
	public float getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance The accountBalance to set.
	 */
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	/**
	 * @return Returns the errOpeningBalance.
	 */
	public String getErrOpeningBalance() {
		return errOpeningBalance;
	}
	/**
	 * @param errOpeningBalance The errOpeningBalance to set.
	 */
	public void setErrOpeningBalance(String errOpeningBalance) {
		this.errOpeningBalance = errOpeningBalance;
	}
	/**
	 * @return Returns the errPassword.
	 */
	public String getErrPassword() {
		return errPassword;
	}
	/**
	 * @param errPassword The errPassword to set.
	 */
	public void setErrPassword(String errPassword) {
		this.errPassword = errPassword;
	}
	/**
	 * @return Returns the errUserId.
	 */
	public String getErrUserId() {
		return errUserId;
	}
	/**
	 * @param errUserId The errUserId to set.
	 */
	public void setErrUserId(String errUserId) {
		this.errUserId = errUserId;
	}
	/**
	 * @return Returns the openingBalance.
	 */
	public String getOpeningBalance() {
		return openingBalance;
	}
	

	/**
	 * @param openingBalance The openingBalance to set.
	 */
	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}
}
