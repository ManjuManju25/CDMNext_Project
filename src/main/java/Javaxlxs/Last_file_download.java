package Javaxlxs;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.testng.Assert;


import CDMNext.StepDefinations.Exceldatacomparision;

import java.io.*;
import java.util.*;



public class Last_file_download {
	
/* Get the newest file for a specific extension */
//public File getTheNewestFile(String filePath, String ext) 
public static void getTheNewestFile() throws IOException {
    File theNewestFile = null;
    File dir = new File(System.getProperty("user.home") + "\\Downloads");
    String y=Exceldatacomparision.format;
    //System.out.println("^^^^^^^^^^^^"+y);
    String ext = Exceldatacomparision.format;
	FileFilter fileFilter = new WildcardFileFilter("*." + ext);
    
	File[] files = dir.listFiles(fileFilter);

    if (files.length > 0) {
        /** The newest file comes first **/
    	 //System.out.println("^^^^^^^^^^^^Entered");
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        theNewestFile = files[0];
        
    //}
    
    System.out.println("The Successfully downloaded file is " + theNewestFile);
    String E =getFileExtension(theNewestFile);
    System.out.println("The Successfully extension file is " +  E);
    //return theNewestFile;
    if(E.equalsIgnoreCase(ext)){
    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
    }
    else{
    	
    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
    }
    }
}


public static String getFileExtension(File file) {
    String name = file.getName();
    try {
        return name.substring(name.lastIndexOf(".") + 1);
       
    } catch (Exception e) {
        return "";
    }
}


public static void main(String[] args) throws IOException {
	Last_file_download.getTheNewestFile();
}
}