import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {
	
	/*
	 * This method create a new file with a given file name.
	 * if the file already exists, display "File already exists."
	 */
	public void createNewFile(String fileName) {
		
		try {
		      File newFile = new File(fileName);
		      if (newFile.createNewFile()) {
		        System.out.println("File created: " + newFile.getName());
		      }
		      
		      else {
		        System.out.println("File already exists.");
		      }
		    
		} catch (IOException e) {
		      
		    	CommonMethod.warningMessage("An error occurred!");
		        e.printStackTrace();
		    }
	 }
	
	
	/*
     * This method writes an object(array list) to file path.
     * if the file does not exist display "File doesn't found "
     */
	public void writeAsObject(ArrayList<?> list, String filePath) {
       
		try {
           
			FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(list);
            output.close();
            file.close();
         }
		
        catch(IOException e) {
            
        	CommonMethod.warningMessage("File doesn't found " +  e);
         }
    }
    
	
	/*
	 * This method reads as object from a file and returns an object.
	 *   
	 */
	public Object readAsObject(String filePath) {
		
		Object list = new ArrayList<>();
        
		try { 
        	FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream stream = new ObjectInputStream(file);
            list = stream.readObject();
            stream.close();
            file.close();
        }
        
		catch (EOFException e) {
            System.out.println(" The file is empty : "+filePath);
        }
        
        catch(IOException  e) {
            System.out.println(" File doesn't found " +  e);
        }
        
        catch (ClassNotFoundException e) {
            CommonMethod.warningMessage("Problems inside the file " + e);
        }
        return list;
	}
}