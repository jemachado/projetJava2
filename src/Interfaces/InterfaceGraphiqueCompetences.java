/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Competence.Competence;
import Entreprise.Entreprise;
import Personnel.Personnel;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiqueCompetences extends javax.swing.JFrame {
    Entreprise entreprise;
    /**
     * Creates new form InterfaceGraphiqueCompetences
     */
    public InterfaceGraphiqueCompetences() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.entreprise = new Entreprise();
        this.entreprise.initDonnees();
        this.initTabCompetences();
    }
    
    private void initTabCompetences() {
        DefaultTableModel model = (DefaultTableModel) jTableCompet.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int j = rowCount - 1; j >= 0; j--) {
            model.removeRow(j);
        }
        Iterator i = this.entreprise.getTCompetences().keySet().iterator();
        String clef = null;
        Competence valeur = null;
        while (i.hasNext()){
            clef = (String)i.next();
            valeur = this.entreprise.getTCompetences().get(clef);
            model.addRow(new Object[]{valeur.getId(), valeur.getLibelleFr(), valeur.getLibelleEn()});
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

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jDialogLibFr = new javax.swing.JLabel();
        jDialogLibEn = new javax.swing.JLabel();
        confirmeSuppOui = new javax.swing.JButton();
        confirmeSuppNon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonAjouteComp = new javax.swing.JButton();
        buttonModifComp = new javax.swing.JButton();
        labelCompComp = new javax.swing.JLabel();
        labelListeComp = new javax.swing.JLabel();
        erreurModif = new javax.swing.JLabel();
        jButtonSauvegarder = new javax.swing.JButton();
        buttonRetourAjoutePers = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextLibelleFr = new javax.swing.JTextField();
        jTextLibelleEn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonSuppComp = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCompet = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setText("Etes vous sure de vouloir supprimer la compétence :");

        jDialogLibFr.setText("Libellé fr");

        jDialogLibEn.setText("Libellé en");

        confirmeSuppOui.setText("Oui");
        confirmeSuppOui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmeSuppOuiMouseClicked(evt);
            }
        });
        confirmeSuppOui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmeSuppOuiActionPerformed(evt);
            }
        });

        confirmeSuppNon.setText("Non");
        confirmeSuppNon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmeSuppNonMouseClicked(evt);
            }
        });
        confirmeSuppNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmeSuppNonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(confirmeSuppOui)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmeSuppNon)
                            .addGap(11, 11, 11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDialogLibEn)
                            .addComponent(jDialogLibFr))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDialogLibFr)
                .addGap(18, 18, 18)
                .addComponent(jDialogLibEn)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmeSuppOui)
                    .addComponent(confirmeSuppNon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(225, 225, 213));

        buttonAjouteComp.setText("Ajouter");
        buttonAjouteComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjouteCompMouseClicked(evt);
            }
        });

        buttonModifComp.setText("Modifier");
        buttonModifComp.setEnabled(false);
        buttonModifComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifCompMouseClicked(evt);
            }
        });

        labelCompComp.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelCompComp.setText("Compétences");

        labelListeComp.setText("Liste :");

        jButtonSauvegarder.setText("Sauvegarder la base de données");
        jButtonSauvegarder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSauvegarderMouseClicked(evt);
            }
        });

        buttonRetourAjoutePers.setText("Retour");
        buttonRetourAjoutePers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourAjoutePersMouseClicked(evt);
            }
        });

        jLabel1.setText("Identifiant : ");

        jLabel2.setText("Libellé en français :");

        jLabel3.setText("Libellé en anglais :");

        buttonSuppComp.setText("Supprimer");
        buttonSuppComp.setEnabled(false);
        buttonSuppComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSuppCompMouseClicked(evt);
            }
        });
        buttonSuppComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuppCompActionPerformed(evt);
            }
        });

        jButton1.setText("Actualiser la liste de compétence");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTableCompet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Libellé français", "Libellé anglais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCompet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCompet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCompetMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCompetMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCompet);

        jLabel4.setText("Actualiser le tableau après un ajout :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(656, 656, 656)
                .addComponent(labelCompComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(404, 404, 404))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelListeComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonAjouteComp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSuppComp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextLibelleFr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                .addComponent(jTextLibelleEn, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jButton1)
                            .addComponent(jLabel4)
                            .addComponent(erreurModif, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRetourAjoutePers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSauvegarder)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelCompComp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelListeComp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextLibelleFr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextLibelleEn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAjouteComp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonSuppComp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erreurModif, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 193, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRetourAjoutePers)
                    .addComponent(jButtonSauvegarder))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAjouteCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAjouteCompMouseClicked
        // TODO add your handling code here:
        interfaceGraphiqueAjouteComp AjoutComp = null;
        try {
            AjoutComp = new interfaceGraphiqueAjouteComp();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(Level.SEVERE, null, ex);
        }
        AjoutComp.setVisible(true);
        
    }//GEN-LAST:event_buttonAjouteCompMouseClicked

    private void buttonModifCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifCompMouseClicked
        if ( this.jTableCompet.getSelectedRowCount() !=0 ) {
            if ( this.entreprise.modifCompétence(this.jTextId.getText(), this.jTextLibelleEn.getText(), this.jTextLibelleFr.getText()) ) {
                this.erreurModif.setText("Modification bien éffectué");
                this.initTabCompetences();
                this.jTextId.setText("");
                this.jTextLibelleEn.setText("");
                this.jTextLibelleFr.setText("");
            } else {
                this.erreurModif.setText("Modification non éffectué");
            }
        } else {
            this.erreurModif.setText("Veuillez selectionner une competence");
        }
    }//GEN-LAST:event_buttonModifCompMouseClicked

    private void jButtonSauvegarderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSauvegarderMouseClicked
        try {
            this.entreprise.sauvegarderTout();
        } catch (IOException ex) {
            Logger.getLogger(interfaceGraphiqueAjoutePerso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSauvegarderMouseClicked

    private void buttonRetourAjoutePersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourAjoutePersMouseClicked
        interfaceGraphiqueAccueil  Accueil = null;
        try {
            Accueil = new interfaceGraphiqueAccueil();
        } catch (NumberFormatException ex) {
            Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        Accueil.setVisible(true);
    }//GEN-LAST:event_buttonRetourAjoutePersMouseClicked

    private void buttonSuppCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSuppCompMouseClicked
        if ( this.jTableCompet.getSelectedRowCount() !=0 ) {
            this.jDialogLibEn.setText(this.jTextLibelleEn.getText());
            this.jDialogLibFr.setText(this.jTextLibelleFr.getText());
            this.jDialog1.setVisible(true);
        } else {
            this.erreurModif.setText("Veuillez selectionner une competence");
        }
    }//GEN-LAST:event_buttonSuppCompMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.initTabCompetences();
    }//GEN-LAST:event_jButton1MouseClicked

    private void buttonSuppCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuppCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSuppCompActionPerformed

    private void jTableCompetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompetMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableCompetMouseClicked

    private void jTableCompetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompetMouseReleased
        if ( this.jTableCompet.getSelectedRowCount() !=0 ) {
            this.buttonModifComp.setEnabled(true);
            this.buttonSuppComp.setEnabled(true);
            DefaultTableModel model = (DefaultTableModel) this.jTableCompet.getModel();
            Competence c = this.entreprise.getTCompetences().get(""+model.getValueAt(this.jTableCompet.getSelectedRow(), 0));
            this.jTextId.setText(c.getId());
            this.jTextLibelleFr.setText(c.getLibelleFr());
            this.jTextLibelleEn.setText(c.getLibelleEn());
        } else {
            this.erreurModif.setText("Veuillez selectionner une competence");
        }
    }//GEN-LAST:event_jTableCompetMouseReleased

    private void confirmeSuppOuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmeSuppOuiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmeSuppOuiActionPerformed

    private void confirmeSuppNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmeSuppNonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmeSuppNonActionPerformed

    private void confirmeSuppOuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmeSuppOuiMouseClicked
        if (entreprise.supCompétence(this.jTextId.getText()) ) {
            this.erreurModif.setText("Suppression bien effectuée");
            this.initTabCompetences();
            this.jTextId.setText("");
            this.jTextLibelleEn.setText("");
            this.jTextLibelleFr.setText("");
        } else {
            this.erreurModif.setText("Suppression non effectuée");
        }
        this.jDialog1.setVisible(false);
    }//GEN-LAST:event_confirmeSuppOuiMouseClicked

    private void confirmeSuppNonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmeSuppNonMouseClicked
        this.jDialog1.setVisible(false);
    }//GEN-LAST:event_confirmeSuppNonMouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfaceGraphiqueCompetences().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceGraphiqueCompetences.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjouteComp;
    private javax.swing.JButton buttonModifComp;
    private javax.swing.JButton buttonRetourAjoutePers;
    private javax.swing.JButton buttonSuppComp;
    private javax.swing.JButton confirmeSuppNon;
    private javax.swing.JButton confirmeSuppOui;
    private javax.swing.JLabel erreurModif;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSauvegarder;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jDialogLibEn;
    private javax.swing.JLabel jDialogLibFr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCompet;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextLibelleEn;
    private javax.swing.JTextField jTextLibelleFr;
    private javax.swing.JLabel labelCompComp;
    private javax.swing.JLabel labelListeComp;
    // End of variables declaration//GEN-END:variables
}
