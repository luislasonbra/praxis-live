/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2015 Neil C Smith.
 * 
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details.
 * 
 * You should have received a copy of the GNU General Public License version 3
 * along with this work; if not, see http://www.gnu.org/licenses/
 * 
 * 
 * Please visit http://neilcsmith.net if you need additional information or
 * have any questions.
 */
package net.neilcsmith.praxis.live.video.options;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.neilcsmith.praxis.video.VideoSettings;



final class CapturePanel extends javax.swing.JPanel {
    
    private final CaptureOptionsPanelController controller;

    CapturePanel(CaptureOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        initDocumentListener();
    }
    
    private void initDocumentListener() {
        DocumentListener l = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                controller.changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                controller.changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                controller.changed();
            }
        };
        devInput1.getDocument().addDocumentListener(l);
        devInput2.getDocument().addDocumentListener(l);
        devInput3.getDocument().addDocumentListener(l);
        devInput4.getDocument().addDocumentListener(l);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultConfigPanel = new javax.swing.JPanel();
        devLbl1 = new javax.swing.JLabel();
        devInput1 = new javax.swing.JTextField();
        devInput2 = new javax.swing.JTextField();
        devInput4 = new javax.swing.JTextField();
        devInput3 = new javax.swing.JTextField();
        devLbl2 = new javax.swing.JLabel();
        devLbl3 = new javax.swing.JLabel();
        devLbl4 = new javax.swing.JLabel();
        resetBtn1 = new javax.swing.JButton();
        resetBtn2 = new javax.swing.JButton();
        resetBtn3 = new javax.swing.JButton();
        resetBtn4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        defaultConfigPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.defaultConfigPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(devLbl1, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devLbl1.text")); // NOI18N

        devInput1.setText(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devInput1.text")); // NOI18N

        devInput2.setText(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devInput2.text")); // NOI18N

        devInput4.setText(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devInput4.text")); // NOI18N

        devInput3.setText(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devInput3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(devLbl2, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devLbl2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(devLbl3, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devLbl3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(devLbl4, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.devLbl4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn1, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.resetBtn1.text")); // NOI18N
        resetBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtn1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn2, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.resetBtn2.text")); // NOI18N
        resetBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtn2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn3, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.resetBtn3.text")); // NOI18N
        resetBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtn3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn4, org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.resetBtn4.text")); // NOI18N
        resetBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout defaultConfigPanelLayout = new javax.swing.GroupLayout(defaultConfigPanel);
        defaultConfigPanel.setLayout(defaultConfigPanelLayout);
        defaultConfigPanelLayout.setHorizontalGroup(
            defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultConfigPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(defaultConfigPanelLayout.createSequentialGroup()
                        .addComponent(devLbl4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(devInput4, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                    .addGroup(defaultConfigPanelLayout.createSequentialGroup()
                        .addComponent(devLbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(devInput3))
                    .addGroup(defaultConfigPanelLayout.createSequentialGroup()
                        .addComponent(devLbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(devInput2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defaultConfigPanelLayout.createSequentialGroup()
                        .addComponent(devLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(devInput1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetBtn1)
                    .addComponent(resetBtn2)
                    .addComponent(resetBtn3)
                    .addComponent(resetBtn4)))
        );
        defaultConfigPanelLayout.setVerticalGroup(
            defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultConfigPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLbl1)
                    .addComponent(devInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLbl2)
                    .addComponent(devInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLbl3)
                    .addComponent(devInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(defaultConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLbl4)
                    .addComponent(devInput4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn4)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CapturePanel.class, "CapturePanel.jPanel1.border.title"))); // NOI18N
        jPanel1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(defaultConfigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(defaultConfigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtn1ActionPerformed
        devInput1.setText(VideoSettings.getDefaultCaptureDevice(1));
        controller.changed();
    }//GEN-LAST:event_resetBtn1ActionPerformed

    private void resetBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtn2ActionPerformed
        devInput2.setText(VideoSettings.getDefaultCaptureDevice(2));
        controller.changed();
    }//GEN-LAST:event_resetBtn2ActionPerformed

    private void resetBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtn3ActionPerformed
        devInput3.setText(VideoSettings.getDefaultCaptureDevice(3));
        controller.changed();
    }//GEN-LAST:event_resetBtn3ActionPerformed

    private void resetBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtn4ActionPerformed
        devInput4.setText(VideoSettings.getDefaultCaptureDevice(4));
        controller.changed();
    }//GEN-LAST:event_resetBtn4ActionPerformed

    void load() {
        devInput1.setText(VideoSettings.getCaptureDevice(1));
        devInput2.setText(VideoSettings.getCaptureDevice(2));
        devInput3.setText(VideoSettings.getCaptureDevice(3));
        devInput4.setText(VideoSettings.getCaptureDevice(4));
        
    }

    void store() {
        String text;
        text = devInput1.getText().trim();
        if (text.isEmpty() || text.equals(VideoSettings.getDefaultCaptureDevice(1))) {
            VideoSettings.resetCaptureDevice(1);
        } else {
            VideoSettings.setCaptureDevice(1, text);
        }
        
        text = devInput2.getText().trim();
        if (text.isEmpty() || text.equals(VideoSettings.getDefaultCaptureDevice(2))) {
            VideoSettings.resetCaptureDevice(2);
        } else {
            VideoSettings.setCaptureDevice(2, text);
        }
        
        text = devInput3.getText().trim();
        if (text.isEmpty() || text.equals(VideoSettings.getDefaultCaptureDevice(3))) {
            VideoSettings.resetCaptureDevice(3);
        } else {
            VideoSettings.setCaptureDevice(3, text);
        }
        
        text = devInput4.getText().trim();
        if (text.isEmpty() || text.equals(VideoSettings.getDefaultCaptureDevice(4))) {
            VideoSettings.resetCaptureDevice(4);
        } else {
            VideoSettings.setCaptureDevice(4, text);
        }

    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel defaultConfigPanel;
    private javax.swing.JTextField devInput1;
    private javax.swing.JTextField devInput2;
    private javax.swing.JTextField devInput3;
    private javax.swing.JTextField devInput4;
    private javax.swing.JLabel devLbl1;
    private javax.swing.JLabel devLbl2;
    private javax.swing.JLabel devLbl3;
    private javax.swing.JLabel devLbl4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton resetBtn1;
    private javax.swing.JButton resetBtn2;
    private javax.swing.JButton resetBtn3;
    private javax.swing.JButton resetBtn4;
    // End of variables declaration//GEN-END:variables
}
