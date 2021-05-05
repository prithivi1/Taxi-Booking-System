package com.company;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int taxiID;
    int earing;
    char currentPosition;
    int arrivalTime;
    int departureTime;
    List<Booking> myBooking = new ArrayList<>();

    public Taxi(int taxiID) {
        this.taxiID = taxiID;
        this.earing = 0;
        this.currentPosition = 'A';
        this.arrivalTime = 0;
        this.departureTime = 0;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    public int getEaring() {
        return earing;
    }

    public void setEaring(int earing) {
        this.earing = earing;
    }


    public char getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(char currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public List<Booking> getMyBooking() {
        return myBooking;
    }

    public void setMyBooking(Booking booking) {
        this.myBooking.add(booking);
    }
}
