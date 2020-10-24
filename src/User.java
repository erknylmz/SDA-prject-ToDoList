import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String passWord;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User() {	
	}

	public User(String userName, String passWord) {	
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	void enterUserData() {
		
		Scanner userScan = new Scanner(System.in);
		System.out.print(">> Enter username:");
		setUserName(userScan.nextLine());
		
		System.out.print(">> Enter password:");
		setPassWord(userScan.nextLine());
	}
	
	@Override
	public String toString() {
		return userName+" :"+ passWord;
	}
}
