/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.model;

/**
 *
 * @author oru
 */
public class Excavator extends AlatBerat {
    private double kapasitasBucket; 

    public Excavator(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasBucket) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasBucket = kapasitasBucket;
    }

    public double getKapasitasBucket() {
        return kapasitasBucket;
    }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Bucket " + this.kapasitasBucket + " m3");
    }

    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = this.hargaSewaPerHari * lamaSewa;
        if (lamaSewa >= 7) {
            System.out.println("   [!] Diskon Excavator 10% diterapkan (Sewa >= 7 Hari)");
            return totalDasar * 0.90; 
        }
        return totalDasar;
    }
}
