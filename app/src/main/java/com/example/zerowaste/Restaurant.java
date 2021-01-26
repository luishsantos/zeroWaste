package com.example.zerowaste;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String nome;
    private String preco;
    private GeoPoint localizacao;
    private List<String> estado;
    private String magic_box;
    private String horario;
    private String morada;
    private String imagem;
    private ArrayList<Restaurant> restaurants;
    /*
    private CollectionReference collRef = FirebaseFirestore.getInstance().collection("restaurantes");
    private static final String TAG = "RestaurantClass";*/
    public Restaurant(){}

    public Restaurant(String nome, String preco, GeoPoint localizacao, List<String> estado, String magic_box, String horario, String morada, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.localizacao = localizacao;
        this.estado = estado;
        this.magic_box = magic_box;
        this.horario = horario;
        this.morada = morada;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public GeoPoint getLocalizacao() {
        return localizacao;
    }

    public List<String> getEstado() {
        return estado;
    }


    public String getMagic_box() {
        return magic_box;
    }
    public String getHorario() {
        return horario;
    }
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

     public String toString(){
        return "Nome:" + nome + "Morada: " + morada;
    }

    public String getMorada() { return morada; }

    public String getImagem() { return imagem; }
}
