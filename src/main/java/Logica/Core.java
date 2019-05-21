/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Darkgrey93
 */
public class Core {
    
    Util bin=new Util("A.jpg");
    double errorgeneral;
    //ArrayList lista=new ArrayList();
    ArrayList<Double> entradas=new ArrayList<Double>();
    ArrayList<Double> entradasfilas=new ArrayList<Double>();
    ArrayList<Double> entradascolumnas=new ArrayList<Double>();
    ArrayList<NeuronaHide> capaHide=new ArrayList<NeuronaHide>();
    ArrayList<NeuronaHide> CapaY=new ArrayList<NeuronaHide>();
    //Factor de Aprendizaje
    double factorAprendizaje=0.5;
    NeuronaHide y1=new NeuronaHide();// neuronas de salida
    int nNeuronas;
    double errorEsperado;
   
    public Core(double errorEsperado,double factorAprendizaje, int nNeuronas) throws IOException {
      this.factorAprendizaje=factorAprendizaje;
      this.nNeuronas=nNeuronas;
      this.errorEsperado=nNeuronas;
      bin.binarizarImagen(200);
      entradas=bin.convertirArreglo2dTo1Dv2(200);
      entradasfilas=bin.sacarFilas(entradas);
      entradascolumnas=bin.sacarColumnas(entradas);
      entradas.clear();
      for(int i=0;i<entradasfilas.size();i++){
          entradas.add(entradasfilas.get(i));
      }
      for(int i=0;i<entradascolumnas.size();i++){
          entradas.add(entradascolumnas.get(i));
      }
      for (int i = 0; i < entradas.size(); i++) {//creamos la capa oculta
        NeuronaHide h1=new NeuronaHide();
        for(int j=0;j<entradas.size();j++){
            
            Double aux=entradas.get(j);
            h1.entradas.add(aux);
        }
        capaHide.add(h1);
       }
      CapaY.add(y1);// se crea la capa de salida
      
      int iteraciones;
      
     // double errorEsperado=0.09;
        iteraciones=1;
        while(iteraciones<1000){//Ciclo que controla cuantas veces se realizan los calculos(ENTRENAMIENTO)
            CapaY.get(0).entradas.clear();
            if(iteraciones==1){
                for(int i=0;i<capaHide.size();i++){//llenamos pesos con respecto a las entradas una sola ve
                    capaHide.get(i).llenarPesos();
                }    
            }
            
             //sumamos pesos * entradas y los sumamos entre si 
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).sumarPesos();
            } 
            for(int i=0;i<capaHide.size();i++){//se activa la alida de cada neurona
                    capaHide.get(i).activacionSigmoidal();
            } 
            for(int i=0;i<capaHide.size();i++){//se pasan las salidadas a las neuronas de salida
                CapaY.get(0).entradas.add(capaHide.get(i).y);
            } 
            
            if(iteraciones==1){
                CapaY.get(0).llenarPesos();
            }
            CapaY.get(0).sumarPesos();// se suman los pesos y entradas de la neurona de salida
            CapaY.get(0).activacionSigmoidal();//se activa la salida de la neuronade salida
            //------backpropagation---------------------------------------
            errorgeneral=CapaY.get(0).calcularErrorS(1.0);// se calcula el error con lo obtenido comparandolo con las salida
            CapaY.get(0).reCalculo(factorAprendizaje,errorgeneral);//se recalaculan los pesos y bias de la neurona de salida
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).calcularError(errorgeneral);// se calcula error de las neuronas de la capa oculta
            }
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).reCalculo(factorAprendizaje);// se calcula error de las neuronas de la capa oculta
            } 
            
            iteraciones++;
        }
        System.out.println("Calculado: "+CapaY.get(0).y);
            //incremento para la siguiente fila
        //fila++;
        System.out.println("el numero de iteraciones fue: "+iteraciones );
      }  
        
    }
        
    

    

