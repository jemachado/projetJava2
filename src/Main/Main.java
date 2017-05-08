/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.interfaceGraphiqueAccueil;

/**
 *
 * @author clementraphaell
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap; 

import com.opencsv.CSVReader;

import Competence.Competence;
import Entreprise.Entreprise;
import Mission.Mission;
import Mission.MissionPreparation;
import Personnel.Personnel;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	
    public static void main(String[] args) throws IOException {

        Entreprise f = new Entreprise();
        f.initDonnees();
        /*
        TreeMap<Integer,Personnel> rechercherPersonnels = f.rechercherPersonnels(null, "Galasso", "Ollie", new ArrayList<String>());
        
        Set<Integer> keys = rechercherPersonnels.keySet();
        for(Integer key: keys){
            Personnel p = rechercherPersonnels.get(key);
            System.out.println(p.toString());
        }*/
        
    }
}
