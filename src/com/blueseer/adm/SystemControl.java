
package com.blueseer.adm;

import com.blueseer.utl.BlueSeerUtils;
import static bsmf.MainFrame.backgroundcolor;
import static bsmf.MainFrame.backgroundpanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vaughnte
 */


public class SystemControl extends javax.swing.JPanel {

    /**
     * Creates new form ClockControl
     */
    public SystemControl() {
        initComponents();
    }

    
     public void getcontrol() {
         try {
           
            Class.forName(bsmf.MainFrame.driver).newInstance();
            bsmf.MainFrame.con = DriverManager.getConnection(bsmf.MainFrame.url + bsmf.MainFrame.db, bsmf.MainFrame.user, bsmf.MainFrame.pass);
            try {
                Statement st = bsmf.MainFrame.con.createStatement();
                ResultSet res = null;
                
                int i = 0;
                    res = st.executeQuery("SELECT * FROM  ov_ctrl;");
                    while (res.next()) {
                        i++;
                        cblogin.setSelected(BlueSeerUtils.ConvertStringToBool(res.getString("ov_login")));
                        tbversion.setText(res.getString("ov_version"));
                        cbcustom.setSelected(BlueSeerUtils.ConvertStringToBool(res.getString("ov_custom")));
                        tbbgimage.setText(res.getString("ov_bgimage"));
                        tbrcolor.setText(res.getString("ov_rcolor"));
                        tbgcolor.setText(res.getString("ov_gcolor"));
                        tbbcolor.setText(res.getString("ov_bcolor"));
                        tbemailserver.setText(res.getString("ov_email_server"));
                        tbemailfrom.setText(res.getString("ov_email_from"));
                        tbimagedir.setText(res.getString("ov_image_directory"));
                        tbtempdir.setText(res.getString("ov_temp_directory"));
                        tblabeldir.setText(res.getString("ov_label_directory"));
                        tbjasperdir.setText(res.getString("ov_jasper_directory"));
                        tbedidir.setText(res.getString("ov_edi_directory"));
                        
                        if (res.getString("ov_fileservertype").toString().toUpperCase().equals("S")) {
                            rbsamba.setSelected(true);
                        }
                        if (res.getString("ov_fileservertype").toString().toUpperCase().equals("W")) {
                            rbwin.setSelected(true);
                        }
                        if (res.getString("ov_fileservertype").toString().toUpperCase().equals("L")) {
                            rblocal.setSelected(true);
                        }
                    }
           
            }
            catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Unable to retrieve ov_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    
    public void initvars(String arg) {
        
         buttonGroup1.add(rbsamba);
        buttonGroup1.add(rbwin);
        buttonGroup1.add(rblocal);
        
        
        rbsamba.setSelected(false);
        rbwin.setSelected(false);
        rblocal.setSelected(false);
        
           getcontrol();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cblogin = new javax.swing.JCheckBox();
        btupdate = new javax.swing.JButton();
        tbversion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbcustom = new javax.swing.JCheckBox();
        tbbgimage = new javax.swing.JTextField();
        tbrcolor = new javax.swing.JTextField();
        tbgcolor = new javax.swing.JTextField();
        tbbcolor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rblocal = new javax.swing.JRadioButton();
        rbwin = new javax.swing.JRadioButton();
        rbsamba = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        tbemailserver = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tbemailfrom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tbimagedir = new javax.swing.JTextField();
        tbtempdir = new javax.swing.JTextField();
        tblabeldir = new javax.swing.JTextField();
        tbjasperdir = new javax.swing.JTextField();
        tbedidir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("System Control"));

        cblogin.setText("Explicit Login?");

        btupdate.setText("Update");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("Version");

        cbcustom.setText("Custom?");

        jLabel2.setText("BG Image Path");

        jLabel3.setText("R Color");

        jLabel4.setText("G Color");

        jLabel5.setText("B Color");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("File Server Type"));

        rblocal.setText("Local");

        rbwin.setText("Win UNC");

        rbsamba.setText("Samba");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbsamba)
                    .addComponent(rbwin)
                    .addComponent(rblocal))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbsamba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbwin)
                .addGap(1, 1, 1)
                .addComponent(rblocal)
                .addContainerGap())
        );

        jLabel6.setText("EmailServerIP");

        jLabel7.setText("EmailFromAddr");

        jLabel8.setText("Image Dir");

        jLabel9.setText("Temp Dir");

        jLabel10.setText("Label Dir");

        jLabel11.setText("Jasper Dir");

        jLabel12.setText("EDI Dir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbedidir, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(tbjasperdir)
                    .addComponent(tblabeldir)
                    .addComponent(tbtempdir)
                    .addComponent(tbimagedir)
                    .addComponent(tbemailserver)
                    .addComponent(tbemailfrom))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbemailserver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbemailfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbimagedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbtempdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tblabeldir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbjasperdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbedidir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbcustom)
                                    .addComponent(cblogin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btupdate)
                            .addComponent(tbbcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbgcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbrcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbversion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbbgimage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cblogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbcustom)
                    .addComponent(jLabel2)
                    .addComponent(tbbgimage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbrcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbgcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbbcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btupdate)
                .addContainerGap())
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
                String serverfiletype = "";
                int i = 0;
                String login = "";
                
                if ( cblogin.isSelected() ) {
                login = "1";    
                } else {
                    login = "0";
                }
                
                if (rbsamba.isSelected()) {
                    serverfiletype = "S";
                }
                if (rbwin.isSelected()) {
                    serverfiletype = "W";
                }
                if (rblocal.isSelected()) {
                    serverfiletype = "L";
                }
                
                
                res = st.executeQuery("SELECT *  FROM  ov_ctrl ;");
                    while (res.next()) {
                        i++;
                    }
                if (i == 0) {
                    
                    st.executeUpdate("insert into ov_ctrl values (" + 
                            "'" + "0.0.0" + "'" + "," +
                            "'" + "" + "'" + "," +
                            "'" + "" + "'" + "," +
                            "'" + login + "'" +  "," +
                            "'" + "0" + "'" + "," +
                            "'" + "" + "'" + "," +
                            "'0'" + "," + "'102'" + "," + "'204'" + "," +
                            "'" + serverfiletype + "'" +  "," + "," +
                            "'" + tbimagedir.getText() + "'" +  "," + "," +
                            "'" + tbtempdir.getText() + "'" +  "," + "," +
                            "'" + tblabeldir.getText() + "'" +  "," + "," +
                            "'" + tbjasperdir.getText() + "'" +  "," + "," +
                            "'" + tbedidir.getText() + "'" +  "," + "," +
                            "'" + tbemailserver.getText() + "'" +  "," + "," +
                            "'" + tbemailfrom.getText() + "'" +  "," + 
                            ")" + ";");              
                          bsmf.MainFrame.show("Inserting Defaults");
                } else {
                    st.executeUpdate("update ov_ctrl set " 
                            + " ov_login = " + "'" + login + "'" + "," +
                              " ov_custom = " + "'" + BlueSeerUtils.boolToInt(cbcustom.isSelected()) + "'" + "," +
                            " ov_version = " + "'" + tbversion.getText() + "'" +  "," +
                            " ov_bgimage = " + "'" + tbbgimage.getText() + "'" + "," +
                            " ov_rcolor = " + "'" + tbrcolor.getText() + "'" + "," +
                            " ov_gcolor = " + "'" + tbgcolor.getText() + "'" + "," +
                            " ov_bcolor = " + "'" + tbbcolor.getText() + "'" + "," +
                            " ov_fileservertype = " + "'" + serverfiletype + "'" + "," +
                            " ov_image_directory = " + "'" + tbimagedir.getText() + "'" + "," +
                            " ov_temp_directory = " + "'" + tbtempdir.getText() + "'" + "," +
                            " ov_label_directory = " + "'" + tblabeldir.getText() + "'" + "," +
                            " ov_jasper_directory = " + "'" + tbjasperdir.getText() + "'" + "," +
                            " ov_edi_directory = " + "'" + tbedidir.getText() + "'" + "," +
                            " ov_email_server = " + "'" + tbemailserver.getText() + "'" + "," +
                            " ov_email_from = " + "'" + tbemailfrom.getText() + "'" +   
                            ";");   
                   
                    bsmf.MainFrame.show("Updated Defaults");
                    
                     // recolor the panels if possible color change
                    bsmf.MainFrame.reColorPanels(new Color(Integer.valueOf(tbrcolor.getText()), Integer.valueOf(tbgcolor.getText()),Integer.valueOf(tbbcolor.getText()) ) );
                    bsmf.MainFrame.backgroundcolor = new Color(Integer.valueOf(tbrcolor.getText()), Integer.valueOf(tbgcolor.getText()),Integer.valueOf(tbbcolor.getText()) );
                    GradientPaint paint =  new GradientPaint(0, 0, backgroundcolor, 0, 0, backgroundcolor);
                    backgroundpanel.setPaint(paint);
                }
              
            } catch (SQLException s) {
                bsmf.MainFrame.show("Problem updating ov_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbcustom;
    private javax.swing.JCheckBox cblogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rblocal;
    private javax.swing.JRadioButton rbsamba;
    private javax.swing.JRadioButton rbwin;
    private javax.swing.JTextField tbbcolor;
    private javax.swing.JTextField tbbgimage;
    private javax.swing.JTextField tbedidir;
    private javax.swing.JTextField tbemailfrom;
    private javax.swing.JTextField tbemailserver;
    private javax.swing.JTextField tbgcolor;
    private javax.swing.JTextField tbimagedir;
    private javax.swing.JTextField tbjasperdir;
    private javax.swing.JTextField tblabeldir;
    private javax.swing.JTextField tbrcolor;
    private javax.swing.JTextField tbtempdir;
    private javax.swing.JTextField tbversion;
    // End of variables declaration//GEN-END:variables
}
