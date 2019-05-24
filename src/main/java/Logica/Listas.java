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
public class Listas {
    ArrayList<NeuronaHide> capaHide=new  ArrayList<NeuronaHide>();
    ArrayList<NeuronaHide> capaY=new  ArrayList<NeuronaHide>();

    public ArrayList<NeuronaHide> getCapaHide() {
        return capaHide;
    }

    public void setCapaHide(ArrayList<NeuronaHide> capaHide) {
        this.capaHide = capaHide;
    }

    public ArrayList<NeuronaHide> getCapaY() {
        return capaY;
    }

    public void setCapaY(ArrayList<NeuronaHide> capaY) {
        this.capaY = capaY;
    }
}
