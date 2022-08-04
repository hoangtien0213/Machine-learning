import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import rent.model.HouseModel;


public class HouseRentPredict {

	private static void writeDataToCsv(String data) {
		File file = new File("output/output.csv");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			// create file if not exists
			if (!file.exists()) {
				file.createNewFile();
			}
			// write integers
			writer.write("head");
			writer.newLine();
			writer.write(data);
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static List<HouseModel> readDataFromCsv() {
		List<HouseModel> dataHouseList = new ArrayList<HouseModel>();
		try {

			Path path1 = Paths.get("input/test-sample.csv");

			File file = new File(path1.toUri());

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "SJIS"));
			String line = "";
			String[] tempArr;

			while ((line = br.readLine()) != null) {
				
				System.out.println(line);
				tempArr = line.split(",");

				HouseModel data = new HouseModel();
				data.setId(Integer.valueOf(tempArr[0]));
				data.setAddress(tempArr[1]);
				dataHouseList.add(data);
			}
			br.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dataHouseList;
	}

	private double predict() {
		double cost = 0;
		
		
		return cost;
	}
	
	public static void main(String[] args) throws Exception {

		List<HouseModel> data =readDataFromCsv();
		for (HouseModel houseData : data) {
			writeDataToCsv(houseData.toString());
		}
		
	}

}
