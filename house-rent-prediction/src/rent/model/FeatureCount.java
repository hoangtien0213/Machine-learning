package rent.model;

import java.util.ArrayList;
import java.util.List;

public class FeatureCount {
	int count = 0;
	
	public FeatureCount(int count, List<String> cost) {
		super();
		this.count = count;
		this.cost = cost;
	}

	public FeatureCount() {

	}

	public FeatureCount(int count, String cost) {
		super();
		this.count = count;
		this.cost.add(cost);
	}

	List<String> cost = new ArrayList<>();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getCost() {
		return cost;
	}

	public void setCost(List<String> cost) {
		this.cost = cost;
	}
}
