/**
 * 
 */
package com.sosquestions.impl;

import java.util.List;

import com.sosquestions.model.User;

/**
 * @author Maria Elisa
 *
 */
public interface IUser {
	public List<User> getUsers(String userAuth);
	public List<User> getUser(String userID, String userAuth);
	public Object createUser(String email, String userID, String password);
	public Object removeUser(String userId, String authID);
	public Object createConnected(String bookmarkID, String userAuth);
	public Object removeConnected(String bookmarkID, String userAuth);
	public Object changeUser(String userID, String newPassword, String newEmail, String userAuth);
	public Object getConnected(String userAuth);
}
