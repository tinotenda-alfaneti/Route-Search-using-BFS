package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Airport {

    double latitude;
    double longitude;
    String airportCode;


    public Airport(String airportCode, double latitude, double longitude) {
        this.airportCode = airportCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */

    public HashMap<ArrayList<String>, Airport> readAirportsFile() {

        HashMap<ArrayList<String>, Airport> airportsFileData = new HashMap<ArrayList<String>, Airport>();
        try {
            Scanner airportsFile = new Scanner(new FileReader("airports.csv"));
            while (airportsFile.hasNextLine()) {
                String[] line = airportsFile.nextLine().split(",");
                ArrayList<String> cityCountry = new ArrayList<String>();
                Airport temp = new Airport(line[4], Double.parseDouble(line[6]), Double.parseDouble(line[7]));
                cityCountry.add(line[2]);
                cityCountry.add(line[3]);
                airportsFileData.put(cityCountry, temp);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        return airportsFileData;
    }
}
