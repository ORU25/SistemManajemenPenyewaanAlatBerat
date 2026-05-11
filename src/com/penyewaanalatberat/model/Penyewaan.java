/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.model;

/**
 *
 * @author ASUS
 */

public class Penyewaan {
    private String idPenyewaan;
    private String namaPenyewa;
    private AlatBerat alatBerat;
    private int lamaSewa;
    private double totalBiaya;

    public Penyewaan(String idPenyewaan, String namaPenyewa, AlatBerat alatBerat, int lamaSewa) {
        this.idPenyewaan = idPenyewaan;
        this.namaPenyewa = namaPenyewa;
        this.alatBerat = alatBerat;
        this.lamaSewa = lamaSewa;
        this.totalBiaya = alatBerat.hitungBiayaAlat(lamaSewa); 
    }

    public String getIdPenyewaan() { return idPenyewaan; }
    public String getNamaPenyewa() { return namaPenyewa; }
    public AlatBerat getAlatBerat() { return alatBerat; }
    public int getLamaSewa() { return lamaSewa; }
    public double getTotalBiaya() { return totalBiaya; }
}
