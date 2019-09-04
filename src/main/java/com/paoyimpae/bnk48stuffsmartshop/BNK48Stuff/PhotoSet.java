/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import java.util.ArrayList;
import org.json.JSONObject;

class PhotoSet implements DataManage {
	/* Product type is BNK48 Photo Set */
	private static String[] chooseAll = new String[] {
		"BNK48 The Debut Photoset",
		"BNK48 Thai Costume Photoset",
		"BNK48 Road Show Photoset",
		"BNK48 Aitakatta Single Costume Photoset",
		"BNK48 Halloween Photoset",
		"BNK48 Loi krathong Photoset",
		"BNK48 Merry Christmas 2017",
		"BNK48 Koisuru Fortune Cookie Senbatsu Photoset",
		"BNK48 Memorial of Handshake Photoset",
		"BNK48 x Changsuek",
		"Other Set"
	}; //List of BNK48 Photo Set Names
	private ArrayList menuList = new ArrayList(); //List of JSON Objects
	
	PhotoSet() {
		/* Create each JSON Objects and put them in list (BNK48 Photo Set) */
		for(int i=0; i<chooseAll.length; i++) {
			JSONObject list = new JSONObject();
			if(i == 0) {
				list.put("productType", "PhotoSet");
				menuList.add(list);
				list = new JSONObject();
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 500*(10-i+1));
			}
			else {
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 500*(10-i+1));
			}
			menuList.add(list);
		}
	}

	public String getList() {
		/* Getter for getting BNK48 Photo Set List */
		return menuList.toString();
	}

	public String getListSelect(int order) {
		/* Getter for getting BNK48 Photo Set List which you select */
		return menuList.get(order).toString();
	}
}
