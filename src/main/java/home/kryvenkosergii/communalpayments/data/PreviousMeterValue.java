package home.kryvenkosergii.communalpayments.data;

/**
 * Holds previous meter's value data.
 * @author SergiiK 2020-08-28
 */
public class PreviousMeterValue {
    //
    private String previousTimeData1;
    private String numberMeterData;
    private int previousMeterValue1;
    private int previousMeterValue2;
    private String source;

    //
    /**
     * Default constructor.
     */
    public PreviousMeterValue() {
        this.previousTimeData1 = "";
        this.previousMeterValue1 = -1;
        this.numberMeterData = "";
        this.previousMeterValue2 = -1;
        this.source = "";
    }

    /**
     * Constructor with 4 parameters.
     * @param previousTimeData1 String.
     * @param previousMeterValue1 int.
     * @param numberMeterData String.
     * @param previousMeterValue2 int.
     */
    public PreviousMeterValue(String previousTimeData1, int previousMeterValue1, int previousMeterValue2, String numberMeterData) {
        this.previousTimeData1 = previousTimeData1;
        this.numberMeterData = numberMeterData;
        this.previousMeterValue1 = previousMeterValue1;
        this.previousMeterValue2 = previousMeterValue2;
        this.source = "";
    }

    /**
     * Constructor with 2 parameters.
     * @param previousTimeData1 String.
     * @param previousMeterValue1 int.
     */
    public PreviousMeterValue(String previousTimeData1, int previousMeterValue1, String numberMeterData) {
        this.previousTimeData1 = previousTimeData1;
        this.previousMeterValue1 = previousMeterValue1;
        this.numberMeterData = numberMeterData;
        this.previousMeterValue2 = -1;
        this.source = "";
    }

    /**
     * Constructor with 3 parameters.
     * @param previousTimeData1 String.
     * @param previousMeterValue1 int.
     * @param source String.
     * @param numberMeterData String.
     */
    public PreviousMeterValue(String previousTimeData1, int previousMeterValue1, String source, String numberMeterData) {
        this.previousTimeData1 = previousTimeData1;
        this.previousMeterValue1 = previousMeterValue1;
        this.source = source;
        this.numberMeterData = numberMeterData;
        this.previousMeterValue2 = -1;
    }

    // getters
    public String getPreviousTimeData1() {
        return previousTimeData1;
    }

    public String getnumberMeterData() {
        return numberMeterData;
    }

    public int getPreviousMeterValue1() {
        return previousMeterValue1;
    }

    public int getPreviousMeterValue2() {
        return previousMeterValue2;
    }

    public String getSource() {
        return source;
    }

    // setters
    public void setPreviousTimeData1(String previousTimeData1) {
        this.previousTimeData1 = previousTimeData1;
    }

    public void setnumberMeterData(String numberMeterData) {
        this.numberMeterData = numberMeterData;
    }

    public void setPreviousMeterValue1(int previousMeterValue1) {
        this.previousMeterValue1 = previousMeterValue1;
    }

    public void setPreviousMeterValue2(int previousMeterValue2) {
        this.previousMeterValue2 = previousMeterValue2;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "PreviousMeterValue [previousTimeData1=" + previousTimeData1 + ", previousMeterValue1=" + previousMeterValue1
                + ",\n numberMeterData=" + numberMeterData + ", previousMeterValue2=" + previousMeterValue2 + ",\n source="
                + source + "]";
    }

}
