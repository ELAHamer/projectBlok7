/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.swing.JFileChooser;

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
    
    private void voorspel(DNA sequentie){
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