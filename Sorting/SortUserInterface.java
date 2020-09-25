package sorting;

import java.util.Random;
import java.util.Scanner;

public class SortUserInterface {
	public static int[] getManualArray(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nMANUAL ARRAY CREATION");
		System.out.print("Enter size of array:");
		int n = sc.nextInt();
		
		int[] res = new int[n];
		System.out.println("\n\nEnter " + n + " elements with spaces in between or one by one");
		for(int i = 0; i < n; i++){
			res[i] = sc.nextInt();
		}
		
		return res;
	}
	
	
	public static int[] getRandomArray(){
		int maxValue = 10000000;
		Random random = new Random();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nRANDOM ARRAY CREATION");
		System.out.print("Enter size of array:");
		int n = sc.nextInt();
		sc.close();
		
		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			res[i] = random.nextInt(maxValue);
		}
		
		return res;
	}
	
	
	public static void print(int[] arr){
		if(arr.length > 100){
			//System.out.println("\n\nToo many numbers in array:" + arr.length);
			return;
		}
		System.out.println("\n\nPRINTING ARRAY");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void printTimeElapsed(double duration){
		System.out.print("\nTime elapsed: ");
		if(duration > 100000000){
			duration /= 1000000000;
			System.out.println(duration + " seconds");
		}
		else if(duration > 10000){
			duration /= 1000000;
			System.out.println(duration + " milliseconds");
		}
		
		else{
			System.out.println(duration + " nanaoseconds");
		}
	}
	
	
	public static int[] acceptArray(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n-----------------------------------------------");
		System.out.println("Select method for input");
		System.out.print("\n1. Manually(Enter numbers)\n2. Generate random array\n3. Exit\nEnter:");
		int choice = sc.nextInt();
		
		if(choice == 3){
			System.out.println("\n\nProgram exited successfully! Thank you");
			System.exit(0);
		}
		if(choice <= 0 || choice > 3){
			System.out.println("\nInvalid choice detected:" + choice + ", Run program again with correct input!");
			System.exit(0);
		}
		
		return (choice == 1)? getManualArray(): getRandomArray();
	}

	
	public static boolean checkSortedArray(int[] arr){
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i-1]){
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args){
		int[] arr = acceptArray();
		
		long startTime = System.nanoTime();
		//BubbleSort.bubbleSort(arr);
		//SelectionSort.selectionSort(arr);
		//MergeSort.mergeSort(arr);
		//InsertionSort.insertionSort(arr);
		QuickSort.quickSort(arr);
		long endTime = System.nanoTime();
		
		print(arr);
		System.out.println("SortedArrayCheck:" + checkSortedArray(arr));
		printTimeElapsed(endTime - startTime);
	}
}
