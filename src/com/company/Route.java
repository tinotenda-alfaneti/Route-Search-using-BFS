package com.company;

public class Route {
        String airportCode;
        String airline;
        int stops;

    /**
     *
     * @param airportCode
     * @param airline
     * @param stops
     */
        Route(String airportCode, String airline, int stops) {
            this.airportCode = airportCode;
            this.airline = airline;
            this.stops = stops;
        }

    /**
     *
     * @param airportCode
     */
    Route(String airportCode) {
            this(airportCode, "", 0);
        }

}


