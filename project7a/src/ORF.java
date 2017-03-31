/** 
* Functie: ORF object voor opslag van de ORFs
 * 
 * @author Koen Rademaker, Ernst Hamer, Rob van Deelen
 * @Creation date: 21/03/2017
 * @version 4.0
 * @known bugs: none
 */
public class ORF extends DNA {
    private Integer frame;
    private Integer positie;
    
/**
 * constructor DNA
 */
    public ORF(String seq, Float pcN, Integer pos,Integer frm) {
        super(seq, pcN);
        this.positie = pos;
        this.frame = frm;
    }
/**
     * bepaalt op basis van de sequentie het percentage onbekende nucleotiden
     * @param seq
     * @return percentage
     */
    public Float bepaalPercentageN(String seq){
        int countN=0;
        
        for(int i=0; i < seq.length();i++){
            if (seq.charAt(i) == 'N');              
            countN++;
            }
        Float pcN = ((float)countN/(float)seq.length())*100;             
        return pcN;
    }
    
    /**
     * 
     * @return percentage
     */
    public Float getPercentageN(){
        return this.PercentageN;
    }

    /**
     *
     * @return sequentie
     */
    public String getSequentie(){
        return this.sequentie;
    }

    /**
     * schrijft sequentie over
     * @param seq
     */
    public void setSequentie(String seq){
        this.sequentie = seq;      
    }

    /**
     * schrijft percentage over
     * @param pcN
     */
    public void setPercentageN(Float pcN){
        this.PercentageN = pcN;
    }
}
