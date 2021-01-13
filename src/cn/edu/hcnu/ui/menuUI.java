package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.FlightService;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class menuUI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FlightService flightService = new FlightServiceImpl();

        while (true){
            System.out.println("请输入相对应的数字进行操作");

            System.out.println("按1，录入航班信息");
            System.out.println("按2，显示所有航班信息");
            System.out.println("按3，查询航班信息");
            System.out.println("按4，机票预定");
            System.out.println("按5，机票退顶");
            System.out.println("按6，退出系统");
            int  choice  = scanner.nextInt();
            switch (choice){
                case 1:
                    String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                    System.out.print("请输入航班编号：");
                    String flightID=scanner.next();
                    System.out.print("请输入机型：");
                    String planeType=scanner.next();
                    System.out.print("请输入座位数：");
                    int currentseatsNum=scanner.nextInt();
                    System.out.print("请输入起飞机场：");
                    String departureAirPort=scanner.next( );
                    System.out.print("请输入目的机场：");
                    String destinationAirport=scanner.next();
                    System.out.print("请输入起飞时间：");
                    String departureTime=scanner.next();
                    Flight flight=new Flight(id,flightID,planeType,currentseatsNum,
                            departureAirPort,destinationAirport,departureTime);
                    try {
                        flightService.insertFlight(flight);
                    } catch (SQLException e) {
                        String errorMessage = e.getMessage();
                        System.out.println("请好好检查！");
                    }
                    break;
                case 2:
                    try {
                        flightService.getAllFlights();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("您输入的不是1~6之间的数字，请重新输入"+"\n");
                    break;
            }
        }

    }
}
