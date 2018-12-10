/*
 * Copyright 2015 Terry Evans Vaughn ("VCSCode").
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blueseer.fap;

import com.blueseer.utl.BlueSeerUtils;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vaughnte
 */
public class APControl extends javax.swing.JPanel {

    /**
     * Creates new form EDIControlPanel
     */
    public APControl() {
        initComponents();
    }

    
     public void getdefault() {
        
        try {

            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                ResultSet res = null;
                int i = 0;
                res = st.executeQuery("select * from ap_ctrl;");
                while (res.next()) {
                    i++;
                    tbbank.setText(res.getString("apc_bank"));
                    cbautovoucher.setSelected(BlueSeerUtils.ConvertStringToBool(res.getString("apc_autovoucher")));
                    tbdefaultpurchacct.setText(res.getString("apc_assetacct"));
                    
                }
               
                if (i == 0)
                    bsmf.MainFrame.show("No AP Ctrl Record found");

            } catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Unable to retrieve ap_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void initvars(String key) {
        getdefault();
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
        tbbank = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btupdate = new javax.swing.JButton();
        cbautovoucher = new javax.swing.JCheckBox();
        tbdefaultpurchacct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("AP Control Maintenance"));

        jLabel1.setText("AP Default Bank");

        btupdate.setText("Update");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        cbautovoucher.setText("Auto Voucher?");

        jLabel2.setText("Asset Purchase Acct");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbbank, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btupdate)
                    .addComponent(cbautovoucher)
                    .addComponent(tbdefaultpurchacct, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addComponent(cbautovoucher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbdefaultpurchacct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btupdate)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdateActionPerformed
        try {

            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                ResultSet res = null;
                boolean proceed = true;
                int i = 0;

                res = st.executeQuery("SELECT *  FROM  ap_ctrl ;");
                while (res.next()) {
                    i++;
                }
                if (i == 0) {

                    st.executeUpdate("insert into ap_ctrl values (" + "'" + tbbank.getText() + "'" + ","
                        + "'" + tbdefaultpurchacct.getText() + "'" + ","
                        + "'" + BlueSeerUtils.boolToInt(cbautovoucher.isSelected()) + "'"
                        + ")" + ";");
                    bsmf.MainFrame.show("Inserting Defaults");
                } else {
                    st.executeUpdate("update ap_ctrl set "
                        + " apc_bank = " + "'" + tbbank.getText() + "'" + ","
                        + " apc_assetacct = " + "'" + tbdefaultpurchacct.getText() + "'" + ","        
                        + " apc_autovoucher = " + "'" + BlueSeerUtils.boolToInt(cbautovoucher.isSelected()) + "'" +
                        ";");
                    bsmf.MainFrame.show("Updated Defaults");
                }

            } catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Problem updating ap_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btupdate;
    private javax.swing.JCheckBox cbautovoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tbbank;
    private javax.swing.JTextField tbdefaultpurchacct;
    // End of variables declaration//GEN-END:variables
}
