
public class HeapSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		int lastIndex = arr.length-1;
		int lastParent = (lastIndex-1)/2;
		while(lastParent>=0) {
			makeHeap(arr,lastParent,lastIndex);
			lastParent--;
		}
		int end = lastIndex;
		while(end>0) {
			T tmp = arr[0];
			arr[0] = arr[end];
			arr[end] = tmp;
			
			end--;
			makeHeap(arr, 0, end);
		}
	}

	private static <T extends Comparable<T>> void makeHeap(T[] arr, int parent, int end) {
		boolean heapRestored = false;
		while(!heapRestored) {
			int maxSonIndex = getMaxSon(arr,parent,end);
			if(maxSonIndex==-1)
				heapRestored = true;
			else {
				if(arr[parent].compareTo(arr[maxSonIndex]) > 0)
					heapRestored = true;
				else {
					T tmp = arr[parent];
					arr[parent] = arr[maxSonIndex];
					arr[maxSonIndex] = tmp;
					parent = maxSonIndex;
				}
			}
		}
	}

	private static <T extends Comparable<T>> int getMaxSon(T[] arr, int parent, int end) {
		int max = -1;
		int s1i = 2*parent+1;
		int s2i = 2*parent+2;
		if(s1i<=end)
			max = s1i;
		else {
			if(s2i<=end) {
				if(arr[s1i].compareTo(arr[s2i]) < 0)
					max = s2i;
			}
		}
		return max;
	}

}
