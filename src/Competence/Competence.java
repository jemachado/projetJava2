/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competence;
import Competence.Competence;
import com.opencsv.CSVReader;
import java.io.FileReader;

public class Competence {
        private CSVReader readerCompetences;
	private String id;
	private String libelleEn;
        private String libelleFr;
	
	public Competence(String id, String libelleEn, String libelleFr){
		this.id=id;
		this.libelleEn=libelleEn;
                this.libelleFr=libelleFr;
	}
        /**
         * retourne le libelle de la competence en francais
         * @return String
         */
        public String getLibelleFr() {
		return libelleFr;
	}
        
        /**
         * modifie le libelle
         * @param libelle String
         */
	public void setLibelleFr(String libelle) {
		this.libelleFr = libelle;
	}
	
        /**
         * retourne le libelle de la competence en anglais
         * @return String 
         */
	public String getLibelleEn() {
		return libelleEn;
	}

        /**
         * modifie le libelle
         * @param libelle String
         */
	public void setLibelleEn(String libelle) {
		this.libelleEn = libelle;
	}
	
        /**
         * retourn l'id de la competence
         * @return String 
         */
	public String getId(){
		return id;
	}

        /**
         * modifie l'id de la competence
         * @param id String
         */
	public void setId(String id) {
		this.id = id;
	}
	
        /**
         * affichage
         * @return String 
         */
	public String toString(){
		String str = ""+this.id+"-- ";
		str += this.getLibelleFr();
		return str;
	}
        
        /**
         * toString en Csv
         * @return String 
         */
        public String toStringCsv(){
		return this.getId()+";"+this.getLibelleEn()+";"+this.getLibelleFr();
        }
}

