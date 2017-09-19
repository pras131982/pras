/*
 * Created on Dec 14, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sample.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rb0012152
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Dispatcher 
{
	public void forward (String action,HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		
		req.getRequestDispatcher(action+".jsp").forward(req,res);
	}
}



