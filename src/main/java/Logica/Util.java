/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import org.apache.commons.io. IOUtils;
import java.util.ArrayList;
/**
 *
 * @author Darkgrey93
 */
public class Util {
    public static final int anchoPermitido=800;
    public static final int altoPermitido=600;
    private Color arreglo[][];
    private int ancho;
    private int alto;
    ArrayList<Double> red = new ArrayList<Double>();
    ArrayList<Double>  green= new ArrayList<Double>();
    ArrayList<Double> blue = new ArrayList<Double>();
    ArrayList<Double> rgb = new ArrayList<Double>();

    public Util(String archivo) {
        arreglo = new Color[anchoPermitido][anchoPermitido];
        cargarImagen(archivo);
    }
   
    public void cargarImagen(String archivo){
        BufferedImage bf=null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if (bf.getWidth()<anchoPermitido) {
            ancho=bf.getWidth();
        }else
            ancho=anchoPermitido;
        if (bf.getHeight()<altoPermitido) {
            alto=bf.getHeight();
        }else
            alto=altoPermitido;
        int cont=0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cont++;
                arreglo[i][j]= new Color(bf.getRGB(j, i));
                //System.out.println(cont +":"+"RedGreenBlue:"+ bf.getRGB(j, i));
            }
        }
    }
    public void binarizarImagen(double umbral){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                int promedio =(pix.getBlue()+pix.getRed()+pix.getGreen())/3;
                if (promedio<umbral) 
                    arreglo[i][j]=Color.BLACK;
                else
                    arreglo[i][j] = Color.WHITE;
            }
        }
    }
    public BufferedImage imprimirImagen(){
        BufferedImage salida = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                salida.setRGB(j, i, arreglo[i][j].getRGB());
            }
        }
        return salida;
    }
    public ArrayList convertirArreglo2dTo1Dv2(double umbral){
        ArrayList<Double> bins=new ArrayList<Double>();
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                int promedio =(pix.getBlue()+pix.getRed()+pix.getGreen())/3;
                if (promedio<umbral){ 
                    arreglo[i][j]=Color.BLACK;
                    bins.add(1.0);
                }
                if(bins.size()==10000){
                    return bins;
                }
                if(promedio>umbral){
                    arreglo[i][j] = Color.WHITE;
                    bins.add(0.0);
                }
            }
        }
       return bins;
    }
    public void obtenerRojo(){
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                double promedio =pix.getRed();
                red.add(promedio);
                if(red.size()>40000){
                    j=201;
                    i=201;
                }
                
            }
        }
       
    }
    public void obtenerVerde(){
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                double promedio =pix.getGreen();
                green.add(promedio);
                if(green.size()>=40000){
                   j=201;
                   i=201;
                }
                
            }
        }
       
    }
    public void obtenerAzul(){
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                double promedio =pix.getBlue();
                blue.add(promedio);
                if(blue.size()>=40000){
                  j=201;
                  i=201;
                }
                
            }
        }
       
    }
    public ArrayList obtenerRgb(){
        ArrayList<Double> redAux=new ArrayList<Double>();
        ArrayList<Double> greenAux=new ArrayList<Double>();
        ArrayList<Double> blueAux=new ArrayList<Double>();
        ArrayList<Double> redFilas=new ArrayList<Double>();
        ArrayList<Double> greenFilas=new ArrayList<Double>();
        ArrayList<Double> blueFilas=new ArrayList<Double>();
        ArrayList<Double> redCol=new ArrayList<Double>();
        ArrayList<Double> greenCol=new ArrayList<Double>();
        ArrayList<Double> blueCol=new ArrayList<Double>();
        obtenerRojo();
        obtenerVerde();
        obtenerAzul();
        redFilas=sacarFilas200(red);
        redCol=sacarColumnas200(red);
        greenFilas=sacarFilas200(green);
        greenCol=sacarColumnas200(green);
        blueFilas=sacarFilas200(blue);
        blueCol=sacarColumnas200(blue);
        for(int i=0;i<redFilas.size();i++){
            redAux.add(redFilas.get(i));
        }
        for(int i=0;i<redCol.size();i++){
            redAux.add(redCol.get(i));
        }
        for(int i=0;i<greenFilas.size();i++){
            greenAux.add(greenFilas.get(i));
            
        }
        for(int i=0;i<greenCol.size();i++){
            greenAux.add(greenCol.get(i));
        }
        for(int i=0;i<blueFilas.size();i++){
            blueAux.add(blueFilas.get(i));
        }
        for(int i=0;i<blueCol.size();i++){
            blueAux.add(blueCol.get(i));
        }
        
        for(int i=0;i<redAux.size();i++){
            rgb.add(redAux.get(i));
        }
        for(int i=0;i<greenAux.size();i++){
            rgb.add(greenAux.get(i));
        }
        for(int i=0;i<blueAux.size();i++){
           rgb.add(blueAux.get(i)); 
        }
        return rgb;
    }
    
    public ArrayList<Double> sacarFilas(ArrayList<Double> list){
        ArrayList<Double> filas=new ArrayList<Double>();
        double num=0;
        for(int i=0;i<list.size();i++){
           
           if(i%100==0){
              num=num/100;
              filas.add(num);
              num=0;
           } 
           num=list.get(i)+num;
        }
        return filas;
    }
     public ArrayList<Double> sacarFilas200(ArrayList<Double> list){
        ArrayList<Double> filas=new ArrayList<Double>();
        double num=0;
        for(int i=0;i<list.size();i++){
           
           if(i%200==0){
              num=num/200;
              filas.add(num);
              num=0;
           } 
           num=list.get(i)+num;
        }
        return filas;
    }
    
    public ArrayList<Double> sacarColumnas(ArrayList<Double> list){
        ArrayList<Double> columnas=new ArrayList<Double>();
        double num=0;
        for (int j = 0; j < 100; j++) {
            for (int i = j; i < list.size(); i++) {
                num=list.get(i)+num;
                i=i+99;
            }
            num=num/100;
            columnas.add(num);
        }
        return columnas;
    }
    public ArrayList<Double> sacarColumnas200(ArrayList<Double> list){
        ArrayList<Double> columnas=new ArrayList<Double>();
        double num=0;
        for (int j = 0; j < 200; j++) {
            for (int i = j; i < list.size(); i++) {
                num=list.get(i)+num;
                i=i+199;
            }
            num=num/200;
            columnas.add(num);
        }
        return columnas;
    }
}
