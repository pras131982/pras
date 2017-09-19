/*
 * Created on Dec 20, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sample.bank.data;

import java.util.HashMap;

import sample.bank.bean.CustomerBean;

/**
 * @author rb0012152
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test {
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		String rajiv = "rajiv";
		map.put("rajiv","rajiv");
		if( !map.containsKey("rajiv")){
			map.put(rajiv,"kukur");
			
		}
		System.out.println(map.get(rajiv));
		
	}

}
