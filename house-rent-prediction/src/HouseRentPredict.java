import java.util.ArrayList;
import java.util.List;

import rent.model.HouseDataModel;
import rent.model.PredictModel;
import rent.util.CsvUtil;

public class HouseRentPredict {

    private static CsvUtil csvUtil = new CsvUtil();

    public static void main(String[] args) {

        List<HouseDataModel> dataHouseList = csvUtil.readDataFromCsvInput();

        List<HouseDataModel> dataTrainList = csvUtil.readDataFromCsvTraining();

        List<PredictModel> dataPredictList = new ArrayList();
        for (HouseDataModel data : dataTrainList) {
            dataPredictList.add(new PredictModel(data.getId(), "" + data.getTimeToStation()));
        }

//         Write predict
//        List<PredictModel> dataPredictList = Arrays.asList(new PredictModel("1", "1000"), new PredictModel("2", "2000"),
//                new PredictModel("3", "3000"));
        csvUtil.writeDataToCsv(dataPredictList);
    }

}
