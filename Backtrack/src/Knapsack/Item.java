package Knapsack;

public class Item implements Comparable<Item>{
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
	
	public int compareTo(Item o) {
		double id = (double)profit/(double)weight;
		double od = (double)o.profit/(double)o.weight;
		if(od==id)
			return 0;
		else if(od<id)
			return -1;
		else
			return 1;
	}
}
