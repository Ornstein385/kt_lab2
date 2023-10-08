package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AddressFileParser {
    protected abstract ArrayList<Building> getBuildings(String filePath);

    private ArrayList<Building> buildings;

    private long processingTime;
    private final String filePath;

    public AddressFileParser(String filePath) {
        this.filePath = filePath;
        processingTime = System.currentTimeMillis();
        buildings = getBuildings(filePath);
        processingTime = System.currentTimeMillis() - processingTime;
    }

    public AddressFileParser showDuplicates() {
        HashMap<Building, Integer> map = new HashMap<>();
        for (Building building : buildings) {
            if (!map.containsKey(building)) {
                map.put(building, 1);
            } else {
                map.put(building, map.get(building) + 1);
            }
        }
        for (Map.Entry<Building, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("запись " + entry.getKey() + " повторяется " + entry.getValue() + " раз.");
            }
        }
        System.out.println("----------------------------");
        return this;
    }

    public AddressFileParser showNumberOfFloors() {
        HashMap<String, int[]> map = new HashMap<>();
        for (Building building : buildings) {
            if (!map.containsKey(building.city)) {
                map.put(building.city, new int[5]);
            }
            if (building.floor > 0 && building.floor < 6) {
                map.get(building.city)[building.floor - 1]++;
            }
        }
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            System.out.println("в городе " + entry.getKey());
            for (int i = 1; i <= 5; i++) {
                if (entry.getValue()[i - 1] > 0) {
                    System.out.println(entry.getValue()[i - 1] + " " + i + "-этажных здания");
                }
            }
            System.out.println("----------------------------");
        }
        return this;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public AddressFileParser showProcessingTime(){
        System.out.println("время обработки файла " + filePath + " = " + getProcessingTime() + " мс.");
        System.out.println("----------------------------");
        return this;
    }
}
