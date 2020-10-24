import java.io.Serializable;
import java.util.ArrayList;


public class UserList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	User user;
	ArrayList<User> userList;
	FileIO fileio;
	
	public UserList() {
	
		user = new User();
		fileio = new FileIO();
		
		userList = (ArrayList<User>) fileio.readAsObject("User.txt");
		
	}
	void readUserList() {
	 
	}
	
	void createNewAcoount(User user) {
		userList.add(user);
		fileio.writeAsObject(userList,"User.txt");
	}
	
	
	/*
	 * this methods checks userName and passWord are correct
	 */
	
	boolean checkUserNameandPassWord(String name, String pass) {
		
		boolean statement=false;
		
		for (User user : userList) {   
			
			if (user.getUserName().equals(name) && user.getPassWord().equals(pass)) {
				statement=true;
				break;
			}
		} 
		
		return statement;
	}
	
	
	/*
	 * Check userName is taken
	 */
	boolean checkUserAccountTaken(String name) {
		
		boolean statement=false;
		
		for (User user : userList){
			
			if (user.getUserName().equals(name)){
				
				System.out.println(">> There is an account with the same name");
        		
				statement=true;
        	}	
        } 
		return statement;
	}
	
}