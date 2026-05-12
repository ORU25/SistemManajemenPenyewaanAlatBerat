/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.repository;
import java.util.ArrayList;
import java.util.List;
import com.penyewaanalatberat.interfaces.Repository;
import com.penyewaanalatberat.model.Penyewaan;

/**
 *
 * @author ASUS
 */
public class PenyewaanRepository implements Repository<Penyewaan> {
    private List<Penyewaan> penyewaanList = new ArrayList<>();

    @Override
    public void tambah(Penyewaan p) {
        penyewaanList.add(p);
    }

    @Override
    public List<Penyewaan> getAll() {
        return penyewaanList;
    }

    @Override
    public void hapus(int index) {
        if (index >= 0 && index < penyewaanList.size()) {
            penyewaanList.remove(index);
        }
    }

    @Override
    public Penyewaan getByIndex(int index) {
        if (index >= 0 && index < penyewaanList.size()) {
            return penyewaanList.get(index);
        }
        return null;
    }

    @Override
    public void update(int index, Penyewaan p) {
        if (index >= 0 && index < penyewaanList.size()) {
            penyewaanList.set(index, p);
        }
    }
}