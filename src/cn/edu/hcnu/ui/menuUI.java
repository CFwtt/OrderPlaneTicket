package cn.edu.hcnu.ui;
import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.FlightService;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println("按5，机票退订");
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
                    System.out.println(flight);
                    try {
                        flightService.insertFlight(flight);
                        System.out.println("添加结束");
                    } catch (SQLException e) {
                       String errorMessage = e.getMessage();

                        if(errorMessage.startsWith("ORA-12899")){
                            //ORA-12899: value too large for column "OPTS"."FLIGHT"."ID" (actual: 32, maximum: 30)
                            //String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                            //ORA-12899: 列 "OPTS"."FLIGHT"."ID" 的值太大 (实际值: 32, 最大值: 30)

                            String pattern = "(\\w+-\\d{5}):(\\s[\\u4E00-\\u9FFF])+\\s\"(\\w+)\"\\.(\"\\w+\")\\.(\"\\w+\")";
                            // 创建 Pattern 对象
                            Pattern r = Pattern.compile(pattern);
                            // 现在创建 matcher 对象
                            Matcher m = r.matcher(errorMessage);
//                            System.out.println(errorMessage);
                            System.out.println(m);
                            if(m.find()){
                                String ErrorCode = m.group(1);
                               String tableName = m.group(4);
                               String columnName = m.group(5);

                                System.out.println("错误代码："+ErrorCode+"\n"+
                                                   "错误原因：此"+tableName+"表中的"+columnName+"字段范围不对劲");
                            }else{
                                System.out.println("NO MATCH!");
                            }
                        }
                    }
                    break;
                case 2:
                    try {
                        Set<Flight> flights = flightService.getAllFlights();
                        System.out.println(flights);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("您输入的不是1~6之间的数字，请重新输入"+"\n");
                    break;
                case 3:
                    System.out.println("输入相应的编号选择您要查询航班的方式：");
                    System.out.println("1，按起飞时间查询");
                    System.out.println("2，按空座信息查询");
                    System.out.println("3，按起飞地查询");
                    System.out.println("4，按目的地查询");
                    int choices = scanner.nextInt();
                        if (choices==1){
                            System.out.print("请输入起飞飞行时间:");
                            String detime = scanner.next();
                            try {
                                Flight flight1 = flightService.getFlightByDepartureTime(detime);
                                if (flight1!=null){
                                    System.out.println("航班信息："+flight1);

                                }else {
                                    System.out.println("您所查询的航班不存在，请重新输入！");
                                }

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else if (choices==2){
                            //按空座位查询
                        }else if (choices==3){
                            System.out.print("请输入起飞机场:");
                            String DepartureAirPort = scanner.next();
                            try {
                                Flight flight1 = flightService.getFlightByDepartureAirPort(DepartureAirPort);
                                if (flight1!=null){
                                    System.out.println("航班信息："+flight1);

                                }else {
                                    System.out.println("您所查询的航班不存在，请重新输入！");
                                }

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else if (choices==4){
                            System.out.print("请输入目的机场:");
                            String destinationAirPort = scanner.next();
                            try {
                                Flight flight1 = flightService.getFlightByDestinationAirPort(destinationAirPort);
                                if (flight1!=null){
                                    System.out.println("航班信息："+flight1);

                                }else {
                                    System.out.println("您所查询的航班不存在，请重新输入！");
                                }

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
            }
        }

    }
}
