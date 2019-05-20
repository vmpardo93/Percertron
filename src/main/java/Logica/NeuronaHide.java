/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Darkgrey93
 */
public class NeuronaHide {
    
    ArrayList<Double> pesos = new ArrayList<Double>();
    ArrayList<Double> entradas = new ArrayList<Double>();
    Double y;
    Double yprima;
    Double yd;
    Double error;
    double bias=new Random().nextDouble();
    
    public void sumarPesos(){
        for(int i=0;i<entradas.size();i++){
            
            y=entradas.get(i)*pesos.get(i);
            
        }
        y=y+(1+bias);
    }
    public void activacionSigmoidal (){
        y = 1.0/(1 + Math.pow(Math.E, (-1) * y));
    }
    
    public void calcularError(double num){
        yprima= y*(1-y);
        error=yprima*(num-y);
    }
    public double calcularErrorS(double num){
        yprima= y*(1-y);
        error=yprima*(num-y);
        return error;
    }
    
    public void reCalculo(double factor, double error){
        for(int i=0;i<entradas.size();i++){
            
                Double auxP;
                auxP=pesos.get(i)+(factor*error*entradas.get(i));
                pesos.remove(i);
                pesos.add(i, auxP);
                
                
            
        }
        bias=error+bias;
    }
    public void reCalculo(double factor){
        for(int i=0;i<entradas.size();i++){
            
                Double auxP;
                auxP=pesos.get(i)+(factor*error*entradas.get(i));
                pesos.remove(i);
                pesos.add(i, auxP);
                
                
            
        }
        bias=error+bias;
    }
    
    
    public void llenarPesos(){
        double nums;
        
        for(int i=0;i<entradas.size();i++){
            nums=new Random().nextDouble();;
            nums=(nums+0.001)*0.001;
            pesos.add(nums);
        }
    }
    
}
