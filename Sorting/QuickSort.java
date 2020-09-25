package sorting;

public class QuickSort {
	public static void quickSort(int[] arr){
		sort(arr, 0, arr.length-1);
	}
	
	private static void sort(int[] arr, int start, int end){
		if(start >= end){
			return;
		}
		
		int index = partition(arr, start, end);
		sort(arr, start, index-1);
		sort(arr, index+1, end);
	}
	
	private static int partition(int[] arr, int start, int end){
		int pivot = arr[start];
		
		int index = start;
		for(int i = start+1; i <= end; i++){
			if(arr[i] < pivot){
				index++;
				swap(arr, index, i);
			}
		}
		
		swap(arr, start, index);
		return index;
	}
	
	private static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
