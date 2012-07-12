package org.agmip.translators.apsim.events;

import org.codehaus.jackson.annotate.JsonProperty;


public class Fertilizer extends Event {
	
	@JsonProperty("feacd")
	String method;
	
	@JsonProperty("fecd")
	String material;

	@JsonProperty("fedep")
	String depth;
	
	@JsonProperty("feamp")
	String phosphorus;
	
	@JsonProperty("feamk")
	String potasium;
	

	@JsonProperty("feamn")
	String nitrogen;
	
	
	
}
