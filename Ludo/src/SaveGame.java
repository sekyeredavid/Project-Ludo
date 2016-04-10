import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SaveGame {

	public static final String SaveFile = "TestSave.sav";
	
	public static void save(Serializable objectToSave){
		
		FileOutputStream fos = null;
		
		try {
			
 			fos = new FileOutputStream(SaveFile);
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objectToSave);   //write to file
			oos.flush(); 
			oos.close();  //close resource
			System.out.println("Saving....");
		} catch (IOException e) {
			// handle exception
			e.printStackTrace();
		}
	}
	public static ViewLudo load(){
		
		if(checkFileExists()){
			
			FileInputStream fis = null;
			ViewLudo loadedObject = null;
			try {
				
				fis = new FileInputStream(SaveFile);
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				loadedObject = (ViewLudo) ois.readObject();
				ois.close();
				
				System.out.println("Loaded");
			} catch (ClassNotFoundException | IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return loadedObject;
		}
		return null;
	}
	
	public static boolean checkFileExists(){
		
		return new File(SaveFile).isFile();
	}
}
