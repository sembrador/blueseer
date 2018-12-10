
package com.blueseer.ord;

import com.blueseer.utl.BlueSeerUtils;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vaughnte
 */


public class OrderControl extends javax.swing.JPanel {

    /**
     * Creates new form ClockControl
     */
    public OrderControl() {
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
                    res = st.executeQuery("SELECT * FROM  order_ctrl ;");
                    while (res.next()) {
                        i++;
                        cbautosource.setSelected(BlueSeerUtils.ConvertStringToBool(res.getString("orc_autosource")));
                        cbautoinvoice.setSelected(BlueSeerUtils.ConvertStringToBool(res.getString("orc_autoinvoice")));
                    }
           
            }
            catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Unable to retrieve order_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    
    public void initvars(String arg) {
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

        jPanel1 = new javax.swing.JPanel();
        cbautosource = new javax.swing.JCheckBox();
        btupdate = new javax.swing.JButton();
        cbautoinvoice = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(0, 102, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Shipper Control"));

        cbautosource.setText("Auto Source Order?");

        btupdate.setText("Update");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        cbautoinvoice.setText("Auto Invoice Order?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btupdate)
                    .addComponent(cbautosource))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbautoinvoice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(cbautosource, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbautoinvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btupdate)
                .addGap(21, 21, 21))
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
                String autosource = "";
                String autoinvoice = "";
                
                if ( cbautosource.isSelected() ) {
                autosource = "1";    
                } else {
                    autosource = "0";
                }
                
                 if ( cbautoinvoice.isSelected() ) {
                autoinvoice = "1";    
                } else {
                    autoinvoice = "0";
                }
                
                
                
                res = st.executeQuery("SELECT *  FROM  order_ctrl ;");
                    while (res.next()) {
                        i++;
                    }
                if (i == 0) {
                    
                    st.executeUpdate("insert into order_ctrl (orc_autosource, orc_autoinvoice ) values (" + "'" + autosource + "'" + "," +
                            "'" + autoinvoice + "'" + ")" + ";");              
                          bsmf.MainFrame.show("Inserting Defaults");
                } else {
                    st.executeUpdate("update order_ctrl set " 
                            + " orc_autosource = " + "'" + autosource + "'" + "," 
                            + " orc_autoinvoice = " + "'" + autoinvoice + "'" +         
                            ";");   
                    bsmf.MainFrame.show("Updated Defaults");
                }
              
            } catch (SQLException s) {
                s.printStackTrace();
                bsmf.MainFrame.show("Problem updating order_ctrl");
            }
            bsmf.MainFrame.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btupdate;
    private javax.swing.JCheckBox cbautoinvoice;
    private javax.swing.JCheckBox cbautosource;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
