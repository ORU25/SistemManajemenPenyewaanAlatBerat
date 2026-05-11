/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.model;

/**
 *
 * @author oru
 */
public class Crane extends AlatBerat {
    private double kapasitasAngkat; 

    public Crane(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasAngkat) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasAngkat = kapasitasAngkat;
    }

    public double getKapasitasAngkat() {
        return kapasitasAngkat;
    }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Angkat " + this.kapasitasAngkat + " Ton");
    }

    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = this.hargaSewaPerHari * lamaSewa;
        if (lamaSewa >= 3) {
            System.out.println("   [!] Diskon Spesial Crane 15% diterapkan (Sewa >= 3 Hari)");
            return totalDasar * 0.85;
        }
        return totalDasar;
    }
}
