
public class SortableList<T extends Comparable<T>> {
	private Node root = null;
	private class Node{
		T info;
		Node next;
		public Node(T info) {
			super();
			this.info = info;
		}
	}
	public void add(T element) {
		Node n = new Node(element);
		n.next = root;
		root = n;
	}
	
	public void insertionSort() {
		if(root==null || root.next==null)
			return;
		Node lastSorted = root;
		while(lastSorted.next!=null) {
			Node firstUnsorted = lastSorted.next;
			if(lastSorted.info.compareTo(firstUnsorted.info) <= 0)
				lastSorted = firstUnsorted;
			else if(lastSorted.info.compareTo(root.info) < 0) {
				lastSorted.next = firstUnsorted.next;
				firstUnsorted.next = root;
				root = firstUnsorted;
			} else {
				Node prev = null, curr = root;
				while(curr.info.compareTo(firstUnsorted.info) <= 0) {
					prev = curr;
					curr = curr.next;
				}				
				lastSorted.next = firstUnsorted.next;
				firstUnsorted.next = prev.next;
				prev.next = firstUnsorted;
			}
		}
	}
	
	public void mergeSort() {
		if(root!=null)
			root = mergeSort(root);
	}

	private Node mergeSort(Node start) {
		if(start.next==null)
			return start;
		Node l1 = start, l1End = l1;
		Node l2 = start.next, l2End = l2;
		Node current = start.next.next;
		while(current!=null) {
			l1End.next = current;
			l1End = current;
			current = current.next;
			if(current!=null) {
				l2End.next = current;
				l2End = current;
				current = current.next;
			}
		}
		l1End.next = null;
		l2End.next = null;
		l1 = mergeSort(l1);
		l2 = mergeSort(l2);
		
		return merge(l1, l2);
	}
	
	private Node merge(Node l1, Node l2) {
		Node root = null;
		if(l1.info.compareTo(l2.info) < 0) {
			root = l1;
			l1 = l1.next;
		} else {
			root = l2;
			l2 = l2.next;
		}
		Node end = root;
		while(l1!=null && l2!=null) {
			if(l1.info.compareTo(l2.info) < 0) {
				end.next = l1;
				end = l1;
				l1 = l1.next;
			} else {
				end.next = l2;
				end = l2;
				l2 = l2.next;
			}
		}
		end.next = l1==null ? l2 : l1;
		return root;
	}
	
	public void quickSort() {
		if(root!=null)
			root = quickSort(root);
	}

	private Node quickSort(Node start) {
		if(start.next==null)
			return start;
		Node pivot = start;
		Node smaller = null, greater = null;
		Node curr = pivot.next;
		while(curr!=null) {
			Node afterCurrent = curr.next;
			if(curr.info.compareTo(pivot.info) < 0) {
				curr.next = smaller;
				smaller = curr;
			} else {
				curr.next = greater;
				greater = curr;
			}
			curr = afterCurrent;
		}
		if(smaller!=null)
			smaller = quickSort(smaller);
		if(greater!=null)
			greater=quickSort(greater);
		pivot.next=greater;
		if(smaller==null)
			return pivot;
		else {
			Node tmp = smaller;
			while(tmp.next!=null)
				tmp = tmp.next;
			tmp.next = pivot;
			return smaller;
		}
	}
}






















