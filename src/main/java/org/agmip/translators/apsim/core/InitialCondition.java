/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agmip.translators.apsim.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.agmip.util.MapUtil;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author hol353
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitialCondition {
    
    @JsonProperty("icdat")
    public String date;
    
    @JsonProperty("icrag")
    public double residueWeight;
    
    @JsonProperty("icrn")
    public double residueNConc;
  
    @JsonProperty("soillayer")
    public InitialConditionLayer[] soilLayers;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getResidueWeight() {
		return residueWeight;
	}

	public void setResidueWeight(double residueWeight) {
		this.residueWeight = residueWeight;
	}

	public double getResidueNConc() {
		return residueNConc;
	}

	public void setResidueNConc(double residueNConc) {
		this.residueNConc = residueNConc;
	}

	public InitialConditionLayer[] getSoilLayers() {
		return soilLayers;
	}

	public void setSoilLayers(InitialConditionLayer[] soilLayers) {
		this.soilLayers = soilLayers;
	}
    
//    public void readFrom(Map input) throws ParseException {
//        MapUtil.BucketEntry management = MapUtil.getBucket(input, "treatment").get(0);
//        MapUtil.BucketEntry initialConditions = management.getSubBucketEntry("initial_condition");
//        
//        DateFormat dateFormatter = new SimpleDateFormat("yyyymmdd");
//        date = dateFormatter.parse(MapUtil.getValueOr(initialConditions.getValues(), "icdat", "?"));
//        residueWeight = Double.parseDouble(MapUtil.getValueOr(management.getValues(), "icrag", "?"));
//        residueNConc = Double.parseDouble(MapUtil.getValueOr(management.getValues(), "icrn", "?"));
//       
//        ArrayList data = management.getDataList();
//        setLayers(new InitialConditionLayer[data.size()]);
//        for (int i = 0; i < data.size(); i++) {
//            layers[i] = new InitialConditionLayer();
//            layers[i].readFrom((Map) data.get(i));
//        } 
//    }
    
    
    

 
}