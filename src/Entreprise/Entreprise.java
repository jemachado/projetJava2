/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entreprise;

import Competence.Competence;
import Mission.Mission;
import Mission.MissionEnCours;
import Mission.MissionPlanifiee;
import Mission.MissionPreparation;
import Mission.MissionTerminee;
import Personnel.Personnel;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Jérémy
 */
public class Entreprise {
    
    private static TreeMap<Integer,Personnel> tPersonnels;
    private static TreeMap<String,Competence> tCompetences;
    private static TreeMap<Integer,MissionPreparation> tMissionsPreparation;
    private static TreeMap<Integer,MissionPlanifiee> tMissionsPlanifiee;
    private static TreeMap<Integer,MissionEnCours> tMissionsEnCours;
    private static TreeMap<Integer,MissionTerminee> tMissionsTerminee;
    private static Integer idPersonnel;
    private static Integer idMission;
    private static String idModifPerso;
    private static String idModifCompet;
    private static String idModifMission;

    
    public Entreprise() { }
    
    public void initDonnees() throws NumberFormatException, IOException{
        tMissionsPreparation = new TreeMap<Integer,MissionPreparation>();
        tMissionsPlanifiee = new TreeMap<Integer,MissionPlanifiee>();
        tMissionsEnCours = new TreeMap<Integer,MissionEnCours>();
        tMissionsTerminee = new TreeMap<Integer,MissionTerminee>();
        this.recupererMission();
        this.tPersonnels = this.recupererPersonnel();
        this.tCompetences = this.recupererCompetence();
        this.recupererAffectation();
        this.majEtatPersonnel();
    }
    
