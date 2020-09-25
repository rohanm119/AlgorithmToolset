package sorting;

public class SelectionSort {
	
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length-1; i++){
			int minIndex = i, minValue = arr[i];
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < minValue){
					minIndex = j;
					minValue = arr[j];
				}
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}
