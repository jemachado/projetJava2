package Mission;

import Entreprise.Entreprise;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

public class MissionPreparation extends Mission {
	
	
	public MissionPreparation(TreeMap<String, Integer> competNbPersonne,
                                int totalPersonne,
                                Date dateDebut,
                                Date dateFin,
                                int id){
                this.id = id;
		this.competNbPersonne = competNbPersonne;
		this.totalPersonne = totalPersonne;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
        
        public void addComptNbPersonne(String s, Integer i){
        if(s!=null && s.equals("") && i!=null ){
            this.competNbPersonne.put(s,i);
        }
    }
        
    public String getType(){
        return "MissionPreparation";
    }
}
