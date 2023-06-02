package CDMNext.StepDefinations;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xhtmlrenderer.css.style.Length;

public class sample {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Resources\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://google.com");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		// start pattern

		// Right triangle star pattern
		/*
		 * int row=6; for(int i=0;i<row;i++) { for(int j=0;j<=i;j++) {
		 * System.out.print(" *"); } System.out.println(); }
		 * 
		 */

		// Left Triangle pattern

		/*
		 * int row=6;
		 * 
		 * for(int i=0;i<row;i++) {
		 * 
		 * for(int j=2*(row-i);j>=0;j--) { System.out.print(" "); } for(int
		 * j=0;j<=i;j++) { System.out.print("* "); } System.out.println(); }
		 */

		// Pyramid star pattern

		/*
		 * int row=6;
		 * 
		 * for(int i=0;i<row;i++) { for(int j=row-i;j>1;j--) { System.out.print(" "); }
		 * for(int j=0;j<=i;j++) { System.out.print("* "); } System.out.println(""); }
		 * 
		 */

		// downward pattern

		/*
		 * int row=6;
		 * 
		 * for(int i=row-1;i>=0;i--) { for(int j=0;j<=i;j++) { System.out.print("* "); }
		 * System.out.println(""); }
		 */

		// reverse pyramid star pattern

//		
//		int row=6;
//		for(int i=0;i<=row-1;i++)
//		{
//			for(int j=0;j<=i;j++)
//			{
//				System.out.print(" ");
//			}
//			
//			for(int k=0;k<=row-1-i;k++)
//			{
//				System.out.print("*"+ " ");
//			}
//			System.out.println();
//		}
//		

		// Right triangle pattern

//		int row=6;
//		
//		for(int i=0;i<row;i++)
//		{
//			for(int j=0;j<=i;j++)
//			{
//				System.out.print(" *");
//			}
//			System.out.println("");
//		}

		// Left triangle pattern

//		int row=6;
//		
//		for(int i=0;i<row;i++)
//		{
//			for(int j=2*(row-i);j>=0;j--)
//			{
//				System.out.print(" ");
//			}
//			for(int j=0;j<i;j++)
//			{
//				System.out.print(" *");
//			}
//			System.out.println();
//		}
//		
		// pyramid triangle pattern

		/*
		 * int row=6;
		 * 
		 * for(int i=0;i<row;i++) { for(int j=row-i;j>=1;j--) { System.out.print(" "); }
		 * for(int j=0;j<=i;j++) { System.out.print("* "); } System.out.println(); }
		 */

		// downward pattern

		/*
		 * int row=6;
		 * 
		 * for(int i=row-1;i>=0;i--) { for(int j=0;j<=i;j++) { System.out.print("* "); }
		 * System.out.println(""); }
		 */

		// downward pattern
		/*
		 * int row=6; for(int i=row-1;i>=0;i--) { for(int j=0;j<=i;j++) {
		 * System.out.print(" *"); } System.out.println(""); }
		 */

		// reverse pyramid

	/*	int row = 6;

		for (int i = 0; i < row; i++) {
			for (int j = row - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println("");
		}*/

		
		//Right Triangle pattern
		
/*		int row=6;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		*/
		
		//Left triangle pattern
/*		int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=2*(row-i);j>=0;j--)
			{
				System.out.print(" ");
			}
			
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println();
		}
		*/
		
		//pyramid
		
/*		int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>=1;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		
		*/
		
		//downward right
		
		
	/*	int row=6;
		for(int i=row-1;i>=0;i--)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println();
		}*/
		/*	int row = 6;

		for (int i = 0; i < row; i++) {
			for (int j = row - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println("");
		}*/
		 
		
	/*	
		int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>=1;j--)
			{
				System.out.println(" ");
			}
			for(int j=0;j<=i;j++)
			{
				
			}
		}
		
		*/
		
		
		
		//Right triangle pattern
		
		
/*		int row=6;
		
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		*/
		
		//Left triangle
		
	/*	int row=6;
		
		for(int i=0;i<row;i++)
		{
			for(int j=2*(row-i);j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println();
		}
		*/
		
		//pyramid triangle
		
/*		int row=6;
		
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>=1;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" * ");
			}
			System.out.println();
			
		}
		*/
		
