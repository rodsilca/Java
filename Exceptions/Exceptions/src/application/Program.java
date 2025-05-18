package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int room = sc.nextInt();
            System.out.println("Check in date (DD/MM/YYYY):");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.println("Check out date (DD/MM/YYYY):");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt);


            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println("Reservation: " + reservation.toString());

            System.out.println();
            System.out.println("Update reservation:");
            System.out.println("Check in date (DD/MM/YYYY):");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.println("Check out date (DD/MM/YYYY):");
            checkOut = LocalDate.parse(sc.next(), fmt);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation.toString());

        }
        catch (DateTimeParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: "+ e.getMessage());
        }
    }
}
