/*
The MIT License (MIT)

Copyright (c) Terry Evans Vaughn "VCSCode"

All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.blueseer.adm;

import bsmf.MainFrame;
import com.blueseer.utl.BlueSeerUtils;
import static bsmf.MainFrame.reinitpanels;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vaughnte
 */
public class FTPMaint extends javax.swing.JPanel {

    
    public FTPMaint() {
        initComponents();
    }

    public void getFTPCode(String mykey) {
        initvars("");
        try {

            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                ResultSet res = null;
                int i = 0;
                res = st.executeQuery("select * from ftp_mstr where ftp_id = " + "'" + mykey + "'" + ";");
                while (res.next()) {
                    i++;
                    tbid.setText(mykey);
                    tbdesc.setText(res.getString("ftp_desc"));
                    cbdelete.setSelected(res.getBoolean("ftp_delete"));
                    tbip.setText(res.getString("ftp_ip"));
                    tblogin.setText(res.getString("ftp_login"));
                    tbpasswd.setText(res.getString("ftp_passwd"));
                    tboutdir.setText(res.getString("ftp_outdir"));
                    tbindir.setText(res.getString("ftp_indir"));
                    tbcddir.setText(res.getString("ftp_chgdir"));
                }
               
                if (i > 0) {
                   enableAll();
                   btadd.setEnabled(false);
                }
            } catch (SQLException s) {
                MainFrame.bslog(s);
                bsmf.MainFrame.show("Unable to retrieve ftp_mstr");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            MainFrame.bslog(e);
        }

    }
    
    public void clearAll() {
         tbid.setText("");
        tbdesc.setText("");
         cbdelete.setSelected(false);
         tbindir.setText("");
         tboutdir.setText("");
         tbcddir.setText("");
         tblogin.setText("");
         tbpasswd.setText("");
         tbip.setText("");
         
         
    }
    
    public void enableAll() {
        tbid.setEnabled(true);
        tbdesc.setEnabled(true);
         cbdelete.setEnabled(true);
        tbindir.setEnabled(true);
         tboutdir.setEnabled(true);
         tbcddir.setEnabled(true);
         tblogin.setEnabled(true);
         tbpasswd.setEnabled(true);
         tbip.setEnabled(true);
         btadd.setEnabled(true);
         btdelete.setEnabled(true);
         btupdate.setEnabled(true);
         btnew.setEnabled(true);
         btbrowse.setEnabled(true);
    }
    
    public void disableAll() {
        tbid.setEnabled(false);
        tbdesc.setEnabled(false);
         cbdelete.setEnabled(false);
         tbindir.setEnabled(false);
         tboutdir.setEnabled(false);
         tbcddir.setEnabled(false);
         tblogin.setEnabled(false);
         tbpasswd.setEnabled(false);
         tbip.setEnabled(false);
         btadd.setEnabled(false);
         btdelete.setEnabled(false);
         btupdate.setEnabled(false);
         btnew.setEnabled(false);
         btbrowse.setEnabled(false);
    }
    