		//downward triangle
		
	/*	int row=6;
		for(int i=row-1;i>=0;i--)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println();
			
		}*/
		
		//reverse pyramid
		
		
		
	/*	
		int row = 6;

		for (int i = 0; i < row; i++) {
			
		}
			for (int j = row - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println("");
		*/
		
	/*	int row=6;
		
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>=1;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" * ");
			}
			System.out.println();
		}
		*/
		
	/*	
			int row = 6;

		for (int i = 0; i < row; i++) {
			
			for (int j = row - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println("");
		}
		*/
		
		
		
	/*	int row=6;
		for(int i=0;i<=row-1;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
			
			for(int k=0;k<=row-1-i;k++)
			{
				System.out.print("*"+ " ");
			}
			System.out.println();
		}
		*/
		
/*		int row=6;
		
		for(int i=0;i<=row-1;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=row-1-i;k++)
			{
				System.out.print(" * ");
			}
			System.out.println();
		}
		
		*/
		
	/*	//pattern same ints
		int row=6;
		int number;
		for(int i=0;i<row;i++)
		{
			number=1;
			for(int j=0;j<i;j++)
			{
				System.out.print(" "+number);
				number++;
			}
			System.out.println();
		}
		//pattern 1 to 10
		int row1=6;
		int number1=1;
		for(int i=0;i<row1;i++)
		{
			
			for(int j=0;j<i+1;j++)
			{
				System.out.print(" "+number1);
				number1++;
			}
			System.out.println("");
		}
		*/
		
		
		// Right triangle pattern
		
		
	/*	int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		*/
		
		
		
		//Left Triangle pattern
		
	/*	int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=2*(row-i);j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		*/
		
		//pyramid pattern
	
	/*	int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>1;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" * ");
			}
			System.out.println("");
		}
		
		*/
		//downward Triangle pattern
		
	/*	
		int row=6;
		for(int i=row-1;i>=0;i--)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		
	*/
		
		
		//reverse pyramid pattern
		
		
	/*	int row=6;
		
		for(int i=0;i<=row-1;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=row-1-i;k++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		*/
		
		//armstrong  number
		
		
	/*	int n=153;
		int temp=n;
		int r;
		int sum=0;
		
		while(n>0)
		{
			r=n%10;
			n=n/10;
			sum= sum+r*r*r;
		}
		if(temp==sum)
		System.out.println("its an armstrong number");
		else
			System.out.println("its NOT armstrong number");
			*/
		
		
		//number pattern 1
		/*
		int n=7;
		int number;
		for(int i=0;i<=n;i++)
		{
			number=1;
			for(int j=0;j<=i;j++)
			{
				System.out.print(number+" ");
				number++;
			}
			System.out.println("");
		}
		*/
		
		//number pattern 2
		
	/*	
		int n=6;
		
		int number=1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(number+" ");
				number++;
			}
			System.out.println("");
		}
		
		*/
		
	/*	
		int row=6;
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(j%2==0)
				{
					System.out.print(0);
				}
				else {
					System.out.print(1);
				}
				
			}
			System.out.println("");
		}
		
		*/
		

	
	//Alphabet letters count
		
		
	/*	int alphabet=65;
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)(alphabet)+" ");
			}
			
			System.out.println();
			alphabet++;
			
		}*/
	/*	A 
		B B 
		C C C 
		D D D D 
		E E E E E 
		F F F F F F 
		G G G G G G G 
		H H H H H H H H 
		I I I I I I I I I  */
		
		//Alphabet letters count
	/*	
		int alphabet=65;
		
		for(int i=0;i<=7;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)(alphabet+j)+" ");
			}
			System.out.println("");
		}
A 
A B 
A B C 
A B C D 
A B C D E 
A B C D E F 
A B C D E F G 
A B C D E F G H 
		*/
		
		
		//Right Triangle pattern
		
	/*	int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
		*/
		
		
		//Left Triangle pattern
		
	/*	int row=6;
		for(int i=0;i<row;i++)
		{
			for(int j=2*(row-i);j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		
		*/
		
		
		//pyramid pattern
		
	/*	int row=6;
		
		for(int i=0;i<row;i++)
		{
			for(int j=row-i;j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		
		*/
		
