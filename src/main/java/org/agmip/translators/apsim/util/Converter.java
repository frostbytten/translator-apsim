package org.agmip.translators.apsim.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.agmip.translators.apsim.ApsimOutput;
import org.agmip.translators.apsim.core.SimulationRun;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ioannis N. Athanasiadis, DUTh
 * @author Dean Holzworth, CSIRO
 * @since Jul 13, 2012
 */
public class Converter {

    public static final SimpleDateFormat agmip = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat apsim = new SimpleDateFormat("dd/MM/yyyy");
    private static final Logger LOG = LoggerFactory.getLogger(ApsimOutput.class);

    public static void generateAPSIMFile(File path, SimulationRun sim)
            throws Exception {
        path.mkdirs();
        File file = new File(path, sim.getExperimentName() + ".apsim");
        file.createNewFile();
        Velocity.init();
        VelocityContext context = new VelocityContext();
        sim.initialise();
        FileWriter writer;
        try {
            context.put("simulation", sim);
            writer = new FileWriter(file);
            Velocity.evaluate(context, writer, "Generate APSIM", Converter.class.getClassLoader().getResourceAsStream("template.apsim"));
            writer.close();
        } catch (IOException ex) {
            LOG.error(ex.getMessage());
        }
    }
        
    public static void generateMetFile(File path, SimulationRun sim) throws Exception {
        path.mkdirs();
        String baseName;
        if (sim.getExperimentName().equals("default")) {
            baseName = sim.getWeather().getShortName();
        } else {
            baseName = sim.getExperimentName();
        }
        File file = new File(path, baseName+".met");
        file.createNewFile();
        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("weather", sim.getWeather());
        FileWriter writer = new FileWriter(file);
        Velocity.evaluate(context, writer, "Generate Met", Converter.class.getClassLoader().getResourceAsStream("template.met"));
        writer.close();
    }

    public static String GetYear(String agmipDate) throws ParseException {
        Date date = apsim.parse(agmipDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR) + "";
    }

    public static String GetDay(String agmipDate) throws ParseException {
        Date date = apsim.parse(agmipDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_YEAR) + "";
    }

