/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Competence.Competence;
import Entreprise.Entreprise;
import javax.swing.JFrame;
import Personnel.Personnel;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import static javafx.scene.input.KeyCode.O;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiquePersonnel extends javax.swing.JFrame {
    JFrame Personnel = new JFrame("Personnel");
    /**
     * Creates new form InterfaceGraphiquePersonnel
     * @throws java.io.IOException
     */
    Entreprise entreprise;
    
    public InterfaceGraphiquePersonnel() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.entreprise = new Entreprise();
        this.entreprise.initDonnees();
        this.initTabPersonnel(Entreprise.tPersonnels);
        this.remplissage();
    }
    
    private void initTabPersonnel(TreeMap<Integer,Personnel> tPers){
        DefaultTableModel model = (DefaultTableModel) tablePersonnel.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int j = rowCount - 1; j >= 0; j--) {
            model.removeRow(j);
        }
        Iterator i;
        i = tPers.keySet().iterator();
        Integer clef = null;
        Personnel valeur = null;
        while (i.hasNext())
        {
            clef = (Integer)i.next();
            valeur = tPers.get(clef);
            model.addRow(new Object[]{valeur.getNom(),valeur.getPrenom(), valeur.getDateEntree()});
        }   
    }
    
    private void remplissage() throws IOException{
        this.comboBoxCompPers1.addItem(" ");
        this.comboBoxCompPers2.addItem(" ");
        this.comboBoxCompPers3.addItem(" ");
        Entreprise e = new Entreprise();
        Set<String> keys = Entreprise.tCompetences.keySet();
        for(String key: keys){
            Competence p = Entreprise.tCompetences.get(key);
            this.comboBoxCompPers1.addItem(p.toString());
            this.comboBoxCompPers2.addItem(p.toString());
            this.comboBoxCompPers3.addItem(p.toString());
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
        labelPrenPers = new javax.swing.JLabel();
        labelListePers = new javax.swing.JLabel();
        tablePers = new javax.swing.JScrollPane();
        tablePersonnel = new javax.swing.JTable();
        textFieldNomPers = new javax.swing.JTextField();
        textFieldPrenPers = new javax.swing.JTextField();
        buttonAjoutePers = new javax.swing.JButton();
        buttonModifPers = new javax.swing.JButton();
        labelCompPers = new javax.swing.JLabel();
        buttonSauvPers = new javax.swing.JButton();
        comboBoxCompPers1 = new javax.swing.JComboBox<>();
        buttonRetourPers = new javax.swing.JButton();
        comboBoxCompPers2 = new javax.swing.JComboBox<>();
        comboBoxCompPers3 = new javax.swing.JComboBox<>();
        labelPersPers = new javax.swing.JLabel();
        buttonRechPers = new javax.swing.JButton();
        labelNomPer = new javax.swing.JLabel();
        separatorPers = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextFieldAnneeEntree = new javax.swing.JTextField();
        TextFieldMoisEntree = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(225, 225, 213));

        labelPrenPers.setText("Prénom :");

        labelListePers.setText("Liste :");

        tablePersonnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Prénom", "Date Début", "Compétences"
            }
        ));
        tablePers.setViewportView(tablePersonnel);

        buttonAjoutePers.setText("Ajouter");
        buttonAjoutePers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjoutePersMouseClicked(evt);
            }
        });

        buttonModifPers.setText("Modifier");
        buttonModifPers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifPersMouseClicked(evt);
            }
        });

        labelCompPers.setText("Compétences :");

        buttonSauvPers.setText("Sauvegarder");
        buttonSauvPers.setEnabled(false);
        buttonSauvPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSauvPersActionPerformed(evt);
            }
        });

        buttonRetourPers.setText("Retour");
        buttonRetourPers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourPersMouseClicked(evt);
            }
        });

        comboBoxCompPers2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCompPers2ActionPerformed(evt);
            }
        });

        labelPersPers.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelPersPers.setText("Personnel");

        buttonRechPers.setText("Rechercher");
        buttonRechPers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRechPersMouseClicked(evt);
            }
        });

        labelNomPer.setText("Nom :");

        jLabel1.setText("Année d'entrée :");

        jLabel2.setText("Mois d'entrée :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(labelPersPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(440, 440, 440))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelCompPers)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxCompPers3, 0, 242, Short.MAX_VALUE)
                                    .addComponent(comboBoxCompPers2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxCompPers1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(229, 229, 229)
                                .addComponent(buttonRechPers, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(labelNomPer)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldNomPers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(labelPrenPers)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldPrenPers)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldAnneeEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldMoisEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSauvPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(750, 750, 750)
                                .addComponent(buttonRetourPers, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAjoutePers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonModifPers, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelListePers)
                                    .addComponent(tablePers))
                                .addGap(390, 390, 390))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separatorPers)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelPersPers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPrenPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrenPers)
                    .addComponent(textFieldNomPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomPer)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldAnneeEntree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldMoisEntree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCompPers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCompPers))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCompPers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRechPers, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(comboBoxCompPers3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorPers, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelListePers)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tablePers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSauvPers)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(buttonAjoutePers)
                        .addGap(32, 32, 32)
                        .addComponent(buttonModifPers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(buttonRetourPers)
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSauvPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSauvPersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSauvPersActionPerformed

    private void buttonAjoutePersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAjoutePersMouseClicked
                                              
        // TODO add your handling code here:
        interfaceGraphiqueAjoutePerso AjoutPers = null;
        try {
            AjoutPers = new interfaceGraphiqueAjoutePerso();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        AjoutPers.setVisible(true);
    }//GEN-LAST:event_buttonAjoutePersMouseClicked

    private void buttonModifPersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifPersMouseClicked
        // TODO add your handling code here:
        InterfaceGraphiqueModifierPerso ModifPerso = null;
        try {
            ModifPerso = new InterfaceGraphiqueModifierPerso();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        ModifPerso.setVisible(true);
    }//GEN-LAST:event_buttonModifPersMouseClicked

    private void buttonRetourPersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourPersMouseClicked
        // TODO add your handling code here:
        interfaceGraphiqueAccueil Accueil = new interfaceGraphiqueAccueil();
        this.dispose();
        Accueil.setVisible(true);
    }//GEN-LAST:event_buttonRetourPersMouseClicked

    private void comboBoxCompPers2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCompPers2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCompPers2ActionPerformed

    private void buttonRechPersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRechPersMouseClicked
        // TODO add your handling code here:
        this.initTabPersonnel(this.entreprise.rechercherPersonnels(null,
                                                                   this.textFieldNomPers.getText(),
                                                                   this.textFieldPrenPers.getText(),
                                                                   new ArrayList<String>() ));
    }//GEN-LAST:event_buttonRechPersMouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfaceGraphiquePersonnel().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldAnneeEntree;
    private javax.swing.JTextField TextFieldMoisEntree;
    private javax.swing.JButton buttonAjoutePers;
    private javax.swing.JButton buttonModifPers;
    private javax.swing.JButton buttonRechPers;
    private javax.swing.JButton buttonRetourPers;
    private javax.swing.JButton buttonSauvPers;
    private javax.swing.JComboBox<String> comboBoxCompPers1;
    private javax.swing.JComboBox<String> comboBoxCompPers2;
    private javax.swing.JComboBox<String> comboBoxCompPers3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCompPers;
    private javax.swing.JLabel labelListePers;
    private javax.swing.JLabel labelNomPer;
    private javax.swing.JLabel labelPersPers;
    private javax.swing.JLabel labelPrenPers;
    private javax.swing.JSeparator separatorPers;
    private javax.swing.JScrollPane tablePers;
    private javax.swing.JTable tablePersonnel;
    private javax.swing.JTextField textFieldNomPers;
    private javax.swing.JTextField textFieldPrenPers;
    // End of variables declaration//GEN-END:variables

}
