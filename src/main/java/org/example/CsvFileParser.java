package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileParser extends AddressFileParser {
    public CsvFileParser(String filePath) {
        super(filePath);
    }

    @Override
    protected ArrayList<Building> getBuildings(String filePath) {
        ArrayList<Building> buildings = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Пропускаем первую строку с заголовками
                }
                String[] values = line.split(";");
                String city = values[0].replace("\"", "");
                String street = values[1].replace("\"", "");
                int house = Integer.parseInt(values[2].replace("\"", ""));
                int floor = Integer.parseInt(values[3].replace("\"", ""));

                Building building = new Building(city, street, house, floor);
                buildings.add(building);
            }

            reader.close();
        } catch (IOException e){
            System.out.println("ошибка чтения файла");
        }
        return buildings;
    }
}
