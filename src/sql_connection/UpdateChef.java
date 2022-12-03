/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_connection;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Eduardo Ruiz Rios
 */
public class UpdateChef extends javax.swing.JInternalFrame {
    
    BD_Connection ctr;
    ArrayList<String> arr;
    
    /**
     * Creates new form UpdateChef
     */
    public UpdateChef() {
        initComponents();
        ctr = new BD_Connection();
        arr = new ArrayList<>();
        loadToCB();
        chefCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                turno.setText( (arr.get(chefCB.getSelectedIndex())).equals("M") ? "Matutino" : "Vespertino");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        waiterLbl = new javax.swing.JLabel();
        turnLbl = new javax.swing.JLabel();
        new_turn = new javax.swing.JLabel();
        chefCB = new javax.swing.JComboBox<>();
        new_turnCB = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        turno = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualizar turno del chef");

        waiterLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        waiterLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        waiterLbl.setText("Cocinero");

        turnLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        turnLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        turnLbl.setText("Turno");

        new_turn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        new_turn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        new_turn.setText("Nuevo turno");

        new_turnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));

        updateBtn.setText("Actualizar");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        turno.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(waiterLbl)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(new_turnCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chefCB, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(new_turn)
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(turnLbl)
                                .addGap(44, 44, 44)
                                .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(updateBtn)
                            .addGap(73, 73, 73)))
                    .addComponent(jLabel1))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waiterLbl)
                    .addComponent(chefCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turnLbl)
                    .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_turn)
                    .addComponent(new_turnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try {
            ctr.setConnection();
            ctr.createStmt();
            ctr.getStmt().execute(String.format("UPDATE cocineros SET Turno = '%s' WHERE ID_Cocinero = '%s'", (new_turnCB.getSelectedItem().toString().equals("Matutino")) ? "M" : "V", chefCB.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Se ha modificado el turno del cocinero " + chefCB.getSelectedItem().toString(), "Modificacion exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Sucedio un error al modificar el turno del cocinero", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ctr.closeStmt();
            ctr.disconnect();
        }
    }//GEN-LAST:event_updateBtnActionPerformed
    
    public void loadToCB() {
        try {
            ctr.setConnection();
            ctr.createStmt();
            if (ctr.runQuery("SELECT ID_Cocinero, Turno FROM cocineros")) {
                if (ctr.getRS().next()) {
                    do {
                        chefCB.addItem(ctr.getString(1));
                        arr.add(ctr.getString(2));
                    } while (ctr.getRS().next());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay cocineros registrados", "No hay cocineros", JOptionPane.INFORMATION_MESSAGE);
                }
                ctr.closeRS();
            }
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Sucedio un error al recuperar los cocineros registrados", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ctr.closeStmt();
            ctr.disconnect();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chefCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel new_turn;
    private javax.swing.JComboBox<String> new_turnCB;
    private javax.swing.JLabel turnLbl;
    private javax.swing.JTextField turno;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel waiterLbl;
    // End of variables declaration//GEN-END:variables
}
