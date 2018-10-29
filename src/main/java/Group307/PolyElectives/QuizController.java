import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* Sorts classes based on quiz results */

public class QuizController
{
	
    public static void ComputeResults(ArrayList<String> tagList, int n)
    {
        ArrayList<ElectiveEntity> electivesList;
        String csv = "src/Electives_CSV.csv";
        electivesList = ReadCSV.readCSV(csv);
        
        /* store tag counts in a LinkedHashMap */
        Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
        for (String s : tagList) {
            if (hm.get(s) != null) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }
        
        /* Top Elective Tags */
        System.out.println("\n\nDistribution of Elective Tags:");
        for (Map.Entry<String, Integer> val : hm.entrySet())
        {
        	System.out.println("	" + val.getKey() + ":	" + val.getValue()); 
        	
        	/* Calculate the Scores */
        	for(ElectiveEntity e: electivesList)
            {
        		Map<String, Double> eTags = e.getTags();
        		if(eTags.containsKey(val.getKey()))
        		{
        			e.setScore(val.getValue(), eTags.get(val.getKey()));
        		}
            }
        }
        
        /* Sort stuff here */
        Collections.sort(electivesList);

        /* Print the sorted electiveList */
        System.out.println("\nTech Electives Ranked (n = " + n + "):\n");
        for(ElectiveEntity e: electivesList)
        {
        	if(n-- == 0)
        		break;
            System.out.println(e);
            System.out.println();
        }
    }
}