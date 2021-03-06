/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComponentSelfLocationPanel.java
 *
 * Created on 09-dec-2009, 11:50:00
 */
package jmanager.components;

import com.sun.opengl.util.Animator;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jmanager.JmanagerView;
import jmanager.dataResp;
import jmanager.field.GLField;
import bica.*;
import jmanager.GrDebug.GrPrimitivesAbs;

/**
 *
 * @author Eduardo Perdices
 */
public class GeneticLocalization extends javax.swing.JPanel {

    private GrPrimitivesAbs grPrimitives = null;
    private Animator animator;
    private GeneticLocalizationEvent myopengl;
    private int imgw = 320;
    private int imgh = 240;
    private int imgc = 3;
    private ArrayList<GeneticLocalizationRace> races;
    private boolean maketest;
    private GeneticLocalizationTest test;

    /** Creates new form ComponentPerceptionPanel */
    public GeneticLocalization() {
        initComponents();

        this.races = new ArrayList<GeneticLocalizationRace>();
        this.test = new GeneticLocalizationTest();
        this.test.setComponent(this);
        this.maketest = false;

        /*Configure OpenGL*/
        myopengl = new GeneticLocalizationEvent();
        drawopengl.addGLEventListener(myopengl);
        animator = new Animator(drawopengl);
        animator.start();
        myopengl.initField();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CaptureButton = new javax.swing.JButton();
        ImgLabel = new javax.swing.JLabel();
        drawopengl = new GLField();
        ResetButton = new javax.swing.JButton();
        TestButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelReliability = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(330, 250));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(330, 250));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(GeneticLocalization.class);
        CaptureButton.setText(resourceMap.getString("CaptureButton.text")); // NOI18N
        CaptureButton.setName("CaptureButton"); // NOI18N
        CaptureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaptureButtonActionPerformed(evt);
            }
        });

        ImgLabel.setBackground(resourceMap.getColor("ImgLabel.background")); // NOI18N
        ImgLabel.setForeground(resourceMap.getColor("ImgLabel.foreground")); // NOI18N
        ImgLabel.setDoubleBuffered(true);
        ImgLabel.setMaximumSize(new java.awt.Dimension(320, 240));
        ImgLabel.setMinimumSize(new java.awt.Dimension(320, 240));
        ImgLabel.setName("ImgLabel"); // NOI18N
        ImgLabel.setOpaque(true);
        ImgLabel.setPreferredSize(new java.awt.Dimension(320, 240));

        drawopengl.setName("drawopengl"); // NOI18N

        ResetButton.setText(resourceMap.getString("ResetButton.text")); // NOI18N
        ResetButton.setName("ResetButton"); // NOI18N
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        TestButton.setText(resourceMap.getString("TestButton.text")); // NOI18N
        TestButton.setName("TestButton"); // NOI18N
        TestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestButtonActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        labelReliability.setText(resourceMap.getString("labelReliability.text")); // NOI18N
        labelReliability.setName("labelReliability"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawopengl, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelReliability))
                            .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CaptureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaptureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelReliability)))
                    .addComponent(drawopengl, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void CaptureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaptureButtonActionPerformed
            getParticles();
            getRealLocation();
            getReliability();
            displayImage();
	}//GEN-LAST:event_CaptureButtonActionPerformed

	private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
            this.resetLocation();
	}//GEN-LAST:event_ResetButtonActionPerformed

	private void TestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestButtonActionPerformed
            if (!this.maketest) {
                this.maketest = true;
                this.test.start();
            } else {
                this.maketest = false;
                this.test.stopTest();
            }
	}//GEN-LAST:event_TestButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CaptureButton;
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton TestButton;
    private javax.media.opengl.GLCanvas drawopengl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelReliability;
    // End of variables declaration//GEN-END:variables

    private void printResp(dataResp r) {

        //sbyte[] util = new byte[r.size];

        if (r.size < 500) {

            System.out.println("Respuesta: [" + new String(r.data) + "] (" + r.size + ")");
        } else {
            System.out.println("Respuesta: [X] (" + r.size + ")");
        }
    }

    public void displayImageInLabel(byte[] dataImg, JLabel label, int w, int h, int pixelStride) {

        int[] bandOffsets = {2, 1, 0}; //b, g, r
        int scanlineStride = 3 * w; //no extra padding
        DataBuffer buffer = new DataBufferByte(dataImg, w * h);
        WritableRaster raster = Raster.createInterleavedRaster(buffer, w, h, scanlineStride, pixelStride, bandOffsets, null);

        ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
        boolean hasAlpha = false;
        boolean isAlphaPremultiplied = false;
        int transparency = Transparency.OPAQUE;
        int transferType = DataBuffer.TYPE_BYTE;
        ColorModel colorModel = new ComponentColorModel(colorSpace, hasAlpha, isAlphaPremultiplied, transparency, transferType);

        BufferedImage img = new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);

        //Display image to the label
        ImageIcon icon = new ImageIcon(img);
        label.setIcon(icon);
    }

    private void displayImage() {
        int w = 320, h = 240;
        int pixelStride = 3; //assuming r, g, b, skip, r, g, b, skip...
        ImageData data = null;

        //SRC Image
        try {
            data = JmanagerView.root.getConnection().localizationPrx.getLocalizationImg();
        } catch (Exception ex) {
            System.out.println(ex);
        } 

        displayImageInLabel(data.pixelData, ImgLabel, w, h, pixelStride);
    }

    public void getParticles() {

        int nraces = 0;
        int wins;
        int life;
        float x, y, theta, prob;


        String slong = new String(JmanagerView.root.getConnection().localizationPrx.getLocalizationInfo());

        try {

            String[] sraces = slong.split("R");
            nraces = Integer.parseInt(sraces[0]);

            this.races.clear();

            /*Save races*/
            for (int i = 1; i < sraces.length - 1; i++) {
                String[] tmprace = sraces[i].split(":");
                if (tmprace.length == 6) {
                    wins = Integer.parseInt(tmprace[0]);
                    x = Float.parseFloat(tmprace[1]);
                    y = Float.parseFloat(tmprace[2]);
                    theta = Float.parseFloat(tmprace[3]);
                    prob = Float.parseFloat(tmprace[4]);
                    life = Integer.parseInt(tmprace[5]);

                    GeneticLocalizationParticle p = new GeneticLocalizationParticle(x, y, 0, theta, 0, 0, prob);
                    GeneticLocalizationRace r = new GeneticLocalizationRace();
                    r.setWins(wins);
                    r.setLife(life);
                    r.setRace(p);
                    this.races.add(r);
                }
            }

            /*Save winner*/
            String[] tmprace = sraces[sraces.length - 1].split(":");
            x = Float.parseFloat(tmprace[0]);
            y = Float.parseFloat(tmprace[1]);
            theta = Float.parseFloat(tmprace[2]);

            myopengl.setRaces(this.races);
            myopengl.setWinner(x, y, theta);

        } catch (NumberFormatException e) {
            System.err.println("(Particles) Error en los datos recibidos: Número no válido");
        } catch (Exception e) {
            System.err.println("(Particles) Error en los datos recibidos: Desconocido");
            System.err.println(e);
        }
    }

    public void getRealLocation() {

        float x, y, theta;
        x = y = theta = 0;

        String slong = new String(JmanagerView.root.getConnection().localizationPrx.getRealPosition());

        try {
            String[] sraces = slong.split(":");
            x = Float.parseFloat(sraces[0]);
            y = Float.parseFloat(sraces[1]);
            theta = Float.parseFloat(sraces[2]);
        } catch (NumberFormatException e) {
            System.err.println("(Real) Error en los datos recibidos: Número no válido");
        } catch (Exception e) {
            System.err.println("(Real) Error en los datos recibidos: Desconocido");
            System.err.println(e);
        }

        /*Save real location*/
        myopengl.setReal(x, y, theta);
    }

    public void getReliability() {
        //dataResp resp = JmanagerView.root.getConnection().send("getReliability:");
        float reliability = JmanagerView.root.getConnection().localizationPrx.getReliability();

        /*save reliability*/
        this.labelReliability.setText(String.valueOf(reliability));
        myopengl.setReliability(reliability);
    }

    public void resetLocation() {
        JmanagerView.root.getConnection().localizationPrx.resetLocalization();
        //dataResp resp = JmanagerView.root.getConnection().send("resetLocation:");
        //printResp(resp);
    }

    public float[] getLocationError() {
        float[] errors = new float[2];

        this.getParticles();
        this.getRealLocation();

        myopengl.showCurrentLocalization();
        errors[0] = myopengl.getLocationError();
        errors[1] = myopengl.getLocationErrorAngle();
        return errors;
    }

    public float getLocationReliability() {
        this.getReliability();
        return myopengl.getReliability();
    }
}
