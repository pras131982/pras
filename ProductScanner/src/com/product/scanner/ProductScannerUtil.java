package com.product.scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import org.springframework.stereotype.Component;

@Component
public class ProductScannerUtil {

	private static final HashMap<String, Object> hmProduct = new HashMap<String, Object>();

	private static final HashMap<String, Object> hmSaleTax = new HashMap<String, Object>();
	
	static {
		init();
	}

	public static void init() {
		FileInputStream inputStream = null;
		ArrayList<String> alProductCategory = new ArrayList<String>();

		try {
			// Load the config file
			inputStream = new FileInputStream("src/com/product/resource/config.properties");
			Properties prop = new Properties();
			prop.load(inputStream);

			// Retrieve ProductCategory and related product and load in cache

			String stProductCategory = prop.getProperty("ProductCategory");
			alProductCategory = new ArrayList<String>(Arrays.asList(stProductCategory.split("\\|")));
			for (String stProdcuctCategory : alProductCategory) {
				if (stProdcuctCategory != null && !stProdcuctCategory.isEmpty()) {

					// Retrieve products for different categories and store in cache
					String stProducts = prop.getProperty(stProdcuctCategory);
					HashMap<String, Object> hmCategoryProduct = new HashMap<String, Object>();
					if (stProducts != null && !stProducts.isEmpty()) {
						StringTokenizer stokProducts = new StringTokenizer(stProducts, "|");
						while (stokProducts.hasMoreTokens()) {
							String stProduct = stokProducts.nextToken();
							if (stProduct != null && !stProduct.isEmpty()) {
								StringTokenizer stokProduct = new StringTokenizer(stProduct, ":");
								while (stokProduct.hasMoreTokens()) {
									hmCategoryProduct.put(stokProduct.nextToken().toLowerCase(), stokProduct.nextToken());
								}
							}

						}
					}
					hmProduct.put(stProdcuctCategory, hmCategoryProduct);
					
					
					// Retrieve Sales Tax for different Category and store in cache
					String stSaleTax = prop.getProperty("ST_" + stProdcuctCategory);
					if (stSaleTax != null && !stSaleTax.isEmpty()) {
						hmSaleTax.put(stProdcuctCategory, stSaleTax);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static HashMap<String, Object> getHmproduct() {
		return hmProduct;
	}

	public static HashMap<String, Object> getHmsaletax() {
		return hmSaleTax;
	}


}
