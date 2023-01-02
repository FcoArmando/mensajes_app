/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

/**
 *
 * @author fco_a
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        int opcionMenu = -1;
        String[] botones = {"1. Ver gatos","2. Salir"};
        
        do{
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos java", "Menu principal", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            
            for(int i=0; i<botones.length;i++){
                if(opcion.equals(botones[i])){
                    opcionMenu = i;
                }
            }
            switch(opcionMenu){
                case 0:
                    break;
                case 1:
                    break;
                default:
                    System.out.println("Seleccione una opción correcta");
            }
        }while(opcionMenu != 1);
    }
}
