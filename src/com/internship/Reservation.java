package com.internship;
class Reservation 
{
    private int reservationNumber;
    private int roomNumber;
    private String guestName;

    public Reservation(int reservationNumber, int roomNumber, String guestName) 
    {
        this.reservationNumber = reservationNumber;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
    }

    public int getReservationNumber()
    {
        return reservationNumber;
    }

    public int getRoomNumber() 
    {
        return roomNumber;
    }

    public String getGuestName() 
    {
        return guestName;
    }
}