
public class Item {
	private int weight;
	private int profit;
	public Item(int weight, int profit) {
		super();
		this.weight = weight;
		this.profit = profit;
	}
	public int getWeight() {
		return weight;
	}
	public int getProfit() {
		return profit;
	}
	@Override
	public String toString() {
		return "[" + weight + ", " + profit + "]";
	}
	
}
