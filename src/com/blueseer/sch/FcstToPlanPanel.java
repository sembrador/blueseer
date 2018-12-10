/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueseer.sch;

import com.blueseer.utl.OVData;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingWorker;
import static bsmf.MainFrame.reinitpanels;
import static bsmf.MainFrame.setperms;

/**
 *
 * @author vaughnte
 */
public class FcstToPlanPanel extends javax.swing.JPanel {

    int numberrecords = 0;
    /**
     * Creates new form PostGLPanel
     */
    public FcstToPlanPanel() {
        initComponents();
    }

    
    public void initvars(String args) {
        tbfrompart.setText("");
         tbtopart.setText("");
          tbfromsite.setText("");
           tbtosite.setText("");
        btpost.setEnabled(true);
        MainProgressBar.setEnabled(true);
        MainProgressBar.setVisible(true);
    }
    
     class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            
       
       numberrecords = OVData.createPlanFromFcst(tbfromsite.getText(), tbtosite.getText(), tbfrompart.getText(), tbtopart.getText());

           /* 
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            //Sleep for at least one second to simulate "startup".
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException ignore) {}
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            
            */
            
            return null;
           
        }
 
        /*
         * Executed in event dispatch thread
         */
        public void done() {
           // Toolkit.getDefaultToolkit().beep();
           // MainProgressBar.setVisible(false);
           // setperms(bsmf.MainFrame.userid);
          //  reinitpanels2("BackGroundPanel", "BackGroundPanel", false, "");
            bsmf.MainFrame.show("Commit Complete! Records created " + String.valueOf(numberrecords));
            MainProgressBar.setEnabled(false);
            MainProgressBar.setIndeterminate(false);
        }
    }  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btpost = new javax.swing.JButton();
        tbfrompart = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MainProgressBar = new javax.swing.JProgressBar();
        tbtopart = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbfromsite = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbtosite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Commit Fcst To Plan"));

        btpost.setText("Commit");
        btpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpostActionPerformed(evt);
            }
        });

        jLabel1.setText("From Part");

        jLabel2.setText("To Part");

        jLabel3.setText("From Site");

        jLabel4.setText("To Site");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(tbfromsite, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(tbtosite, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(tbfrompart, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(tbtopart, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btpost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(MainProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(tbfromsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(tbtosite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(tbfrompart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(tbtopart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btpost)
                .addGap(6, 6, 6)
                .addComponent(MainProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpostActionPerformed
        MainProgressBar.setEnabled(true);
        MainProgressBar.setVisible(true);
        MainProgressBar.setIndeterminate(true);
        numberrecords = 0; 
        Task task = new Task();
        task.execute();
    }//GEN-LAST:event_btpostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar MainProgressBar;
    private javax.swing.JButton btpost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tbfrompart;
    private javax.swing.JTextField tbfromsite;
    private javax.swing.JTextField tbtopart;
    private javax.swing.JTextField tbtosite;
    // End of variables declaration//GEN-END:variables
}
