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
import org.apache.commons.io. IOUtils;
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

    public Util(String archivo) {
        arreglo = new Color[anchoPermitido][anchoPermitido];
        cargarImagen(archivo);
    }
    public ArrayList binarizar() throws FileNotFoundException{
        ArrayList<Double> lista = new ArrayList<Double>();
        byte[] imageInBytes = null;
        FileInputStream myStream=new FileInputStream("C:\\a.jpg");
        
        try {
            imageInBytes = IOUtils.toByteArray(myStream);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<imageInBytes.length;i++){
            byte tempByte;
            tempByte=imageInBytes[i];
            double tempDouble=tempByte;
            lista.add(tempDouble);
        }
        return lista;
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
                if (promedio>umbral){ 
                    arreglo[i][j]=Color.BLACK;
                    bins.add(1.0);
                }
                if(bins.size()>=10000){
                    return bins;
                }
                else
                    arreglo[i][j] = Color.WHITE;
                    bins.add(0.0);
            }
        }
       return bins;
    }
    public ArrayList<Double> sacarFilas(ArrayList<Double> list){
        ArrayList<Double> filas=new ArrayList<Double>();
        double num=0;
        for(int i=0;i<list.size();i++){
           
           if(i%100==0){
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
        int acumulador=0;
        while(acumulador<list.size()){
           if(i%99==0){
              columnas.add(num);
              num=0;
           } 
           num=list.get(i)+num;
           acumulador=acumulador+99;
        }
        return columnas;
    }
}
