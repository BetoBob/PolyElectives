package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV
{
	private ReadCSV() {
	      /* not called */
	}

    public static List<ElectiveEntity> readCSV(String csv) throws IOException
    {
       List<ElectiveEntity> electivesList = new ArrayList<ElectiveEntity>();
       BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));		
            String line;
            ArrayList<String> lineList;
            ElectiveEntity electiveInput;
            
            for (int i = 0; (line = br.readLine()) != null; i++) 
            {
                if(i > 0)
                {
                    lineList = new ArrayList<String>(Arrays.asList(line.split("\"\"\",\"\"\"")));
                    
                    if(lineList.size() != 6)
                    	break;

                    electiveInput = new ElectiveEntity(lineList.get(0).replace("\"\"\"", ""), lineList.get(1), 
                                                 	   lineList.get(2), lineList.get(3), 
                                                 	   lineList.get(4), lineList.get(5).replace("\"\"\"", ""));
                
                    electivesList.add(electiveInput);
                }
            }
            br.close();
        }
        catch (Exception e) { throw new RuntimeException("context", e); }
        finally
        {
        	if(br != null) br.close();
        }

        return electivesList;
    }
}
