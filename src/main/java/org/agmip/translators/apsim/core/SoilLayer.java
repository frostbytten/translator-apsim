package org.agmip.translators.apsim.core;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Dean Holzworth, CSIRO
 * @author Ioannis N. Athanasiadis, DUTh
 * @since Jul 13, 2012
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SoilLayer {
    // bottomDepth
    @JsonProperty("sllb")
    private String bottomDepth = "?";
    
    // thickness
    @JsonIgnore
    private String thickness = "?";
    public String getThickness() { return thickness; }
    
    // bulkDensity
    @JsonProperty("slbdm")
    private String bulkDensity = "?";
    public String getBulkDensity() { return bulkDensity; }
    
    // airDry
    @SuppressWarnings("unused")
    @JsonIgnore
    private String airDry = "?";
    public String getAirDry() {
        double ll = Double.valueOf(lowerLimit);
        return String.valueOf(ll - (ll * 0.05));
    }
    
    // lowerLimit
    @JsonProperty("slll")
    private String lowerLimit = "?";
    public String getLowerLimit() { return lowerLimit; }
    
    // drainedUpperLimit
    @JsonProperty("sldul")
    private String drainedUpperLimit = "?";
    public String getDrainedUpperLimit() { return drainedUpperLimit; }
    
    // saturation
    @JsonProperty("slsat")
    private String saturation = "?"; 
    public String getSaturation() { return saturation; }
    
    // organicCarbon
    @JsonProperty("sloc")
    private String organicCarbon ="?";
    public String getOrganicCarbon() { return organicCarbon; }
    
    // ph
    @JsonProperty("slphw")
    private String ph = "?";
    public String getPh() { return ph; }
    
    // swcon
    @JsonProperty("SLDR")
    private String swcon = "?";
    public String getSwcon() { return swcon; }
    
    // kl
    private double kl;
    public double getKl() { return kl; }
    
    // fbiom
    private double fbiom;
    public double getFbiom() { return fbiom; }
    
    // finert
    private double finert;
    public double getFinert() { return finert; }
    
    private String log;
    public String getLog() { return log; }    
    
    

    
    

    
    // These assumptions are written to the top of the .apsim file in a <Memo>
    public double initialise(double cumThickness, int layerNumber, int numLayers) {
        log = "";
        
        if ("?".equals(bottomDepth))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing thickness.\r\n";

        if ("?".equals(bulkDensity))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing bulk density.\r\n";
        
        if ("?".equals(lowerLimit))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing lowerLimit.\r\n";
        
        if ("?".equals(drainedUpperLimit))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing drained upper limit.\r\n";

        if ("?".equals(saturation))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing saturation.\r\n";

        if ("?".equals(organicCarbon))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ERROR: Missing organ carbon.\r\n";

        if ("?".equals(ph))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ASSUMPTION: Missing PH. Assuming a value of 7.0\r\n";

        if ("?".equals(swcon))
            log += "  * Soil layer " + String.valueOf(layerNumber) + " ASSUMPTION: Missing SWCON. Assuming a value of 0.3\r\n";
        
        double klPerLayer = (0.08 - 0.02) / (numLayers-1);
        kl = 0.08 - ( (layerNumber-1) * klPerLayer);
        
        double fbiomPerLayer = (0.04 - 0.01) / (numLayers-1);
        fbiom = 0.04 - ( (layerNumber-1) * fbiomPerLayer);

        double finertPerLayer = (0.4 - 0.9) / (numLayers-1);
        finert = 0.4 - ( (layerNumber-1) * finertPerLayer);
        
        double bottom = Double.valueOf(bottomDepth);
        thickness = String.valueOf(bottom * 10 - cumThickness);
        return bottom * 10;
    }     
    
}
