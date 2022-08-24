import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import rent.model.FeatureCount;
import rent.model.HouseCsvModel;
import rent.model.HouseDataModel;
import rent.model.PredictModel;
import rent.model.WeightsModel;
import rent.util.CsvUtil;
import rent.util.PredictUtil;

public class HouseRentPredict {

	private static CsvUtil csvUtil = new CsvUtil();
	private static PredictUtil preUtil = new PredictUtil();
	private static int iter = 8000;

	public static void main(String[] args) throws Exception {

//		List<HouseDataModel> dataHouseList = csvUtil.readDataFromCsv("input/test-sample.csv");
//
//		List<PredictModel> predictTraining = csvUtil.readDataPredictFromCsv("input/predict-sample.csv");
//
//		WeightsModel weightModel = new WeightsModel(0.9838793428044887, 2500.0764934611043, 0.041729796075999796,
//				0.4382543467808115, 0.0343761559746757, 0.4579564754192991, 6063.320421145547, -15.040462757299613,
//				0.7428248079108338);
//
//		WeightsModel newWeightModel = preUtil.train(dataHouseList, predictTraining, weightModel, 0.00000000011125,
//				iter);
//		
//		System.out.println("newWeightModel:" + newWeightModel);
//		List<HouseDataModel> dataHouseForPredict = csvUtil.readDataFromCsv("test.csv");
//		List<PredictModel> dataPredictList = new ArrayList<>();
//		for (HouseDataModel houseDataModel : dataHouseForPredict) {
//			PredictModel predict = new PredictModel();
//			predict.setId(houseDataModel.getId());
//			predict.setCost(Double.toString(preUtil.predict(houseDataModel, newWeightModel)));
//			dataPredictList.add(predict);
//		}
//
//		// Write predict
//		csvUtil.writeDataToCsv(dataPredictList);
//		// csvUtil.writeDataToHouseCsv(dataHouseList);
		
		
		// Count feature
		HashMap<String, FeatureCount> featureMap = csvUtil.getCountFeauter("count_feature_copy_1.csv");
		csvUtil.writeDataFeatureCount(featureMap);
		
	}

}
