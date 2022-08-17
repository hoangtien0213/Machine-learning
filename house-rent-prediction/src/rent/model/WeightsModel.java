package rent.model;

public class WeightsModel {

	public WeightsModel() {

	};

	public WeightsModel(double bias, double weightOfTimeToStation, double weightOfStructureAndDesign,
			double weightOfTotalUsableArea, double weightOfNumberYears, double weightOfFloor,
			double weightOfKindsOfHouse, double weightOfFeaturesAndEquipment) {
		super();
		this.bias = bias;
		this.weightOfTimeToStation = weightOfTimeToStation;
		this.weightOfStructureAndDesign = weightOfStructureAndDesign;
		this.weightOfTotalUsableArea = weightOfTotalUsableArea;
		this.weightOfNumberYears = weightOfNumberYears;
		this.weightOfFloor = weightOfFloor;
		this.weightOfKindsOfHouse = weightOfKindsOfHouse;
		this.weightOfFeaturesAndEquipment = weightOfFeaturesAndEquipment;
	}

	public WeightsModel(double bias, double weightOfdeposit, double weightOfKeyMoney, double weightOfAddress,
			double weightOfTimeToStation, double weightOfStructureAndDesign, double weightOfTotalUsableArea,
			double weightOfNumberYears, double weightOfFloor, double weightOfDirection, double weightOfKindsOfHouse,
			double weightOfFeaturesAndEquipment, double weightOfDetailsOfRooms, double weightOfTexture,
			double weightOfTotalFloor, double weightOfYearsOfConstruction, double weightOfInsurance,
			double weightOfParkingLot, double weightOfGoIn, double weightOfTransactionForm, double weightOfCondition,
			double weightOfTotalNumberOfApartments) {
		super();
		this.bias = bias;
		this.weightOfdeposit = weightOfdeposit;
		this.weightOfKeyMoney = weightOfKeyMoney;
		this.weightOfAddress = weightOfAddress;
		this.weightOfTimeToStation = weightOfTimeToStation;
		this.weightOfStructureAndDesign = weightOfStructureAndDesign;
		this.weightOfTotalUsableArea = weightOfTotalUsableArea;
		this.weightOfNumberYears = weightOfNumberYears;
		this.weightOfFloor = weightOfFloor;
		this.weightOfDirection = weightOfDirection;
		this.weightOfKindsOfHouse = weightOfKindsOfHouse;
		this.weightOfFeaturesAndEquipment = weightOfFeaturesAndEquipment;
		this.weightOfDetailsOfRooms = weightOfDetailsOfRooms;
		this.weightOfTexture = weightOfTexture;
		this.weightOfTotalFloor = weightOfTotalFloor;
		this.weightOfYearsOfConstruction = weightOfYearsOfConstruction;
		this.weightOfInsurance = weightOfInsurance;
		this.weightOfParkingLot = weightOfParkingLot;
		this.weightOfGoIn = weightOfGoIn;
		this.weightOfTransactionForm = weightOfTransactionForm;
		this.weightOfCondition = weightOfCondition;
		this.weightOfTotalNumberOfApartments = weightOfTotalNumberOfApartments;
	}

	double bias = 0;

	double weightOfdeposit = 0;

	double weightOfKeyMoney = 0;

	double weightOfAddress = 0;

	double weightOfTimeToStation = 0;

	double weightOfStructureAndDesign = 0;

	double weightOfTotalUsableArea = 0;

	double weightOfNumberYears = 0;

	double weightOfFloor = 0;

	double weightOfDirection = 0;

	double weightOfKindsOfHouse = 0;

	double weightOfFeaturesAndEquipment = 0;

	double weightOfDetailsOfRooms = 0;

	double weightOfTexture = 0;

	double weightOfTotalFloor = 0;

	double weightOfYearsOfConstruction = 0;

	double weightOfInsurance = 0;

	double weightOfParkingLot = 0;

	double weightOfGoIn = 0;

	double weightOfTransactionForm = 0;

	double weightOfCondition = 0;

