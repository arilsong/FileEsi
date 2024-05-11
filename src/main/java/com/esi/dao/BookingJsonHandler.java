package com.esi.dao;

import com.esi.models.Booking;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookingJsonHandler extends BookingFileHandler implements  BookingHandler{
    private Path caminhoFicheiro;

    public BookingJsonHandler(String nomeFicheiro) {
        super(nomeFicheiro);
        this.caminhoFicheiro = Paths.get(nomeFicheiro);
    }
    @Override
    public void ecreverNoFicheiro(List<Booking> bookings) throws IOException {
        List<String> linhas = new ArrayList<>();
        for(Booking  booking : bookings){
            linhas.add(booking.toJson());
        }

        Files.write(caminhoFicheiro,linhas, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    @Override
    public List<Booking> lerDoFicheiro() throws IOException {
        List<Booking> bookings = new ArrayList<>();
        List<String> linhas = null;

        try {
            linhas = Files.readAllLines(caminhoFicheiro, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro na leitura do ficheiro" + e.getMessage().toString());
        }
        for(String linha:linhas){
            Gson gson = new Gson();
            Booking booking = gson.fromJson(linha, Booking.class);
            bookings.add(booking);
        }
        return bookings;
    }
}
