package com.esi.models;

import com.google.gson.Gson;

public class Booking {

    private String nomeCliente;
    private String numeroQuarto;
    private String dataEntrada;
    private String dataSaida;

    public Booking(String nomeCliente, String numeroQuarto, String dataEntrada, String dataSaida) {
        this.nomeCliente = nomeCliente;
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", nomeCliente, numeroQuarto, dataEntrada, dataSaida);
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Booking formStringToObject(String linha){
        String[] partes = linha.split(",");
        if(partes.length ==4){
            return new Booking(partes[0], partes[1], partes[2], partes[3]);
        }
        throw new IllegalArgumentException("verifcar dados no ficheiro (estrutura)");
    }
}
