package org.example;

public class Main {
    public static void main(String[] args) {
        new CsvFileParser("address.csv").showProcessingTime().showDuplicates().showNumberOfFloors();
        new XmlFileParser("address.xml").showProcessingTime().showDuplicates().showNumberOfFloors();
        //   Файлы должны лежать в корневом каталоге проекта
    }
}