    public static Calendar toCalendar(String apsimDate) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(apsim.parse(apsimDate));
        return c;
    }

    public static String toApsimDateString(Calendar date) throws ParseException {
        return apsim.format(date.getTime());
    }
    
    // static helper function for converting a crop code to a crop name.
    public static String cropCodeToName(String cropCode) {
        if ("ALF".equals(cropCode))
            return "lucerne";
        if ("APL".equals(cropCode))
            return "Apple";
        if ("APR".equals(cropCode))
            return "Apricot";
        if ("BAR".equals(cropCode))
            return "barley";
        if ("BHG".equals(cropCode))
            return "Bahia grass";
        if ("BLW".equals(cropCode))
            return "Broad leaf weeds";
        if ("BND".equals(cropCode))
            return "Dry bean";
        if ("BNG".equals(cropCode))
            return "Green bean";
        if ("BNN".equals(cropCode))
            return "Banana";
        if ("BRC".equals(cropCode))
            return "Brachiaria";
        if ("BWH".equals(cropCode))
            return "Buckwheat";
        if ("CAM".equals(cropCode))
            return "Camelina";
        if ("CAR".equals(cropCode))
            return "Carrot";
        if ("CBG".equals(cropCode))
            return "Cabbage";
        if ("CCN".equals(cropCode))
            return "Coconut";
        if ("CFE".equals(cropCode))
            return "Coffee";
        if ("CGR".equals(cropCode))
            return "Concord grape";
        if ("CHP".equals(cropCode))
            return "chickpea";
        if ("CHR".equals(cropCode))
            return "Cherry";
        if ("CIT".equals(cropCode))
            return "Citrus";
        if ("CLV".equals(cropCode))
            return "Clover";
        if ("CNL".equals(cropCode))
            return "canola";
        if ("COT".equals(cropCode))
            return "cotton";
        if ("CRM".equals(cropCode))
            return "Crambe";
        if ("CST".equals(cropCode))
            return "Castor bean";
        if ("CSV".equals(cropCode))
            return "Cassava";
        if ("CWP".equals(cropCode))
            return "cowpea";
        if ("FAL".equals(cropCode))
            return "Fallow";
        if ("FBN".equals(cropCode))
            return "Fababean";
        if ("FIG".equals(cropCode))
            return "Fig";
        if ("FXM".equals(cropCode))
            return "Foxtail millet";
        if ("GRV".equals(cropCode))
            return "Grass vegetations";
        if ("GRW".equals(cropCode))
            return "Grass weeds";
        if ("GUA".equals(cropCode))
            return "Guayule";
        if ("HOP".equals(cropCode))
            return "Hops";
        if ("JBN".equals(cropCode))
            return "Jack bean";
        if ("JUT".equals(cropCode))
            return "Jute";
        if ("LBN".equals(cropCode))
            return "Lima bean";
        if ("LEN".equals(cropCode))
            return "Lentil";
        if ("MAZ".equals(cropCode))
            return "Maize";
        if ("NPG".equals(cropCode))
            return "Napier grass";
        if ("OAT".equals(cropCode))
            return "Oats";
        if ("OLP".equals(cropCode))
            return "Oilpalm";
        if ("ONN".equals(cropCode))
            return "Onion";
        if ("PEA".equals(cropCode))
            return "FieldPea";
        if ("PER".equals(cropCode))
            return "Pear";
        if ("PGP".equals(cropCode))
            return "Pigeonpea";
        if ("PML".equals(cropCode))
            return "millet";
        if ("PNA".equals(cropCode))
            return "Pineapple";
        if ("PNT".equals(cropCode))
            return "Peanut";
        if ("POT".equals(cropCode))
            return "Potato";
        if ("PPN".equals(cropCode))
            return "Perennial peanut";
        if ("PPR".equals(cropCode))
            return "Capsicum pepper";
        if ("PRM".equals(cropCode))
            return "Proso millet";
        if ("QUN".equals(cropCode))
            return "Quinoa";
        if ("RAP".equals(cropCode))
            return "Rape";
        if ("RHP".equals(cropCode))
            return "Rhizoma peanut";
        if ("RIC".equals(cropCode))
            return "Rice";
        if ("SAF".equals(cropCode))
            return "Safflower";
        if ("SBN".equals(cropCode))
            return "Soybean";
        if ("SBT".equals(cropCode))
            return "Beet sugar";
        if ("SES".equals(cropCode))
            return "Sesame";
        if ("SGG".equals(cropCode))
            return "sorghum";
        if ("STR".equals(cropCode))
            return "Shrubs/trees";
        if ("SUC".equals(cropCode))
            return "Sugar";
        if ("SUN".equals(cropCode))
            return "Sunflower";
        if ("SWC".equals(cropCode))
            return "Sweetcorn";
        if ("SWG".equals(cropCode))
            return "Switch grass";
        if ("SWP".equals(cropCode))
            return "Sweet potato";
        if ("TAN".equals(cropCode))
            return "Tanier";
        if ("TAR".equals(cropCode))
            return "Taro";
        if ("TBN".equals(cropCode))
            return "Tepary bean";
        if ("TGR".equals(cropCode))
            return "Table grape";
        if ("TOM".equals(cropCode))
            return "Tomato";
        if ("TRT".equals(cropCode))
            return "Triticale";
        if ("VBN".equals(cropCode))
            return "Velvet bean";
        if ("VIN".equals(cropCode))
            return "Wine grape";
        if ("WHB".equals(cropCode))
            return "wheat";
        if ("WHD".equals(cropCode))
            return "wheat";
        return "?";
    }    
    
   // static helper function for converting a crop code to a crop name.
    public static String tillageCodeToName(String tillageCode) {
        if ("TI001".equals(tillageCode))
            return "V-Ripper";
        if ("TI002".equals(tillageCode))
            return "Subsoiler";
        if ("TI003".equals(tillageCode))
            return "Moldboard plow 20 cm depth";
        if ("TI004".equals(tillageCode))
            return "Chisel plow, sweeps";
        if ("TI005".equals(tillageCode))
            return "Chisel plow, straight point";
        if ("TI006".equals(tillageCode))
            return "Chisel plow, twisted shovels";
        if ("TI007".equals(tillageCode))
            return "Disk plow";
        if ("TI008".equals(tillageCode))
            return "Disk, 1-way";
        if ("TI009".equals(tillageCode))
            return "Disk, tandem";
        if ("TI010".equals(tillageCode))
            return "Disk, double disk";
        if ("TI011".equals(tillageCode))
            return "Cultivator, field";
        if ("TI012".equals(tillageCode))
            return "Cultivator, row";
        if ("TI013".equals(tillageCode))
            return "Cultivator, ridge till";
        if ("TI014".equals(tillageCode))
            return "Harrow, spike";
        if ("TI015".equals(tillageCode))
            return "Harrow, tine";
        if ("TI016".equals(tillageCode))
            return "Lister";
        if ("TI017".equals(tillageCode))
            return "Bedder";
        if ("TI018".equals(tillageCode))
            return "Blade cultivator";
        if ("TI019".equals(tillageCode))
            return "Fertilizer applicator, anhydr";
        if ("TI020".equals(tillageCode))
            return "Manure injector";
        if ("TI022".equals(tillageCode))
            return "Mulch treader";
        if ("TI023".equals(tillageCode))
            return "Plank";
        if ("TI024".equals(tillageCode))
            return "Roller packer";
        if ("TI025".equals(tillageCode))
            return "Drill, double-disk";
        if ("TI026".equals(tillageCode))
            return "Drill, deep furrow";
        if ("TI031".equals(tillageCode))
            return "Drill, no-till";
        if ("TI032".equals(tillageCode))
            return "Drill, no-till";
        if ("TI033".equals(tillageCode))
            return "Planter, row";
        if ("TI034".equals(tillageCode))
            return "Planter, no-till";
        if ("TI035".equals(tillageCode))
            return "Planting stick (hand)";
        if ("TI036".equals(tillageCode))
            return "Matraca hand planter";
        if ("TI037".equals(tillageCode))
            return "Rod weeder";
        if ("TI038".equals(tillageCode))
            return "Rotary hoe";
        if ("TI039".equals(tillageCode))
            return "Roller harrow, cultipacker";
        if ("TI041".equals(tillageCode))
            return "Moldboard plow 25 cm";
        if ("TI042".equals(tillageCode))
            return "Moldboard plow 30 cm";
        return "?";
    }
    
    
}
