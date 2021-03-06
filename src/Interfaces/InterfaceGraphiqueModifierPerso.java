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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiqueModifierPerso extends javax.swing.JFrame {
    
    Entreprise entreprise;
    ArrayList<String> tabC;
    
    
    
    public InterfaceGraphiqueModifierPerso() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.entreprise = new Entreprise();
        initComponents();
        this.tabC = new ArrayList<String>();
        this.remplissageComboBoxAjoutePers();
        this.initForm();
    }
    
    private void initForm(){
        Personnel p = this.entreprise.getTPersonnels().get(Integer.parseInt(this.entreprise.getIdModifPerso()));
        this.textFieldDateEntreAjoutePers.setText(p.toStringDateFr());
        this.textFieldNomAjoutePers.setText(p.getNom());
        this.textFieldPreAjoutePers.setText(p.getPrenom());
        DefaultTableModel model = (DefaultTableModel) this.tableAjouterPers.getModel();
        for (int i = 0 ; i < p.getTabC().size() ; i++) {
            Competence c = this.entreprise.getTCompetences().get(p.getTabC().get(i));
            model.addRow(new Object[]{c.toString()});
        }
    }
    
    private void remplissageComboBoxAjoutePers() throws IOException{
        Entreprise e = new Entreprise();
        Set<String> keys = entreprise.getTCompetences().keySet();
        this.comboBoxCompAjoutePers1.addItem("");
        for(String key: keys){
            Competence p = entreprise.getTCompetences().get(key);
            this.comboBoxCompAjoutePers1.addItem(p.toString());
        }
    }
    
    private boolean Verifier(){
        
        if((textFieldPreAjoutePers.getText().equals(""))||
           (textFieldNomAjoutePers.getText().equals(""))||
           (textFieldDateEntreAjoutePers.getText().equals(""))){
            this.LabelControleSaisiModifPers.setText("Formulaire incomplet");
            return false;
        }
        else {
            if(this.textFieldDateEntreAjoutePers.getText().length() != 10){
                this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                return false;
            }
            int mois = Integer.parseInt(""+this.textFieldDateEntreAjoutePers.getText().charAt(3)+this.textFieldDateEntreAjoutePers.getText().charAt(4));
            if(mois > 12){
                this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)5");
                return false;
            }
            int jour = Integer.parseInt(""+this.textFieldDateEntreAjoutePers.getText().charAt(0)+this.textFieldDateEntreAjoutePers.getText().charAt(1));
            int annee = Integer.parseInt(""+this.textFieldDateEntreAjoutePers.getText().charAt(6)+this.textFieldDateEntreAjoutePers.getText().charAt(7)
                                           +this.textFieldDateEntreAjoutePers.getText().charAt(8)+this.textFieldDateEntreAjoutePers.getText().charAt(9));
            
            switch(mois){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(jour > 31){
                        this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)1");
                        return false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(jour > 30){
                        this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)2");
                        return false;
                    }
                    break;
                case 2:
                    if (((annee % 4 == 0) && 
                         !(annee % 100 == 0))
                         || (annee % 400 == 0)){
                            if(jour > 29){
                                this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)3");
                                return false;
                            }
                        break;
                    }
                    else{
                        if(jour > 28){
                            this.LabelControleSaisiModifPers.setText("La date d'entrée est non valide(jj/mm/aaaa)4");
                            return false;
                        }
                        }
                    break;
                default:
            }
            
        }
        this.LabelControleSaisiModifPers.setText("valide");
        return true;
    }
    
    private String getIdCompet(){
        String item = (String)this.comboBoxCompAjoutePers1.getSelectedItem();
        String id = "";
        int i = 0;
        while (item.charAt(i) != '-' && i < item.length()){
            id += item.charAt(i);
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

        PanelModifPers = new javax.swing.JPanel();
        buttonAjouterAjoutePers = new javax.swing.JButton();
        labelDateEntAjoutePers = new javax.swing.JLabel();
        buttonRetourAjoutePers = new javax.swing.JButton();
        textFieldPreAjoutePers = new javax.swing.JTextField();
        textFieldNomAjoutePers = new javax.swing.JTextField();
        textFieldDateEntreAjoutePers = new javax.swing.JTextField();
        labelCompAjoutePers = new javax.swing.JLabel();
        comboBoxCompAjoutePers1 = new javax.swing.JComboBox<>();
        labelAjoutePers = new javax.swing.JLabel();
        ScrollPaneModifPers = new javax.swing.JScrollPane();
        tableAjouterPers = new javax.swing.JTable();
        labelPrenAjoutePers = new javax.swing.JLabel();
        labelNomAjoutePers = new javax.swing.JLabel();
        ButtonAjouterPersoAjouterComp = new javax.swing.JButton();
        LabelControleSaisiModifPers = new javax.swing.JLabel();
        SupprCompe = new javax.swing.JButton();
        ButtonSauvegarder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelModifPers.setBackground(new java.awt.Color(225, 225, 213));

        buttonAjouterAjoutePers.setText("Modifier");
        buttonAjouterAjoutePers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjouterAjoutePersMouseClicked(evt);
            }
        });
        buttonAjouterAjoutePers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjouterAjoutePersActionPerformed(evt);
            }
        });

        labelDateEntAjoutePers.setText("Date d'entrée :");

        buttonRetourAjoutePers.setText("Retour");
        buttonRetourAjoutePers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourAjoutePersMouseClicked(evt);
            }
        });

        textFieldPreAjoutePers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPreAjoutePersActionPerformed(evt);
            }
        });

        textFieldDateEntreAjoutePers.setToolTipText("");

        labelCompAjoutePers.setText("Compétences :");

        comboBoxCompAjoutePers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCompAjoutePers1ActionPerformed(evt);
            }
        });

        labelAjoutePers.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelAjoutePers.setText("Modifier un personnel");

        tableAjouterPers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compétence(s)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAjouterPers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ScrollPaneModifPers.setViewportView(tableAjouterPers);

        labelPrenAjoutePers.setText("Prénom :");

        labelNomAjoutePers.setText("Nom :");

        ButtonAjouterPersoAjouterComp.setText("Ajouter une compétence");
        ButtonAjouterPersoAjouterComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAjouterPersoAjouterCompMouseClicked(evt);
            }
        });

        SupprCompe.setText("Supprimer une compétence");
        SupprCompe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprCompeMouseClicked(evt);
            }
        });
        SupprCompe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprCompeActionPerformed(evt);
            }
        });

        ButtonSauvegarder.setText("Sauvegarder la base de données");
        ButtonSauvegarder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSauvegarderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelModifPersLayout = new javax.swing.GroupLayout(PanelModifPers);
        PanelModifPers.setLayout(PanelModifPersLayout);
        PanelModifPersLayout.setHorizontalGroup(
            PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModifPersLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModifPersLayout.createSequentialGroup()
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelModifPersLayout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(labelAjoutePers))
                            .addGroup(PanelModifPersLayout.createSequentialGroup()
                                .addComponent(buttonRetourAjoutePers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonSauvegarder)))
                        .addContainerGap())
                    .addGroup(PanelModifPersLayout.createSequentialGroup()
                        .addComponent(ScrollPaneModifPers, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelModifPersLayout.createSequentialGroup()
                                .addComponent(labelCompAjoutePers)
                                .addGap(37, 37, 37)
                                .addComponent(comboBoxCompAjoutePers1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonAjouterPersoAjouterComp)
                                .addGap(0, 193, Short.MAX_VALUE))
                            .addComponent(LabelControleSaisiModifPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelModifPersLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonAjouterAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelModifPersLayout.createSequentialGroup()
                                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNomAjoutePers)
                                            .addComponent(labelPrenAjoutePers))
                                        .addGap(70, 70, 70)
                                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldNomAjoutePers, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(textFieldDateEntreAjoutePers)
                                            .addComponent(textFieldPreAjoutePers)))
                                    .addComponent(labelDateEntAjoutePers)
                                    .addComponent(SupprCompe))
                                .addContainerGap())))))
        );
        PanelModifPersLayout.setVerticalGroup(
            PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModifPersLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelAjoutePers)
                .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModifPersLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollPaneModifPers, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRetourAjoutePers)
                            .addComponent(ButtonSauvegarder)))
                    .addGroup(PanelModifPersLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrenAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPreAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomAjoutePers)
                            .addComponent(textFieldNomAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDateEntAjoutePers)
                            .addComponent(textFieldDateEntreAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(PanelModifPersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCompAjoutePers)
                            .addComponent(comboBoxCompAjoutePers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAjouterPersoAjouterComp))
                        .addGap(18, 18, 18)
                        .addComponent(SupprCompe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelControleSaisiModifPers, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(buttonAjouterAjoutePers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelModifPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelModifPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAjouterAjoutePersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAjouterAjoutePersMouseClicked
        // TODO add your handling code here:
        if (this.Verifier()) {
            
        }
    }//GEN-LAST:event_buttonAjouterAjoutePersMouseClicked

    private void buttonAjouterAjoutePersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjouterAjoutePersActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonAjouterAjoutePersActionPerformed

    private void buttonRetourAjoutePersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourAjoutePersMouseClicked
        // TODO add your handling code here:
        InterfaceGraphiquePersonnel Personnel = null;
        try {
            Personnel = new InterfaceGraphiquePersonnel();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        Personnel.setVisible(true);
    }//GEN-LAST:event_buttonRetourAjoutePersMouseClicked

    private void textFieldPreAjoutePersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPreAjoutePersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPreAjoutePersActionPerformed

    private void comboBoxCompAjoutePers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCompAjoutePers1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCompAjoutePers1ActionPerformed

    private void ButtonAjouterPersoAjouterCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAjouterPersoAjouterCompMouseClicked
        if (this.tabC.indexOf(getIdCompet()) == -1) {
            this.LabelControleSaisiModifPers.setText("Cette personne à déjà cette compétence");
        } else {
            this.tabC.add(getIdCompet());
            DefaultTableModel model = (DefaultTableModel) this.tableAjouterPers.getModel();
            model.addRow(new Object[]{(String)this.comboBoxCompAjoutePers1.getSelectedItem()});
        }
    }//GEN-LAST:event_ButtonAjouterPersoAjouterCompMouseClicked

    private void SupprCompeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprCompeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprCompeMouseClicked

    private void SupprCompeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprCompeActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tableAjouterPers.getModel();
        String item = (String) model.getValueAt( this.tableAjouterPers.getSelectedRow(), this.tableAjouterPers.getSelectedColumn());
        String id = "";
        int i = 0;
        while (item.charAt(i) != '-' && i < item.length()){
            id += item.charAt(i);
            i++;
        }
        this.tabC.remove(id);
        model.removeRow(this.tableAjouterPers.getSelectedRow());
    }//GEN-LAST:event_SupprCompeActionPerformed

    private void ButtonSauvegarderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSauvegarderMouseClicked
        try {
            this.entreprise.sauvegarderTout();
        } catch (IOException ex) {
            Logger.getLogger(interfaceGraphiqueAjoutePerso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSauvegarderMouseClicked

    
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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfaceGraphiqueModifierPerso().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceGraphiqueModifierPerso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjouterPersoAjouterComp;
    private javax.swing.JButton ButtonSauvegarder;
    private javax.swing.JLabel LabelControleSaisiModifPers;
    private javax.swing.JPanel PanelModifPers;
    private javax.swing.JScrollPane ScrollPaneModifPers;
    private javax.swing.JButton SupprCompe;
    private javax.swing.JButton buttonAjouterAjoutePers;
    private javax.swing.JButton buttonRetourAjoutePers;
    private javax.swing.JComboBox<String> comboBoxCompAjoutePers1;
    private javax.swing.JLabel labelAjoutePers;
    private javax.swing.JLabel labelCompAjoutePers;
    private javax.swing.JLabel labelDateEntAjoutePers;
    private javax.swing.JLabel labelNomAjoutePers;
    private javax.swing.JLabel labelPrenAjoutePers;
    private javax.swing.JTable tableAjouterPers;
    private javax.swing.JTextField textFieldDateEntreAjoutePers;
    private javax.swing.JTextField textFieldNomAjoutePers;
    private javax.swing.JTextField textFieldPreAjoutePers;
    // End of variables declaration//GEN-END:variables
}
