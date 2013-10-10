/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DetectCorners.java
 *
 * Created on 16-feb-2010, 13:25:17
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jmanager.JmanagerView;
import jmanager.field.GLField;
import Jama.Matrix;
import java.util.Vector;


/**
 *
 * @author jmortiz
 */
public class NEFKLocalization extends javax.swing.JPanel {


	private VideoThread videoThread = null;
	private NEKFLocalizationEvent myopengl;
	private Animator animator;

	/** Creates new form DetectCorners */
	public NEFKLocalization() {
		initComponents();
		myopengl = new NEKFLocalizationEvent();
		drawopengl.addGLEventListener(myopengl);
		animator = new Animator(drawopengl);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		ActivationCheckBox = new javax.swing.JCheckBox();
		drawButton = new javax.swing.JButton();
		drawopengl = new GLField();

		setName("Form"); // NOI18N

		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(NEFKLocalization.class);
		ActivationCheckBox.setText(resourceMap.getString("ActivationCheckBox.text")); // NOI18N
		ActivationCheckBox.setName("ActivationCheckBox"); // NOI18N
		ActivationCheckBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ActivationCheckBoxActionPerformed(evt);
			}
		});

		drawButton.setText(resourceMap.getString("drawButton.text")); // NOI18N
		drawButton.setName("drawButton"); // NOI18N
		drawButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				drawButtonActionPerformed(evt);
			}
		});

		drawopengl.setName("drawopengl"); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(drawopengl, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(ActivationCheckBox)
										.addGap(133, 133, 133)
										.addComponent(drawButton)))
										.addContainerGap(733, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(ActivationCheckBox)
								.addComponent(drawButton))
								.addGap(44, 44, 44)
								.addComponent(drawopengl, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(89, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void ActivationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivationCheckBoxActionPerformed
		if (ActivationCheckBox.isSelected()) {
			animator.start();
			myopengl.initField();
			//dataResp resp = JmanagerView.root.getConnection().send("run:NEKFLocalization:");
			//try {
			//	Thread.sleep(3000);
			//} catch (InterruptedException ex) {
			//	Logger.getLogger(NEFKLocalization.class.getName()).log(Level.SEVERE, null, ex);
			//}
			JmanagerView.root.getConnection().schedulerPrx.run("NEKFLocalization");
				
		} else {
			animator.stop();
			JmanagerView.root.getConnection().schedulerPrx.stop("NEKFLocalization");
			//dataResp resp = JmanagerView.root.getConnection().send("pause:NEKFLocalization:");
			//            printResp(resp);
		}

	}//GEN-LAST:event_ActivationCheckBoxActionPerformed


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

	private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
		//dataResp resp =  JmanagerView.root.getConnection().send("getFilter:");

		String msg = new String(JmanagerView.root.getConnection().localizationPrx.getLocalizationInfo());
		String points[] = msg.split(":");

		System.out.println("["+msg+"]");

		int nekfs = 0;
		float  QEKF = 0;

		Matrix s = new Matrix(3,1);
		Matrix P = new Matrix(3,3);

		nekfs = new Integer(points[0]);

		s.set(0,0, new Double(points[1]));
		s.set(1,0, new Double(points[2]));
		s.set(2,0, new Double(points[3]));

		P.set(0,0, new Double(points[4]));
		P.set(0,1, new Double(points[5]));
		P.set(0,2, new Double(points[6]));
		P.set(1,0, new Double(points[7]));
		P.set(1,1, new Double(points[8]));
		P.set(1,2, new Double(points[9]));
		P.set(2,0, new Double(points[10]));
		P.set(2,1, new Double(points[11]));
		P.set(2,2, new Double(points[12]));

		QEKF = new Float(points[13]);

		int numobs = new Integer(points[14]);
		Vector vobs = new Vector();
		for(int i=0; i<numobs;i++)
		{
			ObsDbg obs = new ObsDbg();

			obs.color = new Integer(points[15 + (i * 5)]);
			obs.ox = new Float(points[15 + (i * 5) + 1]);
			obs.oy = new Float(points[15 + (i * 5) + 2]);
			obs.lx = new Float(points[15+ (i * 5) + 3]);
			obs.ly = new Float(points[15 + (i * 5) + 4]);

			vobs.addElement(obs);
		}


		myopengl.setFilter(s, P, QEKF, vobs);

	}//GEN-LAST:event_drawButtonActionPerformed




	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JCheckBox ActivationCheckBox;
	private javax.swing.JButton drawButton;
	private javax.media.opengl.GLCanvas drawopengl;
	// End of variables declaration//GEN-END:variables

}