package org.agmip.translators.apsim.events;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Ioannis N. Athanasiadis, DUTh
 * @author Dean Holzworth, CSIRO
 * @since Jul 13, 2012
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Harvest extends Event {

	@Override
	public String getApsimAction() {
		return "";
	}


}
