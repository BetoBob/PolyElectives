package logic;

//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Scanner;

/* Handles user I/O of questions
 * will be replaced with a GUI interface once the design is unified
 * questions will also change (these questions are only designed to test the point system)
 */

public class QuizInterface
{
    /*public static void main(String args[])
    {
    	
    	int n = 0;		// number of tech electives to return
    	int input = 0;
    	
        ArrayList<String> tagList = new ArrayList<String>();       
        ArrayList<ElectiveEntity> electivesList = new ArrayList<ElectiveEntity>();
        Map<String, Integer> tagCounts;

        Scanner reader = new Scanner(System.in); 
        
        System.out.print("How many tech electives would you like listed? (0 .. *): ");
        if(reader.hasNextInt()){
        	n = reader.nextInt();
        }
        
         Question 1 
         * Concentrations 
        System.out.println("\nAre you interested in taking any of the following concentrations?");
        System.out.println("( 1 - 4 ; 0 if none of the above)");
        System.out.println("	1) Data Science (Minor)");
        System.out.println("	2) Computing for the Interactive Arts (Minor)");
        System.out.println("	3) Interactive Entertainment (Concentration)");
        System.out.println("	4) Software Engineering (Major)\n");
        
        System.out.print("Enter your answer: ");
        if(reader.hasNextInt()){
        	input = reader.nextInt();
        }
        
        if(input == 1)
        {
        	tagList.add("DS");
        	tagList.add("R");
        }
        else if(input == 2)
        {
        	tagList.add("GR");
        }
        else if(input == 3)
        {
        	tagList.add("GD");
        	tagList.add("GR");
        }
        else if(input == 4)
        {
        	tagList.add("SD");
        }
        
        
         Read User Answer 
        
        System.out.println();
        
         Question 2
         * Single Tag 
        System.out.println("What are you interested in the following tech electives (select 1 - 4)?");
        System.out.println("( 1 - 4 ; 0 if none of the above)");
        System.out.println("	1) Artificial Intelligence");
        System.out.println("	2) Autonomous Vehicle Development");
        System.out.println("	3) Database Management");
        System.out.println("	4) Networks\n");
        
        System.out.print("Enter your answer: ");
        if(reader.hasNextInt()){
        	input = reader.nextInt();
        }
        if(input == 1)
        {
        	tagList.add("AI");
        }
        else if(input == 2)
        {
        	tagList.add("AVD");
        }
        else if(input == 3)
        {
        	tagList.add("DBM");
        }
        else if(input == 4)
        {
        	tagList.add("NW");
        }
        
         Question 3 
         * Multiple Tags 
        System.out.println("What are you interested in the following tech electives (select 1 - 4)?");
        System.out.println("( 1 - 4 ; 0 if none of the above)");
        System.out.println("	1) Computer Performance and Security");
        System.out.println("	2) Artificial Intelligence and Data Science");
        System.out.println("	3) Game Development and Graphics");
        System.out.println("	4) Networks and Research\n");
        
        System.out.print("Enter your answer: ");
        if(reader.hasNextInt()){
        	input = reader.nextInt();
        }
        if(input == 1)
        {
        	tagList.add("CP");
        	tagList.add("SC");
        }
        else if(input == 2)
        {
        	tagList.add("AI");
        	tagList.add("DS");
        }
        else if(input == 3)
        {
        	tagList.add("GD");
        	tagList.add("GR");
        }
        else if(input == 4)
        {
        	tagList.add("NW");
        	tagList.add("R");
        }
        
         Question 4
         * Multiple Tags 
        System.out.println("What are you interested in the following tech electives (select 1 - 4)?");
        System.out.println("( 1 - 4 ; 0 if none of the above)");
        System.out.println("	1) Software Development and Data Science");
        System.out.println("	2) Software Development and Game Development");
        System.out.println("	3) Security and Database Management");
        System.out.println("	4) Security and Networks\n");
        
        System.out.print("Enter your answer: ");
        if(reader.hasNextInt()){
        	input = reader.nextInt();
        }
        if(input == 1)
        {
        	tagList.add("SD");
        	tagList.add("DS");
        }
        else if(input == 2)
        {
        	tagList.add("SG");
        	tagList.add("GD");
        }
        else if(input == 3)
        {
        	tagList.add("SC");
        	tagList.add("DBM");
        }
        else if(input == 4)
        {
        	tagList.add("SC");
        	tagList.add("NW");
        }
        
        reader.close();
        
         Call QuizController here 
        tagCounts = QuizController.tagsToMap(tagList);
        electivesList = QuizController.computeResults(tagCounts);
        
         send tagCounts and electivesList to results page 
        
         print tag counts 
        System.out.println("\nTop Tags:");
        for (Map.Entry<String, Integer> val : tagCounts.entrySet()) {
        	System.out.println(val.getValue() + " : " + val.getKey());
        }
        
         print tech electives 
        System.out.println("\nTech Electives Ranked (n = " + n + "):\n");
        for(ElectiveEntity e: electivesList)
        {
        	if(n-- == 0)
        		break;
            System.out.println(e);s
            System.out.println();
        }
        
    }*/
}