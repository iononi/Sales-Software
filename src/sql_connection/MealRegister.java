/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_connection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MealRegister extends javax.swing.JInternalFrame {

    BD_Connection contr = new BD_Connection();

    /**
     * Creates new form MealRegister
     */
    public MealRegister() {
        initComponents();
        try {
            contr.setConnection();
            contr.createStmt();
            if (contr.runQuery("SELECT categoria FROM categorias")) {
                if (contr.getRS().next()) {
                    do {
                        categoryCB.addItem(contr.getString(1));
                    } while (contr.getRS().next());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay categorias disponibles", "No hay categorias", JOptionPane.INFORMATION_MESSAGE);
                }
                contr.closeRS();
            }
            contr.closeStmt();
            contr.disconnect();
        } catch (SQLException e) {
            Logger.getLogger(SQL_Connection.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Sucedio un error al recuperar las categorias disponibles", "Error", JOptionPane.ERROR_MESSAGE);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        save_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mealLbl = new javax.swing.JLabel();
        descripLbl = new javax.swing.JLabel();
        imageLbl = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        platillo = new javax.swing.JTextField();
        descrip = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        imagen_btn = new javax.swing.JTextField();
        load_btn = new javax.swing.JButton();
        categoryLbl = new javax.swing.JLabel();
        categoryCB = new javax.swing.JComboBox<>();
        clear_btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        save_btn.setText("Guardar");
        save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel1.setText("Menu de Registro Platillo");

        mealLbl.setText("Platillo");

        descripLbl.setText("Descripcion");

        imageLbl.setText("Imagen");

        priceLbl.setText("Precio");

        imagen_btn.setEditable(false);

        load_btn.setText("Cargar");
        load_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_btnActionPerformed(evt);
            }
        });

        categoryLbl.setText("Categoria");

        clear_btn.setText("Limpiar");
        clear_btn.setToolTipText("Vacia los campos");
        clear_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(save_btn)
                .addGap(42, 42, 42)
                .addComponent(clear_btn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageLbl)
                            .addComponent(mealLbl)
                            .addComponent(descripLbl)
                            .addComponent(priceLbl)
                            .addComponent(categoryLbl))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(platillo)
                                .addComponent(precio)
                                .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(categoryCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imagen_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(load_btn)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mealLbl)
                    .addComponent(platillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripLbl)
                    .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLbl)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageLbl)
                    .addComponent(imagen_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(load_btn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLbl)
                    .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn)
                    .addComponent(clear_btn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        imagen_btn.setText(ruta_bd);
        try {
            contr.setConnection();
            contr.createStmt();
            contr.getStmt().execute(String.format("INSERT INTO platillos(Platillo, Descripcion, Precio, Imagen, R_Categoria) VALUES ('%s', '%s', %.2f, '%s', (SELECT ID_Categoria FROM categorias WHERE Categoria = '%s'))", 
                    platillo.getText(), descrip.getText(), Float.parseFloat(precio.getText()), imagen_btn.getText(), categoryCB.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Se ha registrado el platillo.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: no se pudo registrar el platillo.", "Error de registro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void load_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_btnActionPerformed
        // TODO add your handling code here:
        String ruta = "";

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, JPEG, PNG, GIF & JFIF", "jpg", "jpeg","png", "gif", "jfif");
        fileChooser.setFileFilter(filtrado);

        int response = fileChooser.showOpenDialog(this);

        if (response == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getPath();
            ruta_bd = fileChooser.getSelectedFile().getName();

            imagen_btn.setText(ruta);

            File f = new File(ruta);
            //System.out.println(ruta);
            if (!ruta.equals("C:\\Users\\Eduardo\\Documents\\ALGORITMOS\\Java\\NetBeansProjects\\FPOO\\SQL_Connection\\src\\imagenes")) {
                if (f.renameTo(new File("C:\\Users\\Eduardo\\Documents\\ALGORITMOS\\Java\\NetbeansProjects\\FPOO\\SQL_Connection\\src\\imagenes\\" + ruta_bd))) {
                    f.delete();
                    JOptionPane.showMessageDialog(null, "Image loaded successfully", "Image loaded", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error loading the image", "Image load error", JOptionPane.ERROR_MESSAGE);
                }
            } else { JOptionPane.showMessageDialog(null, "Image loaded successfully", "Image loaded", JOptionPane.INFORMATION_MESSAGE); }

        }
    }//GEN-LAST:event_load_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        platillo.setText("");
        descrip.setText("");
        precio.setText("");
        imagen_btn.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed

    private String ruta_bd = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoryCB;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JButton clear_btn;
    private javax.swing.JTextField descrip;
    private javax.swing.JLabel descripLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JTextField imagen_btn;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton load_btn;
    private javax.swing.JLabel mealLbl;
    private javax.swing.JTextField platillo;
    private javax.swing.JTextField precio;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JButton save_btn;
    // End of variables declaration//GEN-END:variables
}