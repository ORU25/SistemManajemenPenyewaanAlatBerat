/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penyewaanalatberat.main;
import com.penyewaanalatberat.view.MainMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author oru
 */
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MainMenu menu = new MainMenu();
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);

        });

    }
}
