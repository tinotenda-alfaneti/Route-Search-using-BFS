package com.company;

public class Route {
        String airportCode;
        String airline;
        int stops;

    @Override
    public String toString() {
        return airportCode;
    }

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


