package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ElectiveEntity implements Comparable<ElectiveEntity>
{
	/* Descriptors */
    private String fullName = "None";
    private int level;
    private String description = "None";
    private ArrayList<String>  Offered;
    private ArrayList<String>  PreReqs;
    
    /* Scoring */
    private Map<String, Double> Tags;
    private double score = 0;

    private static int translateLevel(String fullName)
    {
        List<String> abbr = Arrays.asList(fullName.split("\\."));
        List<String> numb = Arrays.asList(abbr.get(0).split(" "));
        
        if(numb.size() != 2)
            return 300;
        else
            return Integer.parseInt(numb.get(1));
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

    public ElectiveEntity(String startFullName, String startOffered, String startPreReqs, 
    					  String startTags, String startTagWeights, String startDescription)
    {
    	/* String Values */
        fullName = startFullName;
        level = translateLevel(startFullName);
        description = startDescription;

        /* Array Values */
        Offered = new ArrayList<String>(Arrays.asList(startOffered.split(", ")));
        PreReqs = new ArrayList<String>(Arrays.asList(startPreReqs.split(", ")));
        
        /* Map Values */
        Tags =  tagMapCreate(new ArrayList<String>(Arrays.asList(startTags.split(", "))),
        		translateTagWeights(Arrays.asList(startTagWeights.split(", "))));
        
    }

    @Override
    public String toString() {
        return "Name: " + fullName 
          + "\n Level: " + level
          + "\n Offered: " + Offered.toString()
          + "\n PreReqs: " + PreReqs.toString()
          + "\n Tags: " + Tags.toString()
          + "\n Score: " + score
          + "\n Description: " + description;
    }
    
    @Override
    public int compareTo(ElectiveEntity e) 
    {
        if (this.score > e.getScore()) return -1;
        if (this.score < e.getScore()) return 1;
        if (this.level > e.getLevel()) return 1;
        if (this.level < e.getLevel()) return -1;
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
    
    public int getLevel()
    {
    	return level;
    }
    
    public Map<String, Double> getTags()
    {
    	return Tags;
    }
}