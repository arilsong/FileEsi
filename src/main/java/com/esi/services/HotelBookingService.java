package com.esi.services;

import com.esi.dao.BookingFileHandler;
import com.esi.dao.BookingJsonHandler;
import com.esi.dao.BookingTxtHandler;
import com.esi.models.Booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingService {

    private final BookingFileHandler bookingFileHandler;

    public HotelBookingService(BookingTxtHandler bookingTxtHandler) {
        this.bookingFileHandler = bookingTxtHandler;
    }

    public HotelBookingService(BookingJsonHandler bookingJsonHandler) {
        this.bookingFileHandler = bookingJsonHandler;
    }

    public void adicionarBooking(){

        List<Booking> bookings = new ArrayList<>();

        bookings.add(new Booking("nelson", "401", "2022-02-02", "2022-03-03"));
        bookings.add(new Booking("Alice", "402", "2022-03-02", "2022-04-03"));

        try {
            bookingFileHandler.ecreverNoFicheiro(bookings);
            System.out.println("bookings inserido com sucesso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lerDoFicheiro(){
        List<Booking> bookings = null;
        try {
            bookings = bookingFileHandler.lerDoFicheiro();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reservas já efetuadas:");
        for(Booking booking:bookings)
            System.out.println(booking);
    }
}
