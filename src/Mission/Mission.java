package Mission;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

public abstract class Mission {
    protected int id;
    protected TreeMap<String, Integer> competNbPersonne;
    protected int totalPersonne;
    protected Date dateDebut;
    protected Date dateFin;
    protected TreeMap<Integer, String> tabPerso;
    
    /**
     * retourne le nombre de personne par competences
     * @param i String
     * @return Integer
     */
    public Integer getComptNbPersonne(String i) {
        return competNbPersonne.get(i);
    }
    
    public TreeMap<String, Integer> getComptNbPersonne() {
        return competNbPersonne;
    }
    
    /**
     * retourne le nombre total de personne 
     * @return int
     */
    public int getTotalPersonne() {
        return totalPersonne;
    }

    /**
     * retourne la date de fin de la mission
     * @return Date
     */
    public Date getDateFin() {
        return dateFin;
     }
    
    /**
     * retourne la date de debut de la mission
     * @return Date
     */
    public Date getDateDebut() {
        return dateDebut;
    }
    
    /**
     * retourne l'id de la mission
     * @return int
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * retourne le tableau personnel
     * @return TreeMap
     */
    public TreeMap<Integer, String> getTabPerso(){
        return this.tabPerso;
    }
    
    /**
     * retourne la date de debut en francais
     * @return String
     */
    public String getDateDebutFr(){
        String mois;
        if (this.dateDebut.getMonth() != 0) {
            mois = ""+this.dateDebut.getMonth();
        } else {
            mois = "12";
        }
        return this.dateDebut.getDate()+"/"+mois+"/"+(this.dateDebut.getYear()+1900);
    }
    
    /**
     * retourne la date de fin en francais
     * @return String
     */
    public String getDateFinFr(){
        String mois;
        if (this.dateFin.getMonth() != 0) {
            mois = ""+this.dateFin.getMonth();
        } else {
            mois = "12";
        }
        return this.dateFin.getDate()+"/"+mois+"/"+(this.dateFin.getYear()+1900);
    }
    
    public abstract String getType();
 
    /**
     * 
     * @param p Integer
     * @param compet String
     */
    public void addPerso(Integer p, String compet) {
        tabPerso.put(p,compet);
    }
    
    /**
     * regarde si la personne est disponible
     * @param dateDeb Date
     * @param dateFin Date
     * @return boolean
     */
    public boolean dispo(Date dateDeb, Date dateFin){
        if ((dateDeb.compareTo(this.dateDebut)>0) && (dateDeb.compareTo(this.dateFin)<0)
             || (dateFin.compareTo(this.dateDebut)>0 && (dateFin.compareTo(this.dateFin)<0))
             || (dateDeb.compareTo(this.dateDebut)<0 && (dateFin.compareTo(this.dateFin)>0))){
            return false;
        }
        return true;
    }
    
    /**
     * toString en Csv
     * @return String
     */
    public String toStringCsv(){
        String str = this.getType()+";"+this.getId()+";"+this.getDateDebutFr()+";"+this.getDateFinFr()+";"+this.getTotalPersonne();
        Set<String> keys = this.competNbPersonne.keySet();
        for (String key: keys) {
            str += ";"+key+";"+this.competNbPersonne.get(key);
        }
        return str;
    }
    
    /**
     * toString en Csv pour le tableau personnel
     * @return String
     */
    public String toStringCsvTabPerso(){
        String str = ""+this.getId();
        Set<Integer> keys = this.tabPerso.keySet();
        for (Integer key: keys) {
            str += ";"+this.tabPerso.get(key)+";"+key;
        }
        return str;
    }
}
