package def;

public class Btnode<T extends Comparable> implements Comparable<Btnode<T>> {
	private T info;
	private Btnode<T> left,right;
	public Btnode(T info, Btnode<T> left, Btnode<T> right) {
		super();
		this.info = info;
		this.left = left;
		this.right = right;
	}
	public Btnode(T info) {
		super();
		this.info = info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Btnode<T> getLeft() {
		return left;
	}
	public void setLeft(Btnode<T> left) {
		this.left = left;
	}
	public Btnode<T> getRight() {
		return right;
	}
	public void setRight(Btnode<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return info.toString();
	}
	@Override
	public int compareTo(Btnode<T> o) {
		return info.compareTo(o.getInfo());
	}
	
	
}
