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
    
    
    Entreprise entreprise;
    
    public InterfaceGraphiquePersonnel() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.entreprise = new Entreprise();
        this.initTabPersonnel(this.entreprise.getTPersonnels());
        this.remplissageComboBoxCompPersonnel();
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
            String competence = "";
            for (int j = 0 ; j < valeur.getTabC().size() ; j++) {
                competence +=  valeur.getTabC().get(j)+" - ";
            }
            model.addRow(new Object[]{valeur.getId(),valeur.getNom(),valeur.getPrenom(), valeur.getDateEntree(), competence, valeur.getDispo()});
        }   
    }
    
    private void remplissageComboBoxCompPersonnel() throws IOException{
        this.comboBoxCompPers1.addItem(" ");
        this.comboBoxCompPers2.addItem(" ");
        this.comboBoxCompPers3.addItem(" ");
        Entreprise e = new Entreprise();
        Set<String> keys = entreprise.getTCompetences().keySet();
        for(String key: keys){
            Competence p = entreprise.getTCompetences().get(key);
            this.comboBoxCompPers1.addItem(p.toString());
            this.comboBoxCompPers2.addItem(p.toString());
            this.comboBoxCompPers3.addItem(p.toString());
        }
    }
    
    private String getIdCompet(String compet){
        String id = "";
        int i = 0;
        while( i<compet.length() && compet.charAt(i)!='-') {
            id += compet.charAt(i);
            i++;
        }
        return id;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPers = new javax.swing.JPanel();
        labelPrenPers = new javax.swing.JLabel();
        labelListePers = new javax.swing.JLabel();
        tablePers = new javax.swing.JScrollPane();
        tablePersonnel = new javax.swing.JTable();
        textFieldNomPers = new javax.swing.JTextField();
        textFieldPrenPers = new javax.swing.JTextField();
        buttonAjoutePers = new javax.swing.JButton();
        buttonModifPers = new javax.swing.JButton();
        labelCompPers = new javax.swing.JLabel();
        comboBoxCompPers1 = new javax.swing.JComboBox<>();
        buttonRetourPers = new javax.swing.JButton();
        comboBoxCompPers2 = new javax.swing.JComboBox<>();
        comboBoxCompPers3 = new javax.swing.JComboBox<>();
        labelPersPers = new javax.swing.JLabel();
        buttonRechPers = new javax.swing.JButton();
        labelNomPer = new javax.swing.JLabel();
        separatorPers = new javax.swing.JSeparator();
        LabelAnneeEntrPers = new javax.swing.JLabel();
        LabelmoisEntrePers = new javax.swing.JLabel();
        TextFieldAnneeEntree = new javax.swing.JTextField();
        TextFieldMoisEntree = new javax.swing.JTextField();
        erreurModif = new javax.swing.JLabel();
        ButtonSauvegarder = new javax.swing.JButton();
        buttonModifPers1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPers.setBackground(new java.awt.Color(225, 225, 213));

        labelPrenPers.setText("Prénom :");

        labelListePers.setText("Liste :");

        tablePersonnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identtifiant", "Nom", "Prénom", "Date Début", "Compétences", "Dispo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePersonnel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablePersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePersonnelMouseReleased(evt);
            }
        });
        tablePers.setViewportView(tablePersonnel);

        buttonAjoutePers.setText("Ajouter");
        buttonAjoutePers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjoutePersMouseClicked(evt);
            }
        });

        buttonModifPers.setText("Modifier");
        buttonModifPers.setEnabled(false);
        buttonModifPers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifPersMouseClicked(evt);
            }
        });

        labelCompPers.setText("Compétences :");

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

        LabelAnneeEntrPers.setText("Année d'entrée :");

        LabelmoisEntrePers.setText("Mois d'entrée :");

        ButtonSauvegarder.setText("Sauvegarder la base de données");
        ButtonSauvegarder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSauvegarderMouseClicked(evt);
            }
        });

        buttonModifPers1.setText("Supprimer");
        buttonModifPers1.setEnabled(false);
        buttonModifPers1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifPers1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelPersLayout = new javax.swing.GroupLayout(PanelPers);
        PanelPers.setLayout(PanelPersLayout);
        PanelPersLayout.setHorizontalGroup(
            PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPersLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(labelPersPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(440, 440, 440))
            .addGroup(PanelPersLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersLayout.createSequentialGroup()
                        .addComponent(labelCompPers)
                        .addGap(18, 18, 18)
                        .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxCompPers3, 0, 242, Short.MAX_VALUE)
                            .addComponent(comboBoxCompPers2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxCompPers1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(229, 229, 229)
                        .addComponent(buttonRechPers, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPersLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelNomPer)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldNomPers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(labelPrenPers)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldPrenPers, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LabelAnneeEntrPers)
                        .addGap(18, 18, 18)
                        .addComponent(TextFieldAnneeEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelmoisEntrePers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldMoisEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelPersLayout.createSequentialGroup()
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separatorPers))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPersLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelListePers)
                            .addGroup(PanelPersLayout.createSequentialGroup()
                                .addComponent(buttonRetourPers, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonSauvegarder))
                            .addComponent(tablePers, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPersLayout.createSequentialGroup()
                                .addComponent(buttonModifPers1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(erreurModif, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE))
                            .addGroup(PanelPersLayout.createSequentialGroup()
                                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonModifPers, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(14, 14, 14))
        );
        PanelPersLayout.setVerticalGroup(
            PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelPersPers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPrenPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrenPers)
                    .addComponent(textFieldNomPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomPer)
                    .addComponent(LabelAnneeEntrPers)
                    .addComponent(LabelmoisEntrePers)
                    .addComponent(TextFieldAnneeEntree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldMoisEntree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCompPers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCompPers))
                .addGap(15, 15, 15)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCompPers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRechPers, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(comboBoxCompPers3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorPers, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelListePers)
                .addGap(29, 29, 29)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersLayout.createSequentialGroup()
                        .addComponent(buttonAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonModifPers, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPersLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(erreurModif, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPersLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonModifPers1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 161, Short.MAX_VALUE))
                    .addComponent(tablePers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PanelPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRetourPers)
                    .addComponent(ButtonSauvegarder))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        if ( this.tablePersonnel.getSelectedRowCount() !=0 ) {
            DefaultTableModel model = (DefaultTableModel) this.tablePersonnel.getModel();
            System.out.println(""+model.getValueAt(this.tablePersonnel.getSelectedRow(), 0));
            entreprise.setIdModifPerso(""+model.getValueAt(this.tablePersonnel.getSelectedRow(), 0));
            InterfaceGraphiqueModifierPerso ModifPerso = null;
            try {
                ModifPerso = new InterfaceGraphiqueModifierPerso();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            ModifPerso.setVisible(true);
        } else {
            this.erreurModif.setText("Veuillez selectionner une personne");
        }
    }//GEN-LAST:event_buttonModifPersMouseClicked

    private void buttonRetourPersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourPersMouseClicked
        // TODO add your handling code here:
        interfaceGraphiqueAccueil Accueil = null;
        try {
            Accueil = new interfaceGraphiqueAccueil();
        } catch (NumberFormatException ex) {
            Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiquePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        Accueil.setVisible(true);
    }//GEN-LAST:event_buttonRetourPersMouseClicked

    private void comboBoxCompPers2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCompPers2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCompPers2ActionPerformed

    private void buttonRechPersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRechPersMouseClicked
        ArrayList<String> compet = new ArrayList<String>();
        if (this.comboBoxCompPers1.getSelectedItem() != " ") {
            compet.add(this.getIdCompet((String)this.comboBoxCompPers1.getSelectedItem()));
        }
        if (this.comboBoxCompPers2.getSelectedItem() != " ") {
            compet.add(this.getIdCompet((String)this.comboBoxCompPers2.getSelectedItem()));
        }
        if (this.comboBoxCompPers3.getSelectedItem() != " ") {
            compet.add(this.getIdCompet((String)this.comboBoxCompPers3.getSelectedItem()));
        }
        this.initTabPersonnel(this.entreprise.rechercherPersonnels(null,
                                                                   this.textFieldNomPers.getText(),
                                                                   this.textFieldPrenPers.getText(),
                                                                   compet));
    }//GEN-LAST:event_buttonRechPersMouseClicked

    private void ButtonSauvegarderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSauvegarderMouseClicked
        try {
            this.entreprise.sauvegarderTout();
        } catch (IOException ex) {
            Logger.getLogger(interfaceGraphiqueAjoutePerso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSauvegarderMouseClicked

    private void tablePersonnelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonnelMouseReleased
        this.buttonModifPers.setEnabled(true);
        this.buttonModifPers1.setEnabled(true);
    }//GEN-LAST:event_tablePersonnelMouseReleased

    private void buttonModifPers1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifPers1MouseClicked
        // entreprise.suppPersonnel(entreprise.getIdModifPerso());
    }//GEN-LAST:event_buttonModifPers1MouseClicked

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
    private javax.swing.JButton ButtonSauvegarder;
    private javax.swing.JLabel LabelAnneeEntrPers;
    private javax.swing.JLabel LabelmoisEntrePers;
    private javax.swing.JPanel PanelPers;
    private javax.swing.JTextField TextFieldAnneeEntree;
    private javax.swing.JTextField TextFieldMoisEntree;
    private javax.swing.JButton buttonAjoutePers;
    private javax.swing.JButton buttonModifPers;
    private javax.swing.JButton buttonModifPers1;
    private javax.swing.JButton buttonRechPers;
    private javax.swing.JButton buttonRetourPers;
    private javax.swing.JComboBox<String> comboBoxCompPers1;
    private javax.swing.JComboBox<String> comboBoxCompPers2;
    private javax.swing.JComboBox<String> comboBoxCompPers3;
    private javax.swing.JLabel erreurModif;
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
