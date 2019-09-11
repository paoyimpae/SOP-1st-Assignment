/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import java.util.ArrayList;
import org.json.JSONObject;

class TwoShot implements ProductType {
	/* Product type is BNK48 2-Shot Card */
	private static String[] chooseAll = new String[] {
		"Cherprang BNK48", "Music BNK48", "Jennis BNK48", "Pun BNK48",
		"Mobile BNK48", "Orn BNK48", "Kaew BNK48", "Jane BNK48",
		"Mewnich BNK48", "Wee BNK48", "Fond BNK48", "Natherine BNK48",
		"New BNK48", "Panda BNK48", "View BNK48", "Jaa BNK48",
		"Faii BNK48", "Pakwan BNK48", "Fifa BNK48", "Tarwaan BNK48",
		"Namneung BNK48", "Other Members"
	}; //List of BNK48 Member Names
	private ArrayList menuList = new ArrayList();
	
	TwoShot() {
		/* Create each JSON Objects and put them in list (BNK48 2-Shot Card) */
		for(int i=0; i<chooseAll.length; i++) {
			JSONObject list = new JSONObject();
			if(i == 0) {
				list.put("productType", "TwoShot");
				menuList.add(list);
				list = new JSONObject();
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 200*(22-i+1));
			}
			else {
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 200*(22-i+1));
			}
			menuList.add(list);
		}
	}

	public String getList() {
		/* Getter for getting BNK48 2-Shot Card List */
		return menuList.toString();
	}

	public String getListSelect(int order) {
		/* Getter for getting BNK48 2-Shot Card List which you select */
		return menuList.get(order).toString();
	}
}