    public void initvars(String arg) {
        
        clearAll();
        disableAll();
        
        btnew.setEnabled(true);
        btbrowse.setEnabled(true);
        
        if (! arg.isEmpty()) {
            getFTPCode(arg);
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

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btadd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbdelete = new javax.swing.JCheckBox();
        btupdate = new javax.swing.JButton();
        tbdesc = new javax.swing.JTextField();
        tbid = new javax.swing.JTextField();
        btdelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btbrowse = new javax.swing.JButton();
        btnew = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tbip = new javax.swing.JTextField();
        tblogin = new javax.swing.JTextField();
        tbpasswd = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tbindir = new javax.swing.JTextField();
        tboutdir = new javax.swing.JTextField();
        tbcddir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("FTP Maintenance"));

        btadd.setText("Add");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        jLabel2.setText("Description:");

        cbdelete.setText("Delete After Get?");

        btupdate.setText("Update");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        btdelete.setText("Delete");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel3.setText("IP");

        btbrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lookup.png"))); // NOI18N
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });

        btnew.setText("New");
        btnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnewActionPerformed(evt);
            }
        });

        jLabel4.setText("Login");

        jLabel5.setText("Passwd");

        jLabel6.setText("InDir");

        jLabel7.setText("OutDir");

        jLabel9.setText("CD Dir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(btdelete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btupdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btadd))
                        .addComponent(cbdelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tbid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnew))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tbcddir, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tboutdir, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tbindir, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tbpasswd, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tbip, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tbdesc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(tblogin, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btbrowse)
                    .addComponent(btnew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tblogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbindir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tboutdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbcddir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbdelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btadd)
                    .addComponent(btupdate)
                    .addComponent(btdelete))
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
       try {

            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                ResultSet res = null;
                boolean proceed = true;
                int i = 0;
                
                // check the site field
                if (tbid.getText().isEmpty()) {
                    proceed = false;
                    bsmf.MainFrame.show("Must enter a FTP code");
                   
                }
                
                if (proceed) {

                    res = st.executeQuery("SELECT ftp_id FROM  ftp_mstr where ftp_id = " + "'" + tbid.getText() + "'" + ";");
                    while (res.next()) {
                        i++;
                    }
                    if (i == 0) {
                        st.executeUpdate("insert into ftp_mstr "
                            + "(ftp_id, ftp_desc, ftp_ip, ftp_login, ftp_passwd, ftp_indir, ftp_outdir, ftp_chgdir, ftp_delete ) "
                            + " values ( " + "'" + tbid.getText().toString() + "'" + ","
                            + "'" + tbdesc.getText().toString() + "'" + ","
                            + "'" + tbip.getText().toString() + "'" + ","
                            + "'" + tblogin.getText().toString() + "'" + ","
                            + "'" + tbpasswd.getPassword().toString() + "'" + ","
                            + "'" + tbindir.getText().toString() + "'" + ","
                            + "'" + tboutdir.getText().toString() + "'" + ","
                            + "'" + tbcddir.getText().toString() + "'" + ","
                            + "'" + BlueSeerUtils.boolToInt(cbdelete.isSelected()) + "'"
                            + ")"
                            + ";");
                        bsmf.MainFrame.show("Added FTP Record");
                    } else {
                        bsmf.MainFrame.show("FTP Record Already Exists");
                    }

                   initvars("");
                   
                } // if proceed
            } catch (SQLException s) {
                MainFrame.bslog(s);
                bsmf.MainFrame.show("Unable to Add to ftp_mstr");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            MainFrame.bslog(e);
        }
    }//GEN-LAST:event_btaddActionPerformed

    private void btupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdateActionPerformed
        try {
            boolean proceed = true;
            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                   
                // check the code field
                if (tbid.getText().isEmpty()) {
                    proceed = false;
                    bsmf.MainFrame.show("Must enter a FTP code");
                }
                
                if (proceed) {
                    st.executeUpdate("update ftp_mstr set ftp_desc = " + "'" + tbdesc.getText() + "'" + ","
                            + "ftp_ip = " + "'" + tbip.getText().toString() + "'" + ","
                            + "ftp_login = " + "'" + tblogin.getText().toString() + "'" + ","
                            + "ftp_passwd = " + "'" + tbpasswd.getPassword().toString() + "'" + ","
                            + "ftp_indir = " + "'" + tbindir.getText().toString() + "'" + ","
                            + "ftp_outdir = " + "'" + tboutdir.getText().toString() + "'" + ","
                            + "ftp_chgdir = " + "'" + tbcddir.getText().toString() + "'" + ","
                            + "ftp_delete = " + "'" + BlueSeerUtils.boolToInt(cbdelete.isSelected()) + "'"
                            + " where ftp_id = " + "'" + tbid.getText() + "'"                             
                            + ";"); 
                    bsmf.MainFrame.show("Updated FTP Record");
                    initvars("");
                } 
         
            } catch (SQLException s) {
                MainFrame.bslog(s);
                bsmf.MainFrame.show("Problem updating ftp_mstr");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            MainFrame.bslog(e);
        }
    }//GEN-LAST:event_btupdateActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        boolean proceed = bsmf.MainFrame.warn("Are you sure?");
        if (proceed) {
        try {

            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
              
                   int i = st.executeUpdate("delete from ftp_mstr where ftp_id = " + "'" + tbid.getText() + "'" + ";");
                    if (i > 0) {
                    bsmf.MainFrame.show("deleted code " + tbid.getText());
                    initvars("");
                    }
                } catch (SQLException s) {
                    MainFrame.bslog(s);
                bsmf.MainFrame.show("Unable to Delete FTP Record");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            MainFrame.bslog(e);
        }
        }
    }//GEN-LAST:event_btdeleteActionPerformed

    private void btbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowseActionPerformed
        reinitpanels("BrowseUtil", true, "ftpmaint,ftp_id");
    }//GEN-LAST:event_btbrowseActionPerformed

    private void btnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnewActionPerformed
       enableAll();
       clearAll();
       btupdate.setEnabled(false);
       btdelete.setEnabled(false);
       
    }//GEN-LAST:event_btnewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton btbrowse;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btnew;
    private javax.swing.JButton btupdate;
    private javax.swing.JCheckBox cbdelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tbcddir;
    private javax.swing.JTextField tbdesc;
    private javax.swing.JTextField tbid;
    private javax.swing.JTextField tbindir;
    private javax.swing.JTextField tbip;
    private javax.swing.JTextField tblogin;
    private javax.swing.JTextField tboutdir;
    private javax.swing.JPasswordField tbpasswd;
    // End of variables declaration//GEN-END:variables
}
