/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jerem
 */
public abstract class MissionNonModifiable extends Mission {
    protected ArrayList<String> tabPerso;
    
    public void setTotalPersonne(int totalPersonne) {
        this.totalPersonne = totalPersonne;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public ArrayList<String> getTabPerso() {
        return tabPerso;
    }
}
