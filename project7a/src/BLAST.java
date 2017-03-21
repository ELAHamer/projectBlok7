/**
 *
 * @author Rob
 */
public class BLAST {
    private Integer bitscore;
    private Float eValue;
    private Integer identity;
    private Integer coverage;
    private Integer positives;
    private Integer gaps;
    private String organisme;
    private String eiwit; 
    private String methode;

    public BLAST(Integer bs, Float eV, Integer identity, Integer cv, Integer ps, Integer gp) {
        this.bitscore = bs;
        this.eValue = eV;
        this.identity = identity;
        this.coverage = cv;
        this.gaps = gp;
    }

    public Integer getBitscore() {
        return bitscore;
    }

    public void setBitscore(Integer bitscore) {
        this.bitscore = bitscore;
    }

    public Float geteValue() {
        return eValue;
    }

    public void seteValue(Float eValue) {
        this.eValue = eValue;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getCoverage() {
        return coverage;
    }

    public void setCoverage(Integer coverage) {
        this.coverage = coverage;
    }

    public Integer getPositives() {
        return positives;
    }

    public void setPositives(Integer positives) {
        this.positives = positives;
    }

    public Integer getGaps() {
        return gaps;
    }

    public void setGaps(Integer gaps) {
        this.gaps = gaps;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getEiwit() {
        return eiwit;
    }

    public void setEiwit(String eiwit) {
        this.eiwit = eiwit;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }   
}