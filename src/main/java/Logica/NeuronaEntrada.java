/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Darkgrey93
 */
public class NeuronaEntrada {
    Double[] entradas;
    
    public void recibir(Double[] recibido){
        this.entradas = recibido;
        for(int i = 0; i<=entradas.length;i++){
            entradas[i]=entradas[i]*1;
        }
    }
    
    
}
