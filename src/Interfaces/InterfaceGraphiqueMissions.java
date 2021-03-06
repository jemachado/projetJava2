/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entreprise.Entreprise;
import Mission.Mission;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiqueMissions extends javax.swing.JFrame {
    Entreprise entreprise;
    /**
     * Creates new form InterfaceGraphiqueMissions
     */
    public InterfaceGraphiqueMissions() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.entreprise = new Entreprise();
        this.initTableMission();
    }
    
    private void initTableMission(){
        DefaultTableModel model = (DefaultTableModel) this.tableMissions.getModel();
        TreeMap<Integer,Mission> tabM = this.entreprise.getTMissions();
         Set<Integer> keys = tabM.keySet();
        for(Integer key: keys){
            Mission m = tabM.get(key);
            model.addRow(new Object[] {m.getType(), m.getId(), m.getDateDebutFr(), m.getDateFinFr(), m.getTotalPersonne()});
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
        labelMissionsMission = new javax.swing.JLabel();
        buttonAjouterMission = new javax.swing.JButton();
        labelTypeMission = new javax.swing.JLabel();
        buttonModifierMissions = new javax.swing.JButton();
        buttonRechMissions = new javax.swing.JButton();
        buttonRetourMissions = new javax.swing.JButton();
        comboBoxMTypeMissions = new javax.swing.JComboBox<>();
        labelDateDebMissions = new javax.swing.JLabel();
        textFieldDateDebMissions = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMissions = new javax.swing.JTable();
        labelDateDebMissions1 = new javax.swing.JLabel();
        textFieldDuree = new javax.swing.JTextField();
        textFieldNbPers = new javax.swing.JTextField();
        labelDateDebMissions2 = new javax.swing.JLabel();
        buttonModifierMission = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(225, 225, 213));

        labelMissionsMission.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelMissionsMission.setText("Missions");

        buttonAjouterMission.setText("Ajouter un mission en péparation");
        buttonAjouterMission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjouterMissionMouseClicked(evt);
            }
        });

        labelTypeMission.setText("Type de Mission :");

        buttonModifierMissions.setText("Fiche détails");
        buttonModifierMissions.setEnabled(false);
        buttonModifierMissions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifierMissionsMouseClicked(evt);
            }
        });

        buttonRechMissions.setText("Rechercher");

        buttonRetourMissions.setText("Retour");
        buttonRetourMissions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourMissionsMouseClicked(evt);
            }
        });

        comboBoxMTypeMissions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "MissionPlanifiée", "MissionPlanification", "MissionEnCours", "MissionTerminée" }));
        comboBoxMTypeMissions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMTypeMissionsActionPerformed(evt);
            }
        });

        labelDateDebMissions.setText("Date Début :");

        tableMissions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Identifiant", "Date de début", "Durée", "Nombre de personnel mobilisé"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMissions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMissions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMissionsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableMissions);

        labelDateDebMissions1.setText("Durée :");

        labelDateDebMissions2.setText("Nombre de personne mobilisé :");

        buttonModifierMission.setText("Modifier et assigner le personnel");
        buttonModifierMission.setEnabled(false);
        buttonModifierMission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifierMissionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelDateDebMissions2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldNbPers, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelDateDebMissions1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDateDebMissions)
                                        .addComponent(labelTypeMission))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textFieldDateDebMissions)
                                        .addComponent(comboBoxMTypeMissions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonModifierMissions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAjouterMission, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRechMissions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonModifierMission, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(204, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRetourMissions)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(641, 641, 641)
                .addComponent(labelMissionsMission)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMissionsMission)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTypeMission)
                            .addComponent(comboBoxMTypeMissions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDateDebMissions)
                            .addComponent(textFieldDateDebMissions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDateDebMissions1)
                            .addComponent(textFieldDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDateDebMissions2)
                            .addComponent(textFieldNbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRechMissions, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAjouterMission, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonModifierMission, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonModifierMissions, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRetourMissions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRetourMissionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourMissionsMouseClicked
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
    }//GEN-LAST:event_buttonRetourMissionsMouseClicked

    private void comboBoxMTypeMissionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMTypeMissionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMTypeMissionsActionPerformed

    private void buttonAjouterMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAjouterMissionMouseClicked
       
            InterfaceGraphiqueCreationMissions  createMission = null;
            try {
                createMission = new InterfaceGraphiqueCreationMissions();
            } catch (NumberFormatException ex) {
                Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            createMission.setVisible(true);
        
    }//GEN-LAST:event_buttonAjouterMissionMouseClicked

    private void tableMissionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMissionsMouseReleased
        DefaultTableModel model = (DefaultTableModel) this.tableMissions.getModel();
        String statut = ""+model.getValueAt(this.tableMissions.getSelectedRow(), 0);
        this.buttonModifierMissions.setEnabled(true);
        if (statut.equals("MissionPreparation") || statut.equals("MissionPlanifiee")) {
            this.buttonModifierMission.setEnabled(true);
        } else {
            this.buttonModifierMission.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_tableMissionsMouseReleased

    private void buttonModifierMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifierMissionMouseClicked
        if ( this.tableMissions.getSelectedRowCount() !=0 ) {
            DefaultTableModel model = (DefaultTableModel) this.tableMissions.getModel();
            entreprise.setIdModifMission(""+model.getValueAt(this.tableMissions.getSelectedRow(), 1));
            InterfaceGraphiqueModifierMissions ModifMission = null;
            ModifMission = new InterfaceGraphiqueModifierMissions();
            this.dispose();
            ModifMission.setVisible(true);
        }
    }//GEN-LAST:event_buttonModifierMissionMouseClicked

    private void buttonModifierMissionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifierMissionsMouseClicked
        if ( this.tableMissions.getSelectedRowCount() !=0 ) {
            DefaultTableModel model = (DefaultTableModel) this.tableMissions.getModel();
            entreprise.setIdModifMission(""+model.getValueAt(this.tableMissions.getSelectedRow(), 1));
            InterfaceGraphiqueFicheDetailsMissions ModifMission = null;
            ModifMission = new InterfaceGraphiqueFicheDetailsMissions();
            this.dispose();
            ModifMission.setVisible(true);
        }
    }//GEN-LAST:event_buttonModifierMissionsMouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGraphiqueMissions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjouterMission;
    private javax.swing.JButton buttonModifierMission;
    private javax.swing.JButton buttonModifierMissions;
    private javax.swing.JButton buttonRechMissions;
    private javax.swing.JButton buttonRetourMissions;
    private javax.swing.JComboBox<String> comboBoxMTypeMissions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDateDebMissions;
    private javax.swing.JLabel labelDateDebMissions1;
    private javax.swing.JLabel labelDateDebMissions2;
    private javax.swing.JLabel labelMissionsMission;
    private javax.swing.JLabel labelTypeMission;
    private javax.swing.JTable tableMissions;
    private javax.swing.JTextField textFieldDateDebMissions;
    private javax.swing.JTextField textFieldDuree;
    private javax.swing.JTextField textFieldNbPers;
    // End of variables declaration//GEN-END:variables
}
