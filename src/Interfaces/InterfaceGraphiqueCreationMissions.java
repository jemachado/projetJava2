/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Competence.Competence;
import Entreprise.Entreprise;
import java.io.IOException;
import java.util.ArrayList;
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
public class InterfaceGraphiqueCreationMissions extends javax.swing.JFrame {
    Entreprise entreprise;
    TreeMap<String, Integer> tabC;
    int cptCompetence;
    /**
     * Creates new form InterfaceGraphiqueCreationMissions
     */
    public InterfaceGraphiqueCreationMissions() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.tabC = new TreeMap<String, Integer>();
        this.cptCompetence = 0;
        initComponents();
        this.entreprise = new Entreprise();
        this.remplissageComboBoxCompCreationMission();
    }
    
    private void remplissageComboBoxCompCreationMission() throws IOException{
        this.comboBoxCompetence.addItem(" ");
        Entreprise e = new Entreprise();
        Set<String> keys = entreprise.getTCompetences().keySet();
        for(String key: keys){
            Competence p = entreprise.getTCompetences().get(key);
            this.comboBoxCompetence.addItem(p.toString());
        }
    }
    
    private String getIdCompet(){
        String item = (String)this.comboBoxCompetence.getSelectedItem();
        String id = "";
        int i = 0;
        while (item.charAt(i) != '-' && i < item.length()){
            id += item.charAt(i);
            i++;
        }
        return id;
    }
    
    private boolean verifier(){
        if((textFieldDateDebut.getText().equals(""))||
           (textFieldDateDebut.getText().equals(""))){
            this.jLabelValidation.setText("Formulaire incomplet");
            return false;
        }
        else {
            if(this.textFieldDateDebut.getText().length() != 10){
                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                return false;
            }
            int mois = Integer.parseInt(""+this.textFieldDateDebut.getText().charAt(3)+this.textFieldDateDebut.getText().charAt(4));
            if(mois > 12){
                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                return false;
            }
            int jour = Integer.parseInt(""+this.textFieldDateDebut.getText().charAt(0)+this.textFieldDateDebut.getText().charAt(1));
            int annee = Integer.parseInt(""+this.textFieldDateDebut.getText().charAt(6)+this.textFieldDateDebut.getText().charAt(7)
                                           +this.textFieldDateDebut.getText().charAt(8)+this.textFieldDateDebut.getText().charAt(9));
            
            switch(mois){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(jour > 31){
                        this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                        return false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(jour > 30){
                        this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                        return false;
                    }
                    break;
                case 2:
                    if (((annee % 4 == 0) && 
                         !(annee % 100 == 0))
                         || (annee % 400 == 0)){
                            if(jour > 29){
                                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                                return false;
                            }
                        break;
                    }
                    else{
                        if(jour > 28){
                            this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                            return false;
                        }
                        }
                    break;
                default:
            }
            if(this.textFieldDateFin.getText().length() != 10){
                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                return false;
            }
            mois = Integer.parseInt(""+this.textFieldDateFin.getText().charAt(3)+this.textFieldDateFin.getText().charAt(4));
            if(mois > 12){
                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                return false;
            }
            jour = Integer.parseInt(""+this.textFieldDateFin.getText().charAt(0)+this.textFieldDateFin.getText().charAt(1));
            annee = Integer.parseInt(""+this.textFieldDateFin.getText().charAt(6)+this.textFieldDateFin.getText().charAt(7)
                                           +this.textFieldDateFin.getText().charAt(8)+this.textFieldDateFin.getText().charAt(9));
            
            switch(mois){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(jour > 31){
                        this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                        return false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(jour > 30){
                        this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                        return false;
                    }
                    break;
                case 2:
                    if (((annee % 4 == 0) && 
                         !(annee % 100 == 0))
                         || (annee % 400 == 0)){
                            if(jour > 29){
                                this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                                return false;
                            }
                        break;
                    }
                    else{
                        if(jour > 28){
                            this.jLabelValidation.setText("La date d'entrée est non valide(jj/mm/aaaa)");
                            return false;
                        }
                        }
                    break;
                default:
            }
        }
        return true;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCreationMissions = new javax.swing.JPanel();
        PanelAjoutPers2 = new javax.swing.JPanel();
        buttonAjouterAjoutePers2 = new javax.swing.JButton();
        labelDateEntAjoutePers2 = new javax.swing.JLabel();
        buttonRetourAjoutePers2 = new javax.swing.JButton();
        textFieldDateDebut = new javax.swing.JTextField();
        textFieldDateFin = new javax.swing.JTextField();
        labelCompAjoutePers2 = new javax.swing.JLabel();
        comboBoxCompetence = new javax.swing.JComboBox<>();
        labelAjoutePers2 = new javax.swing.JLabel();
        ScrollpaneAjoutPers2 = new javax.swing.JScrollPane();
        tableCompetence2 = new javax.swing.JTable();
        labelNomAjoutePers2 = new javax.swing.JLabel();
        ButtonAjouterPersoAjouterComp2 = new javax.swing.JButton();
        labelControlSaisieAjoutPers2 = new javax.swing.JLabel();
        SupprCompe2 = new javax.swing.JButton();
        ButtonSauvegarder2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelValidation = new javax.swing.JLabel();
        nbCompetence = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelAjoutPers2.setBackground(new java.awt.Color(225, 225, 213));

        buttonAjouterAjoutePers2.setText("Ajouter");
        buttonAjouterAjoutePers2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAjouterAjoutePers2MouseClicked(evt);
            }
        });

        labelDateEntAjoutePers2.setText("Date de fin :");

        buttonRetourAjoutePers2.setText("Retour");
        buttonRetourAjoutePers2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourAjoutePers2MouseClicked(evt);
            }
        });

        textFieldDateFin.setToolTipText("");

        labelCompAjoutePers2.setText("Compétences :");

        labelAjoutePers2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelAjoutePers2.setText("Création d'une mission en préparation");

        tableCompetence2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant -- Libellé de la compétence -- Besoin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollpaneAjoutPers2.setViewportView(tableCompetence2);

        labelNomAjoutePers2.setText("Date de début :");

        ButtonAjouterPersoAjouterComp2.setText("Ajouter une compétence");
        ButtonAjouterPersoAjouterComp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAjouterPersoAjouterComp2MouseClicked(evt);
            }
        });

        SupprCompe2.setText("Supprimer une compétence");
        SupprCompe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprCompe2MouseClicked(evt);
            }
        });

        ButtonSauvegarder2.setText("Sauvegarder la base de données");

        jLabel5.setText("Format : jj/mm/aaaa");

        jLabel6.setText("Format : jj/mm/aaaa");

        javax.swing.GroupLayout PanelAjoutPers2Layout = new javax.swing.GroupLayout(PanelAjoutPers2);
        PanelAjoutPers2.setLayout(PanelAjoutPers2Layout);
        PanelAjoutPers2Layout.setHorizontalGroup(
            PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addComponent(ScrollpaneAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addComponent(labelNomAjoutePers2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelControlSaisieAjoutPers2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(textFieldDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(labelDateEntAjoutePers2)
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(SupprCompe2))
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(labelCompAjoutePers2)
                                        .addGap(37, 37, 37)
                                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                                .addComponent(textFieldDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6))
                                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                                .addComponent(comboBoxCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nbCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonAjouterPersoAjouterComp2))))
                                    .addComponent(jLabelValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonAjouterAjoutePers2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 136, Short.MAX_VALUE))))
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(labelAjoutePers2))
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addComponent(buttonRetourAjoutePers2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonSauvegarder2)))
                        .addContainerGap())))
        );
        PanelAjoutPers2Layout.setVerticalGroup(
            PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelAjoutePers2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollpaneAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomAjoutePers2)
                            .addComponent(textFieldDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDateEntAjoutePers2)
                            .addComponent(textFieldDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCompAjoutePers2)
                            .addComponent(comboBoxCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAjouterPersoAjouterComp2)
                            .addComponent(nbCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(SupprCompe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAjouterAjoutePers2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelControlSaisieAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRetourAjoutePers2)
                    .addComponent(ButtonSauvegarder2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCreationMissionsLayout = new javax.swing.GroupLayout(PanelCreationMissions);
        PanelCreationMissions.setLayout(PanelCreationMissionsLayout);
        PanelCreationMissionsLayout.setHorizontalGroup(
            PanelCreationMissionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAjoutPers2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelCreationMissionsLayout.setVerticalGroup(
            PanelCreationMissionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAjoutPers2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationMissions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationMissions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRetourAjoutePers2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourAjoutePers2MouseClicked
        // TODO add your handling code here:
        InterfaceGraphiqueMissions Missions = new InterfaceGraphiqueMissions();
        this.dispose();
        Missions.setVisible(true);
    }//GEN-LAST:event_buttonRetourAjoutePers2MouseClicked

    private void buttonAjouterAjoutePers2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAjouterAjoutePers2MouseClicked
        if (this.verifier()) {
            this.entreprise.ajoutMissionPreparation(this.tabC, this.cptCompetence, this.textFieldDateDebut.getText(), this.textFieldDateFin.getText());
            InterfaceGraphiqueMissions Missions = new InterfaceGraphiqueMissions();
            this.dispose();
            Missions.setVisible(true);
        } else {
            
        }
    }//GEN-LAST:event_buttonAjouterAjoutePers2MouseClicked

    private void ButtonAjouterPersoAjouterComp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAjouterPersoAjouterComp2MouseClicked
        int value = (Integer) this.nbCompetence.getValue();
        
        if (value <= 0) {
            this.jLabelValidation.setText("La valeur du nombre de compétence doit être supérieur à zéro");
        } else {
            this.cptCompetence += value;
            this.tabC.put(getIdCompet(),value);
            DefaultTableModel model = (DefaultTableModel) this.tableCompetence2.getModel();
            model.addRow(new Object[]{(String)this.comboBoxCompetence.getSelectedItem()+" --"+value});
        }
    }//GEN-LAST:event_ButtonAjouterPersoAjouterComp2MouseClicked

    private void SupprCompe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprCompe2MouseClicked
        DefaultTableModel model = (DefaultTableModel) this.tableCompetence2.getModel();
        String item = (String) model.getValueAt( this.tableCompetence2.getSelectedRow(), this.tableCompetence2.getSelectedColumn());
        String id = "";
        String nbCompet = "";
        int i = 0;
        while (item.charAt(i) != '-' && i < item.length()){
            id += item.charAt(i);
            i++;
        }
        i = item.length()-1;
        while (item.charAt(i) != '-' && i > 0){
            i--;
        }
        while (i < item.length()){
            nbCompet += item.charAt(i);
            i++;
        }
        this.cptCompetence -= Integer.parseInt(nbCompet);
        this.tabC.remove(id);
        model.removeRow(this.tableCompetence2.getSelectedRow());
    }//GEN-LAST:event_SupprCompe2MouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCreationMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCreationMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCreationMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueCreationMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfaceGraphiqueCreationMissions().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceGraphiqueCreationMissions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjouterPersoAjouterComp2;
    private javax.swing.JButton ButtonSauvegarder2;
    private javax.swing.JPanel PanelAjoutPers2;
    private javax.swing.JPanel PanelCreationMissions;
    private javax.swing.JScrollPane ScrollpaneAjoutPers2;
    private javax.swing.JButton SupprCompe2;
    private javax.swing.JButton buttonAjouterAjoutePers2;
    private javax.swing.JButton buttonRetourAjoutePers2;
    private javax.swing.JComboBox<String> comboBoxCompetence;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelValidation;
    private javax.swing.JLabel labelAjoutePers2;
    private javax.swing.JLabel labelCompAjoutePers2;
    private javax.swing.JLabel labelControlSaisieAjoutPers2;
    private javax.swing.JLabel labelDateEntAjoutePers2;
    private javax.swing.JLabel labelNomAjoutePers2;
    private javax.swing.JSpinner nbCompetence;
    private javax.swing.JTable tableCompetence2;
    private javax.swing.JTextField textFieldDateDebut;
    private javax.swing.JTextField textFieldDateFin;
    // End of variables declaration//GEN-END:variables
}
