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
       //String testSequentie = "AGCTGACTGCATCGAGCTGCTATGGCCCTGAGTAACTGACGATGCCTAGGAATGACAGCTATGCCAGACGATGAATGATTGATTGCTAC";
        ArrayList<DNA> ORFs = new ArrayList<DNA>();
        StringBuilder reverse = new StringBuilder();
        String tempORF = "";
        Integer indexORF = 0;

            try{
                for(int i = 0;i<2;i++){
                    for(int e=i; e<sequentie.length()-2;e=e+3){
                        System.out.println("banana");
                        System.out.println("is "+sequentie.substring(e,e+3)+ " ATG? Answer "+(sequentie.substring(e,e+3) == "ATG"));
                        if(sequentie.substring(e,e+3)== "ATG"){
                            
                            System.out.println("atuff"+sequentie.substring(e,e+3));
                            tempORF += sequentie.substring(e, e+3);
                            indexORF = e+3;
                        }
                    System.out.println("codon: "+sequentie.substring(e,e+3)+" tempORF: "+tempORF);
                    //ORFs.add(new DNA(sequentie.substring(i),0.0f));
                    }
                }
            }catch(StringIndexOutOfBoundsException err){
                System.out.println("error: "+err.getMessage());
                }
            }
            
       // }
//        reverse.append(sequentie);
//        reverse = reverse.reverse();
//        for(int i=0; i<3; i++){
//            ORFs.add(new DNA(reverse.substring(i),0.0f));
//        }
//        for(int i=0; i<ORFs.size(); i++){
//            System.out.println(ORFs.get(i).getSequentie());
//        }


// uitvoeren van voorspelling over DNA
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