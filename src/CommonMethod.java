import java.time.LocalDate;
import java.util.Scanner;

public class CommonMethod {

	public CommonMethod() {
		
	}
	
	/*
	 * This method checks if user input with correct date format. 
	 * if format OK return the LocalDate
	 * if not, display a warning and try again.
	 */
	public static LocalDate dateFormat() {
		
		Scanner inputDate;
		boolean formatIsTrue=false;
		LocalDate localDate=null;
		while (formatIsTrue!=true){
			
			try {
				
				inputDate=new Scanner(System.in);
				String date = inputDate.next();
				localDate = LocalDate.parse(date);
				formatIsTrue=true;	    
			}
			catch (Exception e) {
				System.out.println(">> Please enter correct date format(YYYY-MM-DD)\n");
			}
		}			
		return localDate;
	}
	
	/*
	 * This method checks if user enters correct boolean
	 */
	 public static boolean booleanEnter() { 
			
		 Scanner c;		 	
		 boolean isDateEnterOK = false;			
		 boolean status=false;			
		 while (!status) { 
			 	
			 try {	
				 c=new Scanner(System.in);
				 isDateEnterOK=c.nextBoolean();            	
				 status=true;
			  } 
	        
			 catch (Exception e) { 
				 
				 CommonMethod.warningMessage("Please Enter only TRUE or FALSE ");	        	
			  }	 
		 	} 			
		 return isDateEnterOK;
	    } 
	 
	 public static void warningMessage(String note) {
		System.out.println(">> "+note);
		System.out.println(">> -------------------------------\n");
	 }
}
