
package Mission;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

public class MissionEnCours  extends MissionNonModifiable {
	
        public MissionEnCours(TreeMap<String, Integer> competNbPersonne,
							int totalPersonne,
							Date dateDebut,
							Date dateFin,
                                                        int id){
                this.id = id;
		this.competNbPersonne = competNbPersonne;
		this.totalPersonne = totalPersonne;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tabPerso = new TreeMap<Integer, String>();
	}
	
	public MissionEnCours(MissionPlanifiee mp){
                this.id = mp.id;
		this.competNbPersonne = mp.getComptNbPersonne();
		this.totalPersonne = mp.getTotalPersonne();
		this.dateDebut = mp.getDateDebut();
		this.dateFin = mp.getDateFin();
		this.tabPerso = new TreeMap<Integer, String>();
	}
        
       public String getType(){
            return "MissionEnCours";
        }
       
       public String toString(){
           String str = getType()+";"+this.id+";"+this.dateDebut+";"+this.dateFin.toString()+";"+this.totalPersonne+";";
           Set<String> keys = competNbPersonne.keySet();
            for(String key: keys){
                Integer i = competNbPersonne.get(key);
                str = str + key+";"+i.toString();
            }
           return str;
        }
}
