package com.product.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.product.scanner.ProductConfig;
import com.product.scanner.ProductScannerProcessor;
import com.product.scanner.ProductScannerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductConfig.class)
public class ProductScannerTest {

	private ProductScannerUtil productScannerUtil;

	private ProductScannerProcessor productScannerProcessor;

	ArrayList<String> alInput = null;
	ApplicationContext context  = null;

	@Before
	public void setUp() throws Exception {

		//String[] stProduct = {  };
		String[] stProduct = { "Milk", "Bread", "Oil", "toy", "hat", "ipod", "IPHOne" };
		alInput = new ArrayList<String>(Arrays.asList(stProduct));
		context = new ClassPathXmlApplicationContext("beans.xml");

		productScannerProcessor = (ProductScannerProcessor) context.getBean("ProductScannerProcessor");
		productScannerUtil = (ProductScannerUtil) context.getBean("ProductScannerUtil");
	}

	@After
	public void tearDown() throws Exception {
		if (alInput != null)
			alInput.clear();
		
		if(context != null)
			context = null;
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		//assert if ProductScannerUtil and ProductScannerProcessor not null
		assertNotNull(productScannerUtil);
		assertNotNull(productScannerProcessor);
		
		System.out.println(ProductScannerUtil.getHmproduct());
		HashMap<String,Object> hmOutput = productScannerProcessor.scanProductAndGetBill(alInput);
		System.out.println(hmOutput);
		
		//assert if its success case
		String stAppStatusMessage = (String) hmOutput.get("appStatusMessage");
		assertEquals("SUCCESS", stAppStatusMessage);
	}

}
