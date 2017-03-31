/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Koen
 */
public class Applicatie {
    public static BufferedReader inFile;
    public JFileChooser fileChooser = new JFileChooser();
    public File selectedFile;
    public String sequence = "";
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    

    public void leesBestand(String locatie)throws FileNotFoundException, IOException {
                String lines;
        try {
            inFile = new BufferedReader(new FileReader(locatie));
            inFile.readLine();
            while ((lines = inFile.readLine()) != null) {
                sequence += lines;
    }       System.out.println("lees bestand: "+sequence);
            } catch (FileNotFoundException e) {
            System.out.println("er is iets fout gegaan bij het inladen van het bestand");
        }
    }
    
    public void voorspel(String sequentie)  throws StringIndexOutOfBoundsException{
        ArrayList<DNA> ORFs = new ArrayList<DNA>();

        String tempORF = "";
        Integer indexORF = 0;
        Integer startIndex = 0;

            try{
                for(int i = 0;i<3;i++){
                    System.out.println("loop "+i);
                    for(int e=startIndex; e<sequentie.length()-2;e=e+3){
                        if(sequentie.substring(e,e+3).equals("ATG") && tempORF.equals("")){
                            tempORF += sequentie.substring(e, e+3);
                            indexORF +=3;
                        }else if(tempORF.length()>4 && (sequentie.substring(e, e+3).equals("TAG") || sequentie.substring(e, e+3).equals("TAA")|| sequentie.substring(e, e+3).equals("TGA"))){
                            tempORF +=sequentie.substring(e, e+3);
                            ORFs.add(new DNA(tempORF,0.0f));
                            tempORF = "";
                        }else if(tempORF != ""){
                            tempORF += sequentie.substring(e, e+3);
                        
                        }else if(e+3>sequentie.length()){
                            ORFs.add(new DNA(tempORF,0.0f));
                        }
                    } startIndex = startIndex+1;
                }
            }catch(StringIndexOutOfBoundsException err){
                System.out.println("error: "+err.getMessage());
                
            }finally{for(int Y = 0;Y<ORFs.size()-1;Y++){
                System.out.println("ORF's: "+ORFs.get(Y).getSequentie());
                }
                
            }
    }
            

// uitvoeren van voorspelling over DNA
    
    
    public String reverseSequentie(String sequentie){
        StringBuilder reverse = new StringBuilder();

        reverse.append(sequentie);
        reverse = reverse.reverse();
        return reverse.toString();
        }

    

    private void BlastORF(ORF item){
        // uitvoeren van BLAST
    }
    
    private void opslaan(DNA object){
        // connectie met database maken
        // query voor het opslaan van DNA
        
    }
    
    private void opslaan(ORF object){
        // connectie met database maken
        // query voor het opslaan van een ORF en bijhorend DNA
    }
    
    private void opslaan(BLAST object){
        // connectie met database maken
        // query voor het opslaan van een BLAST met bijhorend ORF en DNA
    }
}