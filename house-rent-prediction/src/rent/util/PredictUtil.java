package rent.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rent.model.HouseCsvModel;
import rent.model.HouseDataModel;
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

	public double costFuncition(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight) {
		int n = houseDataList.size();
		double sum_error = 0;
		for (int i = 0; i < n; i++) {
			double cost = result[i] - predict(houseDataList.get(i), weight);
			sum_error += Math.pow(cost, 2);
		}
		return sum_error / Double.valueOf(n);
	}

	// Todo
	public WeightsModel updateWeight(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight,
			double learningRate) {
		double bias_temp = 0, weightOfdeposit_temp = 0, weightOfKeyMoney_temp = 0, weightOfAddress_temp = 0,
				weightOfTimeToStation_temp = 0, weightOfStructureAndDesign_temp = 0, weightOfTotalUsableArea_temp = 0,
				weightOfNumberYears_temp = 0, weightOfFloor_temp = 0, weightOfDirection_temp = 0,
				weightOfKindsOfHouse_temp = 0, weightOfFeaturesAndEquipment_temp = 0, weightOfDetailsOfRooms_temp = 0,
				weightOfTexture_temp = 0, weightOfTotalFloor_temp = 0, weightOfYearsOfConstruction_temp = 0,
				weightOfInsurance_temp = 0, weightOfParkingLot_temp = 0, weightOfGoIn_temp = 0,
				weightOfTransactionForm_temp = 0, weightOfCondition_temp = 0, weightOfTotalNumberOfApartments_temp = 0;

		int n = houseDataList.size();
		for (int i = 0; i < n; i++) {
			weightOfdeposit_temp += -2 * houseDataList.get(i).getDeposit()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfKeyMoney_temp += -2 * houseDataList.get(i).getKeyMoney()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfAddress_temp += -2 * houseDataList.get(i).getAddress()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfTimeToStation_temp += -2 * houseDataList.get(i).getTimeToStation()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfStructureAndDesign_temp += -2 * houseDataList.get(i).getStructureAndDesign()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfTotalUsableArea_temp += -2 * houseDataList.get(i).getTotalUsableArea()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfNumberYears_temp += -2 * houseDataList.get(i).getNumberOfYearsSinceConstruction()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfFloor_temp += -2 * houseDataList.get(i).getFloor()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfDirection_temp += -2 * houseDataList.get(i).getDirection()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfKindsOfHouse_temp += -2 * houseDataList.get(i).getKindsOfHouse()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfFeaturesAndEquipment_temp += -2 * houseDataList.get(i).getFeaturesAndEquipment()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfDetailsOfRooms_temp += -2 * houseDataList.get(i).getDetailsOfRooms()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfYearsOfConstruction_temp += -2 * houseDataList.get(i).getYearsOfConstruction()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfInsurance_temp += -2 * houseDataList.get(i).getInsurance()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfParkingLot_temp += -2 * houseDataList.get(i).getParkingLot()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfGoIn_temp += -2 * houseDataList.get(i).getGoIn()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfTransactionForm_temp += -2 * houseDataList.get(i).getTransactionForm()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfCondition_temp += -2 * houseDataList.get(i).getCondition()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfTotalNumberOfApartments_temp += -2 * houseDataList.get(i).getTotalNumberOfApartments()
					* (result[i] - predict(houseDataList.get(i), weight));
			bias_temp += -2 * (result[i] - predict(houseDataList.get(i), weight));
		}

		WeightsModel weightNew = new WeightsModel();
		weightNew.setBias(weight.getBias() - (bias_temp / n) * learningRate);
		weightNew.setWeightOfAddress(weight.getWeightOfAddress() - (weightOfAddress_temp/n)*learningRate);
		return weightNew;
	}

	public WeightsModel train(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight,
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

	// Todo
	private HouseDataModel ConvertCsvToModel(HouseCsvModel data) {
		return new HouseDataModel();

	}
}
