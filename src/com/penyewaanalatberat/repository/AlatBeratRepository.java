/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.repository;
import java.util.ArrayList;
import java.util.List;
import com.penyewaanalatberat.model.AlatBerat;

/**
 *
 * @author oru
 */
public class AlatBeratRepository {
    private List<AlatBerat> alatList = new ArrayList<>();

    public void tambah(AlatBerat alat) { 
        alatList.add(alat); 
    }
    
    public List<AlatBerat> getSemuaAlat() { 
        return alatList; 
    }
    
    public void hapus(int index) { 
        if(index >= 0 && index < alatList.size()) {
            alatList.remove(index);
        }
    }
    
    public AlatBerat getByIndex(int index) {
        if(index >= 0 && index < alatList.size()) {
            return alatList.get(index);
        }
        return null;
    }
    
    public void update(int index, AlatBerat alat) {
        if(index >= 0 && index < alatList.size()) {
            alatList.set(index, alat);
        }
    }
}