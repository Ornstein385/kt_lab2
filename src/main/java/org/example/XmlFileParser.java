package org.example;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFileParser extends AddressFileParser {

    public XmlFileParser(String filePath) {
        super(filePath);
    }

    @Override
    protected ArrayList<Building> getBuildings(String filePath) {
        ArrayList<Building> buildings = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String city = element.getAttribute("city");
                    String street = element.getAttribute("street");
                    int house = Integer.parseInt(element.getAttribute("house"));
                    int floor = Integer.parseInt(element.getAttribute("floor"));

                    Building building = new Building(city, street, house, floor);
                    buildings.add(building);
                }
            }
        } catch (IOException e1) {
            System.out.println("ошибка чтения файла");
        } catch (Exception e2){
            System.out.println("ошибка парсинга XML");
        }
        return buildings;
    }
}