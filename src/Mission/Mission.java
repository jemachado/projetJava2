/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;

import java.util.Date;
import java.util.TreeMap;

/**
 *
 * @author clementraphaell
 */
public abstract class Mission {
    protected int id;
    protected TreeMap<String, Integer> competNbPersonne;
    protected int totalPersonne;
    protected Date dateDebut;
    protected int duree;
    
    public Integer getComptNbPersonne(String i) {
        return competNbPersonne.get(i);
    }

    public TreeMap<String, Integer> getComptNbPersonne() {
        return competNbPersonne;
    }
    
    public int getTotalPersonne() {
        return totalPersonne;
    }

    public int getDuree() {
        return duree;
     }
    
    public Date getDateDebut() {
        return dateDebut;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getDateDebutFr(){
            return this.dateDebut.getDay()+"/"+this.dateDebut.getMonth()+"/"+(this.dateDebut.getYear()+1900);
    }
    
    public abstract String getType();
 
    
}
