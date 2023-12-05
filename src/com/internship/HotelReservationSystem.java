package com.internship;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem 
{
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static int reservationCounter = 1;

    public static void main(String[] args) 
    {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        // Add more rooms as needed
    }

    private static void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isReserved()) {
                System.out.println("Room " + room.getRoomNumber() + " - " + room.getCategory());
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter the room number you want to reserve: ");
        int roomNumber = scanner.nextInt();

        Room selectedRoom = findRoom(roomNumber);

        if (selectedRoom != null && !selectedRoom.isReserved()) {
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter your name: ");
            String guestName = scanner.nextLine();

            selectedRoom.reserveRoom();
            reservations.add(new Reservation(reservationCounter++, roomNumber, guestName));

            System.out.println("Reservation successful!");
        } else {
            System.out.println("Invalid room number or the room is already reserved. Reservation failed.");
        }
    }
    private static void viewBookingDetails() {
        System.out.println("Booking Details:");
        for (Reservation reservation : reservations) {
            System.out.println("Reservation Number: " + reservation.getReservationNumber());
            System.out.println("Guest Name: " + reservation.getGuestName());
            System.out.println("Room Number: " + reservation.getRoomNumber());
            System.out.println("---------------------------");
        }
    }

    private static Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}