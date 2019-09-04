/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;

interface DataManage {
	/* Interface for each Product Type */
	public String getList();
	public String getListSelect(int order);
}

public class AllMenu {
	/* Main System Class */
	private static String[] chooseAll = new String[] {
			"PhotoSet", "SingleCD", "TwoShot"
	}; //List of Product Type Names
	private ArrayList menuList = new ArrayList(); //List of JSON Objects
	
	private int allPrice = 0; //Total Prices
	private PhotoSet ps = new PhotoSet(); //Create BNK48 Photo Set Object
	private SingleCD sc = new SingleCD(); //Create BNK48 Single CD Object
	private TwoShot ts = new TwoShot(); //Create BNK48 2-Shot Card Object
	private ArrayList choose = new ArrayList(); //List of cart
	
	AllMenu() {
		/* Create each JSON Objects and put them in list (Product Type) */
		for(int i=0; i<chooseAll.length; i++) {
			JSONObject list = new JSONObject();
			list.put("type", i+1);
			list.put("name", chooseAll[i]);
			menuList.add(list);
		}
	}
	
	public String getMenuType() {
		/* Getter for getting Product Type List */
		return menuList.toString();
	}
	
	public String getMenuTypeSelect(int value) {
		/* Getter for getting Product Type which you select */
		return menuList.get(value-1).toString();
	}

	public String getMenuTypeSelectSpecific(int value) {
		/* Getter for getting goods in Product Type which you select */
		String showList = "";
		if(value == 1) { showList = ps.getList(); }
		if(value == 2) { showList = sc.getList(); }
		if(value == 3) { showList = ts.getList(); }
		return showList;
	}

	public String getMenuTypeSelectOnlyOne(int type, int order) {
		/* Getter for specific getting goods in Product Type which you select */
		String showList = "";
		if(type == 1) { showList = ps.getListSelect(order); }
		if(type == 2) { showList = sc.getListSelect(order); }
		if(type == 3) { showList = ts.getListSelect(order); }
		return showList;
	}

	public void setInCart(int type, int order) {
		/* Setter for choose goods in cart */
		if(type == 1) {
			for(int i=0; i<ps.getList().length(); i++) {
				if(order-1 == i) {
					choose.add(ps.getListSelect(order));
				}
			}
		}
		if(type == 2) {
			for(int i=0; i<sc.getList().length(); i++) {
				if(order-1 == i) {
					choose.add(sc.getListSelect(order));
				}
			}
		}
		if(type == 3) {
			for(int i=0; i<ts.getList().length(); i++) {
				if(order-1 == i) {
					choose.add(ts.getListSelect(order));
				}
			}
		}
	}
	public String getName(int type, int order) {
		/* Getter for getting name of goods (Show in '...\Get' page) */
		if(type == 1) {
			for(int i=0; i<ps.getList().length(); i++) {
				if(order-1 == i) {
					return ps.getListSelect(order).substring(
							ps.getListSelect(order).indexOf("name")+7,
							ps.getListSelect(order).indexOf("\",\"", 
									ps.getListSelect(order).indexOf("name")+7)
					);
				}
			}
		}
		if(type == 2) {
			for(int i=0; i<sc.getList().length(); i++) {
				if(order-1 == i) {
					return sc.getListSelect(order).substring(
							sc.getListSelect(order).indexOf("name")+7,
							sc.getListSelect(order).indexOf("\",\"", 
									sc.getListSelect(order).indexOf("name")+7)
					);
				}
			}
		}
		if(type == 3) {
			for(int i=0; i<ts.getList().length(); i++) {
				if(order-1 == i) {
					return ts.getListSelect(order).substring(
						ts.getListSelect(order).indexOf("name")+7,
						ts.getListSelect(order).indexOf("\",\"", 
								ts.getListSelect(order).indexOf("name")+7)
					);
				}
			}
		}
		return "(Unknown Name)";
	}

	public String getCart() {
		/* Getter for showing goods list in cart */
		if (choose.isEmpty()) return "🛒 You cart is empty ! 😢";
		else return choose.toString();
	}

	public int getValue() {
		/* Calculate for finding total price */
		for(int i=0; i<choose.size(); i++) {
			String element = (String) choose.get(i);
			allPrice += Integer.parseInt(
					element.substring(
							element.indexOf("price")+7,
							element.indexOf("name",
									element.lastIndexOf("price"))-2
						));
		}
		if (allPrice != 0) { 
			return allPrice;
		}
		return 0;
	}

	public void resetValue() {
		/* Setter for resetting value after payment was success */
		choose.clear();
		this.allPrice = 0;
	}
}
