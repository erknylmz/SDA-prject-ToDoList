import java.util.Comparator;


public class DateCompare implements Comparator<Task> 
{
	@Override
	public int compare(Task task1, Task task2) 
	{
		return task1.getDueDate().compareTo(task2.getDueDate());
	}
}