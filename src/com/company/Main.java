package com.company;

import java.io.*;

public class Main {


    public Main() {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        RouteSearch findRoute  = new RouteSearch();
        DataFile dataFiles = new DataFile();
        Route testRoute = new Route(dataFiles.getSourceAirportCode(Airport.readAirportsFile()));
        findRoute.routeSearch(testRoute);


    }






}

