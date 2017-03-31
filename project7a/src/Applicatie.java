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
    public String sequence;
    
    
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
    }
            } catch (FileNotFoundException e) {
            System.out.println("er is iets fout gegaan bij het inladen van het bestand");
        }
    }
    
    public void voorspel(){
       // Float emptyPcn = 0.0;
       String testSequentie = "AGCTGACTGCATCGAGCTGCTATGGCCCTGAGTAACTGACGATGCCTAGGAATGACAGCTATGCCAGACGATGAATGATTGATTGCTAC";
        ArrayList<DNA> ORFs = new ArrayList<DNA>();
        StringBuilder reverse = new StringBuilder();
        for(int i = 0; i<3;i++){
            ORFs.add(new DNA(testSequentie.substring(i+1),0.0f));
        }
        reverse.append(testSequentie);
        reverse = reverse.reverse();
        for(int i=0; i<3; i++){
            ORFs.add(new DNA(reverse.substring(i+1),0.0f));
        }
        System.out.println(ORFs);
        


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