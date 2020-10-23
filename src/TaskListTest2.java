import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TaskListTest2 {

	/* 
	 * we chose edit task in the menu and 
	 * delete ToDOlist test task
	 */
	@Test
	void testdeleteTask() {
	FileIO fileio =new FileIO();
	
	TaskList checkTask =new TaskList("erkan");	
	checkTask.showTaskMenu("erkan");// Erkan is defined user and has tasks
    ArrayList<Task> taskList = (ArrayList<Task>) fileio.readAsObject("erkan"+"task.txt");
    assertEquals(false, taskList.contains("Test"));
    
	}
}
