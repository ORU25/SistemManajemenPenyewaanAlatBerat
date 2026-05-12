/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.service;
import com.penyewaanalatberat.model.AlatBerat;
import com.penyewaanalatberat.model.Penyewaan;
import com.penyewaanalatberat.repository.PenyewaanRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PenyewaanService {
    private PenyewaanRepository repository = new PenyewaanRepository();

    private String generatePenyewaanId() {
        int max = 0;
        for (Penyewaan p : repository.getAll()) {
            String id = p.getIdPenyewaan();
            if (id != null && id.startsWith("SEWA")) {
                try {
                    int value = Integer.parseInt(id.substring(4));
                    if (value > max) {
                        max = value;
                    }
                } catch (NumberFormatException ex) {
                }
            }
        }
        return "SEWA" + (max + 1);
    }

    public List<Penyewaan> getAll() {
        return repository.getAll();
    }

    public Penyewaan getByIndex(int index) {
        return repository.getByIndex(index);
    }

    public void tambahPenyewaan(String namaPenyewa, String lamaSewaText, AlatBerat alatDipilih) {
        if (alatDipilih == null) {
            throw new IllegalArgumentException("Alat Berat tidak valid atau belum dipilih.");
        }

        namaPenyewa = namaPenyewa.trim();
        lamaSewaText = lamaSewaText.trim();

        if (namaPenyewa.isEmpty() || lamaSewaText.isEmpty()) {
            throw new IllegalArgumentException("Nama Penyewa dan Lama Sewa wajib diisi.");
        }

        try {
            int lamaSewa = Integer.parseInt(lamaSewaText);
            if (lamaSewa <= 0) {
                throw new IllegalArgumentException("Lama sewa harus lebih dari 0 hari.");
            }

            Penyewaan penyewaan = new Penyewaan(generatePenyewaanId(), namaPenyewa, alatDipilih, lamaSewa);
            repository.tambah(penyewaan);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lama sewa harus berupa angka.");
        }
    }

    public void updatePenyewaan(int index, String namaPenyewa, String lamaSewaText, AlatBerat alatBaru) {
        if (index < 0 || index >= repository.getAll().size()) {
            throw new IllegalArgumentException("Data penyewaan tidak ditemukan.");
        }
        
        if (alatBaru == null) {
            throw new IllegalArgumentException("Alat Berat tidak valid atau belum dipilih.");
        }

        namaPenyewa = namaPenyewa.trim();
        lamaSewaText = lamaSewaText.trim();

        if (namaPenyewa.isEmpty() || lamaSewaText.isEmpty()) {
            throw new IllegalArgumentException("Nama Penyewa dan Lama Sewa wajib diisi.");
        }

        try {
            int lamaSewa = Integer.parseInt(lamaSewaText);
            if (lamaSewa <= 0) {
                throw new IllegalArgumentException("Lama sewa harus lebih dari 0 hari.");
            }

            Penyewaan lama = repository.getByIndex(index);
            Penyewaan update = new Penyewaan(lama.getIdPenyewaan(), namaPenyewa, alatBaru, lamaSewa);
            repository.update(index, update);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lama sewa harus berupa angka.");
        }
    }

    public void hapusPenyewaan(int index) {
        repository.hapus(index);
    }

    public List<Penyewaan> cariPenyewaan(String keyword) {
        List<Penyewaan> hasilPencarian = new ArrayList<>();
        keyword = keyword.toLowerCase().trim();

        for (Penyewaan p : repository.getAll()) {
            if (p.getNamaPenyewa().toLowerCase().contains(keyword) ||
                p.getIdPenyewaan().toLowerCase().contains(keyword)) {
                hasilPencarian.add(p);
            }
        }
        return hasilPencarian;
    }
}