package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ElectiveEntity implements Comparable<ElectiveEntity>
{
	/* Descriptors */
    private String fullname = "None";
    private int level;
    private String description = "None";
    private ArrayList<String>  offered;
    private ArrayList<String>  preReqs;
    
    /* Scoring */
    private Map<String, Double> tags;
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

    public ElectiveEntity(String startFullName, String startOffered, String startPreReqs, 
    					  String startTags, String startTagWeights, String startDescription)
    {
    	/* String Values */
<<<<<<< HEAD
        fullname = startFullName;
=======
        fName = startFullName;
>>>>>>> c87a5e5d1747b46bf2773e6ec555eb73bd9e7f51
        level = translateLevel(startFullName);
        description = startDescription;

        /* Array Values */
        offered = new ArrayList<String>(Arrays.asList(startOffered.split(", ")));
        preReqs = new ArrayList<String>(Arrays.asList(startPreReqs.split(", ")));
        
        /* Map Values */
        tags =  tagMapCreate(new ArrayList<String>(Arrays.asList(startTags.split(", "))),
        		translateTagWeights(Arrays.asList(startTagWeights.split(", "))));
        
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Name: " + fullname 
=======
        return "Name: " + fName
>>>>>>> c87a5e5d1747b46bf2773e6ec555eb73bd9e7f51
          + "\n Level: " + level
          + "\n Offered: " + offered.toString()
          + "\n PreReqs: " + preReqs.toString()
          + "\n Tags: " + tags.toString()
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
    	return tags;
    }
}