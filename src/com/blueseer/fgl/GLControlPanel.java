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
package com.blueseer.fgl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vaughnte
 */
public class GLControlPanel extends javax.swing.JPanel {

    /**
     * Creates new form EDIControlPanel
     */
    public GLControlPanel() {
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
                res = st.executeQuery("select * from gl_ctrl;");
                while (res.next()) {
                    i++;
                    tbbsfrom.setText(res.getString("gl_bs_from"));
                    tbbsto.setText(res.getString("gl_bs_to"));
                    tbisfrom.setText(res.getString("gl_is_from"));
                    tbisto.setText(res.getString("gl_is_to"));
                    tbearnings.setText(res.getString("gl_earnings"));
                    tbforeignreal.setText(res.getString("gl_foreignreal"));
                }
               
                if (i == 0)
                    bsmf.MainFrame.show("No GL Ctrl Record found");

            } catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Unable to retrieve gl_ctrl");
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
        tbisfrom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbbsfrom = new javax.swing.JTextField();
        tbbsto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btupdate = new javax.swing.JButton();
        tbisto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbearnings = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbforeignreal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("GL Control Maintenance"));

        jLabel2.setText("Balance Sheet To Acct");

        jLabel1.setText("Balance Sheet From Acct");

        jLabel3.setText("Income Statement From Acct");

        btupdate.setText("Update");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Income Statement To Acct");

        jLabel5.setText("Retained Earnings Acct");

        jLabel6.setText("Foreign Currency G/L Acct");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbisfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbbsto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbbsfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbisto, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(btupdate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbearnings)
                            .addComponent(tbforeignreal, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbbsfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbbsto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbisfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbearnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbforeignreal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btupdate)
                .addGap(32, 32, 32))
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
                
                res = st.executeQuery("SELECT *  FROM  gl_ctrl ;");
                    while (res.next()) {
                        i++;
                    }
                if (i == 0) {
                    
                    st.executeUpdate("insert into gl_ctrl values (" + "'" + tbbsfrom.getText() + "'" + ","
                            + "'" + tbbsto.getText() + "'" + "," 
                            + "'" + tbisfrom.getText() + "'" + ","
                            + "'" + tbisto.getText() + "'" + ","
                            + "'" + tbearnings.getText() + "'" + ","
                            + "'" + tbforeignreal.getText() + "'"         
                            + " )" + ";");              
                          bsmf.MainFrame.show("Inserting Defaults");
                } else {
                    st.executeUpdate("update gl_ctrl set " 
                            + " gl_bs_from = " + "'" + tbbsfrom.getText() + "'" + ","
                            + " gl_bs_to = " + "'" + tbbsto.getText() + "'" + "," 
                            + " gl_is_from = " + "'" + tbisfrom.getText() + "'" + "," 
                            + " gl_earnings = " + "'" + tbearnings.getText() + "'" + "," 
                            + " gl_foreignreal = " + "'" + tbforeignreal.getText() + "'" + ","         
                            + " gl_is_to = " + "'" + tbisto.getText() + "'" +
                            ";");   
                    bsmf.MainFrame.show("Updated Defaults");
                }
              
            } catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Problem updating gl_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tbbsfrom;
    private javax.swing.JTextField tbbsto;
    private javax.swing.JTextField tbearnings;
    private javax.swing.JTextField tbforeignreal;
    private javax.swing.JTextField tbisfrom;
    private javax.swing.JTextField tbisto;
    // End of variables declaration//GEN-END:variables
}
