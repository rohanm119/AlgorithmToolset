package sorting;

public class HeapSort {
	public static void heapSort(int[] arr){
		for(int i = arr.length/2; i >= 0; i--){
			heapify(arr, arr.length, i);
		}
		
		int size = arr.length;
		while(size > 0){
			swap(arr, 0, size-1);
			size--;
			heapify(arr, size, 0);
		}
		
	}
	
	private static void heapify(int[] arr, int size, int root){
		int largest = root;
		int leftChild = root*2 + 1;
		int rightChild = root*2 + 2;
		
		if(leftChild < size && arr[leftChild] > arr[largest]){
			largest = leftChild;
		}
		
		if(rightChild < size && arr[rightChild] > arr[largest]){
			largest = rightChild;
		}
		
		if(largest != root){
			swap(arr, root, largest);
			heapify(arr, size, largest);
		}
	}
	
	private static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
