package cn.edu.hcnu.dao.impl;

import cn.edu.hcnu.bean.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IFightDaoImpl implements IFlightDao {

    @Override
    public void insertFlight(Flight flight) throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);


        String sql="INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString( 1,flight.getId());
        pstmt. setString( 2,flight.getFlightId());
        pstmt.setString(3,flight.getPlaneType());
        pstmt.setInt(4,flight.getCurrentseatsNum());
        pstmt. setString(5,flight.getDepartureAirPort());
        pstmt.setString(6,flight.getDestinationAirPort());
        pstmt. setString(7,flight.getDepartureTime());
        pstmt.executeUpdate();


    }

    @Override
    public Set<Flight> getAllFlights() throws SQLException {
        Set<Flight> flights = new HashSet<Flight>();
        String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="select * from  flight";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            String  ID= res.getString("ID");
            String  flightID= res.getString("flight_id");
            String planeType= res.getString("plane_type");
            int currentseatsNum= res.getInt("total_seats_num");
            String departureAirPort = res.getString("departure_airport");
            String destinationAirport = res.getString("destination_airport");
            String departureTime = res.getString("departure_time");

            Flight flight=new Flight(ID, flightID,planeType,currentseatsNum,
                    departureAirPort,destinationAirport,departureTime);
            flights.add(flight);
        }
        return flights;

    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql = "SELECT FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM," +
                "DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME FROM flight WHERE DEPARTURE_TIME = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,departureTime);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            String  flightID= res.getString("flight_id");
            String planeType= res.getString("plane_type");
            int currentseatsNum= res.getInt("total_seats_num");
            String departureAirPort = res.getString("departure_airport");
            String destinationAirport = res.getString("destination_airport");
            String departureTimes = res.getString("departure_time");

            Flight flight=new Flight(flightID,planeType,currentseatsNum,
                    departureAirPort,destinationAirport,departureTime);
            return flight;
        }
        return null;
    }


    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql = "SELECT FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM," +
                "DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME FROM flight WHERE DEPARTURE_AIRPORT = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,departureAirPort);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            String  flightID= res.getString("flight_id");
            String planeType= res.getString("plane_type");
            int currentseatsNum= res.getInt("total_seats_num");
            String departureAirPorts = res.getString("departure_airport");
            String destinationAirport = res.getString("destination_airport");
            String departureTime = res.getString("departure_time");

            Flight flight=new Flight(flightID,planeType,currentseatsNum,
                    departureAirPorts,destinationAirport,departureTime);
            return flight;
        }
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql = "SELECT FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM," +
                "DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME FROM flight WHERE DESTINATION_AIRPORT = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,destinationAirPort);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            String  flightID= res.getString("flight_id");
            String planeType= res.getString("plane_type");
            int currentseatsNum= res.getInt("total_seats_num");
            String departureAirPort = res.getString("departure_airport");
            String destinationAirport = res.getString("destination_airport");
            String departureTime = res.getString("departure_time");

            Flight flight=new Flight(flightID,planeType,currentseatsNum,
                    departureAirPort,destinationAirport,departureTime);
            return flight;
        }
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
