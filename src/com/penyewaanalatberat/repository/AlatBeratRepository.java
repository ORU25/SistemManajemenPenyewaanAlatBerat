/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.repository;
import java.util.ArrayList;
import java.util.List;
import com.penyewaanalatberat.model.AlatBerat;
import com.penyewaanalatberat.interfaces.Repository;

/**
 * 
 * @author oru
 */
public class AlatBeratRepository implements Repository<AlatBerat> {
    private List<AlatBerat> alatList = new ArrayList<>();
    
    @Override
    public void tambah(AlatBerat alat) { 
        alatList.add(alat); 
    }

    @Override
    public List<AlatBerat> getAll() { 
        return alatList; 
    }
    
    @Override
    public void hapus(int index) { 
        if(index >= 0 && index < alatList.size()) {
            alatList.remove(index);
        }
    }
    
    @Override
    public AlatBerat getByIndex(int index) {
        if(index >= 0 && index < alatList.size()) {
            return alatList.get(index);
        }
        return null;
    }
    
    @Override
    public void update(int index, AlatBerat alat) {
        if(index >= 0 && index < alatList.size()) {
            alatList.set(index, alat);
        }
    }
}