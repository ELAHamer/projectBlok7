/** 
 * Functie: Blast object voor opslag van de Blast resultaten
 * 
 * @author Koen Rademaker, Ernst Hamer, Rob van Deelen
 * @Creation date: 21/03/2017
 * @version 4.0
 * @known bugs: none
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

   /**
     * constructor van blast object
     * @param bs
     * @param eV
     * @param identity
     * @param cv
     * @param ps
     * @param gp
     */
    public BLAST(Integer bs, Float eV, Integer identity, Integer cv, Integer ps, Integer gp) {
        this.bitscore = bs;
        this.eValue = eV;
        this.identity = identity;
        this.coverage = cv;
        this.gaps = gp;
    }

    /**
     *
     * @return bitscore
     */
    public Integer getBitscore() {
        return bitscore;
    }

    /**
     * schrijft bitscore over
     * @param bitscore
     */
    public void setBitscore(Integer bitscore) {
        this.bitscore = bitscore;
    }

    /**
     *
     * @return e-value
     */
    public Float geteValue() {
        return eValue;
    }

    /**
     * schrijft e value over
     * @param eValue
     */
    public void seteValue(Float eValue) {
        this.eValue = eValue;
    }

    /**
     *
     * @return identity
     */
    public Integer getIdentity() {
        return identity;
    }

    /**
     * schrijft identity over
     * @param identity
     */
    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    /**
     * 
     * @return coverage
     */
    public Integer getCoverage() {
        return coverage;
    }

    /**
     * schrijft coverage over
     * @param coverage
     */
    public void setCoverage(Integer coverage) {
        this.coverage = coverage;
    }

    /**
     *
     * @return positives
     */
    public Integer getPositives() {
        return positives;
    }

    /**
     * schrijft positives over
     * @param positives
     */
    public void setPositives(Integer positives) {
        this.positives = positives;
    }

    /**
     *
     * @return gaps
     */
    public Integer getGaps() {
        return gaps;
    }

    /**
     *schrijft gaps over
     * @param gaps
     */
    public void setGaps(Integer gaps) {
        this.gaps = gaps;
    }

    /**
     *
     * @return organisme
     */
    public String getOrganisme() {
        return organisme;
    }

    /**
     * schrijft eiwit over
     * @param organisme
     */
    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    /**
     * 
     * @return eiwit
     */
    public String getEiwit() {
        return eiwit;
    }

    /**
     * schrijft eiwit over
     * @param eiwit
     */
    public void setEiwit(String eiwit) {
        this.eiwit = eiwit;
    }

    /**
     *
     * @return methode
     */
    public String getMethode() {
        return methode;
    }

    /**
     * schrijft methode over
     * @param methode
     */
    public void setMethode(String methode) {
        this.methode = methode;
    }   
}
