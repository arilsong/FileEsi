package com.esi.dao;

import com.esi.models.Booking;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookingFileHandler {

    private Path caminhoFicheiro;

    public BookingFileHandler(String nomeFicheiro) {
        this.caminhoFicheiro = Paths.get(nomeFicheiro);
    }

    public void ecreverNoFicheiro(List<Booking> bookings) throws IOException {
        List<String> linhas = new ArrayList<>();
        for(Booking  booking : bookings){
            linhas.add(booking.toString());
        }

        Files.write(caminhoFicheiro,linhas, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public List<Booking> lerDoFicheiro() throws IOException {
        List<Booking> bookings = new ArrayList<>();
        List<String> linhas = null;

        try {
            linhas = Files.readAllLines(caminhoFicheiro, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro na leitura do ficheiro" + e.getMessage().toString());
        }
        for(String linha:linhas){
            bookings.add(Booking.formStringToObject(linha));
        }
        return bookings;
    }
}
