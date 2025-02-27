/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.xprod.xproddesktop;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.xprod.xproddesktop.dao.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author william NYACKA
 */
public class XprodDesktop extends javax.swing.JFrame {

    /**
     * Creates new form XprodDesktop
     */
    public XprodDesktop() {
        initComponents();
        this.setTitle("XPROD Produits - Administrateur");
        setLocationRelativeTo(null);//Pour centrer le contenu de ma fenêtre
        tableUpdate(); //Mettre à jour la table des produits
    }

    //Affichage utilisateur
    public void afficherUser(String user) {
        lblUser.setText(user);
    }

    //Connexion
    Connexion cn = new Connexion();
    Connection con;
    PreparedStatement pst;

    //Mise à jour du tableau
    private void tableUpdate() {
        int cpt; // Déclaration de la variable compteur

        try {
            // Enregistrement du driver MySQL
            con = cn.getCon();
            // Requête SQL pour récupérer tous les produits
            String query = "SELECT * FROM produit";
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery(); // Exécution de la requête

            // Récupération des métadonnées de la requête
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            cpt = rsmd.getColumnCount(); // Nombre de colonnes dans la table

            // Initialisation du modèle du tableau
            DefaultTableModel dtm = (DefaultTableModel) tablePRODUIT.getModel();
            dtm.setRowCount(0); // Réinitialisation du tableau

            while (rs.next()) {
                // Création d'un vecteur pour chaque ligne de données
                Vector vect = new Vector();
                vect.add(rs.getString("idproduit"));
                vect.add(rs.getString("refproduit"));
                vect.add(rs.getString("designation"));
                vect.add(rs.getString("description"));
                vect.add(rs.getString("prixuht"));
                // Ajout de la ligne au tableau
                dtm.addRow(vect);
            }

        } catch (Exception e) {
            // Affichage de l'exception dans la console pour déboguer

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

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDESIGNATION = new javax.swing.JTextField();
        txtDESCRIPTIF = new javax.swing.JTextField();
        txtPRIXUHT = new javax.swing.JTextField();
        txtREF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnAJOUTER = new javax.swing.JButton();
        btnMODIFIER = new javax.swing.JButton();
        btnSUPPRIMER = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePRODUIT = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemProduit = new javax.swing.JMenuItem();
        jMenuFournisseur = new javax.swing.JMenu();
        jMenuItemAddFournisseur = new javax.swing.JMenuItem();
        jMenuCommande = new javax.swing.JMenu();
        jMenuItemCommande = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemSeDeconnecter = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenu2.setText("jMenu2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(222, 184, 41));

        jPanel1.setBackground(new java.awt.Color(238, 182, 52));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Référence");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Désignation");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Prix UHT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Identifiant");

        btnAJOUTER.setText("Ajouter");
        btnAJOUTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAJOUTERActionPerformed(evt);
            }
        });

        btnMODIFIER.setText("Modifier");
        btnMODIFIER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMODIFIERActionPerformed(evt);
            }
        });

        btnSUPPRIMER.setText("Supprimer");
        btnSUPPRIMER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUPPRIMERActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion des produits");

        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Utilisateur");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addContainerGap(362, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUser)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablePRODUIT.setBackground(new java.awt.Color(0, 0, 0));
        tablePRODUIT.setForeground(new java.awt.Color(255, 255, 255));
        tablePRODUIT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id produit", "Référence", "Désignation", "Description", "Prix UHT"
            }
        ));
        tablePRODUIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePRODUITMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePRODUIT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAJOUTER)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMODIFIER)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSUPPRIMER)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtREF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDESIGNATION, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDESCRIPTIF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPRIXUHT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtREF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDESIGNATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDESCRIPTIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPRIXUHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAJOUTER)
                    .addComponent(btnMODIFIER)
                    .addComponent(btnSUPPRIMER))
                .addContainerGap())
        );

        jMenu3.setText("Produit");

        jMenuItemProduit.setText("Ajouter un produit");
        jMenuItemProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProduitActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemProduit);

        jMenuBar1.add(jMenu3);

        jMenuFournisseur.setBackground(new java.awt.Color(239, 109, 109));
        jMenuFournisseur.setText("Fournisseur");

        jMenuItemAddFournisseur.setText("Ajouter un fournisseur");
        jMenuItemAddFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddFournisseurActionPerformed(evt);
            }
        });
        jMenuFournisseur.add(jMenuItemAddFournisseur);

        jMenuBar1.add(jMenuFournisseur);

        jMenuCommande.setText("Commande");

        jMenuItemCommande.setText("Ajouter une commande");
        jMenuItemCommande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCommandeActionPerformed(evt);
            }
        });
        jMenuCommande.add(jMenuItemCommande);

        jMenuBar1.add(jMenuCommande);

        jMenu5.setForeground(new java.awt.Color(255, 0, 0));
        jMenu5.setText("Déconnexion");

        jMenuItemSeDeconnecter.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItemSeDeconnecter.setText("Se déconnecter");
        jMenuItemSeDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSeDeconnecterActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemSeDeconnecter);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAJOUTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAJOUTERActionPerformed
