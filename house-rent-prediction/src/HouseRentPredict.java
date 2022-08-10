import java.util.Arrays;
import java.util.List;

import rent.model.HouseCsvModel;
import rent.model.PredictModel;
import rent.util.CsvUtil;

public class HouseRentPredict {

	private static CsvUtil csvUtil = new CsvUtil();

	public static void main(String[] args) throws Exception {

		List<HouseCsvModel> dataHouseList = csvUtil.readDataFromCsv("input/test-sample.csv");
		// Write predict
		List<PredictModel> dataPredictList = Arrays.asList(new PredictModel("1", "1000"), new PredictModel("2", "2000"),
				new PredictModel("3", "3000"));
		csvUtil.writeDataToCsv(dataPredictList);
	}

}
