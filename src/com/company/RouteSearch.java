
package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class RouteSearch {

    DataFile dataFiles = new DataFile();

    public ArrayList<Route> getDestinations(HashMap<String, ArrayList<Route>> routesMap, String airportCode) {
        ArrayList<Route> dest = new ArrayList<Route>();
        if (routesMap.containsKey(airportCode)) {
            dest = routesMap.get(airportCode);
        }
        return dest;
    }

    public boolean routeSearch(Route start) {

        RouteNode airport = new RouteNode(start);

        Queue<RouteNode> destQueue = new LinkedList<RouteNode>();
        HashSet<String> visitedAirport = new HashSet<String>();
        destQueue.add(airport);

        while (destQueue.size() != 0) {
            RouteNode currAirport = destQueue.poll();
            visitedAirport.add(currAirport.route.airportCode);

            ArrayList<Route> destinations = getDestinations(dataFiles.readRoutesFile(), currAirport.route.airportCode);
            for (Route dest : destinations) {
                RouteNode destAirport = new RouteNode(dest, currAirport);
                if (!visitedAirport.contains(destAirport.route.airportCode) &&
                        !destQueue.contains(destAirport)) {
                    if (destAirport.route.airportCode.equals(dataFiles.getDestAirportCode(dataFiles.readAirportsFile()))) {
                        System.out.println("Destination Found");
                        System.out.println(destAirport.route());
                        return true;
                    }
                    destQueue.add(destAirport);
                    System.out.println("This was added: " + destAirport.route.airportCode);
                }
            }
        }


        return false;
    }
}
