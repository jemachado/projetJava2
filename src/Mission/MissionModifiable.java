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
    
    public void setTotalPersonne(int totalPersonne) {
        this.totalPersonne = totalPersonne;
    }
    
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public void setDuree(Date dateFin) {
        this.dateFin = dateFin;
    }
}
