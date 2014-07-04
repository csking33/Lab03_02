import java.util.Scanner;


public class Main 
{
	static int counter;
	static Scanner in = new Scanner(System.in);
	
	public static void main(String [] args)
	{
		run();
	}
	
	public static void run(){
		System.out.println("Would you like to check a new range?");
		
		if(!in.next().equals("n"))
		{			
			int[] nums = fillArray();
			getItem(nums);
		}
	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++){
			System.out.print("Value at index " + i + " = ");
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public static void getItem(int[] arr)
	{
		
		//Get value from user
		System.out.println("Please enter value to search: ");		
		int val = in.nextInt();
		
		//Test to see if value is within parameters
		while(val < arr[arr.length - arr.length] || val > arr[arr.length - 1]){
			System.out.println("Value must be within range");
			val = in.nextInt();
		}
		
		binSearch(val, arr, 0, arr.length-1);
		
		System.out.println("Press y if you would like to search this range again: ");
		if(in.next().equals("y")){
			counter = 0;
			getItem(arr);
		}
		run();
		
	}
	
	public static void binSearch(int val, int[] arr, int start, int end){
		counter++;
		int mid = (start + end) / 2;
		
		//System.out.println(start + " " + mid + " " + end);
		//System.out.println(start - end);
		
		if(val > arr[mid]){
			binSearch(val, arr, mid, end);
		}else if(val < arr[mid]){
			binSearch(val, arr, start, mid);
		}else{
			System.out.println("The program searched " + counter + " times to find " + val);
		}
	}
	
	public static int[] fillArray(){
		System.out.println("Enter beginning of search: ");
		int start = in.nextInt();
		System.out.println("Enter end of search: ");
		int end = in.nextInt();
		
		if((end - start) <= 0)
		{
			System.out.println("Range must be greater than 0");
			fillArray();
		}
		
		int arrayLength = (end - start) + 1;
		//Fill an array with numerically ordered integers
		int[] nums = new int[arrayLength];
		for(int i = 0; i < nums.length; i++){
			nums[i] = i + start;
		}
		
		return nums;
	}
}