	double weightOfTotalNumberOfApartments = 0;

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}

	public double getWeightOfdeposit() {
		return weightOfdeposit;
	}

	public void setWeightOfdeposit(double weightOfdeposit) {
		this.weightOfdeposit = weightOfdeposit;
	}

	public double getWeightOfKeyMoney() {
		return weightOfKeyMoney;
	}

	public void setWeightOfKeyMoney(double weightOfFestiveMoney) {
		this.weightOfKeyMoney = weightOfFestiveMoney;
	}

	public double getWeightOfAddress() {
		return weightOfAddress;
	}

	public void setWeightOfAddress(double weightOfAddress) {
		this.weightOfAddress = weightOfAddress;
	}

	public double getWeightOfTimeToStation() {
		return weightOfTimeToStation;
	}

	public void setWeightOfTimeToStation(double weightOfTimeToStation) {
		this.weightOfTimeToStation = weightOfTimeToStation;
	}

	public double getWeightOfStructureAndDesign() {
		return weightOfStructureAndDesign;
	}

	public void setWeightOfStructureAndDesign(double weightOfStructureAndDesign) {
		this.weightOfStructureAndDesign = weightOfStructureAndDesign;
	}

	public double getweightOfTotalUsableArea() {
		return weightOfTotalUsableArea;
	}

	public void setWeightOfTotalUsableArea(double weightOfTotalAsableArea) {
		this.weightOfTotalUsableArea = weightOfTotalAsableArea;
	}

	public double getWeightOfNumberYears() {
		return weightOfNumberYears;
	}

	public void setWeightOfNumberYears(double weightOfNumberYears) {
		this.weightOfNumberYears = weightOfNumberYears;
	}

	public double getWeightOfFloor() {
		return weightOfFloor;
	}

	public void setWeightOfFloor(double weightOfFloor) {
		this.weightOfFloor = weightOfFloor;
	}

	public double getWeightOfDirection() {
		return weightOfDirection;
	}

	public void setWeightOfDirection(double weightOfDirection) {
		this.weightOfDirection = weightOfDirection;
	}

	public double getWeightOfKindsOfHouse() {
		return weightOfKindsOfHouse;
	}

	public void setWeightOfKindsOfHouse(double weightOfKindsOfHouse) {
		this.weightOfKindsOfHouse = weightOfKindsOfHouse;
	}

	public double getWeightOfFeaturesAndEquipment() {
		return weightOfFeaturesAndEquipment;
	}

	public void setWeightOfFeaturesAndEquipment(double weightOfFeaturesAndEquipment) {
		this.weightOfFeaturesAndEquipment = weightOfFeaturesAndEquipment;
	}

	public double getWeightOfDetailsOfRooms() {
		return weightOfDetailsOfRooms;
	}

	public void setWeightOfDetailsOfRooms(double weightOfDetailsOfRooms) {
		this.weightOfDetailsOfRooms = weightOfDetailsOfRooms;
	}

	public double getWeightOfTexture() {
		return weightOfTexture;
	}

	public void setWeightOfTexture(double weightOfTexture) {
		this.weightOfTexture = weightOfTexture;
	}

	public double getWeightOfTotalFloor() {
		return weightOfTotalFloor;
	}

	public void setWeightOfTotalFloor(double weightOfTotalFloor) {
		this.weightOfTotalFloor = weightOfTotalFloor;
	}

	public double getWeightOfYearsOfConstruction() {
		return weightOfYearsOfConstruction;
	}

	public void setWeightOfYearsOfConstruction(double weightOfYearsOfConstruction) {
		this.weightOfYearsOfConstruction = weightOfYearsOfConstruction;
	}

	public double getWeightOfInsurance() {
		return weightOfInsurance;
	}

	public void setWeightOfInsurance(double weightOfInsurance) {
		this.weightOfInsurance = weightOfInsurance;
	}

	public double getWeightOfParkingLot() {
		return weightOfParkingLot;
	}

	public void setWeightOfParkingLot(double weightOfParkingLot) {
		this.weightOfParkingLot = weightOfParkingLot;
	}

	public double getWeightOfGoIn() {
		return weightOfGoIn;
	}

	public void setWeightOfGoIn(double weightOfGoIn) {
		this.weightOfGoIn = weightOfGoIn;
	}

	public double getWeightOfTransactionForm() {
		return weightOfTransactionForm;
	}

	public void setWeightOfTransactionForm(double weightOfTransactionForm) {
		this.weightOfTransactionForm = weightOfTransactionForm;
	}

	public double getWeightOfCondition() {
		return weightOfCondition;
	}

	public void setWeightOfCondition(double weightOfCondition) {
		this.weightOfCondition = weightOfCondition;
	}

	public double getWeightOfTotalNumberOfApartments() {
		return weightOfTotalNumberOfApartments;
	}

	public void setWeightOfTotalNumberOfApartments(double weightOfTotalNumberOfApartments) {
		this.weightOfTotalNumberOfApartments = weightOfTotalNumberOfApartments;
	}

	@Override
	public String toString() {
		return "WeightsModel [bias=" + bias + ", weightOfdeposit=" + weightOfdeposit + ", weightOfKeyMoney="
				+ weightOfKeyMoney + ", weightOfAddress=" + weightOfAddress + ", weightOfTimeToStation="
				+ weightOfTimeToStation + ", weightOfStructureAndDesign=" + weightOfStructureAndDesign
				+ ", weightOfTotalUsableArea=" + weightOfTotalUsableArea + ", weightOfNumberYears="
				+ weightOfNumberYears + ", weightOfFloor=" + weightOfFloor + ", weightOfDirection=" + weightOfDirection
				+ ", weightOfKindsOfHouse=" + weightOfKindsOfHouse + ", weightOfFeaturesAndEquipment="
				+ weightOfFeaturesAndEquipment + ", weightOfDetailsOfRooms=" + weightOfDetailsOfRooms
				+ ", weightOfTexture=" + weightOfTexture + ", weightOfTotalFloor=" + weightOfTotalFloor
				+ ", weightOfYearsOfConstruction=" + weightOfYearsOfConstruction + ", weightOfInsurance="
				+ weightOfInsurance + ", weightOfParkingLot=" + weightOfParkingLot + ", weightOfGoIn=" + weightOfGoIn
				+ ", weightOfTransactionForm=" + weightOfTransactionForm + ", weightOfCondition=" + weightOfCondition
				+ ", weightOfTotalNumberOfApartments=" + weightOfTotalNumberOfApartments + "]";
	}
}
