package logic;

import java.util.*;

public class ElectiveEntity implements Comparable<ElectiveEntity>
{
    private String fullName;
    private String abbreviation;
    private String description = "None";

    private ArrayList<String>  offered;
    private ArrayList<String>  preReqs;
    
    private Map<String, Double> tags;
    /* potentially change to Map */
    private ArrayList<String>  concentrations;
    private ArrayList<String>  concentrationReq;
    
    private double score = 0;

    private static String translateAbbr(String FullName)
    {
        List<String> abbr = Arrays.asList(FullName.split("."));
        
        if(abbr.size() < 2)
            return "None";
        else
            return abbr.get(0);
    }
    
    private static ArrayList<Double> translateTagWeights(List<String> tagWeightsString)
    {
    	ArrayList<Double> tagWeightsDouble = new ArrayList<Double>();
    	
    	for(String tag: tagWeightsString)
    		tagWeightsDouble.add(Double.parseDouble(tag));
    	
    	return tagWeightsDouble;
    }
    
    private static Map<String, Double> tagMapCreate(ArrayList<String> tags, 
    												 ArrayList<Double> tagWeights)
    {
    	Map<String, Double> tagsMap = new LinkedHashMap<String, Double>();
    	int n = tags.size();

    	for(int i = 0; i < n; i++)
    		tagsMap.put(tags.get(i), tagWeights.get(i));
    	
    	return tagsMap;
    	
    }

    public ElectiveEntity(String startFullName, String startOffered,       
                    	  String startPreReqs,       
                    	  String startTags, String startTagWeights,
                    	  String startConcentration, String startConcentrationReq,
                    	  String startDescription)
    {
    	/* String Values */
        fullName = startFullName;
        abbreviation = translateAbbr(startFullName);
        // possibly include class level
        description = startDescription;

        /* Array Values */
        offered =    	   	new ArrayList<String>(Arrays.asList(startOffered.split(", ")));
        preReqs =           new ArrayList<String>(Arrays.asList(startPreReqs.split(", ")));
        
        /* Map Values */
        tags = 				tagMapCreate(new ArrayList<String>(Arrays.asList(startTags.split(", "))),
        					translateTagWeights(Arrays.asList(startTagWeights.split(", "))));
        /* Will convert to a map */
        concentrations =	new ArrayList<String>(Arrays.asList(startConcentration.split(", ")));
        concentrationReq = 	new ArrayList<String>(Arrays.asList(startConcentrationReq.split(", ")));
    }

    @Override
    public String toString() {
        return "Name: " + fullName 
          + "\n Offered: " + offered.toString()
          + "\n PreReqs: " + preReqs.toString()
          + "\n Tags: " + tags.toString()
          + "\n Score: " + score
          + "\n Concentrations: " + concentrations.toString()
          + "\n Description: " + description;
    }
    
    public int compareTo(ElectiveEntity e) 
    {
        if (this.score > e.getScore()) return -1;
        if (this.score < e.getScore()) return 1;
        return 0;
    }

    /* get and set methods */
    
    public double getScore()
    {
    	return score;
    }
    
    public void setScore(int count, double weight)
    {
    	this.score += (count * weight);
    }
    
    public Map<String, Double> getTags()
    {
    	return tags;
    }
}