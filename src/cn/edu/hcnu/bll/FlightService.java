package cn.edu.hcnu.bll;

import cn.edu.hcnu.bean.Flight;

import java.sql.SQLException;
import java.util.Set;

public interface FlightService {


    void insertFlight(Flight flight) throws SQLException;
    Set<Flight> getAllFlights() throws SQLException;
    Flight getFlightByDepartureTime(String departureTime) throws SQLException;
    Flight getFlightByDepartureAirPort(String departureAirPort) throws SQLException;
    Flight getFlightByDestinationAirPort(String destinationAirPort) throws SQLException;
    void  updateFlight(Flight flight);
}
