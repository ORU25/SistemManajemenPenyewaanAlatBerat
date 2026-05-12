/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.model;

/**
 *
 * @author oru
 */
public class Bulldozer extends AlatBerat{
    private String tipeBlade; 
    
    public Bulldozer(String idAlat, String namaAlat, double hargaSewaPerHari, String tipeBlade) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.tipeBlade = tipeBlade;
    }

    public String getTipeBlade() {
        return tipeBlade;
    }
    
    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = this.hargaSewaPerHari * lamaSewa;
        // Diskon Bulldozer 5% diterapkan (Sewa >= 5 Hari)
        if (lamaSewa >= 5) {
            return totalDasar * 0.95;
        }
        return totalDasar;
    }
}
