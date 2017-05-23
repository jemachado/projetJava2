/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Competence.Competence;
import Entreprise.Entreprise;
import Mission.MissionPlanifiee;
import Mission.MissionPreparation;
import Personnel.Personnel;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clementraphaell
 */
public class InterfaceGraphiqueModifierMissions extends javax.swing.JFrame {
    Entreprise entreprise;
    TreeMap<String, Integer> tabC;
    TreeMap<Integer, String> tabPerso;
    
    int cptCompetence;
    /**
     * Creates new form InterfaceGraphiqueModifierMissions
     */
    public InterfaceGraphiqueModifierMissions() {
        initComponents();
        this.tabC = new TreeMap<String, Integer>();
        this.tabPerso = new TreeMap<Integer, String>();
        this.entreprise = new Entreprise();
        this.cptCompetence = 0;
        this.initComboBoxCompetence();
        this.initTableCompet();
        this.initComboBoxCompetence2();
        this.actualiserPerso.setEnabled(true);
        this.initTablePerso();
        this.initDate();
        if (this.entreprise.getIdModifMission().getType().equals("MissionPlanifiee")) {
            this.textFieldDateDebut.setEnabled(false);
            this.textFieldDateFin.setEnabled(false);
            this.ButtonAjouterPersoAjouterComp2.setEnabled(false);
            this.SupprCompe2.setEnabled(false);
            this.comboBoxCompetence.setEnabled(false);
            this.nbCompetence.setEnabled(false);
        }
        if (this.entreprise.getIdModifMission().getType().equals("MissionPreparation")) {
            this.changeMissionPlan.setEnabled(true);
        }
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
    
    private void initComboBoxPerso(){
        while ( this.comboBoxPersonnel.getItemCount() !=0 ) {
            this.comboBoxPersonnel.removeItemAt(this.comboBoxPersonnel.getItemCount()-1);
        }
        this.comboBoxPersonnel.addItem(" ");
        if (!this.comboBoxCompetence2.getSelectedItem().equals(" ")) {
            String item = (String)this.comboBoxCompetence2.getSelectedItem();
            String id = "";
            int i = 0;
            while (item.charAt(i) != '-' && i < item.length()){
                id += item.charAt(i);
                i++;
            }
            Competence c = this.entreprise.getTCompetences().get(id);
            TreeMap<Integer,Personnel> tPers = entreprise.getTabPersoDispo(entreprise.getIdModifMission(),c);
            Set<Integer> keys = tPers.keySet();
            for(Integer key: keys){
                Personnel p = tPers.get(key);
                this.comboBoxPersonnel.addItem(p.getId()+" - "+p.getNom()+" "+p.getPrenom());
            }
        }
    }
    
    private void initComboBoxCompetence2() {
        while ( this.comboBoxCompetence2.getItemCount() !=0 ) {
            this.comboBoxCompetence2.removeItemAt(this.comboBoxCompetence2.getItemCount()-1);
        }
        Set<String> keys = tabC.keySet();
        this.comboBoxCompetence2.addItem(" ");
        for(String key: keys){
            this.comboBoxCompetence2.addItem(this.entreprise.getTCompetences().get(key).toString());
        }
        this.initComboBoxPerso();
    }
    
    private void initTableCompet(){
        TreeMap<String, Integer> tabCompet = this.entreprise.getIdModifMission().getComptNbPersonne();
        DefaultTableModel model = (DefaultTableModel) this.tableCompetence2.getModel();
        Set<String> keys = tabCompet.keySet();
        for(String key: keys){
            if (this.tabC.get(key) == null) {
                this.tabC.put(key,tabCompet.get(key));
            }
            Competence c = this.entreprise.getTCompetences().get(key);
            model.addRow(new Object[]{c.toString()+" --"+tabCompet.get(key)});
        }
    }
    
    private void initComboBoxCompetence(){
        while ( this.comboBoxCompetence.getItemCount() !=0 ) {
            this.comboBoxCompetence.removeItemAt(this.comboBoxCompetence.getItemCount()-1);
        }
        Set<String> keys = entreprise.getTCompetences().keySet();
        this.comboBoxCompetence.addItem("");
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
    
    private void initTablePerso(){
        System.out.println(this.entreprise.getIdModifMission().getTabPerso());
        this.tabPerso = this.entreprise.getIdModifMission().getTabPerso();
        DefaultTableModel model = (DefaultTableModel) this.tablePerso.getModel();
        Set<Integer> keys = this.tabPerso.keySet();
        for(Integer key: keys){
            model.addRow(new Object[]{this.tabPerso.get(key).toString(),this.entreprise.getTPersonnels().get(key).toStringCsv()});
        }
        initAjoutPerso();
    }
    
    private void initAjoutPerso(){
        if (this.tabPerso.size()<this.cptCompetence) {
            this.ButtonAjouterPersoAjouterComp3.setEnabled(true);
        } else {
            this.ButtonAjouterPersoAjouterComp3.setEnabled(false);
        }
    }
    
    private void initDate(){
        this.textFieldDateDebut.setText(this.entreprise.getIdModifMission().getDateDebutFr());
        this.textFieldDateFin.setText(this.entreprise.getIdModifMission().getDateFinFr());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAjoutPers2 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePerso = new javax.swing.JTable();
        labelCompAjoutePers3 = new javax.swing.JLabel();
        comboBoxCompetence2 = new javax.swing.JComboBox<>();
        comboBoxPersonnel = new javax.swing.JComboBox<>();
        ButtonAjouterPersoAjouterComp3 = new javax.swing.JButton();
        SupprCompe3 = new javax.swing.JButton();
        actualiserPerso = new javax.swing.JButton();
        changeMissionPlan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelAjoutPers2.setBackground(new java.awt.Color(225, 225, 213));

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
        labelAjoutePers2.setText("Modification et affection d'une mission");

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
        tableCompetence2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        tablePerso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compétence", "Personnel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePerso.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablePerso);

        labelCompAjoutePers3.setText("Compétence / Personnel :");

        comboBoxCompetence2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxCompetence2MouseClicked(evt);
            }
        });
        comboBoxCompetence2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCompetence2ActionPerformed(evt);
            }
        });

        ButtonAjouterPersoAjouterComp3.setText("Affecter");
        ButtonAjouterPersoAjouterComp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAjouterPersoAjouterComp3MouseClicked(evt);
            }
        });

        SupprCompe3.setText("Supprimer l'affectation");
        SupprCompe3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprCompe3MouseClicked(evt);
            }
        });

        actualiserPerso.setText("Actualiser cette liste");
        actualiserPerso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualiserPersoMouseClicked(evt);
            }
        });

        changeMissionPlan.setText("Passer cette mission en planifiée");
        changeMissionPlan.setEnabled(false);
        changeMissionPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeMissionPlanMouseClicked(evt);
            }
        });
        changeMissionPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeMissionPlanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAjoutPers2Layout = new javax.swing.GroupLayout(PanelAjoutPers2);
        PanelAjoutPers2.setLayout(PanelAjoutPers2Layout);
        PanelAjoutPers2Layout.setHorizontalGroup(
            PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addComponent(buttonRetourAjoutePers2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSauvegarder2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addComponent(ScrollpaneAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(labelCompAjoutePers3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxCompetence2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(SupprCompe2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(comboBoxPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(ButtonAjouterPersoAjouterComp3))
                                    .addComponent(actualiserPerso)))
                            .addComponent(SupprCompe3)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomAjoutePers2)
                                    .addComponent(labelDateEntAjoutePers2)
                                    .addComponent(labelCompAjoutePers2))
                                .addGap(99, 99, 99)
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(textFieldDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(textFieldDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                        .addComponent(comboBoxCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nbCompetence, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonAjouterPersoAjouterComp2)))))
                        .addGap(156, 156, 156)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControlSaisieAjoutPers2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addComponent(jLabelValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(labelAjoutePers2))
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320)
                                .addComponent(changeMissionPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        PanelAjoutPers2Layout.setVerticalGroup(
            PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelAjoutePers2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabelValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275)
                        .addComponent(labelControlSaisieAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ScrollpaneAjoutPers2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
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
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SupprCompe2)
                                    .addComponent(actualiserPerso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCompAjoutePers3)
                                    .addComponent(comboBoxCompetence2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonAjouterPersoAjouterComp3)
                                    .addComponent(comboBoxPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SupprCompe3)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelAjoutPers2Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(changeMissionPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelAjoutPers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRetourAjoutePers2)
                            .addComponent(ButtonSauvegarder2))
                        .addGap(131, 131, 131))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelAjoutPers2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRetourAjoutePers2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRetourAjoutePers2MouseClicked
        InterfaceGraphiqueMissions Missions = new InterfaceGraphiqueMissions();
        this.dispose();
        Missions.setVisible(true);
    }//GEN-LAST:event_buttonRetourAjoutePers2MouseClicked

    private void ButtonAjouterPersoAjouterComp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAjouterPersoAjouterComp2MouseClicked
        if (this.ButtonAjouterPersoAjouterComp2.isEnabled()) {
            int value = (Integer)this.nbCompetence.getValue();
            if (value <= 0) {
                this.jLabelValidation.setText("La valeur du nombre de compétence doit être supérieur à zéro");
            } else {
                this.cptCompetence += value;
                this.tabC.put(getIdCompet(),value);
                DefaultTableModel model = (DefaultTableModel) this.tableCompetence2.getModel();
                model.addRow(new Object[]{(String)this.comboBoxCompetence.getSelectedItem()+" --"+value});
                this.initComboBoxCompetence2();
            }
        }
    }//GEN-LAST:event_ButtonAjouterPersoAjouterComp2MouseClicked

    private void SupprCompe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprCompe2MouseClicked
        if (this.SupprCompe2.isEnabled()) {
            DefaultTableModel model = (DefaultTableModel) this.tableCompetence2.getModel();
            String item = (String) model.getValueAt( this.tableCompetence2.getSelectedRow(),0);
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
            i++;
            while (i < item.length()){
                nbCompet += item.charAt(i);
                i++;
            }
            this.tabC.remove(id);
            this.cptCompetence -= Integer.parseInt(nbCompet);
            model.removeRow(this.tableCompetence2.getSelectedRow());
        }
    }//GEN-LAST:event_SupprCompe2MouseClicked

    private void ButtonAjouterPersoAjouterComp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAjouterPersoAjouterComp3MouseClicked
        if (this.ButtonAjouterPersoAjouterComp3.isEnabled()) {
            String itemComp = (String)this.comboBoxCompetence2.getSelectedItem();
            String itemPerso = (String)this.comboBoxPersonnel.getSelectedItem();
            String idPerso = "";
            String idCompet = "";
            int i = 0;
            while (itemComp.charAt(i) != '-' && i < itemComp.length()){
                idCompet += itemComp.charAt(i);
                i++;
            }
            i = 0;
            while (itemPerso.charAt(i) != ' ' && i < itemPerso.length()){
                idPerso += itemPerso.charAt(i);
                i++;
            }
            this.entreprise.getIdModifMission().addPerso(new Integer(idPerso), idCompet);
            DefaultTableModel model = (DefaultTableModel) this.tablePerso.getModel();
            model.addRow( new Object[]{idCompet,this.entreprise.getTPersonnels().get(new Integer(idPerso)).toStringCsv()});
        }
    }//GEN-LAST:event_ButtonAjouterPersoAjouterComp3MouseClicked

    private void SupprCompe3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprCompe3MouseClicked
        
    }//GEN-LAST:event_SupprCompe3MouseClicked

    private void comboBoxCompetence2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxCompetence2MouseClicked
        
    }//GEN-LAST:event_comboBoxCompetence2MouseClicked

    private void comboBoxCompetence2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCompetence2ActionPerformed
        this.actualiserPerso.setEnabled(true);
        this.comboBoxPersonnel.setEnabled(false);
    }//GEN-LAST:event_comboBoxCompetence2ActionPerformed

    private void actualiserPersoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualiserPersoMouseClicked
        this.initComboBoxPerso();
        this.comboBoxPersonnel.setEnabled(true);
        this.actualiserPerso.setEnabled(false);
    }//GEN-LAST:event_actualiserPersoMouseClicked

    private void changeMissionPlanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeMissionPlanMouseClicked
        
    }//GEN-LAST:event_changeMissionPlanMouseClicked

    private void changeMissionPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeMissionPlanActionPerformed
        if (verifier()) {
            MissionPlanifiee mp = new MissionPlanifiee(this.entreprise.getIdModifMission());
            this.entreprise.getTMissionsPlanifiee().put((Integer)mp.getId(), mp);
            this.entreprise.getTMissionsPreparation().remove(mp.getId());
            this.changeMissionPlan.setEnabled(false);
            this.textFieldDateDebut.setEnabled(false);
            this.textFieldDateFin.setEnabled(false);
            this.ButtonAjouterPersoAjouterComp2.setEnabled(false);
            this.SupprCompe2.setEnabled(false);
            this.comboBoxCompetence.setEnabled(false);
            this.nbCompetence.setEnabled(false);
        }
    }//GEN-LAST:event_changeMissionPlanActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraphiqueModifierMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGraphiqueModifierMissions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjouterPersoAjouterComp2;
    private javax.swing.JButton ButtonAjouterPersoAjouterComp3;
    private javax.swing.JButton ButtonSauvegarder2;
    private javax.swing.JPanel PanelAjoutPers2;
    private javax.swing.JScrollPane ScrollpaneAjoutPers2;
    private javax.swing.JButton SupprCompe2;
    private javax.swing.JButton SupprCompe3;
    private javax.swing.JButton actualiserPerso;
    private javax.swing.JButton buttonRetourAjoutePers2;
    private javax.swing.JButton changeMissionPlan;
    private javax.swing.JComboBox<String> comboBoxCompetence;
    private javax.swing.JComboBox<String> comboBoxCompetence2;
    private javax.swing.JComboBox<String> comboBoxPersonnel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelValidation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAjoutePers2;
    private javax.swing.JLabel labelCompAjoutePers2;
    private javax.swing.JLabel labelCompAjoutePers3;
    private javax.swing.JLabel labelControlSaisieAjoutPers2;
    private javax.swing.JLabel labelDateEntAjoutePers2;
    private javax.swing.JLabel labelNomAjoutePers2;
    private javax.swing.JSpinner nbCompetence;
    private javax.swing.JTable tableCompetence2;
    private javax.swing.JTable tablePerso;
    private javax.swing.JTextField textFieldDateDebut;
    private javax.swing.JTextField textFieldDateFin;
    // End of variables declaration//GEN-END:variables
}
