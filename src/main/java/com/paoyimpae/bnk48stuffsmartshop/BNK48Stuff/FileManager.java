/* Developed By Sataphol Ketrattanakul (Student ID : 60070072) */

package com.paoyimpae.bnk48stuffsmartshop.BNK48Stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileManager {
	/* FileManager Singleton Class */
    private static FileManager instance;
    
	/* Attributes for Writing */
	private LocalDate dateNow = LocalDate.now(); // Get 'Date' Object
	private LocalTime timeNow = LocalTime.now(); // Get 'Time' Object
	private String customerName = ""; // Customer Name
	public String getCustomerName() {
		/* Getter Customer Name */
		return customerName;
	}
	public void setCustomerName(String customerName) {
		/* Setter Customer Name */
		this.customerName = customerName;
	}

	private int totalGoods = 0; // Total Goods in Cart
	private int totalPrice = 0; // Total Price in Cart
	public int getTotalGoods() {
		/* Getter Total Goods */
		return totalGoods;
	}
	public void setTotalGoods(int totalGoods) {
		/* Setter Total Goods */
		this.totalGoods = totalGoods;
	}
	public int getTotalPrice() {
		/* Getter Total Price */
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		/* Setter Total Price */
		this.totalPrice = totalPrice;
	}
	public LocalDate getDateNow() {
		/* Getter 'Date' Object */ 
		return dateNow;
	}
	public LocalTime getTimeNow() {
		/* Getter 'Time' Object */ 
		return timeNow;
	}
	
	/* Attributes for Reading */
	private String logString = ""; // String Log for Returning to /ShowLog
	public void setLogString(String logString) {
		/* Setter for Returning to /ShowLog */ 
		this.logString = logString;
	}
	public String getLogString() {
		/* Getter for Returning to /ShowLog */ 
		return logString;
	}
	
	public void WriteLog(String customerName, int totalGoods, int totalPrice) {
		/* Write Method of This Class */
		this.setCustomerName(customerName);
		this.setTotalGoods(totalGoods);
		this.setTotalPrice(totalPrice);
		String desktopPath = System.getProperty("user.home") + "/Desktop"; // Get the Desktop Path
		String path = desktopPath + "\\ServiceHistoryLog.txt"; // Combine Path
		File file = new File(path); // New 'File' Object
		FileWriter writer; 
		try {
			writer = new FileWriter(file, true); // New 'FileWriter' Object
			writer.write(String.format(
					"Name : %s, Date : %s, Time : %02d:%02d:%02d, Total Goods : %d, Total Prices : %d Baht.\r\n", 
					customerName,
					dateNow.toString(), 
					timeNow.getHour(), timeNow.getMinute(), timeNow.getSecond(), 
					totalGoods, totalPrice
				)
			); // Write Each Log in File !
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void ReadLog() {
		/* Read Method of This Class */
		String logString = "";
		String desktopPath = System.getProperty("user.home") + "/Desktop"; // Get the Desktop Path
		String path = desktopPath + "\\ServiceHistoryLog.txt"; // Combine Path
		File file = new File(path); // New 'File' Object
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); // 'BufferReader' & 'FileReader' Object
			String stringLine; // Get New String Line of File
			while ((stringLine = br.readLine()) != null) {
				logString += "<div>";
				logString += stringLine + "</div>"; // Put String Line in String Log Variable
			}
			br.close(); // Close It
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logString = "🙏 Sorry, No History Log File Found 😢"; // In Case of 'Not Found File'
			e.printStackTrace();
		}
		this.setLogString(logString);
	}

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
}