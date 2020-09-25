package sorting;

public class MergeSort {
	public static void mergeSort(int[] arr){
		sort(arr, 0, arr.length-1);
	}
	
	private static void sort(int[] arr, int start, int end){
		if(start >= end){
			return;
		}
		
		int mid = (int)Math.floor((start + end) / 2);
		
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		merge(arr, start, end);
	}
	
	private static void merge(int[] arr, int start, int end){
		int mid = (int)Math.floor((start + end) / 2);
		int left = start, right = mid+1;
		
		int[] buffer = new int[end-start+1];
		
		int k = 0;
		while(left <= mid && right <= end){
			if(arr[left] < arr[right]){
				buffer[k++] = arr[left++];
			}
			else{
				buffer[k++] = arr[right++];
			}
		}
		
		while(left <= mid){
			buffer[k++] = arr[left++];
		}
		
		while(right <= end){
			buffer[k++] = arr[right++];
		}
		
		for(int i = 0; i < buffer.length; i++){
			arr[i+start] = buffer[i];
		}
	}
}
