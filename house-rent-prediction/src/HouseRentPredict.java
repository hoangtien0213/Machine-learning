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
	private static int iter = 1;

	public static void main(String[] args) throws Exception {

		List<HouseDataModel> dataHouseList = csvUtil.readDataFromCsv("input/test-sample.csv");

		List<PredictModel> predictTraining = csvUtil.readDataPredictFromCsv("input/predict-sample.csv");

		WeightsModel weightModel = new WeightsModel(0.125, 0.45, 0.212, 0.1255, 0.2206, 0.22554, 0.3366, 0.3365);

		WeightsModel newWeightModel = preUtil.train(dataHouseList, predictTraining, weightModel, 0.001, iter);
		System.out.println("newWeightModel:" + newWeightModel);

		List<HouseDataModel> dataHouseForPredict = csvUtil.readDataFromCsv("test.csv");
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
	}

}
