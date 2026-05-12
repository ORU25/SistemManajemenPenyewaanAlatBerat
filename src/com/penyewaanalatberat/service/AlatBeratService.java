/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.service;
import com.penyewaanalatberat.model.AlatBerat;
import com.penyewaanalatberat.model.Bulldozer;
import com.penyewaanalatberat.model.Crane;
import com.penyewaanalatberat.model.Excavator;
import com.penyewaanalatberat.repository.AlatBeratRepository;
import java.util.List;

/**
 * 
 * @author oru
 */
public class AlatBeratService {
    private AlatBeratRepository repository = new AlatBeratRepository();

    private String generateAlatId() {
        int max = 0;
        for (AlatBerat alat : repository.getSemuaAlat()) {
            String id = alat.getIdAlat();
            if (id != null && id.startsWith("AB")) {
                try {
                    int value = Integer.parseInt(id.substring(2));
                    if (value > max) {
                        max = value;
                    }
                } catch (NumberFormatException ex) {
                }
            }
        }
        return "AB" + (max + 1);
    }

    public List<AlatBerat> getSemuaAlat() {
        return repository.getSemuaAlat();
    }

    public AlatBerat getByIndex(int index) {
        return repository.getByIndex(index);
    }
    
    public void tambahAlatBerat(String jenis, String nama, String hargaText, String tambahan) {
        if (jenis == null || jenis.isEmpty()) {
            throw new IllegalArgumentException("Pilih jenis alat berat terlebih dahulu.");
        }
        
        nama = nama.trim();
        if (nama.isEmpty()) {
            throw new IllegalArgumentException("Nama alat berat wajib diisi.");
        }   
        
        double harga;
        try {
            harga = Double.parseDouble(hargaText.trim());
            if (harga <= 0) {
                throw new IllegalArgumentException("Harga sewa harus lebih dari 0.");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Harga sewa harus berupa angka.");
        }
        
        tambahan = tambahan.trim();
        if (tambahan.isEmpty()) {
            throw new IllegalArgumentException("Property tambahan wajib diisi.");
        }
        
        String id = generateAlatId();        
        AlatBerat alat = buildAlatBerat(jenis, id, nama, harga, tambahan);
        
        repository.tambah(alat);
    }

    private AlatBerat buildAlatBerat(String jenis, String id, String nama, double harga, String tambahan) {
        switch (jenis) {
            case "Bulldozer":
                return new Bulldozer(id, nama, harga, tambahan);
            case "Crane":
                try {
                    double kapasitasAngkat = Double.parseDouble(tambahan);
                    return new Crane(id, nama, harga, kapasitasAngkat);
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Kapasitas angkat harus berupa angka.");
                }
            case "Excavator":
                try {
                    double kapasitasBucket = Double.parseDouble(tambahan);
                    return new Excavator(id, nama, harga, kapasitasBucket);
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Kapasitas bucket harus berupa angka.");
                }
                
            default:
                throw new IllegalArgumentException("Jenis alat berat tidak dikenali.");
        }
    }
    
    public void updateAlatBerat(int index, String jenis, String nama, String hargaText, String tambahan) {
        if (index < 0 || index >= repository.getSemuaAlat().size()) {
            throw new IllegalArgumentException("Data tidak ditemukan.");
        }
        
        AlatBerat alatLama = repository.getByIndex(index);
        String id = alatLama.getIdAlat();
        
        if (jenis == null || jenis.isEmpty()) {
            throw new IllegalArgumentException("Pilih jenis alat berat terlebih dahulu.");
        }
        
        nama = nama.trim();
        if (nama.isEmpty()) {
            throw new IllegalArgumentException("Nama alat berat wajib diisi.");
        }
        
        double harga;
        try {
            harga = Double.parseDouble(hargaText.trim());
            if (harga <= 0) {
                throw new IllegalArgumentException("Harga sewa harus lebih dari 0.");
            }
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Harga sewa harus berupa angka.");
        }
        
        tambahan = tambahan.trim();
        if (tambahan.isEmpty()) {
            throw new IllegalArgumentException("Property tambahan wajib diisi.");
        }
        
        AlatBerat alatBaru = buildAlatBerat(jenis, id, nama, harga, tambahan);
        
        repository.update(index, alatBaru);
    }

    public void hapusAlatBerat(int index) {
        repository.hapus(index);
    }
}
    