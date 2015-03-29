/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.g0orx.openhpsdr;

import java.util.ArrayList;

import org.g0orx.openhpsdr.discovery.Discovered;

/**
 *
 * @author john
 */
public class DeviceJDialog extends javax.swing.JDialog {

    /**
     * Creates new form DeviceJDialog
     */
    public DeviceJDialog(java.awt.Frame parent, boolean modal,ArrayList<Discovered> discovered) {
        super(parent, modal);
        this.discovered=discovered;
        initComponents();
        this.setTitle("Discovery detected more than one device. Select the one required.");
        jList1.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSelect.setText("Select");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        String[] strings = new String[discovered.size()];
        for(int i=0;i<discovered.size();i++) {
            strings[i]=discovered.get(i).toString();
        }
        jList1.setModel(new javax.swing.AbstractListModel() {

            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jButtonSelect)
                .addGap(163, 163, 163))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelect)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        Configuration configuration=Configuration.getInstance();
        configuration.discovered=this.discovered.get(jList1.getSelectedIndex());
        Log.i("DeviceJDialog", "selected: "+configuration.discovered.toString());
        this.dispose();
    }//GEN-LAST:event_jButtonSelectActionPerformed


    ArrayList<Discovered> discovered;
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
