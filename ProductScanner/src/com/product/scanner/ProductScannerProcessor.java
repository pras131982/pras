package com.product.scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ProductScannerProcessor {

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> scanProductAndGetBill(ArrayList<String> alInut) {
		HashMap<String, Object> hmResult = new HashMap<String, Object>();

		try {
			HashMap<String, Object> hmProductFromMemory = ProductScannerUtil.getHmproduct();
			HashMap<String, Object> hmSalesTaxFromMemory = ProductScannerUtil.getHmsaletax();
			StringBuffer sbUnknownItem = new StringBuffer();
			int iUnknownItem = 0;


			// If input list is null then return Data error.
			if (alInut == null || alInut.isEmpty()) {
				hmResult.put("appStatusCode", "100");
				hmResult.put("appStatusMessage", "Data Error");
				return hmResult;
			}
			for (String stInputProduct : alInut) {
				if (stInputProduct != null)
					stInputProduct = stInputProduct.toLowerCase();
				boolean bItemFound = false;
				Iterator<Entry<String, Object>> it = hmProductFromMemory.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Object> es = it.next();
					String stProductCategory = (String) es.getKey();
					HashMap<String, Object> hmProduct = (HashMap<String, Object>) es.getValue();
					if (hmProduct != null && hmProduct.containsKey(stInputProduct)) {
						double dPrice = Double.parseDouble((String) hmProduct.get(stInputProduct));
						String stSalesTax = (String) hmSalesTaxFromMemory.get(stProductCategory);
						double dPriceWithST = dPrice + ((dPrice * Double.parseDouble(stSalesTax)) / 100);
						hmResult.put(stInputProduct, dPriceWithST);
						bItemFound = true;
					}
				}
				if (!bItemFound) {
					String stUnknownItem = stInputProduct;
					if(iUnknownItem > 0){
						stUnknownItem = "|"+stUnknownItem;
					}
					hmResult.put("Unknown Input Item", sbUnknownItem.append(stUnknownItem));
					iUnknownItem++;
				}

			}

			Iterator<Object> itTotal = hmResult.values().iterator();
			double dTotal = 0.0;
			while (itTotal.hasNext()) {
				Object obj = itTotal.next();
				if (obj instanceof Double)
					dTotal = dTotal + (Double) obj;
			}

			hmResult.put("Total with Sale Tax", dTotal);
			hmResult.put("appStatusCode", "0");
			hmResult.put("appStatusMessage", "SUCCESS");

		} catch (Exception ex) {
			// If exception occured then return System error.
			hmResult = new HashMap<String, Object>();
			hmResult.put("appStatusCode", "600");
			hmResult.put("appStatusMessage", "System Error");
			ex.printStackTrace();
		} finally {
			if (hmResult == null || hmResult.isEmpty()) {
				hmResult = new HashMap<String, Object>();
				hmResult.put("appStatusCode", "600");
				hmResult.put("appStatusMessage", "System Error");
			}
		}

		return hmResult;
	}

}
