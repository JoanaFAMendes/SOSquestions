/**
 * 
 */
package com.sosquestions.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maria Elisa
 *
 */

@XmlRootElement(name = "user")

public class User {
	private String email;
	private String userID;
	private String password;
	//connected
private String [] connected;

	/**
	 * @param email
	 * @param userID
	 */
	public User(String email, String userID, String password) {
		super();
		this.email = email;
		this.userID = userID;
		this.setPassword(password);
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @param the connected
	 */
	public String[] getConnected() {
		return connected;
	}

	/**
	 * @param url the connected to set
	 */
	public void setConnected(String [] connected) {
		this.connected=connected;
	}

	/**
	 * @param the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
