package CDMNext.StepDefinations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import org.testng.annotations.BeforeSuite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

//Input values - Testcase ID, Sl.No, Test Case Description , Execution Remarks 

public class HTML_Report {
	public static LocalDateTime dtStartTime;
	public static String fileName = "testfile.html";
	public static String projectPath = System.getProperty("user.dir");
	public static String tempFile = projectPath + File.separator + fileName;
	public static File file = new File(tempFile);
	public static BufferedWriter bw;
	public static String testcaseID;
	public static int slNo;
	public static int passCount;
	public static int failCount;
	public static String strTCResult;
	public static String execRemarks;

	// @BeforeSuite
	public static void openHTMLReport() throws Throwable {
		dtStartTime = LocalDateTime.now();
		LocalTime dtStartTime = LocalTime.now();
		int dtStartTimeHour = dtStartTime.getHour();
		int dtStartTimeMin = dtStartTime.getMinute();
		// if file does exists, then delete and create a new file
		if (file.exists()) {
			String backupfile = "backupfile-" + dtStartTimeHour + dtStartTimeMin + ".html";
			try {
				File newFileName = new File(projectPath + File.separator + backupfile);
				file.renameTo(newFileName);
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		bw = new BufferedWriter(new FileWriter(file));
		slNo = 0;
		passCount = 0;
		failCount = 0;
	}

	@Before
	public static void scenarioParameters(Scenario scenario) throws Throwable {
		execRemarks = "";
		strTCResult = "";
		testcaseID = scenario.getName();
		slNo = slNo + 1;

	}

	@After
	public static void html_Body() throws Throwable {
		try {

			StringBuilder htmlStringBuilder = new StringBuilder();
			// append html header and title

			htmlStringBuilder.append("<body>");
			// append table
			htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
			// append row
			if (execRemarks == null) {
				execRemarks = "Application is not ready to execute";
			}
			if (strTCResult == "PASS") {
				htmlStringBuilder.append(
						"<table border=1 width=100%><tr><td align=center td width=10%><font size=2.8 face=Cambria color="
								+ "green" + ">" + slNo
								+ "</font></td><td align=left td width=45%><font size=2.8 face=Cambria color=" + "green"
								+ ">" + testcaseID
								+ "</font></td><td align=left td width=45%><font size=2.8 face=Cambria color=" + "green"
								+ ">" + execRemarks + "</font></td></tr>");
			} else {
				htmlStringBuilder.append(
						"<table border=1 width=100%><tr><td align=center td width=10%><font size=2.8 face=Cambria color="
								+ "red" + ">" + slNo
								+ "</font></td><td align=left td width=45%><font size=2.8 face=Cambria color=" + "red"
								+ ">" + testcaseID
								+ "</font></td><td align=left td width=45%><font size=2.8 face=Cambria color=" + "red"
								+ ">" + execRemarks + "</font></td></tr>");
			}

			bw.append(htmlStringBuilder.toString());
			if (strTCResult == "PASS") {
				passCount = passCount + 1;
			} else {
				failCount = failCount + 1;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void html_Header() throws Throwable {
		try {

			// define a HTML String Builder
			StringBuilder htmlStringBuilder = new StringBuilder();
			// append html header and title
			htmlStringBuilder.append("<html><head><title>CDMNext Automation</title></head>");
			htmlStringBuilder.append(
					"<table border=1 width=100%><tr><td colspan=4><font size=6 face=Cambria color=green><center>"
							+ "<b>CDMNext Automation</b></center></font></td></tr>");
			// append body
			htmlStringBuilder.append("<body>");
			// append table
			htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
			// append row
			htmlStringBuilder.append("<table border=1 width=100%><tr><td width=20%><font size=" + "3.5 face="
					+ "Cambria color=" + "green" + "><b>System Name:</td>" + "<td width=30%><font size=" + "3.5 face="
					+ "Cambria color=" + "brown><b>" + System.getProperty("user.name") + "</b></font></td>"
					+ "<td width=18%><font size=" + "3.5 face=" + "Cambria color=" + "green"
					+ "><b>Operating System:</b></font></td>" + "<td width=32%><font size=" + "3.5 face="
					+ "Cambria color=" + "brown><b>" + System.getProperty("os.name") + "</b></font></td></tr>");
			htmlStringBuilder.append("<meta http-equiv=" + "refresh content=" + "150" + "><table border=" + "1"
					+ " width=100%>" + "<tr>" + "<th width=10%><font size=" + "2.8 face=" + "Cambria color=" + "blue"
					+ "><b> Sl No.</b></font></th>" + "<th width=45%><font size=" + "2.8 face=" + "Cambria color="
					+ "blue" + "><b> Test Case ID & Description </b></font> </th>" + "<th width=45%><font size="
					+ "2.8 face=" + "Cambria color=" + "blue><b> Execution Remarks </b></font></th></tr>");

			bw.append(htmlStringBuilder.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void html_Footer() throws Throwable {
		try {

			// define a HTML String Builder
			StringBuilder htmlStringBuilder = new StringBuilder();
			// append html header and title

			htmlStringBuilder.append("<table border=1 width=100%><tr><td width=20%><font size=" + "3.5 face="
					+ "Cambria color=" + "green" + "><b>Execution Started At:</td>" + "<td width=30%><font size="
					+ "3.5 face=" + "Cambria color=" + "brown><b>" + dtStartTime + "</b></font></td>"
					+ "<td width=18%><font size=" + "3.5 face=" + "Cambria color=" + "green"
					+ "><b>No. of Test Cases: </b></font></td>" + "<td width=32%><font size=" + "3.5 face="
					+ "Cambria color=" + "brown><b>" + slNo + "</b></font></td></tr>");
			htmlStringBuilder.append("<table border=1 width=100%><tr><td width=20%><font size=" + "3.5 face="
					+ "Cambria color=" + "green" + "><b>Total No. of testcases Passed</td>"
					+ "<td width=30%><font size=" + "3.5 face=" + "Cambria color=" + "brown><b>" + passCount
					+ "</b></font></td>" + "<td width=18%><font size=" + "3.5 face=" + "Cambria color=" + "green"
					+ "><b>Total No. of testcases Failed</b></font></td>" + "<td width=32%><font size=" + "3.5 face="
					+ "Cambria color=" + "brown><b>" + failCount + "</b></font></td></tr>");
			htmlStringBuilder.append(
					"<tr ><td colspan=4><font size=5 face=Cambria color=green><center>Execution Completed Successfully.</center></font></td></tr>");

			bw.append(htmlStringBuilder.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}