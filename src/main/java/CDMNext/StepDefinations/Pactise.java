package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pactise {
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.close();
	}

	public void reverseString(String str) {
		StringBuffer buffer = new StringBuffer(str);
		buffer.reverse();
		System.out.println("Reverse string is: " + buffer);

	}

	public void reverseString1(String str) {
		StringBuilder builder = new StringBuilder(str);
		builder.reverse();
		System.out.println("Reverse string is: " + builder);

	}

	public void printIncrementalOrder() {

		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

	}

	public void printStar() {

		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public void CheckPalindromeNumberOrNot(int num) {
		int reverseNum = 0, remainder;
		int n = num;
		while (n != 0) {
			remainder = n % 10;
			System.out.println("Remainder is: " + remainder);
			reverseNum = reverseNum * 10 + remainder;
			n = n / 10;
			System.out.println("number is: " + n);

		}
		System.out.println("Actual number is: " + num);
		if (num == reverseNum) {
			System.out.println(reverseNum + " is a palindrome");
		} else {
			System.out.println(reverseNum + " is not a palindrome");
		}
	}

	public void CheckStringIsPalindromeORNot(String expected) {
		String reverseStr = "";
		int n = expected.length();
		for (int i = (n - 1); i >= 0; i--) {
			reverseStr = reverseStr + expected.charAt(i);

		}
		if (expected.equalsIgnoreCase(reverseStr)) {
			System.out.println(reverseStr + " is a palindrome");
		} else {
			System.out.println(reverseStr + " is not a palindrome");
		}
	}
public void findtheSecondLargestNum() {
	int array[] = {10,50,45,78,65};
	int size = array.length;
	System.out.println("Array size is " + size);
	Arrays.sort(array);
	System.out.println("Sorted array is" + Arrays.toString(array));
	int res = array[size - 2];
	System.out.println(res);
	System.out.println("2nd Largest element is " + res);
}
public static void ascendingOrder(){
    ArrayList<String> input_list = new ArrayList<String>();
    input_list.add("java");
    input_list.add("coding");
    input_list.add("is");
    input_list.add("fun");
    System.out.println("The list is defined as: " + input_list);
    Collections.sort(input_list);

    System.out.println("The sorted list is: " + input_list);
 }
public void printValuesInAscendingOrder() {
	int size,i;
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter Number of elements in an array: ");
	size = sc.nextInt();
	int a[] = new int[size];
	System.out.println("Please enter "+ size + " elements in an array");
	for(i = 0; i < size; i++) {
		a[i] = sc.nextInt();
	}
	Arrays.sort(a);
	System.out.println("Sorted array "+ Arrays.toString(a));
}
public void DuplicateElement() {
	int arr[] = new int[] {1, 2, 3, 4, 2, 7, 8, 8, 3};
	for(int i = 0; i < arr.length; i++) {
		for(int j = i + 1; j < arr.length; j++) {
			if(arr[i] == arr[j]) {
				System.out.print("\n Duplicate elements are: "+ arr[j]);
			}
		}
	}
}
public void descendingOrder() {
	//Collections.reverseOrder do not work for primitive Types 
    //define an array with Integer
	
    Integer[] IntArray = {52, 45, 32, 64, 12, 87, 78, 98, 23, 7};  
    int size = IntArray.length;
    //print original array
    System.out.printf("Original Array: %s", 
             Arrays.toString(IntArray)); 

    // Sorts IntArray in descending order 
    Arrays.sort(IntArray, Collections.reverseOrder()); 

    //print sorted array  
    System.out.printf("\n\nSorted Array: %s", 
           Arrays.toString(IntArray)); 
    int res = IntArray[size - 2];
    System.out.printf("\n\nSecond least value: %s", 
    		res); 
    
}
	public static void main(String[] args) {
		String str = "Nadiya";
		int num = 1223221;
		String expected = "MADAM";
		Pactise pr = new Pactise();
		// pr.launchBrowser();
		// pr.reverseString(str);
		// pr.printIncrementalOrder();
		// pr.printStar();
		// pr.reverseString1(str);
		// pr.CheckPalindromeNumberOrNot(num);
		//pr.CheckStringIsPalindromeORNot(expected);
		//pr.findtheSecondLargestNum();
		//pr.ascendingOrder();
		//pr.printValuesInAscendingOrder();
		//pr.DuplicateElement();
		pr.descendingOrder();
	}

}
