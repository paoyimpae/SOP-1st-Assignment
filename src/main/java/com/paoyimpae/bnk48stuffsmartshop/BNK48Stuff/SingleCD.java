/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import java.util.ArrayList;
import org.json.JSONObject;

class SingleCD implements DataManage {
	/* Product type is BNK48 Single CD */
	private static String[] chooseAll = new String[] {
		"BNK48 Aitakatta Single",
		"BNK48 Koisuru Fortune Cookie",
		"BNK48 Shonichi",
		"BNK48 River (Special)",
		"BNK48 Kimi wa Melody",
		"BNK48 BNK Festival",
		"BNK48 Beginner",
		"BNK48 Jabaja x Reborn (Special)"
	}; //List of BNK48 Single CD Names
	private ArrayList menuList = new ArrayList();
	
	SingleCD() {
		/* Create each JSON Objects and put them in list (BNK48 Single CD) */
		for(int i=0; i<chooseAll.length; i++) {
			JSONObject list = new JSONObject();
			if(i == 0) {
				list.put("productType", "SingleCD");
				menuList.add(list);
				list = new JSONObject();
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 550*(8-i+1));
			}
			else {
				list.put("type", i+1);
				list.put("name", chooseAll[i]);
				list.put("price", 550*(8-i+1));
			}
			menuList.add(list);
		}
	}

	public String getList() {
		/* Getter for getting BNK48 Single CD List */
		return menuList.toString();
	}

	public String getListSelect(int order) {
		/* Getter for getting BNK48 Single CD List which you select */
		return menuList.get(order).toString();
	}
}
