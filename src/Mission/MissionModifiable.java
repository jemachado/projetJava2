/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;

import java.util.Date;

/**
 *
 * @author jerem
 */
public abstract class MissionModifiable extends Mission {
    
    /**
     * permet de modifier le nombre total de personne
     * @param totalPersonne int
     */
    public void setTotalPersonne(int totalPersonne) {
        this.totalPersonne = totalPersonne;
    }
    
    /**
     * permet de modifier la date de debut de la mission
     * @param dateDebut Date
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    /**
     * permet de modifier la date de fin
     * @param dateFin Date
     */
    public void setDuree(Date dateFin) {
        this.dateFin = dateFin;
    }
}
