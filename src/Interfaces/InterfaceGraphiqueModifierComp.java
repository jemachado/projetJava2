/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Competence.Competence;
import Entreprise.Entreprise;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiqueModifierComp extends javax.swing.JFrame {
    Entreprise entreprise;
    /**
     * Creates new form InterfaceGraphiqueModifierComp
     */
    public InterfaceGraphiqueModifierComp() throws IOException {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.entreprise = new Entreprise();
        this.initTabCompetences();
        this.entreprise.initDonnees();
        this.remplissageComboBoxCompModifComp();
        
    }
    
    private void remplissageComboBoxCompModifComp() throws IOException{
        Entreprise e = new Entreprise();
        Set<String> keys = this.entreprise.getTCompetences().keySet();
        for(String key: keys){
            Competence p = this.entreprise.getTCompetences().get(key);
            this.comboBoxCompModifComp.addItem(p.toString());
        }
        this.comboBoxCompModifComp.addItem(" ");
    }

    private void initTabCompetences() {
        DefaultTableModel model = (DefaultTableModel) tableModifierComp.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int j = rowCount - 1; j >= 0; j--) {
            model.removeRow(j);
        }
        Iterator i = this.entreprise.getTCompetences().keySet().iterator();
        String clef = null;
        Competence valeur = null;
        while (i.hasNext())
        {
            clef = (String)i.next();
            valeur = this.entreprise.getTCompetences().get(clef);
            model.addRow(new Object[]{valeur.getId(), valeur.getLibelleFr()});
        }
    }
    
    private void initForm(){
        Competence c = this.entreprise.getTCompetences().get(this.entreprise.getIdModifCompet());
        this.textFieldCodeModifComp.setText(c.getId());
        this.textFieldDescrModifComp.setText(c.getLibelleFr());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelModifComp = new javax.swing.JPanel();
        labelCodeModifComp = new javax.swing.JLabel();
        textFieldCodeModifComp = new javax.swing.JTextField();
        labelDescrModifComp = new javax.swing.JLabel();
        textFieldDescrModifComp = new javax.swing.JTextField();
        buttonModifModifComp = new javax.swing.JButton();
        buttonRetourModifComp = new javax.swing.JButton();
        labelModifComp = new javax.swing.JLabel();
        labelCompModifComp = new javax.swing.JLabel();
        comboBoxCompModifComp = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ButtonModifCompSupprimer = new javax.swing.JButton();
        LabelListeModifComp = new javax.swing.JLabel();
        ScrollPaneModifComp = new javax.swing.JScrollPane();
        tableModifierComp = new javax.swing.JTable();
        buttonSauvegarderModifComp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelModifComp.setBackground(new java.awt.Color(225, 225, 213));

        labelCodeModifComp.setText("Code :");

        labelDescrModifComp.setText("Description :");

        textFieldDescrModifComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldDescrModifCompActionPerformed(evt);
            }
        });

        buttonModifModifComp.setText("Modifier");
        buttonModifModifComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModifModifCompMouseClicked(evt);
            }
        });

        buttonRetourModifComp.setText("Retour");
        buttonRetourModifComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRetourModifCompMouseClicked(evt);
            }
        });

        labelModifComp.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelModifComp.setText("Modifier Compétences");

        labelCompModifComp.setText("Compétences :");

        comboBoxCompModifComp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCompModifCompItemStateChanged(evt);
            }
        });

        ButtonModifCompSupprimer.setText("Supprimer");
        ButtonModifCompSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModifCompSupprimerActionPerformed(evt);
            }
        });

        LabelListeModifComp.setText("Liste:");

        tableModifierComp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Identifiant", "Libellé"
            }
        ));
        ScrollPaneModifComp.setViewportView(tableModifierComp);

        buttonSauvegarderModifComp.setText("Sauvegarder");

        javax.swing.GroupLayout PanelModifCompLayout = new javax.swing.GroupLayout(PanelModifComp);
        PanelModifComp.setLayout(PanelModifCompLayout);
        PanelModifCompLayout.setHorizontalGroup(
            PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModifCompLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelListeModifComp)
                    .addComponent(ScrollPaneModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModifCompLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelModifCompLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonModifModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(279, 279, 279))
                            .addGroup(PanelModifCompLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelModifCompLayout.createSequentialGroup()
                                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCompModifComp)
                                            .addComponent(labelCodeModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxCompModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(44, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModifCompLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(PanelModifCompLayout.createSequentialGroup()
                                                .addComponent(textFieldCodeModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65))
                                            .addComponent(textFieldDescrModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ButtonModifCompSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(100, 100, 100))))))
                    .addGroup(PanelModifCompLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(labelDescrModifComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelModifCompLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(buttonSauvegarderModifComp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRetourModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModifCompLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(529, 529, 529))
        );
        PanelModifCompLayout.setVerticalGroup(
            PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModifCompLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelModifComp)
                .addGap(59, 59, 59)
                .addComponent(LabelListeModifComp)
                .addGap(18, 18, 18)
                .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModifCompLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelCompModifComp)
                        .addGap(26, 26, 26)
                        .addComponent(comboBoxCompModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodeModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCodeModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDescrModifComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldDescrModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonModifModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonModifCompSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(270, 270, 270))
                    .addGroup(PanelModifCompLayout.createSequentialGroup()
                        .addComponent(ScrollPaneModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModifCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSauvegarderModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRetourModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelModifComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 741, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRetourModifCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourModifCompMouseClicked
        // TODO add your handling code here:
        InterfaceGraphiqueCompetences  Competences = null;
        try {
            Competences = new InterfaceGraphiqueCompetences();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        Competences.setVisible(true);
    }//GEN-LAST:event_buttonRetourModifCompMouseClicked

    private void textFieldDescrModifCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDescrModifCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDescrModifCompActionPerformed

    private void comboBoxCompModifCompItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCompModifCompItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCompModifCompItemStateChanged

    private void buttonModifModifCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModifModifCompMouseClicked
        // TODO add your handling code here:
        boolean remplie = this.Verifier();
        String lignes = new String();
        if(remplie == true){
            //tableAjouterPers.add(lignes);
            jLabel1.setText("Bien remplie");
        }
        else
            jLabel1.setText("Vous n'avez pas tous remplie");
    }//GEN-LAST:event_buttonModifModifCompMouseClicked

    private void ButtonModifCompSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModifCompSupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonModifCompSupprimerActionPerformed

    public boolean Verifier() 
        {
            boolean verifier = true;
            if((textFieldCodeModifComp.getText().equals(""))||(textFieldDescrModifComp.getText().equals(""))){
                verifier = false;        
            }
            return verifier;
        }
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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfaceGraphiqueModifierComp().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceGraphiqueModifierComp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonModifCompSupprimer;
    private javax.swing.JLabel LabelListeModifComp;
    private javax.swing.JPanel PanelModifComp;
    private javax.swing.JScrollPane ScrollPaneModifComp;
    private javax.swing.JButton buttonModifModifComp;
    private javax.swing.JButton buttonRetourModifComp;
    private javax.swing.JButton buttonSauvegarderModifComp;
    private javax.swing.JComboBox<String> comboBoxCompModifComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCodeModifComp;
    private javax.swing.JLabel labelCompModifComp;
    private javax.swing.JLabel labelDescrModifComp;
    private javax.swing.JLabel labelModifComp;
    private javax.swing.JTable tableModifierComp;
    private javax.swing.JTextField textFieldCodeModifComp;
    private javax.swing.JTextField textFieldDescrModifComp;
    // End of variables declaration//GEN-END:variables
}
