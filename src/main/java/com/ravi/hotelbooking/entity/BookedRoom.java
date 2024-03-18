package com.ravi.hotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private  String guestEmail;
    private int numberofAdults;
    private int numberofChildren;
    private int totalNumofGuest;
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;



    public void calculateTotalNumOfGuests(){
        this.totalNumofGuest = this.numberofAdults + this.numberofChildren;
    }

    public void setNumberofAdults(int numberofAdults) {
        this.numberofAdults = numberofAdults;
        calculateTotalNumOfGuests();
    }

    public void setNumberofChildren(int numberofChildren) {
        this.numberofChildren = numberofChildren;
        calculateTotalNumOfGuests();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
