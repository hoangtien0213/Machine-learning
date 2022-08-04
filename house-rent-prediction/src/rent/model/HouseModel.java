package rent.model;

public class HouseModel {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getFestiveMoney() {
		return festiveMoney;
	}

	public void setFestiveMoney(String festiveMoney) {
		this.festiveMoney = festiveMoney;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTimeToStation() {
		return timeToStation;
	}

	public void setTimeToStation(String timeToStation) {
		this.timeToStation = timeToStation;
	}

	public String getStructureAndDesign() {
		return structureAndDesign;
	}

	public void setStructureAndDesign(String structureAndDesign) {
		this.structureAndDesign = structureAndDesign;
	}

	public String getTotalAsableArea() {
		return totalAsableArea;
	}

	public void setTotalAsableArea(String totalAsableArea) {
		this.totalAsableArea = totalAsableArea;
	}

	public String getNumberOfYearsSinceConstruction() {
		return numberOfYearsSinceConstruction;
	}

	public void setNumberOfYearsSinceConstruction(String numberOfYearsSinceConstruction) {
		this.numberOfYearsSinceConstruction = numberOfYearsSinceConstruction;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getKindsOfHouse() {
		return KindsOfHouse;
	}

	public void setKindsOfHouse(String kindsOfHouse) {
		KindsOfHouse = kindsOfHouse;
	}

	public String getFeaturesAndEquipment() {
		return featuresAndEquipment;
	}

	public void setFeaturesAndEquipment(String featuresAndEquipment) {
		this.featuresAndEquipment = featuresAndEquipment;
	}

	public String getDetailsOfRooms() {
		return detailsOfRooms;
	}

	public void setDetailsOfRooms(String detailsOfRooms) {
		this.detailsOfRooms = detailsOfRooms;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(String totalFloor) {
		this.totalFloor = totalFloor;
	}

	public String getYearsOfConstruction() {
		return yearsOfConstruction;
	}

	public void setYearsOfConstruction(String yearsOfConstruction) {
		this.yearsOfConstruction = yearsOfConstruction;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(String parkingLot) {
		this.parkingLot = parkingLot;
	}

	public String getGoIn() {
		return goIn;
	}

	public void setGoIn(String goIn) {
		this.goIn = goIn;
	}

	public String getTransactionForm() {
		return transactionForm;
	}

	public void setTransactionForm(String transactionForm) {
		this.transactionForm = transactionForm;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTotalNumberOfApartments() {
		return totalNumberOfApartments;
	}

	public void setTotalNumberOfApartments(String totalNumberOfApartments) {
		this.totalNumberOfApartments = totalNumberOfApartments;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getNextUpdateDate() {
		return nextUpdateDate;
	}

	public void setNextUpdateDate(String nextUpdateDate) {
		this.nextUpdateDate = nextUpdateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	String deposit;
	
	String festiveMoney;
	
	String address;
	
	String timeToStation;
	
	String structureAndDesign;
	
	String totalAsableArea;
	
	String numberOfYearsSinceConstruction;

	String floor;
	
	String direction;
	
	String KindsOfHouse;
	
	String featuresAndEquipment;
	
	String detailsOfRooms;
	
	String texture;
	
	String totalFloor;
	
	String yearsOfConstruction;
	
	String insurance;
	
	String parkingLot;
	
	String goIn;
	
	String transactionForm;
	
	String condition;
	
	String totalNumberOfApartments;
	
	String updateDate;
	
	String nextUpdateDate;
	
	String remark;
	
	@Override
	public String toString() {
		return "HouseModel [id=" + id + ", deposit=" + deposit + ", festiveMoney=" + festiveMoney + ", address="
				+ address + ", timeToStation=" + timeToStation + ", structureAndDesign=" + structureAndDesign
				+ ", totalAsableArea=" + totalAsableArea + ", numberOfYearsSinceConstruction="
				+ numberOfYearsSinceConstruction + ", floor=" + floor + ", direction=" + direction + ", KindsOfHouse="
				+ KindsOfHouse + ", featuresAndEquipment=" + featuresAndEquipment + ", detailsOfRooms=" + detailsOfRooms
				+ ", texture=" + texture + ", totalFloor=" + totalFloor + ", yearsOfConstruction=" + yearsOfConstruction
				+ ", insurance=" + insurance + ", parkingLot=" + parkingLot + ", goIn=" + goIn + ", transactionForm="
				+ transactionForm + ", condition=" + condition + ", totalNumberOfApartments=" + totalNumberOfApartments
				+ ", updateDate=" + updateDate + ", nextUpdateDate=" + nextUpdateDate + ", remark=" + remark				
				+ "]";
	}
}
