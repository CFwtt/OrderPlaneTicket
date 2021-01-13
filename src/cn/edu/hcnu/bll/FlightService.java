package cn.edu.hcnu.bll;

import cn.edu.hcnu.bean.Flight;

import java.sql.SQLException;

public interface FlightService {


    void insertFlight(Flight flight) throws SQLException;
    void getAllFlights() throws SQLException;
    Flight getFlightByDepartureTime(String departureTime);
    Flight getFlightByDepartureAirPort(String departureAirPort);
    Flight getFlightByDestinationAirPort(String destinationAirPort);
    void  updateFlight(Flight flight);
}