    /**
     * Récupère tout le personnel présent dans le csv et lui associe toutes ces comptétences
     * 
     * @return tabP HashMap<String,Personnel>
     * @throws NumberFormatException
     * @throws IOException
     */
    private TreeMap<Integer,Personnel>  recupererPersonnel() throws NumberFormatException, IOException{
            TreeMap<Integer,Personnel> tabP = new TreeMap<Integer,Personnel>();
            try {
                //Recupérer tout le personnel dans le fichier csv liste_personnel.csv
                CSVReader readerPersonnels = new CSVReader(new FileReader("liste_personnel.csv"), ';');

                String [] nextLine;
                int i = 0;
                while ((nextLine = readerPersonnels.readNext()) != null) {
                   // nextLine[] is an array of values from the line
                   if(i!=0){
                            tabP.put(Integer.valueOf(nextLine[3]), new Personnel(Integer.parseInt(nextLine[3]),nextLine[2],nextLine[1],nextLine[0]));
                   }
                   i++;
                }

                //Recuperer toutes les compétences de chaque personne
                CSVReader readerCompetPersonnels = new CSVReader(new FileReader("competences_personnel.csv"), ';');

                String [] nextLine2;
                i = 0;
                while ((nextLine2 = readerCompetPersonnels.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    if(i!=0){
                        Personnel p = tabP.get(Integer.valueOf(nextLine2[0]));
                        for(int j = 1; j<nextLine2.length ;j++){
                            p.ajouterCompetence(nextLine2[j]);
                        }
                    }
                    i++;
                }
                
                this.idPersonnel = new Integer((int)tabP.lastKey() + 1);
                return tabP;
            } catch (FileNotFoundException e) {
                     return null;
            }
    }

    /**
     * Récupère toutes les compétences présentent dans le csv et lui associe toutes ces comptétences
     * 
     * @return
     * @throws NumberFormatException
     * @throws IOException 
     */
    private TreeMap<String,Competence>  recupererCompetence() throws NumberFormatException, IOException{
            TreeMap<String,Competence> tabC = new TreeMap<String,Competence>();
            try {
                CSVReader readerCompetences = new CSVReader(new FileReader("liste_competences.csv"), ';');
                 String [] nextLine;
                 int i = 0;
                 while ((nextLine = readerCompetences.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    if(i!=0 & nextLine[1]!=""){
                            tabC.put(nextLine[0],new Competence(nextLine[0],nextLine[1],nextLine[2]));
                    }
                    i++;
                }
             return tabC;
            } catch (Exception e) {
                     System.out.println(e.toString());
                     return null;
            }
    }
    
    /**
     * Récupère toutes les missions présentent dans le csv et lui associe toutes ces comptétences
     * 
     * @return
     * @throws NumberFormatException
     * @throws IOException 
     */
    private TreeMap<Integer,Mission>  recupererMission() throws NumberFormatException, IOException{
            TreeMap<Integer,Mission> tabM = new TreeMap<Integer,Mission>();
            try {
                CSVReader reader = new CSVReader(new FileReader("liste_mission.csv"), ';');
                 String [] nextLine;
                 int i = 0;
                 while ((nextLine = reader.readNext()) != null) {
                     
                    // nextLine[] is an array of values from the line
                    if(i!=0){
                        this.idMission = (new Integer(nextLine[1]))+1;
                        if (nextLine[0].equals("MissionPreparation")) {
                            TreeMap<String, Integer> competNbPersonne = new TreeMap<String, Integer>();
                            if(nextLine.length>5){
                                for (int j = 5; j < nextLine.length ; j = j+2) {
                                    int f = j+1;
                                    competNbPersonne.put(nextLine[j],new Integer(nextLine[f]));
                                }
                            }
                            if (dateFr(nextLine[2]).compareTo(new Date()) > 0) {
                                tMissionsPreparation.put(Integer.parseInt(nextLine[1]), new MissionPreparation(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            }
                            
                            
                        } else if (nextLine[0].equals("MissionPlanifiee")) {
                            TreeMap<String, Integer> competNbPersonne = new TreeMap<String, Integer>();
                            if(nextLine.length>5){
                                for (int j = 5; j < nextLine.length ; j = j+2) {
                                    int f = j+1;
                                    competNbPersonne.put(nextLine[j],new Integer(nextLine[f]));
                                }
                            }
                            if ((dateFr(nextLine[2]).compareTo(new Date()) < 0) && (dateFr(nextLine[3]).compareTo(new Date()) > 0)) {
                                tMissionsEnCours.put(Integer.parseInt(nextLine[1]), new MissionEnCours(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            } else if (dateFr(nextLine[3]).compareTo(new Date()) < 0){
                                tMissionsTerminee.put(Integer.parseInt(nextLine[1]), new MissionTerminee(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            } else {
                                tMissionsPlanifiee.put(Integer.parseInt(nextLine[1]), new MissionPlanifiee(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            }
                            
                        } else if (nextLine[0].equals("MissionEnCours")) {
                            TreeMap<String, Integer> competNbPersonne = new TreeMap<String, Integer>();
                            if(nextLine.length>5){
                                for (int j = 5; j < nextLine.length ; j = j+2) {
                                    int f = j+1;
                                    competNbPersonne.put(nextLine[j],new Integer(nextLine[f]));
                                }
                            }
                            if (dateFr(nextLine[3]).compareTo(new Date()) < 0) {
                                tMissionsTerminee.put(Integer.parseInt(nextLine[1]), new MissionTerminee(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            } else {
                                tMissionsEnCours.put(Integer.parseInt(nextLine[1]), new MissionEnCours(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                            }
                            
                        } else if (nextLine[0].equals("MissionTerminee")) {
                            TreeMap<String, Integer> competNbPersonne = new TreeMap<String, Integer>();
                            if(nextLine.length>5){
                                for (int j = 5; j < nextLine.length ; j = j+2) {
                                    int f = j+1;
                                    competNbPersonne.put(nextLine[j],new Integer(nextLine[f]));
                                }
                            }
                            tMissionsTerminee.put(Integer.parseInt(nextLine[1]), new MissionTerminee(competNbPersonne,
                                                                        Integer.parseInt(nextLine[4]),
                                                                        dateFr(nextLine[2]),
                                                                        dateFr(nextLine[3]),
                                                                        Integer.parseInt(nextLine[1])
                                                                        ));
                        }
                    }
                    i++;
                 }
                 
                return tabM;
            } catch (Exception e) {
                     System.out.println(e.toString());
                     return null;
            }
    }
    
    private void recupererAffectation(){
            try {
                CSVReader readerAffectation = new CSVReader(new FileReader("mission_personnel.csv"), ';');
                String [] nextLine;
                int i = 0;
                while ((nextLine = readerAffectation.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    if(i!=0){
                        for(int j = 1; j<nextLine.length ;j++){
                            
                            Integer id = new Integer(nextLine[0]);
                            Integer idPerso = new Integer(nextLine[j]);
                            if (this.tMissionsPreparation.get(id) != null) {
                                this.tMissionsPreparation.get(id).addPerso(nextLine[j]);
                            } else if(this.tMissionsPlanifiee.get(id) != null) {
                                this.tMissionsPlanifiee.get(id).addPerso(nextLine[j]);
                                this.tPersonnels.get(idPerso).setDispo(false);
                            } else if(this.tMissionsEnCours.get(id) != null) {
                                this.tMissionsEnCours.get(id).addPerso(nextLine[j]);
                            } else if(this.tMissionsTerminee.get(id) != null) {
                                this.tMissionsTerminee.get(id).addPerso(nextLine[j]);
                                
                            }
                        }
                    }
                    i++;
                }
            } catch (Exception e) {
                     System.out.println(e.toString());
            }
    }
    
    private void majEtatPersonnel(){
        Set<Integer> keys = tMissionsEnCours.keySet();
        for(Integer key: keys){
            MissionEnCours m = tMissionsEnCours.get(key);
            ArrayList<String> tabPerso = m.getTabPerso();
            for (int i = 0 ; i < tabPerso.size() ; i++) {
                System.out.println(tabPerso.get(i));
                this.tPersonnels.get(new Integer(tabPerso.get(i))).setDispo(false);
            }
        }
    }
    
    //TODO
    private Mission miseAJourStatusMission(Mission m){
        return null;
    }
    
    // Toutes les fonctions d'écriture dans les csv
    
    /**
     * Réécris tous les fichier csv
     * 
     * @throws IOException 
     */
    public void sauvegarderTout() throws IOException {
        this.sauvegarderCompetence();
        this.sauvegarderPersonnel();
    }
    
    /**
     * Réécris tout le personnel dans le fichier csv
     * 
     * @throws IOException 
     */
    private void sauvegarderPersonnel() throws IOException{
        CSVWriter writer = new CSVWriter(new FileWriter("liste_personnel.csv"), ';' , CSVWriter.NO_QUOTE_CHARACTER);
        String  [] entries = "Prenom;Nom;date entrée entreprise;identifiant;".split(";");
        
        CSVWriter writer2 = new CSVWriter(new FileWriter("competences_personnel.csv"), ';' , CSVWriter.NO_QUOTE_CHARACTER);
        String  [] entries2 = "Employe;Liste Competences;".split(";");
        
        writer.writeNext(entries);
        writer2.writeNext(entries2);
        
        
        Set<Integer> keys = this.tPersonnels.keySet();
        for(Integer key: keys){
            Personnel p = this.tPersonnels.get(key);
            entries = p.toStringCsv().split(";");
            writer.writeNext(entries);
            
            ArrayList<String> tabC = p.getTabC();
            
            String competenceP = p.getId()+";";
            for (String c : tabC) {
                competenceP += c+";";
            }
            entries2 = competenceP.split(";");
            writer2.writeNext(entries2);
        }
	writer.close ();
        writer2.close();
    }
    
    /**
     * Réécris toutes les compétences dans le fichier csv
     * 
     * @throws IOException 
     */
    private void sauvegarderCompetence() throws IOException{
        CSVWriter writer = new CSVWriter(new FileWriter("test.csv"), ';' , CSVWriter.NO_QUOTE_CHARACTER);
        String  [] entries;
        Iterator i = this.tCompetences.keySet().iterator();
        String clef = null;
        Competence valeur = null;
        while (i.hasNext())
        {
            clef = (String)i.next();
            valeur = this.tCompetences.get(clef);
            entries = valeur.toStringCsv().split(";");
            writer.writeNext(entries);
        }
	writer.close ();
    }
    
    
    /*private void sauvegarderMission() throws IOException{
        CSVWriter writer = new CSVWriter(new FileWriter("test.csv"), ';' , CSVWriter.NO_QUOTE_CHARACTER);
        String  [] entries;
        Iterator i = this.tCompetences.keySet().iterator();
        String clef = null;
        Competence valeur = null;
        while (i.hasNext())
        {
            clef = (String)i.next();
            valeur = this.tCompetences.get(clef);
            entries = valeur.toStringCsv().split(";");
            writer.writeNext(entries);
        }
	writer.close ();
    }*/
    
    //CRUD Personnel
    
    /**
     * rechercher une personne selon les critères rentrées en paramètre
     * @param dateEntree
     * @param nom
     * @param prenom
     * @param competences
     * @return 
     */
    public TreeMap<Integer,Personnel> rechercherPersonnels(Date dateEntree, String nom, String prenom, ArrayList<String> competences){
        TreeMap<Integer,Personnel> tPers = new TreeMap<Integer,Personnel>();
        Set<Integer> keys = this.tPersonnels.keySet();
        Personnel pFiltre = new Personnel(dateEntree, nom, prenom, competences);
        for(Integer key: keys){
            Personnel p = this.tPersonnels.get(key);
            if ( p.compareTo(pFiltre)) {
                tPers.put(p.getId(), p);
            }
        }
        return tPers;
    }
    
    /**
     * Ajouter une personne selon les variables rentrées en paramètre
     * @param dateEntree
     * @param nom
     * @param prenom
     * @param tabC 
     */
    public void ajoutPersonnel(String dateEntree, String nom, String prenom, ArrayList<String> tabC){
        Personnel p = new Personnel(this.idPersonnel,dateEntree, nom, prenom);
        for (int i = 0 ; i < tabC.size() ; i++) {
            p.ajouterCompetence(tabC.get(i));
        }
        this.tPersonnels.put(idPersonnel, p);
        this.idPersonnel++;
    }
    
    /**
     * Modifier une personne selon les variables rentrées en paramètre
     * @param dateEntree
     * @param nom
     * @param prenom
     * @param tabC
     * @return 
     */
    public boolean modifierPersonnel(String dateEntree, String nom, String prenom, ArrayList<String> tabC){
        if (dateEntree == null || dateEntree.equals("") || nom == null || nom.equals("") || prenom == null || prenom.equals("") ) {
            return false;
        }
        Personnel p = new Personnel(this.idPersonnel,dateEntree, nom, prenom);
        for (int i = 0 ; i < tabC.size() ; i++) {
            p.ajouterCompetence(tabC.get(i));
        }
        this.tPersonnels.put(idPersonnel, p);
        return true;
    }
    
    public void suppPersonnel(Integer id){
        this.tPersonnels.remove(id);
    }
    
    // CUD Compétence
    
    /**
     * Ajouter une compétence
     * @param id
     * @param libelleEn
     * @param libelleFr
     * @return 
     */
    public boolean ajoutCompétence(String id, String libelleEn, String libelleFr){
        if(id == null || id.equals("") || libelleEn.equals("") || libelleEn == null || libelleFr == null || libelleFr.equals("") ){
            return false;
        }
        if ( this.tCompetences.get(id) == null ) {
            System.out.println("ca passe");
            Competence c = new Competence(id,libelleEn, libelleFr);
            this.tCompetences.put(id, c);
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * Modifier une compétence
     * 
     * @param id
     * @param libelleEn
     * @param libelleFr
     * @return 
     */
    public boolean modifCompétence(String id, String libelleEn, String libelleFr){
        if(id == null || id.equals("") || libelleEn.equals("") || libelleEn == null || libelleFr == null || libelleFr.equals("") ){
            return false;
        }
        if ( this.tCompetences.get(id) != null ) {
            Competence c = new Competence(id,libelleEn, libelleFr);
            this.tCompetences.put(id, c);
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * Supprimer une compétence
     * 
     * @param id
     * @return 
     */
    public boolean supCompétence(String id){
        if(id == null || id.equals("")){
            return false;
        }
        if ( this.tCompetences.get(id) != null ) {
            this.tCompetences.remove(id);
            return true;
        } else {
            return false;
        }
        
    }
    
    //CRUD Missions
    
    //TODO
    public boolean ajoutMissionPreparation(TreeMap<String, Integer> competNbPersonne,
                                           int totalPersonne,
                                           String dateDebut,
                                           String dateFin){
        this.idMission++;
        this.tMissionsPreparation.put(idMission, new MissionPreparation(competNbPersonne,
                                                                    totalPersonne,
                                                                    this.dateFr(dateDebut),
                                                                    this.dateFr(dateFin),
                                                                    idMission));
        return false;
    }
    
    // TODO
    public boolean modifMission(){
        return false;
    }
    
    // TODO
    public boolean SuppMission(){
        return false;
    }
    
    // TODO
    public boolean rechercherMission(String status, int totalPersonne, Date dateDebut){
        return false;
    }
    
    
    
    public Date dateFr(String dateFr){
        int jour = Integer.parseInt(""+dateFr.charAt(0)+dateFr.charAt(1));
        int mois = Integer.parseInt(""+dateFr.charAt(3)+dateFr.charAt(4));
        int année = Integer.parseInt(""+dateFr.charAt(6)+dateFr.charAt(7)+dateFr.charAt(8)+dateFr.charAt(9));
        return new Date(année-1900,mois,jour,0,0);
    }
    
    public String toStringDateFr(Date date){
        String jour;
        String mois;
                
        if (date.getDay() < 10) {
            jour = "0"+date.getDay();
        } else {
            jour = ""+date.getDay();
        }
        
        if (date.getMonth() < 10) {
            mois = "0"+date.getMonth();
        } else {
            mois = ""+date.getMonth();
        }
        return jour+"/"+mois+"/"+date.getYear();
    }
    
    /**
     * return tous le personnel
     * @return 
     */
    public TreeMap<Integer,Personnel> getTPersonnels(){
        return this.tPersonnels;
    }
    
    /**
     * 
     * @return 
     */
    public TreeMap<String,Competence> getTCompetences(){
        return this.tCompetences;
    }
    
    public TreeMap<Integer,MissionPlanifiee> getTMissionsPlanifiee(){
        return this.tMissionsPlanifiee;
    }
    
    public TreeMap<Integer,MissionPreparation> getTMissionsPreparation(){
        return this.tMissionsPreparation;
    }
    
    public TreeMap<Integer,MissionEnCours> getTMissionsEnCours(){
        return this.tMissionsEnCours;
    }
    
    public TreeMap<Integer,MissionTerminee> getTMissionsTerminee(){
        return this.tMissionsTerminee;
    }
    
    public TreeMap<Integer,Mission> getTMissions(){
        TreeMap<Integer,Mission> tabMission = new TreeMap<Integer,Mission>();
        Set<Integer> keys = tMissionsPreparation.keySet();
        for(Integer key: keys){
            Mission m = tMissionsPreparation.get(key);
            tabMission.put(m.getId(),m);
        }
        keys = tMissionsPlanifiee.keySet();
        for(Integer key: keys){
            Mission m = tMissionsPlanifiee.get(key);
            tabMission.put(m.getId(),m);
        }
        keys = tMissionsEnCours.keySet();
        for(Integer key: keys){
            Mission m = tMissionsEnCours.get(key);
            tabMission.put(m.getId(),m);
        }
        keys = tMissionsTerminee.keySet();
        for(Integer key: keys){
            Mission m = tMissionsTerminee.get(key);
            tabMission.put(m.getId(),m);
        }
        return tabMission;
    }
    
    public String getIdModifPerso(){
        return this.idModifPerso;
    }
    
    public void setIdModifPerso(String idModifPerso){
        this.idModifPerso = idModifPerso;
    }
    
    public String getIdModifCompet(){
        return this.idModifCompet;
    }
    
    public void setIdModifCompet(String idModifCompet){
        this.idModifCompet = idModifCompet;
    }
    
    public void setIdModifMission(String idModifMission){
        this.idModifMission = idModifMission;
    }
    
    public Mission getIdModifMission(){
        System.out.println(this.idModifMission);
        if (this.tMissionsPlanifiee.get(new Integer(this.idModifMission)) != null) {
            return this.tMissionsPlanifiee.get(new Integer(this.idModifMission));
        } else {
            return this.tMissionsPreparation.get(new Integer(this.idModifMission));
        }
    }
    
    public TreeMap<Integer,Personnel> getTabPersoDispo(Mission m){
        TreeMap<Integer,Personnel> tabPerso = this.getTPersonnels();
        Set<Integer> keys = tMissionsPreparation.keySet();
        for(Integer key: keys){
            System.out.println(tMissionsPreparation.get(key).dispo(m.getDateDebut(), m.getDateFin()));
            if(!tMissionsPreparation.get(key).dispo(m.getDateDebut(), m.getDateFin())){
                ArrayList<String> tabPer = tMissionsPreparation.get(key).getTabPerso();
                for (int i = 0 ; i < tabPer.size() ; i++) {
                    tabPerso.remove(Integer.parseInt(tabPer.get(i)));
                }
            }
        }
        keys = tMissionsPlanifiee.keySet();
        for(Integer key: keys){
            if(!tMissionsPlanifiee.get(key).dispo(m.getDateDebut(), m.getDateFin())){
                ArrayList<String> tabPer = tMissionsPlanifiee.get(key).getTabPerso();
                for (int i = 0 ; i < tabPer.size() ; i++) {
                    tabPerso.remove(Integer.parseInt(tabPer.get(i)));
                }
            }
        }
        keys = this.tMissionsEnCours.keySet();
        for(Integer key: keys){
            if(!tMissionsEnCours.get(key).dispo(m.getDateDebut(), m.getDateFin())){
                ArrayList<String> tabPer = tMissionsEnCours.get(key).getTabPerso();
                for (int i = 0 ; i < tabPer.size() ; i++) {
                    tabPerso.remove(Integer.parseInt(tabPer.get(i)));
                }
            }
        }
        return tabPerso;
    }
}