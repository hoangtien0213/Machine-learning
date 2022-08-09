package rent.model;

public class PredictModel {
    
    private String id;
    private String cost;

    public PredictModel() {}

    public PredictModel(String id, String cost) {
        this.id = id;
        this.cost = cost;
    }
 
    public void setId(String id) {
		this.id = id;
	}
 
    public void setCost(String cost) {
		this.cost = cost;
	}
    public String getId() {
		return this.id;
	}

	public String getCost() {
		return this.cost;
	}

    public String[] toArrayString() {
		return new String[] {this.id, this.cost};
	}
}
