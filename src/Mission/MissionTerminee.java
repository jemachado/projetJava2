/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;

import Mission.Mission;
import java.util.ArrayList;

/**
 *
 * @author clementraphaell
 */
public class MissionTerminee extends MissionNonModifiable {
    public MissionTerminee(MissionEnCours mp){
                this.id = mp.id;
		this.competNbPersonne = mp.getComptNbPersonne();
		this.totalPersonne = mp.getTotalPersonne();
		this.dateDebut = mp.getDateDebut();
		this.duree = mp.getDuree();
		this.tabPerso = new ArrayList<String>();
	}
    
     public String getType(){
        return "MissionTerminee";
    }
}
