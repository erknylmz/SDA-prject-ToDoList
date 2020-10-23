import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public ArrayList<Task> taskList;
	private FileIO fileio;
  
	public TaskList() {		
	}

	public TaskList(String userName) {
	
	}
	
	Scanner taskListScan;
	
	void showTaskMenu(String userName) {
		fileio = new FileIO();
        taskList = (ArrayList<Task>) fileio.readAsObject(userName+"task.txt");
        if (taskList == null) // if the list is empty
        taskList = new ArrayList<>();
		//TaskList chekTask = new TaskList(userName);
		taskListScan = new Scanner(System.in);
		
		while (true){
			
			int state[] = checkDoneTask(taskList); //shows users toDo/isDone tasks
		
			System.out.format(">> Welcome to ToDoLy " + userName+"\n");
			System.out.format(">> You have %d task(s) ToDo and %d task(s) are done!\n", state[1], state[0]);
			System.out.println(">> Pick an option:");
			System.out.println(">> (1) Show Task List (by date or project)");
			System.out.println(">> (2) Add New Task");
			System.out.println(">> (3) Edit Task (update, mark as done, remove)");
			System.out.println(">> (4) Save and Quit");
    		
			
			int i=taskListScan.nextInt();
    		
			switch (i) {
    			
    			case 1:
    				
    				sortTaskMenu();
    				
    			break;
    			
    			case 2:
    				
    				Task newTask =new Task();
    				
    				taskList.add(newTask.addNewTask()); 
    				
    				break;
    			
    			case 3: 
    				
                	editTask(); 
                	
    			break;
                
    			case 4:
                	
                	if (taskList == null)  // if the list is empty
    					taskList = new ArrayList<>();  
    				
                	fileio.writeAsObject(taskList, userName+"task.txt");
    				System.exit(0);
                
             default:
                   
            	 	CommonMethod.warningMessage("Please enter suitable option! ");
                    showTaskMenu(userName);
             break;
    		 }     
    	}  	 
	
	}
	
	 /*
	  * This method shows sorted task list in the menu by project name or date
	  */
	void sortTaskMenu(){
    	
		taskListScan.nextLine();
    	System.out.println(">> (1) Show by Project");
		System.out.println(">> (2) Show by Date");
		System.out.println(">> Pick an option: ");
		
		int i=taskListScan.nextInt();
		
		switch (i){
			
		case 1:{
			
			sortTaskbyProjectName();
			
		}	
		
		break;
		
		case 2:{
			
			sortTaskbyDate();
			
		}
		
		break;
			
		default:
			CommonMethod.warningMessage(" Please Enter 1 or 2 ");
			sortTaskMenu();
		}
    }
	
	/*
	 * This method compares the taskList and sort by date
	 */
	void sortTaskbyDate() {
		
		Collections.sort(taskList, new DateCompare());
	    for (Task tasks: taskList)
	 	System.out.println(tasks);	
	}

	/*
	 * This method compares the taskList and sort by project name
	 */
	void sortTaskbyProjectName() {
		 
		Collections.sort(taskList, new ProjectNameCompare()); 
		for (Task tasks: taskList) 
		System.out.println(tasks);	 
		
	}
	
	/*
	 * This method checks the taskList for Done and ToDo tasks
	 * return an array includes done and ToDo numbers 
	 */
	int [] checkDoneTask(ArrayList<Task> taskList) {
		
		int isDone=0;
		int toDo=0;
	    int index=0;
	    
	    while(index<taskList.size()) {
	    	
	    	System.out.println();
	    	if(taskList.get(index).isDone()==true)
	    	isDone++;
	    	else
	    	toDo++;
	    	index++;
	    }
	    	int state[]= {isDone, toDo};
	    	return state;		 
	 }
	
	/*
	 * This method search by taskTitle 
	 * returns the index of the searched task in the taskList
	 */
	int searchTaskbyTaskTitle(){
		
		taskListScan.nextLine();
		boolean searching=true;
		int index=0; int statement=-1;
	    	
	    System.out.println(">> Enter task title: ");
	    	
	    String tTitle=taskListScan.nextLine();
	    	
	    //searching task list by task title
	    while(index<taskList.size()) {
	    		
	    	if(taskList.get(index).getTaskTitle().equals(tTitle)) {
	    			
	    		System.out.println(taskList.get(index));	
	    		System.out.println("Is this the task you searched(Y/N)");	    			
	    		String op=taskListScan.nextLine(); 
	    			
	    		if (op.equals("y") || op.equals("Y")) { 
	    			
	    			statement= index;	    				
	    			searching=false;	    				
	    			break;
	    		}
	    	}	
	    		index++;
	    }
	    	if (index==taskList.size() && searching==true) { 
	    			
	    		CommonMethod.warningMessage(" The task you are looking for was not found! ");	    			
	    		statement=-1;
	    	}	 	  
	   return statement;
	 }

	/*
	 * This method changes, deletes or marks is done a task which user look for it 
     * 
	 */
	void editTask() {
	    	
		taskListScan.nextLine();	
	    int index= searchTaskbyTaskTitle();
	    	
	    if (index!=-1) {  //if The task looks for was found
	    		
	    	System.out.println(">> Pick an option :");
	    	System.out.println(">> (1) Change");
	    	System.out.println(">> (2) Delete");
	    	System.out.println(">> (3) Mark is done");
	    	String option=taskListScan.next();
	    		
	    	if (option.equals("1")) {
	    			
	    		taskList.remove(index);
	    		Task newTask =new Task();
				taskList.add(newTask.addNewTask());
	    			
	    		CommonMethod.warningMessage(" Task is changed!...");
	    	}
	    	
	    	if (option.equals("2")){
	    			
	    		taskList.remove(index);
	    		CommonMethod.warningMessage(" Task is removed!...");
	    	}
	    		
	    	if (option.equals("3")){
	    			
	    		taskList.get(index).setDone(true);
	    		CommonMethod.warningMessage(" Task is marked as done!...");
	    	}
	    }
	    	
	   }
	
}
