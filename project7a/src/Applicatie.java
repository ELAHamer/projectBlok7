
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Functie: De applicatie accepteert een DNA sequentie, uit deze sequentie
 *          voorspelt de applicatie alle mogelijke ORFs van de opgegeven sequentie.
 *          De voorspelde ORFs worden gevisualiseert op de GUI.
 *          De DNA sequentie wordt opgeslagen in de database samen met de voorspelde ORFs.
 * 
 * @author Koen Rademaker, Ernst Hamer, Rob van Deelen
 * @Creation date: 21/03/2017
 * @version 4.0
 * @known bugs: none
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
    
    /**
     * Functie: leest het opgegeven bestand, haalt de header er uit en slaat de gevonden
     *          sequentie op in de variable sequence
     * @param locatie
     * @throws FileNotFoundException
     * @throws IOException
     */
    
    public void leesBestand(String locatie) throws FileNotFoundException, IOException {
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
    
    /**
     *  voorspelt de ORFs op de ingeladen DNA sequentie.
     *  De ORFs worden meegegeven aan de functie opslaan ORF
     */
    public void voorspel() {
        // Float emptyPcn = 0.0;
        String testSequentie = "AGCTGACTGCATCGAGCTGCTATGGCCCTGAGTAACTGACGATGCCTAGGAATGACAGCTATGCCAGACGATGAATGATTGATTGCTAC";
        ArrayList<DNA> readingFrames = new ArrayList<DNA>();
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            readingFrames.add(new DNA(testSequentie.substring(i), 0.0f));
        }
        reverse.append(testSequentie);
        reverse = reverse.reverse();
        for (int i = 0; i < 3; i++) {
            readingFrames.add(new DNA(reverse.substring(i), 0.0f));
        }

        ArrayList<String[]> codonFrames = new ArrayList<>();
        for (int i = 0; i < readingFrames.size(); i++) {
            codonFrames.add(readingFrames.get(i).getSequentie().split("(?<=\\G.{3})"));
        }

        // ORFs voorspellen en opslaan in ORFsList
        opslaanDNA();
        opslaanORF();

    }
    /**
     * het uitvoeren van blast op de gevonden ORFs
     * 
     */
    private void BlastORF(ORF item) {
        // uitvoeren van BLAST
    }
    
     /**
     *  het opslaan van de DNA sequentie in de database.
     * 
     */
    private void opslaanDNA() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            e.printStackTrace();
        }

        Connection insertDNA = null;
        try {
            insertDNA = DriverManager.getConnection("jdbc:oracle:thin:@//cytosine.nl:1521/xe", "owe7_pg3", "blaat1234");
            Statement statement = insertDNA.createStatement();
            statement.executeUpdate("INSERT INTO sequentie VALUES('" + sequence + "',0.0,(SELECT MAX(DNA_SEQUENTIE_ID) FROM DNA_SEQUENTIE)+1)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (insertDNA != null && !insertDNA.isClosed()) {
                    insertDNA.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * het opslaan van de ORFs in de database.
     * 
     */
    private void opslaanORF() {
        Connection insertORF = null;
        try {
            insertORF = DriverManager.getConnection("jdbc:oracle:thin:@//cytosine.nl:1521/xe", "owe7_pg3", "blaat1234");
            Statement statement = insertORF.createStatement();
            for (int i = 0; i < ORFsList.size(); i++) {
                statement.executeUpdate("INSERT INTO ORF VALUES('" + ORFsList.get(i).getSequence() + "', 0.0, (SELECT MAX(ORF_ID) FROM ORF)+1, (SELECT MAX(DNA_SEQUENTIE_ID) FROM DNA_SEQUENTIE))");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (insertORF != null && !insertORF.isClosed()) {
                    insertORF.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void opslaan(BLAST object) {
       
    }
}
