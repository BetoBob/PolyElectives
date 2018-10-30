package polyElectives;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.FileReader;

class ReadCSV
{

    public static ArrayList<ElectiveEntity> readCSV(String csv)
    {
        ArrayList<ElectiveEntity> electivesList = new ArrayList<ElectiveEntity>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line;
            ArrayList<String> lineList;
            ElectiveEntity electiveInput;
            
            for (int i = 0; (line = br.readLine()) != null; i++) 
            {
                if(i > 0)
                {
                    lineList = new ArrayList<String>(Arrays.asList(line.split("\"\"\",\"\"\"")));
                    
                    if(lineList.size() != 8)
                    	break;
                    
                    electiveInput = new ElectiveEntity(lineList.get(0).replace("\"\"\"", ""), lineList.get(1), 
                                                 	   lineList.get(2), lineList.get(3), 
                                                 	   lineList.get(4), lineList.get(5), 
                                                 	   lineList.get(6), lineList.get(7).replace("\"\"\"", ""));
                
                    electivesList.add(electiveInput);
                }
            }
            br.close();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return electivesList;
    }
}
