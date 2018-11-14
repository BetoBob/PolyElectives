package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* Sorts classes based on quiz results */

public class QuizController
{
	
	   private QuizController() {
		      /* not called */
	   }
	
	   public static Map<String, Integer> tagsToMap(List<String> tagList)
	   {
		   Map<String, Integer> tags = new LinkedHashMap<String, Integer>();
		   
		   for (String s : tagList) {
			   if (tags.get(s) != null) {
				   tags.put(s, tags.get(s) + 1);
			   } else {
				   tags.put(s, 1);
			   }
		   }
        
        /* sort tags */
        
        return tags;
	}
	
    public static List<ElectiveEntity> computeResults(Map<String, Integer> tags) throws IOException
    {
    	Map<String, Double> eTagWeights;
        List<ElectiveEntity> electivesList = ReadCSV.readCSV("src/Electives_CSV.csv");
        
        /* Top Elective Tags */
        for (Map.Entry<String, Integer> val : tags.entrySet())
        {	
        	/* Calculate the Scores */
        	for(ElectiveEntity e: electivesList)
            {
        		eTagWeights = e.getTags();
        		if(eTagWeights.containsKey(val.getKey())) {
        			e.setScore(val.getValue(), eTagWeights.get(val.getKey()));
        		}
            }
        }
        
        /* Sort electivesList */
        Collections.sort(electivesList);
        
        return electivesList;
    }
}