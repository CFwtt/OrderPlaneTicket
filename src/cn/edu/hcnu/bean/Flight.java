package cn.edu.hcnu.bean;

public class Flight {
    private String id;
    private String FlightId;
    private String planeType;
    private int currentseatsNum;
    private String departureAirPort;//出发机场
    private String destinationAirPort;//目的机场
    private String departureTime;//出发时间

    public Flight(String flightId, String planeType, int currentseatsNum, String departureAirPort, String destinationAirPort, String departureTime) {
        FlightId = flightId;
        this.planeType = planeType;
        this.currentseatsNum = currentseatsNum;
        this.departureAirPort = departureAirPort;
        this.destinationAirPort = destinationAirPort;
        this.departureTime = departureTime;
    }

    public Flight(String id, String flightId, String planeType, int currentseatsNum, String departureAirPort, String destinationAirPort, String departureTime) {
        this.id = id;
        FlightId = flightId;
        this.planeType = planeType;
        this.currentseatsNum = currentseatsNum;
        this.departureAirPort = departureAirPort;
        this.destinationAirPort = destinationAirPort;
        this.departureTime = departureTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getDepartureAirPort() {
        return departureAirPort;
    }

    public void setDepartureAirPort(String departureAirPort) {
        this.departureAirPort = departureAirPort;
    }

    public String getDestinationAirPort() {
        return destinationAirPort;
    }

    public void setDestinationAirPort(String destinationAirPort) {
        this.destinationAirPort = destinationAirPort;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCurrentseatsNum() {
        return currentseatsNum;
    }

    public void setCurrentseatsNum(int currentseatsNum) {
        this.currentseatsNum = currentseatsNum;
    }

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }

    @Override
    public String toString() {
        return "航班号：'" +FlightId+ '\'' +
                ", 飞机类型：'" + planeType + '\'' +
                ", 座位数：" + currentseatsNum +
                ", 起飞机场：'" + departureAirPort + '\'' +
                ", 目的机场：'" + destinationAirPort + '\'' +
                ", 到达时间: '" + departureTime ;
    }
}
