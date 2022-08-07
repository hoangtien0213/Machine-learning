import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import rent.model.HouseModel;
import rent.model.WeightsModel;

public class HouseRentPredict {

//	private static void writeDataToCsv(String data) {
//		File file = new File("output/output.csv");
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//			// create file if not exists
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			// write integers
//			writer.write("head");
//			writer.newLine();
//			writer.write(data);
//			System.out.println("File written successfully.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	private static List<HouseModel> readDataFromCsv() {
		List<HouseModel> dataHouseList = new ArrayList<HouseModel>();
		try {
			Charset cs = Charset.forName("SJIS");
			Path path1 = Paths.get("input/test-sample.csv");

			File file = new File(path1.toUri());

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
			String line = "";
			String[] tempArr;

			while ((line = br.readLine()) != null) {

				System.out.println(line);
				tempArr = line.split(",");

				HouseModel data = new HouseModel();
				data.setId(tempArr[0]);
				data.setAddress(tempArr[1]);
				dataHouseList.add(data);
			}
			br.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dataHouseList;
	}

	private double predict(HouseModel houseData, WeightsModel weight ) {
		double cost = 0;

		cost = weight.getWeightOfAddress();
		
		return cost;
	}
	
	

	private static List<HouseModel> readerCSV() {
		List<HouseModel> dataHouseList = new ArrayList<HouseModel>();
		Path path1 = Paths.get("input/test-sample.csv");

		File file = new File(path1.toUri());

		try {
			InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "SJIS");
			CSVReader reader = new CSVReader(csvStreamReader);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null && !nextLine[0].equals("ID")) {
					System.out.println(Arrays.toString(nextLine));
					HouseModel data = new HouseModel(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
							nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9], nextLine[10], nextLine[11],
							nextLine[12], nextLine[13], nextLine[14], nextLine[15], nextLine[16], nextLine[17],
							nextLine[18], nextLine[19], nextLine[20], nextLine[21], nextLine[22], nextLine[23],
							nextLine[24]);
					dataHouseList.add(data);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error1");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return dataHouseList;
	}

	private static void writeDataToCsv(String[] data) {
		File file = new File("output/output.csv");
		try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
			// create file if not exists
			if (!file.exists()) {
				file.createNewFile();
			}
			// write integers
			writer.writeNext(new String[] { "Header" });
			writer.writeNext(data);
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		List<HouseModel> dataHouseList = readerCSV();
		for (HouseModel houseModel : dataHouseList) {
			writeDataToCsv(houseModel.toArrayString());
		}
	}

}