		//reverse pyramid
	/*	int row=6;
		for(int i=0;i<=row-1;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=row-1-i;k++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		*/
		
		//downward triangle
	/*	int row=6;
		for(int i=row-1;i>=0;i--)
		
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" *");
			}
			System.out.println("");
		}
		*/
		
		
		//Number pattern
	
/*	int number;
	for(int i=0;i<=6;i++)
	{
		number=1;
		for(int j=0;j<=i;j++)
		{
			System.out.print(number+" ");
			number++;
		}
		System.out.println("");
	}
		
	System.out.println("<=====================>");
		int n=1;
	
		for(int i=0;i<=6;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(n+" ");
				n++;
			}
			System.out.println("");
		}
		*/
		
		//pattern
/*		int row=6;
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(j%2==0)
				{
					System.out.print("1 ");
					
				}
				else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
			
		}
		*/
		
		//Armstrong number program
		
/*		int n=153;
		
		int temp=n;
		int sum=0;
		int r;
		
		while(n>0)
		{
			r=n%10;
			n=n/10;
			sum=sum+r*r*r;
			
		}
		if(temp==sum)
			System.out.println("armstrong number");
		else
			System.out.println("NOT armstrong number ");
		
		*/
		
		
	/*	int alphabet=65;
		
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)(alphabet+j)+" ");
			}
			System.out.println("");
		}
		
		*/
		
/*		int alphabet=65;
		
		for(int i=0;i<=6;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)alphabet+" ");
				
			}
			alphabet++;
			System.out.println("");
		}
		*/
		
		//Time Stamp
		
	/*Date d=new Date();
	SimpleDateFormat s=new SimpleDateFormat();
	System.out.println(s.format(d)); */
	
	//string reverse using inbuilt method
	/*
	String s="swami";
	StringBuilder b=new StringBuilder();
	b.append(s);
	System.out.println(b.reverse());
	
	
	//String reverse using for loop
	
	String str="swami";
	String b1=" ";
	for(int i=0;i<str.length();i++)
	{
		char c=str.charAt(i);
	b1=	c+b1;
	
	}
	System.out.println(b1);
	
	*/
		//Reverse string each word
		
	/*	String sa="Good monring";
		String str[]=sa.split("\\s");
		 
		for(String s:str)
		{
			StringBuilder b=new StringBuilder(s);
			b.reverse();
			System.out.print(b.toString());
			
		}
		*/
		
		
		
	//swap a string
		
/*		String s1="abc";
		String s2="def";
		s1=s1+s2;
		s2=s1.substring(0,(s1.length()-s2.length()));
		s1=s1.substring(s2.length());
		System.out.println(s1);
		System.out.println(s2);
				
			*/
		
		
//	//	fibnoic series
//		
//     int n1=0;
//	 int n2 =1;
//	 int n3;
//	
//	 
//	 for(int i=2;i<=10;i++)
//	 {
//		 n3=n1+n2;
//		 n1=n2;
//		 n2=n3;
//		 System.out.println(n3);
//	 }
//	
		
/*		int n1=0;
		int n2=1;
		int n3;
		for(int i=0;i<=10;i++)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.println(n3);
		}
		*/
		
		//capitalize each word in string
	/*	String s="is to be there or not to be there";
		String a="";
		String str[]=s.split("\\s");
		for(String word:str)
		{
			String first=word.substring(0,1);
			 String second=word.substring(1);
			  a=first.toUpperCase()+second;
			  System.out.print(a);
		}
		*/
		//total number of characters in a string
		
	/*	
		String s="hello good morning friends";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
				count++;
		}
		System.out.println(count);
		
		*/
		
		
		//Program to find the frequency of characters
		
