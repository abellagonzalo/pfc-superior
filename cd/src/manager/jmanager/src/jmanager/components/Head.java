/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComponentPerceptionPanel.java
 *
 * Created on 28-oct-2009, 13:08:37
 */
package jmanager.components;

import jmanager.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JSlider;

/**
 *
 * @author paco
 */
public class Head extends javax.swing.JPanel {

	private static final int VEL_CONTROL = 0;
	private static final int POS_CONTROL = 1;
	private int controlType = VEL_CONTROL;

	/** Creates new form ComponentGTLocalization */
	public Head() {
		initComponents();
	}

	public void refresh() {

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panjSlider1 = new javax.swing.JSlider();
        tiltjSlider2 = new javax.swing.JSlider();
        typeControljToggleButton1 = new javax.swing.JToggleButton();
        stopjButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(330, 250));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(330, 250));

        panjSlider1.setMinimum(-100);
        panjSlider1.setValue(0);
        panjSlider1.setName("panjSlider1"); // NOI18N
        panjSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panChanged(evt);
            }
        });

        tiltjSlider2.setMinimum(-100);
        tiltjSlider2.setOrientation(javax.swing.JSlider.VERTICAL);
        tiltjSlider2.setValue(0);
        tiltjSlider2.setName("tiltjSlider2"); // NOI18N
        tiltjSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tiltChanged(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(Head.class);
        typeControljToggleButton1.setText(resourceMap.getString("typeControljToggleButton1.text")); // NOI18N
        typeControljToggleButton1.setName("typeControljToggleButton1"); // NOI18N
        typeControljToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeControlButtonPressed(evt);
            }
        });

        stopjButton1.setText(resourceMap.getString("stopjButton1.text")); // NOI18N
        stopjButton1.setName("stopjButton1"); // NOI18N
        stopjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panjSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(tiltjSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(typeControljToggleButton1)
                        .addGap(34, 34, 34)
                        .addComponent(stopjButton1)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeControljToggleButton1)
                    .addComponent(stopjButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panjSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tiltjSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void stopButtonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonPressed
		
			panjSlider1.setValue(0);
			tiltjSlider2.setValue(0);
			if (controlType == VEL_CONTROL) {
				JmanagerView.root.getConnection().headPrx.stop();
				//dataResp resp = JmanagerView.root.getConnection().send("Head:stop:");
			} else {
				JmanagerView.root.getConnection().headPrx.setPanPos(0.0f, 0.5f);
				JmanagerView.root.getConnection().headPrx.setTiltPos(0.0f, 0.5f);
				//dataResp resp = JmanagerView.root.getConnection().send("Head:setPanPos:0:0.5:");
				//resp = JmanagerView.root.getConnection().send("Head:setTiltPos:0:0.5:");
			}            
		
	}//GEN-LAST:event_stopButtonPressed

	private void typeControlButtonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeControlButtonPressed
		AbstractButton abstractButton = (AbstractButton) evt.getSource();
		boolean selected = abstractButton.getModel().isSelected();
		if (selected) {
			controlType = POS_CONTROL;
			typeControljToggleButton1.setText("Pos. control");
			stopjButton1.setText("Reset");
		}else {
			controlType = VEL_CONTROL;
			typeControljToggleButton1.setText("Vel. control");
			stopjButton1.setText("Stop");
		}
	}//GEN-LAST:event_typeControlButtonPressed

	private void panChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panChanged
		
			//JSlider source = (JSlider)evt.getSource();
			if (controlType == VEL_CONTROL) {
				if (!panjSlider1.getValueIsAdjusting()) {
					JmanagerView.root.getConnection().headPrx.setPan(panjSlider1.getValue() / 100.0f);
					//dataResp resp = JmanagerView.root.getConnection().send("Head:setPan:" +
					//		panjSlider1.getValue() / 100.0 + ":");
				}
			}else{
				if (!panjSlider1.getValueIsAdjusting()) {
					JmanagerView.root.getConnection().headPrx.setPanPos((float)(Math.toRadians(panjSlider1.getValue() / -100.0f * 120.0f)), 0.5f);
					//dataResp resp = JmanagerView.root.getConnection().send("Head:setPanPos:" +
					//		Math.toRadians(panjSlider1.getValue() / -100.0 * 120.0) + ":" + 0.5 + ":");
				}
			}
		
	}//GEN-LAST:event_panChanged

	private void tiltChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tiltChanged
		
			//JSlider source = (JSlider)evt.getSource();
			if (controlType == VEL_CONTROL) {
				if (!tiltjSlider2.getValueIsAdjusting()) {
					JmanagerView.root.getConnection().headPrx.setTilt(tiltjSlider2.getValue() / -100.0f);
					//dataResp resp = JmanagerView.root.getConnection().send("Head:setTilt:" +
					//		tiltjSlider2.getValue() / -100.0 + ":");
				}
			}else{
				if (!tiltjSlider2.getValueIsAdjusting()) {
					float value = (float)(Math.toRadians(tiltjSlider2.getValue() / -100.0 * 39.0));
					if (value > Math.toRadians(30)) value = (float)Math.toRadians(30);
					JmanagerView.root.getConnection().headPrx.setTiltPos(value, 0.5f);
					//dataResp resp = JmanagerView.root.getConnection().send("Head:setTiltPos:" +
					//		value + ":" + 0.5 + ":");
				}
			}
		
	}//GEN-LAST:event_tiltChanged
	/**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider panjSlider1;
    private javax.swing.JButton stopjButton1;
    private javax.swing.JSlider tiltjSlider2;
    private javax.swing.JToggleButton typeControljToggleButton1;
    // End of variables declaration//GEN-END:variables
}