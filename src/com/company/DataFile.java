package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataFile {

    /**
     *
     * @return
     */
    public ArrayList<String[]> readInputFile() {
        ArrayList<String[]> inputFileData = new ArrayList<String[]>();
        try {
            Scanner inputsFile = new Scanner(new File("inputfile.csv"));

            while (inputsFile.hasNextLine()) {
                String[] res = inputsFile.nextLine().split(",");
                inputFileData.add(res);
            }
            inputsFile.close();

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        return inputFileData;
    }

    /**
     *
     * @return
     */

    public HashMap<ArrayList<String>, String> readAirportsFile() {

        HashMap<ArrayList<String>, String> airportsFileData = new HashMap<ArrayList<String>, String>();
        try {
            Scanner airportsFile = new Scanner(new FileReader("airports.csv"));
            while (airportsFile.hasNextLine()) {
                String[] line = airportsFile.nextLine().split(",");
                ArrayList<String> cityCountry = new ArrayList<String>();
                cityCountry.add(line[2]);
                cityCountry.add(line[3]);
                airportsFileData.put(cityCountry, line[4]);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        return airportsFileData;
    }

    /**
     *
     * @return
     */
    public HashMap<String, ArrayList<Route>> readRoutesFile() {

        //Generate destinations from a given start city
        HashMap<String, ArrayList<Route>> routesMap = new HashMap<String, ArrayList<Route>>();

        try {
            Scanner routes = new Scanner(new FileReader("routes.csv"));
            while (routes.hasNextLine()) {
                String[] route = routes.nextLine().split(",");
                ArrayList<Route> temp = new ArrayList<Route>();
                Route tempRoute = new Route(route[4], route[0], Integer.parseInt(route[7]));
                if (routesMap.containsKey(route[2])) {
                    temp = routesMap.get(route[2]);
                    if (!temp.contains(tempRoute)) {
                        temp.add(tempRoute);
                        routesMap.put(route[2], temp);
                    }

                } else {
                    temp.add(tempRoute);
                    routesMap.put(route[2], temp);
                }
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        return routesMap;
    }

    //TODO: Change the working of this method. It should used the already created fileOutPutData
    public String getSourceAirportCode(HashMap<ArrayList<String>, String> airportsData) {

        //Get airport code for the given city and country
        ArrayList<String[]> fileOutput = readInputFile();
        String airportCode = "";
        ArrayList<String> cityCountry = new ArrayList<String>();
        cityCountry.add(fileOutput.get(0)[0]);
        cityCountry.add(fileOutput.get(0)[1]);
        if (airportsData.containsKey(cityCountry)) {
            airportCode = airportsData.get(cityCountry);

        }
        return airportCode;
    }

    //TODO: Also change this method
    public String getDestAirportCode(HashMap<ArrayList<String>, String> countries){

        //Get airport code for the given city and country
        ArrayList<String[]> fileOutput = readInputFile();
        String destCode = "";
        ArrayList<String> cityCountry = new ArrayList<String>();
        cityCountry.add(fileOutput.get(1)[0]);
        cityCountry.add(fileOutput.get(1)[1]);
        if (countries.containsKey(cityCountry)) {
            destCode = countries.get(cityCountry);

        }
        return destCode;
    }

}