	/*	String str="picture perfect";
		int count;
		int i;
		int j;
		
		 char String[]=str.toCharArray();
		 for( i=0;i<str.length();i++)
		 {
			 for(j=i+1;j<str.length();j++)
			 {
				 count=1;
				 if(String[i]==String[j])
				 {
					 count++;
					 String[j]='0';
				 }
			        }  

	
		 }
		// System.out.println("Characters and their corresponding frequencies"); 
		  for(i = 0; i <str.length(); i++) {  
		 if(String[i] != ' ' && String[i] != '0')  
             System.out.println(String[i]);  
       
		
		  }
		 /*	
		
		
		 String str = "picture perfect";  
	        int[] freq = new int[str.length()];  
	        int i, j;  
	          
	        //Converts given string into character array  
	        char string[] = str.toCharArray();  
	          
	        for(i = 0; i <str.length(); i++) {  
	            freq[i] = 1;  
	            for(j = i+1; j <str.length(); j++) {  
	                if(string[i] == string[j]) {  
	                    freq[i]++;  
	                      
	                    //Set string[j] to 0 to avoid printing visited character  
	                    string[j] = '0';  
	                }  
	            }  
	        }  
	          
	        //Displays the each character and their corresponding frequency  
	        System.out.println("Characters and their corresponding frequencies");  
	        for(i = 0; i <freq.length; i++) {  
	            if(string[i] != ' ' && string[i] != '0')  
	                System.out.println(string[i] + "-" + freq[i]);  
	        }  
		
		
		*/
		
	/*	
		//total number of vowels and consonants in a string.
		
		int vol=0;
		int con=0;
		String str="This is a really simple sentence";
		str=str.toLowerCase();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
			{
				vol++;
			}
			else {
				if(str.charAt(i)>='a' && str.charAt(i)<='z')
				{
					con++;
				}
			}
		}
		
		
		System.out.println("vol===== :"+vol);
		
		System.out.println("con===== :"+con);
		
		*/
		
		
		
		//ReplaceSpace
		
	//	String s="Once in a blue moon";
      //   s=s.replace(" ","-");
      //   System.out.println(s);
		
		
        // total number of characters in a string
		
/*		String s="The best of both worlds";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
			{
				count++;
			}
			
		}
		System.out.println(count);
		
		*/
		
		
		//CountWords
		
	/*	String s="Beauty lies in the eyes of beholder";
		int count=0;
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)==' ' && Character.isLetter(s.charAt(i+1)) && (i>0))
			{
				count++;
			}
		}
		count++;
		System.out.println(count);
		*/
		
		
		//count the words
		
	/*	String s="Beauty lies in the eyes of beholder";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ' && (i>0) && Character.isLetter(s.charAt(i+1)))
		    {
				
				count++;
				}
		}
		
		//count++;
		System.out.println(count);
		
		*/
	//	Palindrome  
		
	/*	String s="Kayak";
		boolean flag=true;
		s=s.toLowerCase();
		
		for(int i=0;i<s.length()/2;i++)
		{
			
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
			{
				flag=false;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("given string palindrome");
		}
		else {
			System.out.println("given string NOT palindrome");
		}
		
		
		*/
		
	/*	String s="Kayak";
		 s=s.toLowerCase();
		boolean flag=true;
		for(int i=0;i<s.length()/2;i++)
		{
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
			{
				flag=false;
				break;
			}
			
		}
		
		if(flag)
		System.out.println("its a palindram");
		else
			System.out.println("NOT a palindram");
		*/
		
		
		
		
		//Reverse string
		
/*		//inbuilt
		String s="Dream big";
		StringBuilder b=new StringBuilder();
		b.append(s);
		System.out.println(b.reverse());
		*/
		
		//using for loop
	/*	 String s="Dream big";
		  String str[]=s.split("\\s");
	
		  for(String word:str)
		  {
			  StringBuilder b=new StringBuilder(word);
			  System.out.print(b.reverse());
		  }
		*/
		
		
		//  maerDgib
		
		//gib maerD
		
		
		
		
	/*	//reverse String
		String s="Dream big";
		String word="";
		for(int i=s.length()-1;i>=0;i--)
		{
			 word=word+s.charAt(i);
		}
		System.out.println(word);
		
		*/
		//duplicate characters count
		
		
		/*
		 String s="Great responsibility";
		char string[]= s.toCharArray();
		int count;
		 for(int i=0;i<s.length();i++)
		 {
			 count=1;
			 for(int j=i+1;j<s.length();j++)
			 {
				 if(string[i]==string[j] && string[i]!=' ')
				 {
					 count++;
					 string[j]='0';
				 }
			 }
			 
			 if(count>1 && string[i]!='0')
			 {
				 System.out.println(string[i]);
			 }
			 
		 }
		
		*/
		
		
		
