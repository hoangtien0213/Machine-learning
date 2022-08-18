import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rent.model.HouseCsvModel;
import rent.model.HouseDataModel;
import rent.model.PredictModel;
import rent.model.WeightsModel;
import rent.util.CsvUtil;
import rent.util.PredictUtil;

public class HouseRentPredict {

	private static CsvUtil csvUtil = new CsvUtil();
	private static PredictUtil preUtil = new PredictUtil();
	private static int iter = 5000;

	public static void main(String[] args) throws Exception {

		List<HouseDataModel> dataHouseList = csvUtil.readDataFromCsv("house-rent-prediction/input/test-sample.csv");

		List<PredictModel> predictTraining = csvUtil.readDataPredictFromCsv("house-rent-prediction/input/predict-sample.csv");

		WeightsModel weightModel = // new WeightsModel(0.01200724115958909, 0.26888046354832384, 0.24108944627778836, -0.0001786169253864465, 0.5252432457810584, 0.05228056482654562, 0.06895614126251053, 0.7288311286409825);
        new WeightsModel(1 ,-0.3539915212321787,-1.2939802724592129,2.0733581505609666,0.505053900406873,6063.416879004779,-5.218666781508343,0.729385903514384);

		WeightsModel newWeightModel = preUtil.train(dataHouseList, predictTraining, weightModel, 0.00000000011125, iter);
		System.out.println("newWeightModel:" + newWeightModel);
		List<HouseDataModel> dataHouseForPredict = csvUtil.readDataFromCsv("house-rent-prediction/test.csv");
		List<PredictModel> dataPredictList = new ArrayList<>();
		int index = 0;
		for (HouseDataModel houseDataModel : dataHouseForPredict) {
			index++;
			PredictModel predict = new PredictModel();
			predict.setId(String.valueOf(index));
			predict.setCost(Double.toString(preUtil.predict(houseDataModel, newWeightModel)));
			dataPredictList.add(predict);
		}

		
		
		// Write predict
		csvUtil.writeDataToCsv(dataPredictList);
		// csvUtil.writeDataToHouseCsv(dataHouseList);
	}

}
