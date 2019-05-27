/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Core;
import Logica.Listas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Darkgrey93
 */
public class Entrenar extends javax.swing.JFrame {
    
    /**
     * Creates new form Entrenar
     */
    JFreeChart Grafica;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    ArrayList<Double> listaErrores=new ArrayList<Double>();
    ArrayList<Double> listaPesos=new ArrayList<Double>();
    Listas lista = new Listas();
    public Entrenar() {
        initComponents();
    }
    public Entrenar(Listas lista) {
        initComponents();
        this.lista=lista;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    File fichero;
     BufferedImage imagen;
    ImageIcon img=null;
    JPanel panelprincipal;
    String extension="JPG";
    JLabel JLabelfoto;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jT_Error = new javax.swing.JTextField();
        jT_Nneuronas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jT_Factor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        JLabelfoto1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Error");

        jLabel2.setText("N neuronasH");

        jLabel3.setText("Factor Aprendizaje");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        JLabelfoto1.setText("Cargar Foto");
        JLabelfoto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JLabelfoto1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JLabelfoto1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                JLabelfoto1AncestorRemoved(evt);
            }
        });

        jButton1.setText("Entrenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aplicacion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu.setText("Cargar Foto");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuKeyPressed(evt);
            }
        });

        jMenuItem.setText("Cargar");
        jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem);

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem1);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jT_Error, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jT_Nneuronas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jT_Factor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addComponent(JLabelfoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jT_Error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jT_Nneuronas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jT_Factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabelfoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private static final int IMG_WIDTH = 500;
	private static final int IMG_HEIGHT = 500;
    
    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActionPerformed
        // TODO add your handling code here:
         JFileChooser fc=new JFileChooser();
    int r=fc.showOpenDialog(null);
    if(r==JFileChooser.APPROVE_OPTION){
     try {
      imagen=ImageIO.read(fc.getSelectedFile().toURL());
      Entrenar.this.setSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
      extension=fc.getSelectedFile().toURL().toString().substring(fc.getSelectedFile().toURL().toString().length()-3, fc.getSelectedFile().toURL().toString().length()).toUpperCase();
      System.out.println(extension);
      img=new ImageIcon(imagen);
      JLabelfoto=new JLabel(img);
      JLabelfoto1.add(JLabelfoto);
      JLabelfoto1.repaint();
      repaint();
     } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   
    }//GEN-LAST:event_jMenuItemActionPerformed
//prueba
    private static BufferedImage resizeImage(BufferedImage imagen, int type){
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(imagen, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
    }
    //
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fc=new JFileChooser();
    int r=fc.showSaveDialog(null);
    if(r==JFileChooser.APPROVE_OPTION){
     File archivo=fc.getSelectedFile();
     int type = imagen.getType() == 0? BufferedImage.TYPE_INT_ARGB : imagen.getType();
     BufferedImage resizeImageJpg = resizeImage(imagen, type);
     try {
      ImageIO.write(resizeImageJpg, extension, archivo);
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void JLabelfoto1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLabelfoto1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_JLabelfoto1AncestorAdded

    private void JLabelfoto1AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLabelfoto1AncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_JLabelfoto1AncestorRemoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel1.removeAll();
        jPanel1.repaint();
        try {
            // TODO add your handling code here:
            double factor=Double.parseDouble(jT_Factor.getText());
            double error=Double.parseDouble(jT_Error.getText());
            int nNeuronas = Integer.parseInt(jT_Nneuronas.getText());
            Core corazon=new Core();
            if(lista.getCapaHide().size()!=0 && lista.getCapaY().size()!=0){
                lista=corazon.reentrenar(lista.getCapaHide(), lista.getCapaY(), error, factor, nNeuronas);
            }
            if(lista.getCapaHide().size()==0 || lista.getCapaY().size()==0){
                lista=corazon.entrenar(error,factor,nNeuronas);
            }
            
            listaErrores=corazon.RetornarErrores();
            listaPesos=corazon.RetornarPesos();
        } catch (IOException ex) {
            Logger.getLogger(Entrenar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<listaErrores.size();i++) {
            double error;
            error=this.listaErrores.get(i);
            int j = i + 1;
            datos.addValue(error, "Error General", "Iteracion"+j);
            Grafica = ChartFactory.createLineChart("Error General","Iteracion", "Final Error",
                    datos,PlotOrientation.VERTICAL, true, true, false);
        }  
        for (int i=0;i<listaPesos.size();i++) {
            double peso;
            peso=this.listaPesos.get(i);
            int j = i + 1;
            datos.addValue(peso, "Pesos", "Iteracion"+j);
            Grafica = ChartFactory.createLineChart("Pesos","Iteracion", "Final Peso",
                    datos,PlotOrientation.VERTICAL, true, true, false);
        }  
        ChartPanel panel = new ChartPanel(Grafica);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panel);   
        jPanel1.validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(lista.getCapaY().size()!=0 && lista.getCapaHide().size()!=0){
            Aplicacion app=new Aplicacion(lista);
            app.setVisible(true);
            this.setVisible(false);
        }else{
            System.out.println("No hay un etrenamienti previo por favor entrene");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuKeyPressed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Entrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrenar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelfoto1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jT_Error;
    private javax.swing.JTextField jT_Factor;
    private javax.swing.JTextField jT_Nneuronas;
    // End of variables declaration//GEN-END:variables
}
