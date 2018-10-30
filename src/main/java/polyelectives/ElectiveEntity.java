package polyelectives;

import java.util.*;

public class ElectiveEntity implements Comparable<ElectiveEntity>
{
    private String FullName;
    private String Abbreviation;
    private String Description = "None";

    private ArrayList<String>  Offered;
    private ArrayList<String>  PreReqs;
    
    private Map<String, Double> Tags;
    /* potentially change to Map */
    private ArrayList<String>  Concentrations;
    private ArrayList<String>  ConcentrationReq;
    
    private double Score = 0;

    private static String translateAbbr(String FullName)
    {
        List<String> abbr = Arrays.asList(FullName.split("."));
        
        if(abbr.size() < 2)
            return "None";
        else
            return abbr.get(0);
    }
    
    private static ArrayList<Double> translateTagWeights(List<String> TagWeightsString)
    {
    	ArrayList<Double> TagWeightsDouble = new ArrayList<Double>();
    	
    	for(String tag: TagWeightsString)
    		TagWeightsDouble.add(Double.parseDouble(tag));
    	
    	return TagWeightsDouble;
    }
    
    private static Map<String, Double> tagMapCreate(ArrayList<String> Tags, 
    												 ArrayList<Double> TagWeights)
    {
    	Map<String, Double> TagsMap = new LinkedHashMap<String, Double>();
    	int n = Tags.size();

    	for(int i = 0; i < n; i++)
    		TagsMap.put(Tags.get(i), TagWeights.get(i));
    	
    	return TagsMap;
    	
    }

    public ElectiveEntity(String startFullName, String startOffered,       
                    	  String startPreReqs,       
                    	  String startTags, String startTagWeights,
                    	  String startConcentration, String startConcentrationReq,
                    	  String startDescription)
    {
    	/* String Values */
        FullName = startFullName;
        Abbreviation = translateAbbr(startFullName);
        // possibly include class level
        Description = startDescription;

        /* Array Values */
        Offered =    	   	new ArrayList<String>(Arrays.asList(startOffered.split(", ")));
        PreReqs =           new ArrayList<String>(Arrays.asList(startPreReqs.split(", ")));
        
        /* Map Values */
        Tags = 				tagMapCreate(new ArrayList<String>(Arrays.asList(startTags.split(", "))),
        					translateTagWeights(Arrays.asList(startTagWeights.split(", "))));
        /* Will convert to a map */
        Concentrations =	new ArrayList<String>(Arrays.asList(startConcentration.split(", ")));
        ConcentrationReq = 	new ArrayList<String>(Arrays.asList(startConcentrationReq.split(", ")));
    }

    @Override
    public String toString() {
        return "Name: " + FullName 
          + "\n Offered: " + Offered.toString()
          + "\n PreReqs: " + PreReqs.toString()
          + "\n Tags: " + Tags.toString()
          + "\n Score: " + Score
          + "\n Concentrations: " + Concentrations.toString()
          + "\n Description: " + Description;
    }
    
    public int compareTo(ElectiveEntity e) 
    {
        if (this.Score > e.getScore()) return -1;
        if (this.Score < e.getScore()) return 1;
        return 0;
    }

    /* get and set methods */
    
    public double getScore()
    {
    	return Score;
    }
    
    public void setScore(int count, double weight)
    {
    	this.Score += (count * weight);
    }
    
    public Map<String, Double> getTags()
    {
    	return Tags;
    }
}