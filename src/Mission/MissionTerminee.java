/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;

import Mission.Mission;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

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
		this.dateFin = mp.getDateFin();
		this.tabPerso = new ArrayList<String>();
	}
    
    public MissionTerminee(TreeMap<String, Integer> competNbPersonne,
							int totalPersonne,
							Date dateDebut,
							Date dateFin,
                                                        int id){
                this.id = id;
		this.competNbPersonne = competNbPersonne;
		this.totalPersonne = totalPersonne;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tabPerso = new ArrayList<String>();
	}
    
    /**
     * return le status de la mission
     * @return 
     */
     public String getType(){
        return "MissionTerminee";
    }
}
