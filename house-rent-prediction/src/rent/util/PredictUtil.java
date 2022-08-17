package rent.util;

import java.util.ArrayList;
import java.util.List;

import rent.model.HouseDataModel;
import rent.model.PredictModel;
import rent.model.WeightsModel;

public class PredictUtil {

	public double predict(HouseDataModel houseData, WeightsModel weight) {
		double cost = 0;

		cost = weight.getWeightOfdeposit() * houseData.getDeposit()
				+ weight.getWeightOfKeyMoney() * houseData.getKeyMoney()
				+ weight.getWeightOfAddress() * houseData.getAddress()
				+ weight.getWeightOfTimeToStation() * houseData.getTimeToStation()
				+ weight.getWeightOfStructureAndDesign() * houseData.getStructureAndDesign()
				+ weight.getweightOfTotalUsableArea() * houseData.getTotalUsableArea()
				+ weight.getWeightOfNumberYears() * houseData.getNumberOfYearsSinceConstruction()
				+ weight.getWeightOfFloor() * houseData.getFloor()
				+ weight.getWeightOfDirection() * houseData.getDirection()
				+ weight.getWeightOfKindsOfHouse() * houseData.getKindsOfHouse()
				+ weight.getWeightOfFeaturesAndEquipment() * houseData.getFeaturesAndEquipment()
				+ weight.getWeightOfDetailsOfRooms() * houseData.getDetailsOfRooms()
				+ weight.getWeightOfTexture() * houseData.getTexture()
				+ weight.getWeightOfTotalFloor() * houseData.getTotalFloor()
				+ weight.getWeightOfYearsOfConstruction() * houseData.getYearsOfConstruction()
				+ weight.getWeightOfInsurance() * houseData.getInsurance()
				+ weight.getWeightOfParkingLot() * houseData.getParkingLot()
				+ weight.getWeightOfGoIn() * houseData.getGoIn()
				+ weight.getWeightOfTransactionForm() * houseData.getTransactionForm()
				+ weight.getWeightOfCondition() * houseData.getCondition()
				+ weight.getWeightOfTotalNumberOfApartments() * houseData.getTotalNumberOfApartments()
				+ weight.getBias();

		return cost;
	}

	/***
	 * 
	 * @param houseDataList
	 * @param result
	 * @param weight
	 * @return
	 */
	public double costFuncition(List<HouseDataModel> houseDataList, List<PredictModel> result, WeightsModel weight) {
		int n = houseDataList.size();
		double sum_error = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Predict:"+i+ " " + predict(houseDataList.get(i), weight));
			double cost = Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight);
			sum_error += Math.pow(cost, 2);
		}
		return sum_error / Double.valueOf(n);
	}

	/***
	 * Update Weight Function
	 * 
	 * @param houseDataList
	 * @param result
	 * @param weight
	 * @param learningRate
	 * @return WeightsModel
	 */
	public WeightsModel updateWeight(List<HouseDataModel> houseDataList, List<PredictModel> result, WeightsModel weight,
			double learningRate) {
		double bias_temp = 0, weightOfTimeToStation_temp = 0, weightOfStructureAndDesign_temp = 0,
				weightOfTotalUsableArea_temp = 0, weightOfNumberYears_temp = 0, weightOfFloor_temp = 0,
				weightOfKindsOfHouse_temp = 0, weightOfFeaturesAndEquipment_temp = 0;

		int n = houseDataList.size();
		for (int i = 0; i < n; i++) {
			weightOfTimeToStation_temp += -2 * houseDataList.get(i).getTimeToStation()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfStructureAndDesign_temp += -2 * houseDataList.get(i).getStructureAndDesign()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfTotalUsableArea_temp += -2 * houseDataList.get(i).getTotalUsableArea()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfNumberYears_temp += -2 * houseDataList.get(i).getNumberOfYearsSinceConstruction()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfFloor_temp += -2 * houseDataList.get(i).getFloor()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfKindsOfHouse_temp += -2 * houseDataList.get(i).getKindsOfHouse()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
			weightOfFeaturesAndEquipment_temp += -2 * houseDataList.get(i).getFeaturesAndEquipment()
					* (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));

			bias_temp += -2 * (Double.parseDouble(result.get(i).getCost()) - predict(houseDataList.get(i), weight));
		}

		WeightsModel weightNew = new WeightsModel();
		weightNew.setBias(weight.getBias() - (bias_temp / n) * learningRate);
		weightNew.setWeightOfTimeToStation(
				weight.getWeightOfTimeToStation() - (weightOfTimeToStation_temp / n) * learningRate);
		weightNew.setWeightOfStructureAndDesign(
				weight.getWeightOfStructureAndDesign() - (weightOfStructureAndDesign_temp / n) * learningRate);
		weightNew.setWeightOfTotalUsableArea(
				weight.getWeightOfTotalNumberOfApartments() - (weightOfTotalUsableArea_temp / n) * learningRate);
		weightNew.setWeightOfNumberYears(
				weight.getWeightOfNumberYears() - (weightOfNumberYears_temp / n) * learningRate);
		weightNew.setWeightOfFloor(weight.getWeightOfFloor() - (weightOfFloor_temp / n) * learningRate);
		weightNew.setWeightOfKindsOfHouse(
				weight.getWeightOfKindsOfHouse() - (weightOfKindsOfHouse_temp / n) * learningRate);
		weightNew.setWeightOfFeaturesAndEquipment(
				weight.getWeightOfFeaturesAndEquipment() - (weightOfFeaturesAndEquipment_temp / n) * learningRate);
		return weightNew;
	}

	public WeightsModel train(List<HouseDataModel> houseDataList, List<PredictModel> result, WeightsModel weight,
			double learningRate, int iter) {
		List<String> cost_his = new ArrayList<String>();
		for (int i = 0; i < iter; i++) {
			weight = updateWeight(houseDataList, result, weight, learningRate);
			double cost = costFuncition(houseDataList, result, weight);
			cost_his.add(String.valueOf(cost));
		}

		System.out.println(cost_his.toString());
		return weight;
	}
}
