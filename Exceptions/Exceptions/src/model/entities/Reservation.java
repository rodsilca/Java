package model.entities;

import model.exceptions.DomainException;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(){}

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
        if(!checkOut.isAfter(checkIn)){
            throw new DomainException("Check out date must be after check in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Long duration(){
        return ChronoUnit.DAYS.between(checkIn,checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException{
        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now)||checkOut.isBefore(now)){
            throw new DomainException("Reservation dates must be future dates");
        }
        if(!checkOut.isAfter(checkIn)){
            throw new DomainException("Check out date must be after check in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room "+ roomNumber+", check-in: "+ checkIn.format(fmt)+", check-out: "+ checkOut.format(fmt)+", "+duration()+" nights");

        return sb.toString();
    }
}
