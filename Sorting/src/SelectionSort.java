
public class SelectionSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = arr.length-1; i >0; i--) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if(arr[max].compareTo(arr[j]) < 0)
					max = j;
			}
			if(max!=i) {
				T tmp = arr[i];
				arr[i] = arr[max];
				arr[max] = tmp;
			}
		}
	}
	
	public static <T extends Comparable<T>> void sortv2(T[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[min].compareTo(arr[j]) > 0)
					min = j;
			}
			if(min!=i) {
				T tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}
}
