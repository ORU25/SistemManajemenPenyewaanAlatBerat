/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.penyewaanalatberat.interfaces;
import java.util.List;

/**
 *
 * @author oru
 */
public interface Repository<Type> {
    List<Type> getAll();
    Type getByIndex(int index);
    void tambah(Type T);
    void update(int index, Type T);
    void hapus(int index);
}
