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
            this.tabPerso = new TreeMap<Integer,String>();
    }

    /**
     * toString
     * @return String
     */
    public String toString(){
       String str = getType()+";"+this.id+";"+this.dateDebut+";"+this.dateFin.toString()+";"+this.totalPersonne+";";
       Set<String> keys = competNbPersonne.keySet();
        for(String key: keys){
            Integer i = competNbPersonne.get(key);
            str = str + key+";"+i.toString();
        }
       return str;
    }
        
    /**
     * Ajouter une compétence à la mission
     * @param s String
     * @param i Integer
     */
    public void addComptNbPersonne(String s, Integer i){
    if(s!=null && s.equals("") && i!=null ){
        this.competNbPersonne.put(s,i);
    }
    }
    
    /**
     * retourne le type de la mission
     * @return String
     */
    public String getType(){
        return "MissionPreparation";
    }
    
    /**
     * toString en csv
     * @return String
     */
    public String toStringCsv(){
        String str = this.getType()+";"+this.getId()+";"+this.getDateDebutFr()+";"+this.getDateFinFr()+";"+this.getTotalPersonne();
        Set<Integer> keys = this.tabPerso.keySet();
        for (Integer key: keys) {
            str += ";"+this.tabPerso.get(key)+";"+key;
        }
        return str;
    }
}
