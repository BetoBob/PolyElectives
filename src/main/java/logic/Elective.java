package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;

public class Elective implements Comparable<Elective>
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

    public VBox getBox() {
    	VBox box = new VBox();
    	StringBuilder temp = new StringBuilder("Offered: ");
    	
    	Text off_reqs, fullname_text, desc_text;
    	TextFlow tf;
    	
    	fullname_text = new Text(fullname);
    	fullname_text.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
    	box.getChildren().add(fullname_text);
    	box.setMaxWidth(775);
		box.setMinHeight(175);
		
    	for (String str : offered) temp.append(" " + str + ",");
    	temp = new StringBuilder(temp.substring(0, temp.toString().length() - 1));
    	temp.append("    |    Pre-Reqs:");
    	for (String str : preReqs) temp = temp.append(" " + str + ",");	
    	temp = new StringBuilder(temp.substring(0, temp.toString().length() - 1));
    	
    	off_reqs = new Text(temp + "\n");
    	off_reqs.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
    	box.getChildren().add(off_reqs);
    	
    	desc_text = new Text(description);
    	desc_text.setFont(Font.font("Tahoma", 16));
    	tf = new TextFlow(desc_text);
    	//tf.setTextAlignment(TextAlignment.CENTER);
    	box.getChildren().add(tf);
    	box.setAlignment(Pos.CENTER);
    	return box;
    }
    
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

    public Elective(String startFullName, String startOffered, String startPreReqs, 
    					  String startTags, String startTagWeights, String startDescription)
    {
    	/* String Values */
        fullname = startFullName;
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
        return "Name: " + fullname 
          + "\n Level: " + level
          + "\n Offered: " + offered.toString()
          + "\n PreReqs: " + preReqs.toString()
          + "\n Tags: " + tags.toString()
          + "\n Score: " + score
          + "\n Description: " + description;
    }
    
    @Override
    public int compareTo(Elective e) 
    {
        if (this.score > e.getScore()) return -1;
        if (this.score < e.getScore()) return 1;
        if (this.level > e.getLevel()) return 1;
        if (this.level < e.getLevel()) return -1;
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
    	return true;
    }
    @Override
    public int hashCode() {
    	return 1;
    }

    /* get and set methods */
    
    public String getFullname()
    {
    	return fullname;
    }
    
    public int getLevel()
    {
    	return level;
    }
    
    public String getDescription()
    {
    	return description;
    }
    
    public Map<String, Double> getTags()
    {
    	return tags;
    }
    
    public double getScore()
    {
    	return score;
    }
   
    public void setScore(int count, double weight)
    {
    	this.score += (count * weight);
    }
    
}
