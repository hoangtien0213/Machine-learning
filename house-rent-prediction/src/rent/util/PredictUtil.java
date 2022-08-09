package rent.util;

import java.util.ArrayList;
import java.util.List;

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
		int n =houseDataList.size();
		double sum_error=0;
		for (int i=0;i<n;i++) {
			double cost=result[i]-predict(houseDataList.get(i),weight);
			sum_error +=Math.pow(cost, 2);
		}
		return sum_error/Double.valueOf(n);
	}

	
	// Todo
	public WeightsModel updateWeight(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight, double learningRate) {
		return new WeightsModel();
	}
	
	public WeightsModel train(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight, double learningRate, int iter) {
		List<String> cost_his = new ArrayList<String>();
		for (int i =0;i<iter;i++) {
			weight=updateWeight(houseDataList, result, weight, learningRate);
			double cost = costFuncition(houseDataList, result, weight);
			cost_his.add(String.valueOf(cost));
		}
		
		System.out.println(cost_his.toString());
		return weight;
	}
	

}
