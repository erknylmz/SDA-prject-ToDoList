import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterFace {
	
	private User user;
	private TaskList checkTask;
	private UserList checkUser;
	private FileIO fileio;
	
	public UserInterFace() {

		user = new User();
		
		checkUser = new UserList();
		
		fileio = new FileIO();
		
		checkTask = new TaskList();
		
	}
	
	Scanner interFaceScan;
	
	void welcome() {
		
		interFaceScan = new Scanner(System.in);
		
		System.out.println(">> Welcome to ToDoList");
		System.out.println(">> Have you got an account?");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Yes");
		System.out.println(">> (2) No");	
		
		int isNewUser;
		
		boolean choiseIsTrue=false; // check correct enter (1 or 2)
		
		while (!choiseIsTrue) {
		
			try {
		
				isNewUser= interFaceScan.nextInt();
				
				switch (isNewUser){ // check new user? 
			
					case 1:{     // The user has already an account
						
						choiseIsTrue=true;
						
						user.enterUserData(); // get userName and passWord
						
						// check userName and passWord are correct with checkUserNameandPassWord methods in userList 
						//
						
						if (checkUser.checkUserNameandPassWord(user.getUserName(), user.getPassWord()))
					
							//userName and pass are correct, display users task menu 
							
							checkTask.showTaskMenu(user.getUserName()); 
						
						else {
							
							// if userName and pass are not correct 
							CommonMethod.warningMessage("Username or password is wrong!");
					
							welcome();
						}
					}
			
					break;
			
					case 2:{         //  user is new
						
						choiseIsTrue=true;
				
						user.enterUserData();  // get userName and passWord
				
						// check userName and passWord are correct with checkUserNameandPassWord methods in userList 
						
						if (!checkUser.checkUserAccountTaken(user.getUserName())){
					
						// if there is no an account with the same name
							
							checkUser.createNewAcoount(user); // create new user account 
							
							// create a new task file which belongs to new user
							fileio.createNewFile(user.getUserName()+"task.txt"); 
					
							// display users task menu 
							checkTask.showTaskMenu(user.getUserName());
						}
						else {
							
							// if there is an account with the same name 
							
							CommonMethod.warningMessage("There is an account with the same name");
					
							welcome();
						}
					}
			
					break;
        
					default:{
							// if user input wrong 
							CommonMethod.warningMessage("Please enter suitable option! ");
					
							welcome();
					}
					break;
				}
			}
			catch (InputMismatchException e) {
			    
				CommonMethod.warningMessage("Please enter suitable option! ");
			}
			
			welcome();
		}
		
	}
	
	
	public static void main(String[] args) {
	
	UserInterFace ui = new UserInterFace();
	ui.welcome();
	}

}

