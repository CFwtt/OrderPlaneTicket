package cn.edu.hcnu.dao.impl;


import cn.edu.hcnu.bean.Flight;

import java.util.Set;

public interface IFlightDao {

    void insertFlight(Flight flight);
    Set<Flight> getAllFlights();
    Flight getFlightByDepartureTime(String departureTime);
    Flight getFlightByDepartureAirPort(String departureAirPort);
    Flight getFlightByDestinationAirPort(String destinationAirPort);
    void  updateFlight(Flight flight);
}
