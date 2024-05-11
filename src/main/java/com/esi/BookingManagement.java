package com.esi;

import com.esi.dao.BookingFileHandler;
import com.esi.dao.BookingJsonHandler;
import com.esi.dao.BookingTxtHandler;
import com.esi.services.HotelBookingService;

public class BookingManagement {

    public static void main(String[] args){
//        BookingTxtHandler fileHandler = new BookingTxtHandler("reservahotels.txt");
        BookingJsonHandler fileHandler = new BookingJsonHandler("reservahotels.json");
        HotelBookingService hotelBookingService = new HotelBookingService(fileHandler);
        hotelBookingService.adicionarBooking();
        hotelBookingService.lerDoFicheiro();
    }
}
