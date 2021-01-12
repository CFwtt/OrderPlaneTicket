package cn.edu.hcnu.dao.impl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;

import java.util.Set;

public class IFightDaoImpl implements IFlightDao {

    @Override
    public void insertFlight(Flight flight) {
        System.out.println();
    }

    @Override
    public Set<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) {
        return null;
    }

    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) {
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
