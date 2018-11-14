package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import Javaxlxs.Last_file_download;
//import Javaxlxs.xlxs;

public class Latestfiledownload {
	public static void lastFileModified() {
		
		    File theNewestFile = null;
		    File dir = new File(System.getProperty("user.home") + "\\Downloads");
		    String ext="pdf";
		    FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		    File[] files = dir.listFiles(fileFilter);
		    
		    if (files.length > 0) {
		        /** The newest file comes first **/
		        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		        theNewestFile = files[0];
		    //}

		    //return theNewestFile;
		    login.Log4j.info("****************> THE SUCCESFULLY DOWNLOADED INSIGHTS  - >***************");
			String x = (double) theNewestFile.length() / 1024 + "  kb";
			
				   //String z="FAIL";
				   //System.out.println("The Downloaded Insight Fail"+ theNewestFile + " - Status : " + z );
			   //}
		   
			//String q=Download.InsightName;
			 //if(theNewestFile.equalsIgnoreCase(q)){
			
		    if (theNewestFile.exists()){
		    	 String y="PASS";
		    login.Log4j.info("The Downloaded Insight are - " + theNewestFile +   " - Size : " +  x  +   " - Status : " + y );
		   
		    }else{
		    	 String z="FAIL";
				   System.out.println("The Downloaded Insight Fail"+ theNewestFile + " - Status : " + z );
				   return;
			   //}
		    }
		    	
		 
	}  
		   // System.out.println("***** writing to xlxs ************");
	        //xlxs.writexlxs();
	}
	public static void main(String[] args) throws IOException {
		Latestfiledownload.lastFileModified();
	}
	
}
