package coupons;

import java.util.ArrayList;

public class cupon {
	
	private ArrayList<String> correctCode = new ArrayList<>();
	private ArrayList<String> expirationDate = new ArrayList<>();
	
	/**
	 * @return the correctCode
	 */
	public ArrayList<String> getCorrectCode() {
		return correctCode;
	}
	/**
	 * @param correctCode the correctCode to set
	 */
	public void setCorrectCode(ArrayList<String> correctCode) {
		this.correctCode = correctCode;
	}
	/**
	 * @return the expirationDate
	 */
	public ArrayList<String> getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(ArrayList<String> expirationDate) {
		this.expirationDate = expirationDate;
	}

		


}
