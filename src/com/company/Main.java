package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Taxi> allTaxi = new ArrayList<>();
    static List<Booking> allBooking = new ArrayList<>();
    static int bookingID = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    for(int i=1;i<=4;i++)
        {
            Taxi taxi = new Taxi(i);
            allTaxi.add(taxi);
        }

	    while (true)
        {
            System.out.println("****** CALL TAXT BOOKING ******");
            System.out.println("1.BOOK TAXI");
            System.out.println("2.DISPLAY TAXI DETAILS");
            System.out.println("3.TAXI STATUS");
            System.out.println("4.EXIT");
            System.out.println();
            System.out.println("ENTER YOUR CHOICE : ");
            int n = sc.nextInt();
            switch (n)
            {
                case 1 :
                    booking();
                    break;
                case 2:
                    taxiDetails();
                    break;
                case 3:
                    taxiStatus();
                    break;
                case 4:
                    System.out.println("THANKS YOU!!");
                    return;
                default:
                    System.out.println("ENTER VALID CHOICE!!!");
                    break;
            }
        }
    }

    public static void booking()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER CUSTOMER ID : ");
        int customerID = sc.nextInt();
        sc.nextLine();


        System.out.println("ENTER PICKUP POINT : ");
        char pickUp = sc.next().charAt(0);


        System.out.println("ENTER DROP POINT : ");
        char drop = sc.next().charAt(0);


        System.out.println("ENTER PICK UP TIME : ");
        int pickUpTime = sc.nextInt();
        sc.nextLine();


        int available = taxiAvailablity(pickUpTime,pickUp);

        if(available!=0) {
            int duration = calculateDuration(pickUp, drop);
            int cost = calculateCost(duration, pickUp, drop);

            System.out.println("AMOUNT TO BE PAID : " + cost);
            System.out.println("ENTER 1 TO CONFIRM 0 TO CANCEL");
            int n = sc.nextInt();
            if (n == 1)
            {

                Taxi taxi = allTaxi.get(available - 1);

                Booking booking = new Booking(bookingID, customerID, pickUp, drop, pickUpTime, (pickUpTime + duration), cost, available);

                allBooking.add(booking);
                bookingID++;

                taxi.setEaring(taxi.getEaring() + cost);
                taxi.setCurrentPosition(drop);
                taxi.setArrivalTime(pickUpTime);
                taxi.setDepartureTime(pickUpTime + duration);
                taxi.setMyBooking(booking);

                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("BOOKING CONFIRMED");
                System.out.println("TAXI-" + available + " HAS BEEN ALLOCATED");
                System.out.println("PICK UP POINT   : "+pickUp);
                System.out.println("DROP POINT      : "+drop);
                System.out.println("BOARDING TIME   : "+pickUpTime);
                System.out.println("ESTIMATED TIME  : "+duration);
                System.out.println("AMOUNT            : "+cost);
                System.out.println("THANKS FOR BOOKING!!..ENJOY YOUR RIDE");
                System.out.println("----------------------------------------");
                System.out.println();
            }else {
                    System.out.println("BOOKING CANCELLED");
                }
        } else {
                System.out.println();
                System.out.println("OOPS !! SORRY NO TAXI AVAILABLE AT THIS TIME...TRY DIFFERENT TIME");
                System.out.println();
            }

    }

    public static int taxiAvailablity(int pickUpTime,char pickUp)
    {
        int distance = 6,taxiID = 0;
        for(int i=0;i<allTaxi.size();i++)
        {
            Taxi taxi = allTaxi.get(i);
            if (taxi.getDepartureTime()<=pickUpTime)
            {
                if(Math.abs(taxi.getCurrentPosition() - pickUp)< distance)
                {
                    taxiID = i+1;;
                    distance = Math.abs(taxi.getCurrentPosition()-pickUp);
                }
                if(Math.abs(taxi.getCurrentPosition() - pickUp)==distance)
                {
                    if(allTaxi.get(taxiID-1).getEaring()>taxi.getEaring())
                    {
                        taxiID=i+1;
                    }
                }
            }
        }
        if(taxiID==0)
        {
            return 0;
        }
        return taxiID;
    }

    public static int calculateDuration(char pickUp,char Drop)
    {
        return Math.abs(pickUp-Drop);
    }

    public static int calculateCost(int distance,char pickUp,char Drop)
    {
        int cost = 100;
        cost+=((distance*15)-5)*10;
        return cost;
    }


    public static void taxiDetails()
    {
        for (int i=0;i<allTaxi.size();i++) {
            Taxi taxi = allTaxi.get(i);
            System.out.println("--------------------------------------------------------");
            System.out.format("%-10s%-10s%-15s%-10s", "TAXI NO : ", taxi.getTaxiID(), "TOTAL EARNINGS : ", taxi.getEaring());
            System.out.println();
            System.out.println("---------------------------------------------------------");
            List<Booking> bookings = taxi.getMyBooking();
            if (bookings.size() != 0) {
                System.out.format("%-15s%-15s%-10s%-10s%-15s%-15s%-10s", "BOOKING ID", "CUSTOMER ID", "PICK UP", "DROP","PICK-UP TIME","DROP TIME", "AMOUNT");
                System.out.println();

                for (int j = 0; j < bookings.size(); j++) {
                    System.out.format("%-15s%-15s%-10s%-10s%-15s%-15s%-10s", bookings.get(j).getBookingID(), bookings.get(j).getCustomerID(),
                            bookings.get(j).getPickUpPoint(), bookings.get(j).getDropPoint(), bookings.get(j).getPickUpTime(),bookings.get(j).getDropTime(),bookings.get(j).getCost());
                    System.out.println();
                }
                System.out.println("-----------------------------------------------------------");
                System.out.println();
                System.out.println();
            }
        }
    }

    public static void taxiStatus()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("TAXI STATUS");
        System.out.println();
        System.out.println("ENTER TIME TO CHECK STATUS");
        int n = sc.nextInt();

        for(int i=0;i<allTaxi.size();i++)
        {
            if(n<allTaxi.get(i).getArrivalTime() || n>allTaxi.get(i).getDepartureTime())
            {
                System.out.println("TAXI-"+(i+1)+" AVAILABLE");
            }else{
                System.out.println("TAXI-"+(i+1)+" NOT AVAILABLE");
            }
        }
    }
}
