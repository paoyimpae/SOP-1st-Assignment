/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madgag.gif.fmsware.*;
import java.awt.*;
import java.io.File;

import javax.swing.ImageIcon;

@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class SpringBootFunction {
	/* Create AllMenu object (as create customer) */
	AllMenu cust = new AllMenu();
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFunction.class, args);
	}
	
	/* Main page */
	@RequestMapping("/")
	String home() {
		/* [Teacher Commented] HTML is gone ! */
		cust.setCustomerName("Unknown Name");
		return "🙏 Welcome " + cust.getCustomerName() + " to BNK48 Stuff Smart Shop By Paoyimpae ✅";
	}
	
	/* Main page with Username */
	@RequestMapping("/{userName}")
	String home(@PathVariable String userName) {
		cust.setCustomerName(userName);
		return "🙏 Welcome " + cust.getCustomerName() + " to BNK48 Stuff Smart Shop By Paoyimpae ✅";
	}
	
	/* Show product type list (List of JSON) */
	@RequestMapping("/Buy")
	String buyMenu() {
		return(cust.getMenuType());
	}
	
	/* Choose product type (JSON) */
	@RequestMapping(value = "/Buy/{value}")
	String buyMenuChoosing(@PathVariable int value) {
		return(cust.getMenuTypeSelect(value));
	}
	
	/* Show goods in product type that is choosed at first */
	@RequestMapping(value = "/Buy/{value}/Choose")
	String chooseAlter(@PathVariable int value) {
		return(cust.getMenuTypeSelectSpecific(value));
	}
	
	/* Choose goods in product type that is choosed at first */
	@RequestMapping(value = "/Buy/{type}/Choose/{order}")
	String chooseAlter(@PathVariable int type,@PathVariable int order) {
		return(cust.getMenuTypeSelectOnlyOne(type, order));
	}
	
	/* Get goods in cart (You're buying it) */
	@RequestMapping(value = "/Buy/{type}/Choose/{order}/Get")
	String chooseIt(@PathVariable int type,@PathVariable int order) {
		cust.setInCart(type, order);
		return("👉  You added " + cust.getName(type, order) + " in your cart ! 😉");
	}
	
	/* List of goods in cart */
	@RequestMapping(value = "/Cart")
	String cartOverAll() {
		return cust.getCart();
	}
	
	/* 
	 * Check out 
	 * 1.) If you choose goods, it shows total price and message. 
	 * 2.) If you don't choose goods, it shows message.
	*/
	@RequestMapping(value = "/Sayonara")
	String calculate() {
		int amount = cust.getCartList().size();
		int cost = cust.getValue();
		String name = cust.getCustomerName();
		cust.resetValue();
		if (cost == 0) { return "✅ Thank you " + name + ", for your attention in my shop 🙏"; }
		else {
			FileManager instance = new FileManager().getInstance();
			instance.WriteLog(name, amount, cost);
			return "🎉 Total Price : " + cost + " Baht 💵\n"
					+ "✅ Thank you " + name + ", for your attention in my shop 🙏";
		}
	}
	
	/* Show History Log of Service */
	@RequestMapping(value = "/ShowLog")
	String showLog() {
		FileManager instance = new FileManager().getInstance();
		instance.ReadLog();
		String log = instance.getLogString();
		return log;
	}
}
