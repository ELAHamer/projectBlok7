/**
 *
 * @author Rob
 */
public class DNA {
    protected String sequentie;
    protected Float PercentageN;
        
    DNA(String seq,Float pcN) {
        this.PercentageN = bepaalPercentageN(seq);
        this.sequentie = seq;
    }
    
    public Float bepaalPercentageN(String seq){
        int countN=0;
        
        for(int i=0; i < seq.length();i++){
            if (seq.charAt(i) == 'N');              
            countN++;
            }
        Float pcN = ((float)countN/(float)seq.length())*100;             
        return pcN;
    }
    
    public Float getPercentageN(){
        return this.PercentageN;
    }
    public String getSequentie(){
        return this.sequentie;
    }
    public void setSequentie(String seq){
        this.sequentie = seq;      
    }
    public void setPercentageN(Float pcN){
        this.PercentageN = pcN;
    }
}