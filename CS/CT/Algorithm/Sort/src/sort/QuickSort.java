package sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arraySet = { 10, 5, 6, 4, 8, 2, 1, 3, 7, 9 };
		printArray(arraySet);
		quickSort(arraySet);
		System.out.println();
		printArray(arraySet);
		
	}

	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if (start < part2 - 1) {
			quickSort(arr, start, part2 - 1);
		}
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end)/2];
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot)end--;
			if(start <= end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		// TODO Auto-generated method stub
		
	}
	private static void printArray(int[] arr) {
		for(int data :arr) {
			 System.out.printf("%2d ",data);
		}
	}

}
