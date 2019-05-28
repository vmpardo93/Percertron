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
    
    
    double errorgeneral;
    //ArrayList lista=new ArrayList();
    ArrayList<Double> entradas=new ArrayList<Double>();
    ArrayList<Double> entradasfilas=new ArrayList<Double>();
    ArrayList<Double> entradascolumnas=new ArrayList<Double>();
    ArrayList<NeuronaHide> capaHide=new ArrayList<NeuronaHide>();
    ArrayList<NeuronaHide> CapaY=new ArrayList<NeuronaHide>();
    ArrayList<Double> listaErrores=new ArrayList<Double>();
    ArrayList<Double> listaPesos=new ArrayList<Double>();
    //Factor de Aprendizaje
    double factorAprendizaje=0.5;
    NeuronaHide y1=new NeuronaHide();// neuronas de salida
    int nNeuronas;
    double errorEsperado;
   
    public  Core()  {
      
    }  
    
    public Listas reentrenar(ArrayList<NeuronaHide> capaHide,ArrayList<NeuronaHide> capaY,double errorEsperado,double factorAprendizaje, int nNeuronas, String ruta){
        Util bin=new Util(ruta);
        this.factorAprendizaje=factorAprendizaje;
        this.nNeuronas=nNeuronas;
        this.errorEsperado=errorEsperado;
        //bin.binarizarImagen(200);Esto es para blanco y negro
        //entradas=bin.convertirArreglo2dTo1Dv2(200);Esto es para blanco y negro
        entradas=bin.obtenerRgb();
        
        /*entradasfilas=bin.sacarFilas(entradas);//sacamos promedios filas
        entradascolumnas=bin.sacarColumnas(entradas);//sacamos promedios de columnas
        entradas.clear();//limpiamos el arreglo 1d
        for(int i=0;i<entradasfilas.size();i++){
            entradas.add(entradasfilas.get(i));//lo volvemos a armar
        }
        for(int i=0;i<entradascolumnas.size();i++){
          entradas.add(entradascolumnas.get(i));// lo volvemos a armar
        }*/
        int iteraciones;
        for(int i = 0; i<200;i++){
            capaHide.get(i).entradas.clear();//limpiamos entradas antiguas
        }
        for (int i = 0; i < 200; i++) {//llenamos con nuevas entradas
            for(int j=0;j<entradas.size();j++){
                Double aux=entradas.get(j);
                capaHide.get(i).entradas.add(aux);
            }
        }
        capaY.get(0).entradas.clear();
     // double errorEsperado=0.09;
        iteraciones=1;
        boolean aux=true;
        while(aux==true){//Ciclo que controla cuantas veces se realizan los calculos(ENTRENAMIENTO)
            
            capaY.get(0).entradas.clear();
            
            
            
             //sumamos pesos * entradas y los sumamos entre si 
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).sumarPesos();
            } 
            for(int i=0;i<capaHide.size();i++){//se activa la alida de cada neurona
                    capaHide.get(i).activacionSigmoidal();
            } 
            for(int i=0;i<capaHide.size();i++){//se pasan las salidadas a las neuronas de salida
               
                capaY.get(0).entradas.add(capaHide.get(i).y);
                
            } 
            
            capaY.get(0).sumarPesos();// se suman los pesos y entradas de la neurona de salida
            capaY.get(0).activacionSigmoidal();//se activa la salida de la neuronade salida
            //------backpropagation---------------------------------------
            errorgeneral=capaY.get(0).calcularErrorS(1);// se calcula el error con lo obtenido comparandolo con las salida
            listaErrores.add(errorgeneral);
            NeuronaHide n=capaHide.get((int)(capaHide.size()*Math.random()));
            listaPesos.add(n.pesos.get(n.pesos.size()-1));
            System.out.println("Error"+errorgeneral);
            if(errorgeneral<errorEsperado){
                aux=false;
            }
            capaY.get(0).reCalculo(factorAprendizaje,errorgeneral);//se recalaculan los pesos y bias de la neurona de salida
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).calcularError(errorgeneral);// se calcula error de las neuronas de la capa oculta
            }
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).reCalculo(factorAprendizaje);// se calcula error de las neuronas de la capa oculta
            } 
            
            iteraciones++;
        }
        System.out.println("Calculado: "+capaY.get(0).y);
            //incremento para la siguiente fila
        //fila++;
        System.out.println("el numero de iteraciones fue: "+iteraciones );
        Listas listas=new Listas();
        listas.setCapaHide(capaHide);
        listas.setCapaY(capaY);
        return listas;
    }
    public Listas entrenar(double errorEsperado,double factorAprendizaje, int nNeuronas,String ruta)throws IOException{
       Util bin=new Util(ruta);//carga la imagen a la clase util
      this.factorAprendizaje=factorAprendizaje;
      this.nNeuronas=nNeuronas;
      this.errorEsperado=errorEsperado;
      //bin.binarizarImagen(200); Esto es para imagenes a blanco y negro
      entradas=bin.obtenerRgb();
//      Util bin2=new Util("PruebaA2.png");
//      ArrayList<Double> entrada2=new ArrayList<Double>();
//      entrada2=bin2.obtenerRgb();
//      for(int i=0;i<entrada2.size();i++){
//        entradas.add(entrada2.get(i));
//      }
      //entradasfilas=bin.sacarFilas(entradas);//sacamos promedios filas
      //entradascolumnas=bin.sacarColumnas(entradas);//sacamos promedios de columnas
      //entradas.clear();//limpiamos el arreglo 1d
      /*for(int i=0;i<entradasfilas.size();i++){
          entradas.add(entradasfilas.get(i));//lo volvemos a armar
      }
      for(int i=0;i<entradascolumnas.size();i++){
          entradas.add(entradascolumnas.get(i));// lo volvemos a armar
      }*/
      for (int i = 0; i < nNeuronas; i++) {//creamos la capa oculta
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
        boolean aux=true;
        for(int i=0;i<capaHide.size();i++){//llenamos pesos con respecto a las entradas una sola vez
            capaHide.get(i).llenarPesos();
        }  
        while(aux==true){//Ciclo que controla cuantas veces se realizan los calculos(ENTRENAMIENTO)
            
            CapaY.get(0).entradas.clear();
            
             //sumamos pesos * entradas y los sumamos entre si tmbien el bias
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
                CapaY.get(0).llenarPesos();//solo 1 vez 
            }
            CapaY.get(0).sumarPesos();// se suman los pesos y entradas de la neurona de salida
            CapaY.get(0).activacionSigmoidal();//se activa la salida de la neuronade salida
            //------backpropagation---------------------------------------
            errorgeneral=CapaY.get(0).calcularErrorS(1);// se calcula el error con lo obtenido comparandolo con las salida
            listaErrores.add(errorgeneral);//grafica
            NeuronaHide n=capaHide.get((int)(capaHide.size()*Math.random()));//graficaas
            listaPesos.add(n.pesos.get(n.pesos.size()-1));//graficas
            System.out.println("Error"+errorgeneral);
            if(errorgeneral<errorEsperado){
                aux=false;
            }
            CapaY.get(0).reCalculo(factorAprendizaje,errorgeneral);//se recalaculan los pesos y bias de la neurona de salida
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).calcularError(errorgeneral);// se calcula error de las neuronas de la capa oculta
            }
            for(int i=0;i<capaHide.size();i++){
                    capaHide.get(i).reCalculo(factorAprendizaje);// se calcula error de las neuronas de la capa oculta
            } 
            
            iteraciones++;
        }
        ;
        System.out.println("Calculado: "+CapaY.get(0).y);
            //incremento para la siguiente fila
        //fila++;
        System.out.println("el numero de iteraciones fue: "+iteraciones );
        Listas listas=new Listas();
        listas.setCapaHide(capaHide);
        listas.setCapaY(CapaY);
        return listas; 
    }
    public double aplicacion(ArrayList<NeuronaHide> capaHide,ArrayList<NeuronaHide> capaY){
        Util bin=new Util("Negro.png");
        double yoriginal=capaY.get(0).y;
        //bin.binarizarImagen(200);
        //entradas=bin.convertirArreglo2dTo1Dv2(200);
        entradas=bin.obtenerRgb();
        //entradasfilas=bin.sacarFilas(entradas);//sacamos promedios filas
        //entradascolumnas=bin.sacarColumnas(entradas);//sacamos promedios de columnas
        //entradas.clear();//limpiamos el arreglo 1d
        /*for(int i=0;i<entradasfilas.size();i++){
            entradas.add(entradasfilas.get(i));//lo volvemos a armar
        }
        for(int i=0;i<entradascolumnas.size();i++){
          entradas.add(entradascolumnas.get(i));// lo volvemos a armar
        }*/
        for(int i = 0; i<capaHide.size();i++){
            capaHide.get(i).entradas.clear();//limpiamos entradas antiguas
        }
        
        for (int i = 0; i < capaHide.size(); i++) {//llenamos con nuevas entradas
            for(int j=0;j<entradas.size();j++){
                Double aux=entradas.get(j);
                capaHide.get(i).entradas.add(aux);
            }
        }
        capaY.get(0).entradas.clear();//se limpian entradas antiguas de capa de salida
        for(int i=0;i<capaHide.size();i++){
            capaHide.get(i).sumarPesos();//sumamos pesos
        } 
        for(int i=0;i<capaHide.size();i++){//se activa la alida de cada neurona
            capaHide.get(i).activacionSigmoidal();
        } 
        for(int i=0;i<capaHide.size();i++){//se pasan las salidadas a las neuronas de salida
               
            capaY.get(0).entradas.add(capaHide.get(i).y);
                
        } 
            
        capaY.get(0).sumarPesos();// se suman los pesos y entradas de la neurona de salida
        capaY.get(0).activacionSigmoidal();//se activa la salida de la neuronade salida
        yoriginal=capaY.get(0).y;
        System.out.println("este fue y final "+yoriginal);
        return capaY.get(0).y;
    }
    public ArrayList RetornarErrores(){
        return listaErrores;
    }
    public ArrayList RetornarPesos(){
        return listaPesos;
    }    
}
        
    

    

