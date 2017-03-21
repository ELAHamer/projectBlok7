/**
 *
 * @author Rob
 */
public class ORF extends DNA {
    private Integer frame;
    private Integer positie;
    
    
    public ORF(String seq, Float pcN, Integer pos,Integer frm) {
        super(seq, pcN);
        this.positie = pos;
        this.frame = frm;
    }
    
    @Override
    public Float bepaalPercentageN(String seq){
        int countN=0;
        
        for(int i=0; i < seq.length();i++){
            if (seq.charAt(i) == 'N');              
            countN++;
            }
        
        Float pcN = ((float)countN/(float)seq.length())*100;
        return pcN;
    }
    
    public Integer getFrame(){
        return this.frame;
    }
    public void setFrame(Integer frm){
        this.frame = frm;
    }
    public void setPositie(Integer pos){
        this.positie = pos;
    }
    public Integer getPositie(){
        return this.positie;
    }
}
