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
    
    public Integer getComptNbPersonne(String i) {
        return competNbPersonne.get(i);
    }

    public TreeMap<String, Integer> getComptNbPersonne() {
        return competNbPersonne;
    }
    
    public int getTotalPersonne() {
        return totalPersonne;
    }

    public Date getDateFin() {
        return dateFin;
     }
    
    public Date getDateDebut() {
        return dateDebut;
    }
    
    public int getId(){
        return this.id;
    }
    
    public TreeMap<Integer, String> getTabPerso(){
        return this.tabPerso;
    }
    
    
    public String getDateDebutFr(){
        String mois;
        if (this.dateDebut.getMonth() != 0) {
            mois = ""+this.dateDebut.getMonth();
        } else {
            mois = "12";
        }
        return this.dateDebut.getDate()+"/"+mois+"/"+(this.dateDebut.getYear()+1900);
    }
    
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
 
    public void addPerso(Integer p, String compet) {
        tabPerso.put(p,compet);
    }
    
    public boolean dispo(Date dateDeb, Date dateFin){
        if ((dateDeb.compareTo(this.dateDebut)>0) && (dateDeb.compareTo(this.dateFin)<0)
             || (dateFin.compareTo(this.dateDebut)>0 && (dateFin.compareTo(this.dateFin)<0))
             || (dateDeb.compareTo(this.dateDebut)<0 && (dateFin.compareTo(this.dateFin)>0))){
            return false;
        }
        return true;
    }
    
    public String toStringCsv(){
        String str = this.getType()+";"+this.getId()+";"+this.getDateDebutFr()+";"+this.getDateFinFr()+";"+this.getTotalPersonne();
        Set<String> keys = this.competNbPersonne.keySet();
        for (String key: keys) {
            str += ";"+key+";"+this.competNbPersonne.get(key);
        }
        return str;
    }
    
    public String toStringCsvTabPerso(){
        String str = ""+this.getId();
        Set<Integer> keys = this.tabPerso.keySet();
        for (Integer key: keys) {
            str += ";"+this.tabPerso.get(key)+";"+key;
        }
        return str;
    }
}
