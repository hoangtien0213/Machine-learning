import java.util.List;

import rent.model.HouseCsvModel;
import rent.util.CsvUtil;

public class HouseRentPredict {
	
	private static CsvUtil csvUtil = new CsvUtil();
	
	public static void main(String[] args) throws Exception {

		List<HouseCsvModel> dataHouseList = csvUtil.readDataFromCsv();
		for (HouseCsvModel houseModel : dataHouseList) {
			csvUtil.writeDataToCsv(houseModel.toArrayString());
		}
	}

}
