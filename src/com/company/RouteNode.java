package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RouteNode {

    Route route;
    RouteNode prev;

    /**
     *
     * @param route
     */

    public RouteNode(Route route) {
        this(route, null);

    }

    /**
     *
     * @param route
     * @param prev
     */
    public RouteNode(Route route, RouteNode prev) {
        this.route = route;
        this.prev = prev;

    }

    /**
     *
     * @param result
     */
    public void writeOutputFile(ArrayList<RouteNode> result) {

        try {
            PrintWriter output = new PrintWriter("outputfile.txt");
            int i = 1;
            for (RouteNode currRoute : result) {
                String message = i + ". " + currRoute.route.airline + " from " +
                        currRoute.prev.route.airportCode + " to " +
                        currRoute.route.airportCode + currRoute.route.stops;
                System.out.println(message);
                output.write(message);
                i++;
            }
            output.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public ArrayList<RouteNode> route() {

        ArrayList<RouteNode> finalRoute = new ArrayList<RouteNode>();

        RouteNode end = this;
        while (end.prev != null) {
            finalRoute.add(0, end);
            end = end.prev;
        }
        writeOutputFile(finalRoute);
        return finalRoute;
    }
}
