/**
 * 
 */
package com.sosquestions.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import com.sosquestions.data.UserData;
import com.sosquestions.model.User;

/**
 * @author Maria Elisa
 *
 */
public class UserManager implements IUser{

	static UserManager um = null;

	public static UserManager getInstance() {
		if (um == null) {
			um = new UserManager();
		}
		return um;
	}
	//remove specific user
	@Override
	public Object removeUser(String userID, String authID) {
		// TODO Auto-generated method stub
		if (userID.equals(authID)) {
			UserData userData = UserData.getInstance();
			userData.removeData(userID);
			// The user is removed with success
			return Response.ok().entity(userID + " removed!").build();
		} else {
			// The current user is not authorized to remove another user
			return Response.serverError().status(401).type("text/plain").entity("Not Authorized to remove!").build();
		}
	}

	//create user
	@Override
	public Response createUser(String email, String userID, String password) {
		// TODO Auto-generated method stub
		UserData userData = UserData.getInstance();
		List<User> users = userData.getData();
		
		//see if exist userID
		boolean exist = false;
		/*for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID().equals(userID)) {
				exist = true;
				break;
			}
		}*/
		if (exist) {
			//Already exist user
			return Response.serverError().status(401).type("text/plain").entity("User Already Exists!").build();
		} else {
			//doesn't exist -> create user
			User user = new User(userID, password, email);
			userData.insertData(user);
			// The user is created with success
			return Response.ok().entity(userID + " created!").build();
		}
	}

	//get all users
	@Override
	public List<User> getUsers(String userAuth) {
		// TODO Auto-generated method stub
		if (userAuth != null) {
			UserData userData = UserData.getInstance();
			return userData.getData();
		} else {
			// Invalid login
			Response.serverError().status(401).type("text/plain").entity("Invalid Login!").build();
		}
		return null;
	}

	//get specific user
	@Override
	public List<User> getUser(String userID, String userAuth) {
		// TODO Auto-generated method stub
		if (userAuth != null) {
			UserData userData = UserData.getInstance();
			return userData.getData(userID);
		} else {
			// Invalid login
			Response.serverError().status(401).type("text/plain").entity("Invalid Login!").build();
		}
		return null;
	}

	//create connected to specific user
	@Override
	public Response createConnected(String bookmarkID, String userAuth) {
/*		// TODO Auto-generated method stub
		UserData userData = UserData.getInstance();
		List<User> users = userData.getData();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID().equals(userAuth)) {
				String[] connected = users.get(i).getConnected(); 
				for(int j=0; j<connected.length; j++) {
					if(connected[j].equals(bookmarkID)) {
						return Response.serverError().status(401).type("text/plain").entity("Already Exists!").build();
					}
				}
				//doesn't exist -> create user
				connected[connected.length]=bookmarkID;
						users.get(i).setConnected(connected);
				
				String[] cn = users.get(i).getConnected();
				userData.createConnectedData(userAuth, cn);
				// The connected is created with success
				return Response.ok().entity("Connected created!").build();
			}
			else {
				return Response.serverError().status(401).type("text/plain").entity("Not Authorized!").build();
			}
		}	*/
		return null;
	}

	//remove connected from specific user
	@Override
	public Response removeConnected(String bookmarkID, String userAuth) {
		/*// TODO Auto-generated method stub
		UserData userData = UserData.getInstance();
		List<User> users = userData.getData();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID().equals(userAuth)) {
				String[] connected = users.get(i).getConnected(); 
				for(int j=0; j<connected.length; j++) {
					if(connected[j].equals(bookmarkID)) {
						connected[j]=null;
					}
					else {
						//doesn't exist
						return Response.serverError().status(401).type("text/plain").entity("Already Exists!").build();
					}
				}
				String[] cn = users.get(i).getConnected();
				userData.removeConnectedData(userAuth, cn);
				// The connected is created with success
				return Response.ok().entity("Removed created!").build();
			}
			else {
				return Response.serverError().status(401).type("text/plain").entity("Not Authorized!").build();
			}
		}*/	
		return null;
	}

	//change a specific user
	@Override
	public Object changeUser(String userID, String newPassword, String newEmail, String userAuth) {
		/*// TODO Auto-generated method stub
		if (userID.equals(userAuth)) {
			UserData userData = UserData.getInstance();
			userData.changeData(userID, newPassword, newEmail);
			// The user is changed with success
			return Response.ok().entity(userID + " changed!").build();
		} else {
			// The current user is not authorized to change another user
			return Response.serverError().status(401).type("text/plain").entity("Not Authorized!").build();
		}*/
		return null;
	}

	//get all connected to a specific user
	@Override
	public Object getConnected(String userAuth) {
		/*// TODO Auto-generated method stub
		if (userAuth != null) {
			UserData userData = UserData.getInstance();
			return userData.getConnectedData(userAuth);
		} else {
			// Invalid login
			Response.serverError().status(401).type("text/plain").entity("Invalid Login!").build();
		}*/
		return null;
	}	

}
