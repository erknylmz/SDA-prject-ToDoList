import java.io.Serializable;
import java.time.LocalDate;

import java.util.Scanner;


public class Task implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String projectName, taskTitle;
	
	private boolean isDone;
	
	LocalDate dueDate;
	
	
	
	public Task(String projectName, String taskTitle, boolean isDone, LocalDate dueDate) {
		
		this.projectName = projectName;
		this.taskTitle = taskTitle;
		this.isDone = isDone;
		this.dueDate = dueDate;
	
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Task() {
		
	}
	
	Scanner taskScan;
	
	/*
	 * This methods adds a new task to taskList and 
	 * return new taskList 
	 */
	public Task addNewTask() {
		taskScan = new Scanner(System.in);
		
		System.out.println(">> Project Name");	
		String projectName = taskScan.nextLine();
	    	
	    System.out.println(">> Task Title");
	    String taskTitle = taskScan.nextLine();
	    	
	    System.out.println(">> Due Date(yyyy-mm-dd");
	    LocalDate dueDate =CommonMethod.dateFormat();
	        
	    System.out.println(">> Is Done (True or False)");
	    boolean isDone = CommonMethod.booleanEnter();
	        
	    Task newTask = new Task(projectName, taskTitle, isDone, dueDate);
		
		return newTask;
		
	}


	@Override
	public String toString(){
		return 
		"\n---------------------------\n"+ 
		"\nProject name : " + projectName+ 
		"\nTask title   : " + taskTitle+ 
		"\nIs Done      : " + isDone+ 
		"\nDue date     : " + dueDate;
	}

}
