import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;



class TaskListTest {
	
	
	/*
	 *  we entered with manual in the console
	 *  project name : "Test"
	 *  task title : "ToDOList test"
	 *  due date : 2020-10-23
	 *  is done : true
	 *  and we select from task list menu save and quit.
	 *  now we check it is written to task file
	 *  
	 */
	@Test
	void testaddTask() {
	FileIO fileio =new FileIO();
	
	TaskList checkTask =new TaskList("erkan");	
	checkTask.showTaskMenu("erkan");// Erkan is defined user and has tasks
    ArrayList<Task> taskList = (ArrayList<Task>) fileio.readAsObject("erkan"+"task.txt");
    assertEquals(true, taskList.contains("Test"));
    
	}
	
}

