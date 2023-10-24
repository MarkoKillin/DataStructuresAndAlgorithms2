
public interface PriorityQueue<T extends Comparable<T>> {
	T max();
	T delMax();
	int size();
	void insert(T element);
	boolean isEmpty();
}
