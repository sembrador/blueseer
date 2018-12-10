/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueseer.inv;

import com.blueseer.utl.OVData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import static bsmf.MainFrame.con;
import static bsmf.MainFrame.driver;

/**
 *
 * @author vaughnte
 */
public class ItemLevelMaint extends javax.swing.JPanel {

    /**
     * Creates new form ItemLevelMaint
     */
    public ItemLevelMaint() {
        initComponents();
    }

    
    public void initvars(String arg) {
         btlevel.setEnabled(true);
         btmrp.setEnabled(true);
       ddsite.removeAllItems();
       ArrayList<String>  mylist = OVData.getSiteList();
        for (String code : mylist) {
            ddsite.addItem(code);
        }
        ddsite.setSelectedItem(OVData.getDefaultSite());
    }
   
       class TaskItemLevel extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            
       talog.append("calculating item level... "  + "\n");
       ArrayList<String> myarray = new ArrayList<String>();
        OVData.setzerolevelpsmstr();
        for (int i = 0; i < 8; i++) {
            talog.append("entering level " + String.valueOf(i) + "\n");
            myarray = OVData.getNextLevelpsmstr(i);
            if (! myarray.isEmpty()) {
            OVData.updateItemlevel(myarray, i + 1);
            } else {
                break;
            }
        }

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
            bsmf.MainFrame.show("ItemLevel Complete!");
            MainProgressBar.setVisible(false);
            talog.setText("");
             btlevel.setEnabled(true);
             btmrp.setEnabled(true);
        }
    }  
    
         class TaskMRP extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            
       
      
        ArrayList<String> myarray = new ArrayList<String>();
        // delete all current MRP records...clean slate
          talog.append("Deleting all MRP" + "\n");
          OVData.deleteAllMRP();
        
        // create zero level demand
          talog.append("Creating Zero Level Demand" + "\n");
          OVData.createMRPZeroLevel(ddsite.getSelectedItem().toString());
        
        // create derived mrp records from zero level demand
           talog.append("Creating Derived MRP" + "\n");
        for (int i = 0; i < 8; i++) {
            talog.append("MRP Level " + String.valueOf(i) + "\n");
            OVData.createMRPByLevel(i, ddsite.getSelectedItem().toString());
        }

        if (OVData.isInvCtrlDemdToPlan())
        OVData.createPlanFromDemand(ddsite.getSelectedItem().toString());
        
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
            bsmf.MainFrame.show("MRP Complete!");
            talog.setText("");
            MainProgressBar.setVisible(false);
             btlevel.setEnabled(true);
             btmrp.setEnabled(true);
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
        btmrp = new javax.swing.JButton();
        btlevel = new javax.swing.JButton();
        ddsite = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        MainProgressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        talog = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Level and MRP engine"));

        btmrp.setText("MRP");
        btmrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmrpActionPerformed(evt);
            }
        });

        btlevel.setText("Level");
        btlevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlevelActionPerformed(evt);
            }
        });

        jLabel1.setText("Site");

        talog.setColumns(20);
        talog.setRows(5);
        jScrollPane1.setViewportView(talog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MainProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 146, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btmrp)
                            .addComponent(btlevel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ddsite, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btlevel)
                .addGap(18, 18, 18)
                .addComponent(btmrp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btlevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlevelActionPerformed
       // bind_tree("4048");
        btlevel.setEnabled(false);
        btmrp.setEnabled(false);
         MainProgressBar.setVisible(true);
        MainProgressBar.setIndeterminate(true);
        
        ItemLevelMaint.TaskItemLevel taskitemlevel = new ItemLevelMaint.TaskItemLevel();
        taskitemlevel.execute();
        
        
       
        /*
        ArrayList<String> myarray = new ArrayList<String>();
        myarray = OVData.getzerolevelpsmstr();
        for (String myitem : myarray)
        talist.append(myitem + "\n");
                */
    }//GEN-LAST:event_btlevelActionPerformed

    private void btmrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmrpActionPerformed
       btlevel.setEnabled(false);
        btmrp.setEnabled(false);
            MainProgressBar.setVisible(true);
        MainProgressBar.setIndeterminate(true);
        
        ItemLevelMaint.TaskMRP taskmrp = new ItemLevelMaint.TaskMRP();
        taskmrp.execute();
        
        
       
    }//GEN-LAST:event_btmrpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar MainProgressBar;
    private javax.swing.JButton btlevel;
    private javax.swing.JButton btmrp;
    private javax.swing.JComboBox ddsite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea talog;
    // End of variables declaration//GEN-END:variables
}
