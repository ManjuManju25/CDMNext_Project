package Javaxlxs;

import java.io.File;

public class File_delete {
	public static void delete()
    {	
    	try{
    		
    		//File file = new File("C:\\Users\\Admin\\Downloads\\Untitled insight.xlsx");
    		File file = new File(System.getProperty("user.home") + "\\Downloads\\Untitled insight.xlsx");
    		
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
    }
}

