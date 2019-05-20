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
    double [][] arregloXOR = {
                        {1, 1, 0},
                        {1, 0, 1},
                        {0, 1, 1},
                        {0, 0, 0}
                        };
    
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
    NeuronaHide h1=new NeuronaHide();
    NeuronaHide h2=new NeuronaHide();
    NeuronaHide y1=new NeuronaHide();
   
    public Core() throws IOException {
      bin.binarizarImagen(200);
      entradas=bin.convertirArreglo2dTo1Dv2(200);
      entradasfilas=bin.sacarFilas(entradas);
        for (int i = 0; i < entradas.size(); i++) {
            for(int j=0;j<entradas.size();j++){
            NeuronaHide h1=new NeuronaHide();
            Double aux=entradas.get(j);
            h1.entradas.add(aux);
            
            }
            capaHide.add(h1);
        }
      int fila=0;
      int iteraciones;
      
     // double errorEsperado=0.09;
      while(fila<=3){
        iteraciones=1;
        while(iteraciones<1000){//Ciclo que controla cuantas veces se realizan los calculos(ENTRENAMIENTO)
            h1.entradas.clear();
            h2.entradas.clear();
            y1.entradas.clear();//limpiamos todos los array list
            h1.entradas.add(arregloXOR[fila][0]);// se le pasa a cada neurona cada 0 y 1 de la matriz a analizar
            h1.entradas.add(arregloXOR[fila][1]);//esto se debe hacer dinamico para que sea una entrada cualquiera de 0 y 1s
            h2.entradas.add(arregloXOR[fila][0]);
            h2.entradas.add(arregloXOR[fila][1]);
            if(iteraciones==1){
                h1.llenarPesos();//llenamos pesos con respecto a las entradas una sola vez
                h2.llenarPesos();
            }
            
            h1.sumarPesos(); //sumamos pesos * entradas y los sumamos entre si 
            h2.sumarPesos();
            h1.activacionSigmoidal();
            h2.activacionSigmoidal();//se activa la alida de cada neurona
            y1.entradas.add(h1.y);//se pasan las salidadas a las neuronas de salida
            y1.entradas.add(h2.y);
            if(iteraciones==1){
                y1.llenarPesos();
            }
            y1.sumarPesos();// se suman los pesos y entradas de la neurona de salida
            y1.activacionSigmoidal();//se activa la salida de la neuronade salida
            //------backpropagation---------------------------------------
            errorgeneral=y1.calcularErrorS(arregloXOR[fila][2]);// se calcula el error con lo obtenido comparandolo con las salida
            y1.reCalculo(factorAprendizaje,errorgeneral);//se recalaculan los pesos y bias de la neurona de salida
            h1.calcularError(errorgeneral);// se calcula error de las neuronas de la capa oculta
            h2.calcularError(errorgeneral);
            h1.reCalculo(factorAprendizaje);//se recalculan los pesos de las neuronas de la capa oculta pasandole el coeficiente de 
            h2.reCalculo(factorAprendizaje);
            
            
            iteraciones++;
        }
        System.out.println(""+(int)arregloXOR[fila][0]+"\tXOR\t"+(int)arregloXOR[fila][1]+"\t=\t" + (int)arregloXOR[fila][2]+"\tCalculado: "+y1.y);
            //incremento para la siguiente fila
        fila++;
        System.out.println("el numero de iteraciones fue: "+iteraciones );
      }  
        
    }
        
    

    
}
