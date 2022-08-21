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
	private static int iter = 8000;

	public static void main(String[] args) throws Exception {

		List<HouseDataModel> dataHouseList = csvUtil.readDataFromCsv("input/test-sample.csv");

		List<PredictModel> predictTraining = csvUtil.readDataPredictFromCsv("input/predict-sample.csv");

		WeightsModel weightModel = // new WeightsModel(0.01200724115958909, 0.26888046354832384, 0.24108944627778836, -0.0001786169253864465, 0.5252432457810584, 0.05228056482654562, 0.06895614126251053, 0.7288311286409825);
             // new WeightsModel(0.9998621533294892, 0.02921674012533904, 0.2720277902830526, 0.027388077524908034, 0.6274126386715467, 6063.418549655184, -5.198590226312037, 1.249281388874249);
	     // new WeightsModel(0.9999012186070612, 0.11561201861836867, 0.3753538623296254, 0.03090575151966244, 0.54375496192264, 6063.419323893816, -4.759781703294192, 1.0526120800463674);
		// new WeightsModel(0.9988702610013133, 2500, 0.09213895260781184, 0.35883079737783774, 0.03026562117807521, 0.4690799459383173, 6063.426928862106, -1.7409873051389118, 1.0143732362508897);
		new WeightsModel(0.9877050769103738, 2500.0102178820666, 0.03970719574173748, 0.43682864383195014, 0.0343208551384238, 0.4515215686983304, 6063.361878524114, -14.77998623694422, 0.7395345434150876);
			
		WeightsModel newWeightModel = preUtil.train(dataHouseList, predictTraining, weightModel, 0.00000000011125, iter);
		// MSE: 9.911741795991688E8, 
		// 9.907712385639181E8, 
		// 9.904101743413165E8
		// 9.897968378872386E8, 9.895372112367901E8, 9.885936024234755E8, 9.882329039826242E8,  9.876975224942334E8
		// 9.873960927880741E8
		// 8.28E8, 8.176883155358394E8, 8.131504496829221E8, 8.103719202945099E8
		// 8.097368311193013E8
		
		System.out.println("newWeightModel:" + newWeightModel);
		List<HouseDataModel> dataHouseForPredict = csvUtil.readDataFromCsv("test.csv");
		List<PredictModel> dataPredictList = new ArrayList<>();
		for (HouseDataModel houseDataModel : dataHouseForPredict) {
			PredictModel predict = new PredictModel();
			predict.setId(houseDataModel.getId());
			predict.setCost(Double.toString(preUtil.predict(houseDataModel, newWeightModel)));
			dataPredictList.add(predict);
		}

		
		
		// Write predict
		csvUtil.writeDataToCsv(dataPredictList);
		// csvUtil.writeDataToHouseCsv(dataHouseList);
	}

}