		/*String s="Great responsibility";
		 char str[]=s.toCharArray();
		 
		 int count;
		 for(int i=0;i<str.length;i++)
		 {
			 count=1;
			 for(int j=i+1;j<str.length;j++)
			 {
				 if(str[i]==str[j] && str[i]!=' ')
				 {
					 count++;
					 str[j]='0';
				 }
				 
			 }
			 
			 if(count>1 && str[i]!='0')
			 {
				 System.out.println(str[i]);
			 }
			 
			 
			 
			 
			 
		 }
		
		*/
		
/*		
		String str = "picture perfect";  
       // int[] freq = new int[str.length()]; 
        int freq[]=new int[str.length()];
        int i, j;  
          
        //Converts given string into character array  
        char string[] = str.toCharArray();  
          
        for(i = 0; i <str.length(); i++) {  
            freq[i] = 1;  
            for(j = i+1; j <str.length(); j++) {  
                if(string[i] == string[j]) {  
                    freq[i]++;  
                      
                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';  
                }  
            }  
        }  
          
        //Displays the each character and their corresponding frequency  
        System.out.println("Characters and their corresponding frequencies");  
        for(i = 0; i <freq.length; i++) {  
            if(string[i] != ' ' && string[i] != '0')  
                System.out.println(string[i] + "-" + freq[i]);  
        }
		
		*/
		
		
		
		//duplicate letters count in string
		
		/*String s="Great responsibility";
		
		 char str[]=s.toCharArray();
		 int count;
		 
		 for(int i=0;i<str.length;i++)
		 {
			 count=1;
			 for(int j=i+1;j<str.length;j++)
			 {
				 if(str[i]==str[j] && str[i]!=' ')
				 {
					 count++;
					 str[j]='0';
				 }
			 }
			 
			 if(count>1 && str[i]!='0')
			 {
				 System.out.println(str[i]);
			 }
			 
			 
		 }*/
		
		
		//find the frequency of characters
		
	/*	
		String s="picture perfect";
		int word[]=new int [s.length()];
		
		 char str[]=s.toCharArray();
		 
		 for(int i=0;i<str.length;i++)
		 {
			 word[i]=1;
			 for(int j= i+1;j<str.length;j++)
			 {
				 if(str[i]==str[j])
				 {
					 word[i]++;
					 str[j]='0';
					 
				 }
			 }
 
		 }
		 for(int i=0;i<word.length;i++)
		 {
			 if(str[i]!=' '&& str[i]!='0')
			 {
				 System.out.println(str[i]+"-"+word[i]);
			 }
		 }
		
		
		*/
		
		//Program to swap two string variables without using third or temp variable
		
	/*	
		String s1="abc";
		String s2="def";
		s1=s1+s2;
		s2=s1.substring(0,(s1.length()-s2.length()));
		s1=s1.substring(s2.length());
		System.out.println("After swap string S1:"+s1);
		System.out.println("After swap String S2:"+s2);
				
		*/
		
		
	// count the each character count in string
/*
	String s = "picture perfect";
	int word[] = new int[s.length()];
	char c[] = s.toCharArray();

	for (int i = 0; i < c.length; i++) {
		word[i] = 1;
		for (int j = 1 + i; j < c.length; j++) {
			if (c[i] == c[j]) {
				word[i]++;
				c[j] = '0';
			}
		}
	}
	for (int i = 0; i < word.length; i++) {
		if (c[i] != ' ' && c[i] != '0') {
			System.out.println(c[i] + " " + word[i]);
		}
	}
	*/
		
		
		
		//Program to count the total number of vowels and consonants in a string
		
		/*
		String s="This is a really simple sentence";
		s=s.toLowerCase();
		 int vol=0;
		 int con=0;
		 
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
            {
	              vol++;
	
             }
			else if(s.charAt(i)>='a' && s.charAt(i)<='z')
			{
				con++;
			}
		
		}
		
		
		System.out.println(vol);
		System.out.println(con);
		
		
		
		
		
		*/
	//	Program to remove all the white spaces from a string
		
		
		String s="hello world";
		s=s.replaceAll("\\s","");
		System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