// Je récupère les informations entrées dans nos textes
        String refProduit = txtREF.getText();
        String designation = txtDESIGNATION.getText();
        String descriptif = txtDESCRIPTIF.getText();
        String prixUHT = txtPRIXUHT.getText();

        try {
            con = cn.getCon();

            pst = con.prepareStatement("INSERT INTO produit (refproduit, designation, description, prixuht) VALUES (?,?,?,?)");

            pst.setString(1, refProduit);
            pst.setString(2, designation);
            pst.setString(3, descriptif);
            pst.setString(4, prixUHT);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Données enregistrées");

            //Vider les champs après le message
            txtREF.setText("");
            txtDESCRIPTIF.setText("");
            txtDESIGNATION.setText("");
            txtPRIXUHT.setText("");

            tableUpdate(); //Mis à jour du tableau lors d'un ajout

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAJOUTERActionPerformed

    private void tablePRODUITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePRODUITMouseClicked
        // Pour séléctionner les informations d'un champ
        DefaultTableModel dtm = (DefaultTableModel) tablePRODUIT.getModel();

        int selectedIndex = tablePRODUIT.getSelectedRow();

        txtID.setText(dtm.getValueAt(selectedIndex, 0).toString());
        txtREF.setText(dtm.getValueAt(selectedIndex, 1).toString());
        txtDESIGNATION.setText(dtm.getValueAt(selectedIndex, 2).toString());
        txtDESCRIPTIF.setText(dtm.getValueAt(selectedIndex, 3).toString());
        txtPRIXUHT.setText(dtm.getValueAt(selectedIndex, 4).toString());
    }//GEN-LAST:event_tablePRODUITMouseClicked

    private void btnMODIFIERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMODIFIERActionPerformed
        // Modification
        DefaultTableModel dtm = (DefaultTableModel) tablePRODUIT.getModel();

        int selectedIndex = tablePRODUIT.getSelectedRow();

        try {
            int IDProduit = Integer.parseInt(dtm.getValueAt(selectedIndex, 0).toString());//ID de la table produit

            String refProduit = txtREF.getText();
            String designation = txtDESIGNATION.getText();
            String descriptif = txtDESCRIPTIF.getText();
            String prixUHT = txtPRIXUHT.getText();

            con = cn.getCon();
            pst = con.prepareStatement("update produit set refproduit=?, designation=?, description=?, prixuht=? where idproduit=?");

            pst.setString(1, refProduit);
            pst.setString(2, designation);
            pst.setString(3, descriptif);
            pst.setString(4, prixUHT);
            pst.setInt(5, IDProduit);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Données mise à jour");

            //Vider les champs après le message
            txtID.setText("");
            txtREF.setText("");
            txtDESCRIPTIF.setText("");
            txtDESIGNATION.setText("");
            txtPRIXUHT.setText("");

            tableUpdate();//Mettre à jour la table des produits

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnMODIFIERActionPerformed

    private void btnSUPPRIMERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSUPPRIMERActionPerformed
        //Supprimer
        DefaultTableModel dtm = (DefaultTableModel) tablePRODUIT.getModel();
        int selectedIndex = tablePRODUIT.getSelectedRow();
        int IDProduit = Integer.parseInt(dtm.getValueAt(selectedIndex, 0).toString());  //Id de la table produit 

        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette données ?", "ATTENTION!", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            try {
                con = cn.getCon();
                pst = con.prepareStatement("delete from produit where idproduit=?");
                pst.setInt(1, IDProduit);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Données supprimées !");

                //Je vide le contenu des champs remplis
                txtREF.setText("");
                txtDESCRIPTIF.setText("");
                txtDESIGNATION.setText("");
                txtPRIXUHT.setText("");

                tableUpdate(); //Mettre à jour la table des produits

            } catch (SQLException ex) {
                Logger.getLogger(XprodDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSUPPRIMERActionPerformed

    private void jMenuItemAddFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddFournisseurActionPerformed
        Fournisseur AjoutFournisseur = new Fournisseur();
        AjoutFournisseur.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemAddFournisseurActionPerformed

    private void jMenuItemCommandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCommandeActionPerformed
        Commande AjoutCommande = new Commande();
        AjoutCommande.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemCommandeActionPerformed

    private void jMenuItemSeDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSeDeconnecterActionPerformed
        Login connexion = new Login();
        connexion.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemSeDeconnecterActionPerformed

    private void jMenuItemProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProduitActionPerformed
        XprodDesktop AjoutProduit = new XprodDesktop();
        AjoutProduit.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemProduitActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XprodDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XprodDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XprodDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XprodDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XprodDesktop().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAJOUTER;
    private javax.swing.JButton btnMODIFIER;
    private javax.swing.JButton btnSUPPRIMER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCommande;
    private javax.swing.JMenu jMenuFournisseur;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAddFournisseur;
    private javax.swing.JMenuItem jMenuItemCommande;
    private javax.swing.JMenuItem jMenuItemProduit;
    private javax.swing.JMenuItem jMenuItemSeDeconnecter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tablePRODUIT;
    private javax.swing.JTextField txtDESCRIPTIF;
    private javax.swing.JTextField txtDESIGNATION;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPRIXUHT;
    private javax.swing.JTextField txtREF;
    // End of variables declaration//GEN-END:variables

}
