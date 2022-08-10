package rent.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import rent.model.HouseCsvModel;
import rent.model.PredictModel;

public class CsvUtil {

	public List<HouseCsvModel> readDataFromCsv(String fileName) {
		List<HouseCsvModel> dataHouseList = new ArrayList<HouseCsvModel>();
		Path path1 = Paths.get(fileName);

		File file = new File(path1.toUri());

		try {
			InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			CSVReader reader = new CSVReader(csvStreamReader);
			reader.skip(1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(Arrays.toString(nextLine));
				HouseCsvModel data = new HouseCsvModel(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
						nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9], nextLine[10], nextLine[11],
						nextLine[12], nextLine[13], nextLine[14], nextLine[15], nextLine[16], nextLine[17],
						nextLine[18], nextLine[19], nextLine[20], nextLine[21], nextLine[22], nextLine[23],
						nextLine[24], nextLine[25]);
				dataHouseList.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return dataHouseList;
	}
	
	public List<PredictModel> readDataPredictFromCsv(String fileName) {
		List<PredictModel> predictList = new ArrayList<PredictModel>();
		Path path1 = Paths.get(fileName);

		File file = new File(path1.toUri());

		try {
			InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			CSVReader reader = new CSVReader(csvStreamReader);
			reader.skip(1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(Arrays.toString(nextLine));
				PredictModel data = new PredictModel(nextLine[0], nextLine[1]);
				predictList.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return predictList;
	}

	public void writeDataToCsv(List<PredictModel> dataPredictList) {
		File file = new File("predict.csv");
		try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
			// create file if not exists
			if (!file.exists()) {
				file.createNewFile();
			}
			// write integers
			writer.writeNext(new String[] { "ID", "Cost" });
			for (PredictModel predictModel : dataPredictList) {
				writer.writeNext(predictModel.toArrayString());
			}
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
