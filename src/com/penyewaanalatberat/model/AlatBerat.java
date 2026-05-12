/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.model;

/**
 *
 * @author oru
 */
public abstract class AlatBerat {
    protected String idAlat;
    protected String namaAlat;
    protected double hargaSewaPerHari;
    
    public String getIdAlat() { return idAlat; }
    public void setIdAlat(String idAlat) { this.idAlat = idAlat; }

    public String getNamaAlat() { return namaAlat; }
    public void setNamaAlat(String namaAlat) { this.namaAlat = namaAlat; }

    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public void setHargaSewaPerHari(double hargaSewaPerHari) { this.hargaSewaPerHari = hargaSewaPerHari; }
    
    public AlatBerat(String idAlat, String namaAlat, double hargaSewaPerHari) {
        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }


    public abstract double hitungBiayaAlat(int lamaSewa);
}
