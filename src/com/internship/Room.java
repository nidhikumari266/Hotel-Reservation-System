package com.internship;
class Room 
{
    private int roomNumber;
    private String category;
    private boolean isReserved;

    public Room(int roomNumber, String category) 
    {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isReserved = false;
    }

    public int getRoomNumber() 
    {
        return roomNumber;
    }

    public String getCategory() 
    {
        return category;
    }

    public boolean isReserved()
    {
        return isReserved;
    }

    public void reserveRoom() 
    {
        isReserved = true;
    }
}