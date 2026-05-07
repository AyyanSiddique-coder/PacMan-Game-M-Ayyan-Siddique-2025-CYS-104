package CEP_2_LAB;

import java.io.*;
import java.util.ArrayList;

public class BusSystem {

    public static ArrayList<Bus> buses = new ArrayList<>();

    static String FILE_NAME = "bus_data.txt";

    // LOAD DATA FROM FILE
    public static void loadBuses() {

        try {

            File file = new File(FILE_NAME);

            // If file does not exist create default data
            if(!file.exists()) {

                createDefaultData();
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            buses.clear();

            while((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String route = data[1];
                String location = data[2];

                buses.add(new Bus(id, route, location));
            }

            br.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // SAVE DATA TO FILE
    public static void saveBuses() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(new FileWriter(FILE_NAME));

            for(Bus bus : buses) {

                bw.write(bus.toString());

                bw.newLine();
            }

            bw.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // CREATE DEFAULT 15 BUSES
    public static void createDefaultData() {

        buses.add(new Bus(1,
                "Johar Town Route",
                "Johar Town"));

        buses.add(new Bus(2,
                "DHA Route",
                "DHA Phase 5"));

        buses.add(new Bus(3,
                "Model Town Route",
                "Model Town"));

        buses.add(new Bus(4,
                "Wapda Town Route",
                "Wapda Town"));

        buses.add(new Bus(5,
                "Canal Road Route",
                "Canal Road"));

        buses.add(new Bus(6,
                "Bahria Town Route",
                "Bahria Town"));

        buses.add(new Bus(7,
                "Thokar Route",
                "Thokar Niaz Baig"));

        buses.add(new Bus(8,
                "Shadman Route",
                "Shadman"));

        buses.add(new Bus(9,
                "Gulberg Route",
                "Gulberg"));

        buses.add(new Bus(10,
                "Iqbal Town Route",
                "Iqbal Town"));

        buses.add(new Bus(11,
                "Raiwind Route",
                "Raiwind"));

        buses.add(new Bus(12,
                "Ferozepur Road Route",
                "Ferozepur Road"));

        buses.add(new Bus(13,
                "Cantt Route",
                "Lahore Cantt"));

        buses.add(new Bus(14,
                "Kalma Chowk Route",
                "Kalma Chowk"));

        buses.add(new Bus(15,
                "Liberty Route",
                "Liberty Market"));

        saveBuses();
    }
}