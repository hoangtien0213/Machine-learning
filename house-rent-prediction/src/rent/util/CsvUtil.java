package rent.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import rent.model.HouseCsvModel;
import rent.model.HouseDataModel;
import rent.model.PredictModel;

public class CsvUtil {

    public List<HouseDataModel> readDataFromCsvInput() {
        List<HouseDataModel> dataHouseList = new ArrayList<HouseDataModel>();
        Path path1 = Paths.get("test.csv");

        File file = new File(path1.toUri());

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            CSVReader reader = new CSVReader(csvStreamReader);
            // skip header
            reader.skip(1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // System.out.println(Arrays.toString(nextLine));
                HouseCsvModel data = new HouseCsvModel(nextLine[0], nextLine[1], null, nextLine[2], nextLine[3], nextLine[4],
                        nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9], nextLine[10], nextLine[11],
                        nextLine[12], nextLine[13], nextLine[14], nextLine[15], nextLine[16], nextLine[17],
                        nextLine[18], nextLine[19], nextLine[20], nextLine[21], nextLine[22], nextLine[23],
                        nextLine[24], nextLine[25]);

                dataHouseList.add(this.convertCsvToModel(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dataHouseList;
    }

    public List<HouseDataModel> readDataFromCsvTraining() {
        List<HouseDataModel> dataHouseList = new ArrayList<HouseDataModel>();
        Path path1 = Paths.get("rent.csv");

        File file = new File(path1.toUri());

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            CSVReader reader = new CSVReader(csvStreamReader);
            // skip header
            reader.skip(1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // System.out.println(Arrays.toString(nextLine));
                HouseCsvModel data = new HouseCsvModel(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
                        nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9], nextLine[10], nextLine[11],
                        nextLine[12], nextLine[13], nextLine[14], nextLine[15], nextLine[16], nextLine[17],
                        nextLine[18], nextLine[19], nextLine[20], nextLine[21], nextLine[22], nextLine[23],
                        nextLine[24], nextLine[25], nextLine[26]);

                dataHouseList.add(this.convertCsvToModel(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dataHouseList;
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

    public void writeDataToCsv(String data) {
        File file = new File("predict.csv");
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

    // Todo
    private HouseDataModel convertCsvToModel(HouseCsvModel csv) {
        HouseDataModel data = new HouseDataModel();
        // ID
        data.setId(csv.getId());

        // Address
        // data.setAddress(1);

        // Time to station
        final String regex = "\\d+";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(csv.getTimeToStation());
        long min = 0;
        int count = 0;
        while (matcher.find()) {
            // min += Integer.parseInt(matcher.group(0));
            if (count == 0) {
                min = Integer.parseInt(matcher.group(0));
            } else {
                long temp = Integer.parseInt(matcher.group(0));
                if (temp < min) {
                    min = temp;
                }
            }
            count++;
        }
        data.setStationCount(count);
        data.setTimeToStation(min);

        // StructureAndDesign
        // https://resources.realestate.co.jp/living/1r-1k-1dk-1ldk-apartment-whats-the-difference-and-which-should-i-rent/
        // https://resources.realestate.co.jp/living/what-is-a-2ldk-apartment-real-estate-japans-word-of-the-day/
        if ("ワンルーム".equals(csv.getStructureAndDesign())) {
            data.setStructureAndDesign(1);
        } else {
            double roomNum = Double.parseDouble(csv.getStructureAndDesign().substring(0, 1));
            double subRoom = (csv.getStructureAndDesign().length() - 1) / 2.0;
            data.setStructureAndDesign(roomNum + subRoom);
        }

        // totalAsableArea
        data.setTotalUsableArea(
                Double.parseDouble(csv.getTotalUsableArea().substring(0, csv.getTotalUsableArea().length() - 2)));

        // numberOfYearsSinceConstruction
        if ("新築".equals(csv.getNumberOfYearsSinceConstruction())) {
            data.setNumberOfYearsSinceConstruction(1);
        } else {
            data.setNumberOfYearsSinceConstruction(
                    Double.parseDouble(csv.getNumberOfYearsSinceConstruction().replaceAll("\\D", "")));
        }

        // floor
        if ("-".equals(csv.getFloor())) {
            data.setFloor(1);
        } else {
            data.setFloor(Double.parseDouble(csv.getFloor().substring(0, 1)));
        }

        // kindsOfHouse TODO
        if ("マンション".equals(csv.getKindsOfHouse())) {
            data.setKindsOfHouse(5);
        } else if ("アパート".equals(csv.getKindsOfHouse())) {
            data.setKindsOfHouse(4);
        } else if ("一戸建て".equals(csv.getKindsOfHouse())) {
            data.setKindsOfHouse(3);
        } else if ("テラス・タウンハウス".equals(csv.getKindsOfHouse())) {
            data.setKindsOfHouse(2);
        } else {
            data.setKindsOfHouse(1);
        }

        // featuresAndEquipment
        data.setFeaturesAndEquipment(csv.getFeaturesAndEquipment().split("、").length);

        return data;
    }
}
