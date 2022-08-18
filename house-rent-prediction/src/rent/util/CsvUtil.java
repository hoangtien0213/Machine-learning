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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import rent.model.HouseCsvModel;
import rent.model.HouseDataModel;
import rent.model.PredictModel;

public class CsvUtil {

	private static final String regex_number = "(-?\\d+(\\.\\d+)?)|(-?\\d+)";

	public List<HouseDataModel> readDataFromCsv(String fileName) {
		List<HouseDataModel> dataHouseList = new ArrayList<HouseDataModel>();
		Path path1 = Paths.get(fileName);

		File file = new File(path1.toUri());

		try {
			InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			CSVReader reader = new CSVReader(csvStreamReader);
			reader.skip(1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
//				System.out.println(Arrays.toString(nextLine));
				HouseCsvModel data = new HouseCsvModel(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
						nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9], nextLine[10], nextLine[11],
						nextLine[12], nextLine[13], nextLine[14], nextLine[15], nextLine[16], nextLine[17],
						nextLine[18], nextLine[19], nextLine[20], nextLine[21], nextLine[22], nextLine[23],
						nextLine[24], nextLine[25]);
				dataHouseList.add(this.convertCsvToModel(data));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
				// System.out.println(Arrays.toString(nextLine));
				PredictModel data = new PredictModel(nextLine[0], nextLine[1]);
				predictList.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return predictList;
	}

	public void writeDataToCsv(List<PredictModel> dataPredictList) {
		File file = new File("house-rent-prediction/predict.csv");
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

	public void writeDataToHouseCsv(List<HouseDataModel> dataPredictList) {
		File file = new File("data.csv");
		try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
			// create file if not exists
			if (!file.exists()) {
				file.createNewFile();
			}
			// write integers
			writer.writeNext(new String[] { "1", "2", "3", "4", "5", "6", "7" });
			for (HouseDataModel predictModel : dataPredictList) {
				writer.writeNext(new String[] {""+predictModel.getTimeToStation(),
				""+predictModel.getStructureAndDesign(), ""+predictModel.getTotalUsableArea(),
				""+predictModel.getNumberOfYearsSinceConstruction(),
				""+predictModel.getFloor(),
				""+predictModel.getKindsOfHouse(),
				""+predictModel.getFeaturesAndEquipment() });
			}
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	

	public HouseDataModel convertCsvToModel(HouseCsvModel csv) {
		HouseDataModel data = new HouseDataModel();
		// ID
		data.setId(csv.getId());

		// Address
		// data.setAddress(1);

		// Time to station
		final String regex = "\\d+分";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(csv.getTimeToStation());
		long min = 0;
		int count = 0;
		while (matcher.find()) {
			// min += Integer.parseInt(matcher.group(0));
			int minute = Integer.parseInt(matcher.group(0).replace("分", ""));
			if (count == 0) {
				min = minute;
			} else {
				if (minute < min) {
					min = minute;
				}
			}
			count++;
		}

		data.setTimeToStation(300.0 * 300.0/min);

		// StructureAndDesign
		// https://resources.realestate.co.jp/living/1r-1k-1dk-1ldk-apartment-whats-the-difference-and-which-should-i-rent/
		// https://resources.realestate.co.jp/living/what-is-a-2ldk-apartment-real-estate-japans-word-of-the-day/
		long roomCost = 15000;
		if (Constant.WARUMU.equals(csv.getStructureAndDesign())) {
			data.setStructureAndDesign(roomCost);
		} else {
			String roomCount = this.getNumberIn(csv.getStructureAndDesign()).get(0);
			double roomNum = Double.parseDouble(roomCount);
			// Moi phong L,D,K ~ 1/3 Bed room (30%)
			double subRoom = (csv.getStructureAndDesign().length() - roomCount.length()) / 3.0;
			data.setStructureAndDesign((roomNum * roomCost )* (subRoom + 1));
		}

		// totalAsableArea
		data.setTotalUsableArea(1120 * Double.parseDouble(this.getNumberIn(csv.getTotalUsableArea()).get(0)));

		// numberOfYearsSinceConstruction
		long costHouseNew = 35000;
		if (Constant.HOUSE_NEW.equals(csv.getNumberOfYearsSinceConstruction())) {
			data.setNumberOfYearsSinceConstruction(2.5 * costHouseNew);
		} else {
			data.setNumberOfYearsSinceConstruction(costHouseNew + (costHouseNew
					/ Double.parseDouble(this.getNumberIn(csv.getNumberOfYearsSinceConstruction()).get(0))));
		}

		// floor
		if (Constant.DASHES.equals(csv.getFloor())) {
			data.setFloor(1);
		} else {
			data.setFloor(Double.parseDouble(this.getNumberIn(csv.getFloor()).get(0)));
		}

		long costHouseKind = 1000;
		if (Constant.HOUSE_KIND_MANSHON.equals(csv.getKindsOfHouse())) {
			data.setKindsOfHouse(2 * costHouseKind);
		} else if (Constant.HOUSE_KIND_APAITO.equals(csv.getKindsOfHouse())) {
			data.setKindsOfHouse(1.7 * costHouseKind);
		} else if (Constant.HOUSE_KIND_DETACHED_HOUSE.equals(csv.getKindsOfHouse())) {
			data.setKindsOfHouse(1.5 * costHouseKind);
		} else if (Constant.HOUSE_KIND_TOWNHOUSES.equals(csv.getKindsOfHouse())) {
			data.setKindsOfHouse(1.3 * costHouseKind);
		} else {
			data.setKindsOfHouse(costHouseKind);
		}

		// featuresAndEquipment
		data.setFeaturesAndEquipment(1000 * csv.getFeaturesAndEquipment().split(Constant.COMMA_FULLSIZE).length);

		return data;
	}

	private List<String> getNumberIn(String stringToSearch) {
		Pattern integerPattern = Pattern.compile(regex_number);
		Matcher matcher = integerPattern.matcher(stringToSearch);

		List<String> integerList = new ArrayList<>();
		while (matcher.find()) {
			integerList.add(matcher.group());
		}

		return integerList;
	}
}
