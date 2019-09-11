/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

public class ProductTypeFactory {
	/* Product Type Factory for Each Product Type (Factory Design Pattern) */
	public ProductType getProductType(String productTypeName){ 
	   if (productTypeName == null) { 
	      return null; 
	   }   
	   if (productTypeName.equalsIgnoreCase("PHOTOSET")) { 
	      return new PhotoSet(); 
	   } 
	   else if (productTypeName.equalsIgnoreCase("SINGLECD")) { 
	      return new SingleCD(); 
	   } 
	   else if (productTypeName.equalsIgnoreCase("TWOSHOT")) { 
	      return new TwoShot(); 
	   } 
	   return null; 
	}
}
