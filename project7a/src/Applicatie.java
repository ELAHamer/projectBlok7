/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Koen
 */
public class Applicatie {

    /**
     * @param args the command line arguments
     */
    
    public JFileChooser fileChooser = new JFileChooser();
    public File selectedFile;
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    private void openBestand(){
        // openen van een geselecteerd bestand
    }
    
    private void leesBestand(File bestand){
        // lezen van ingeladen bestand
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