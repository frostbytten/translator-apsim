package org.agmip.translators.apsim.events;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;


public class Planting extends Event{

	/**
	 * Cultivar name
	 * Unit or Type: text
	 */
	@JsonProperty("cul_name")
	String cultivar;

	/**
	 * Planting depth
	 * Unit or Type: mm
	 */
	@JsonProperty("pldp")
	Double depth;
	/**
	 * Row spacing
	 * Unit or Type: cm
	 */
	@JsonProperty("plrs")
	String rowSpacing;
	/**
	 * Plant population at planting
	 * Unit or Type: number/m2
	 */
	@JsonProperty("plpop")
	Double population;

}
