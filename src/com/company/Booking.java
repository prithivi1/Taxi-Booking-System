package com.company;

public class Booking {
    int BookingID;
    int customerID;
    char pickUpPoint;
    char dropPoint;
    int pickUpTime;
    int dropTime;
    int cost;
    int allocatedTaxi;

    public Booking(int bookingID, int customerID, char pickUpPoint, char dropPoint, int pickUpTime,int dropTime, int cost,int allocatedTaxi) {
        this.BookingID = bookingID;
        this.customerID = customerID;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
        this.pickUpTime = pickUpTime;
        this.dropTime = dropTime;
        this.cost = cost;
        this.allocatedTaxi = allocatedTaxi;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAllocatedTaxi() {
        return allocatedTaxi;
    }

    public void setAllocatedTaxi(int allocatedTaxi) {
        this.allocatedTaxi = allocatedTaxi;
    }
}
