package rent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	/***
	 * 
	 * @param houseDataList
	 * @param result
	 * @param weight
	 * @return
	 */
	public double costFuncition(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight) {
		int n = houseDataList.size();
		double sum_error = 0;
		for (int i = 0; i < n; i++) {
			double cost = result[i] - predict(houseDataList.get(i), weight);
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
	public WeightsModel updateWeight(List<HouseDataModel> houseDataList, int[] result, WeightsModel weight,
			double learningRate) {
		double bias_temp = 0, weightOfTimeToStation_temp = 0, weightOfStructureAndDesign_temp = 0,
				weightOfTotalUsableArea_temp = 0, weightOfNumberYears_temp = 0, weightOfFloor_temp = 0,
				weightOfKindsOfHouse_temp = 0, weightOfFeaturesAndEquipment_temp = 0;

		int n = houseDataList.size();
		for (int i = 0; i < n; i++) {
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
			weightOfKindsOfHouse_temp += -2 * houseDataList.get(i).getKindsOfHouse()
					* (result[i] - predict(houseDataList.get(i), weight));
			weightOfFeaturesAndEquipment_temp += -2 * houseDataList.get(i).getFeaturesAndEquipment()
					* (result[i] - predict(houseDataList.get(i), weight));

			bias_temp += -2 * (result[i] - predict(houseDataList.get(i), weight));
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

	 private HouseDataModel convertCsvToModel(HouseCsvModel csv) {
	        HouseDataModel data = new HouseDataModel();
	        // ID
	        data.setId(csv.getId());

	        // Address
	        // data.setAddress(1);

	        // Time to station
	        final String regex = "\\d+";
	        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	        final Matcher matcher = pattern.matcher(csv.getTimeToStation());
	        long min = 0;
	        int count = 0;
	        while (matcher.find()) {
	            // min += Integer.parseInt(matcher.group(0));
	            if (count == 0) {
	                min = Integer.parseInt(matcher.group(0));
	            } else {
	                long temp = Integer.parseInt(matcher.group(0));
	                if (temp < min) {
	                    min = temp;
	                }
	            }
	            count++;
	        }
	        data.setTimeToStation(min);

	        // StructureAndDesign
	        // https://resources.realestate.co.jp/living/1r-1k-1dk-1ldk-apartment-whats-the-difference-and-which-should-i-rent/
	        // https://resources.realestate.co.jp/living/what-is-a-2ldk-apartment-real-estate-japans-word-of-the-day/
	        if (Constant.WARUMU.equals(csv.getStructureAndDesign())) {
	            data.setStructureAndDesign(1);
	        } else {
	            double roomNum = Double.parseDouble(csv.getStructureAndDesign().substring(0, 1));
	            // Moi phong L,D,K ~ 1/3 Bed room (30%)
	            double subRoom = (csv.getStructureAndDesign().length() - 1) / 3.0;
	            data.setStructureAndDesign(roomNum + subRoom);
	        }

	        // totalAsableArea
	        data.setTotalUsableArea(
	                Double.parseDouble(csv.getTotalUsableArea().substring(0, csv.getTotalUsableArea().length() - 2)));

	        // numberOfYearsSinceConstruction
	        if (Constant.HOUSE_NEW.equals(csv.getNumberOfYearsSinceConstruction())) {
	            data.setNumberOfYearsSinceConstruction(1);
	        } else {
	            data.setNumberOfYearsSinceConstruction(
	                    Double.parseDouble(csv.getNumberOfYearsSinceConstruction().replaceAll("\\D", "")));
	        }

	        // floor
	        if (Constant.DASHES.equals(csv.getFloor())) {
	            data.setFloor(1);
	        } else {
	            data.setFloor(Double.parseDouble(csv.getFloor().substring(0, 1)));
	        }

	        // kindsOfHouse TODO
	        if (Constant.HOUSE_KIND_MANSHON.equals(csv.getKindsOfHouse())) {
	            data.setKindsOfHouse(5);
	        } else if (Constant.HOUSE_KIND_APAITO.equals(csv.getKindsOfHouse())) {
	            data.setKindsOfHouse(4);
	        } else if (Constant.HOUSE_KIND_DETACHED_HOUSE.equals(csv.getKindsOfHouse())) {
	            data.setKindsOfHouse(3);
	        } else if (Constant.HOUSE_KIND_TOWNHOUSES.equals(csv.getKindsOfHouse())) {
	            data.setKindsOfHouse(2);
	        } else {
	            data.setKindsOfHouse(1);
	        }

	        // featuresAndEquipment
	        data.setFeaturesAndEquipment(csv.getFeaturesAndEquipment().split("、").length);

	        return data;
	    }
	 
		private List<String> findNumber(String stringToSearch) {
		    Pattern integerPattern = Pattern.compile("(-?\\d+(\\.\\d+)?)|(-?\\d+)");
		    Matcher matcher = integerPattern.matcher(stringToSearch);

		    List<String> integerList = new ArrayList<>();
		    while (matcher.find()) {
		        integerList.add(matcher.group());
		    }

		    return integerList;
		}
}
