package Javaxlxs;

import java.io.File;
import CDMNext.util.CommonFunctionality;

public class File_delete {
	public static void delete() {
			File file;
			// File file = new File("C:\\Users\\Admin\\Downloads\\Untitled insight.xlsx");
			// File file = new File(System.getProperty("user.home") + "\\Downloads\\Untitled
			// insight.xlsx");
			try {
				file = Last_file_download.theNewestFile;
				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println("Delete operation is failed.");
				}
				
			} catch (Exception e) {
				file = CommonFunctionality.theNewestFile;
				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println("Delete operation is failed.");
				}
			}
			
	}

}
