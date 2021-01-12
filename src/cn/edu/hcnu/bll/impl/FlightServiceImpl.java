package cn.edu.hcnu.bll.impl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.FlightService;
import cn.edu.hcnu.dao.impl.IFightDaoImpl;
import cn.edu.hcnu.dao.impl.IFlightDao;

import java.util.Set;

public class FlightServiceImpl implements FlightService {

    IFlightDao iFlightDao;

    public FlightServiceImpl() {
        iFlightDao = new IFightDaoImpl();
    }

    @Override
    public void insertFlight(Flight flight) {
        iFlightDao.insertFlight(flight);
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
