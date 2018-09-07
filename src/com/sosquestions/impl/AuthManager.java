/**
 * 
 */
package com.sosquestions.impl;

import java.security.Key;
import java.util.List;

import com.sosquestions.data.UserData;
import com.sosquestions.model.User;

import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * @author Maria Elisa
 *
 */
public class AuthManager implements IAuth{
	
static Key key;
	
	static AuthManager am = null;
	
	public static AuthManager getInstance() {
		if(am == null) {
			am = new AuthManager();	
			key = MacProvider.generateKey();
		}
		return am;
	}
	
	public Key getKey() {
		return key;
	}
	
	public boolean getAuth(String username, String password) {
		UserData userData = UserData.getInstance();				
		List<User> users = userData.getRawData();
		
		for(User user:users) {
			if(user.getUserID().equals(username)) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
		
	}

}
