/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Design the random number guesser program
 * Due: 2/23/2021
 * Platform/compiler: JAVA
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Shengquan Yang
*/


import java.util.Scanner;
 
public class RandomNumberGuesser
{
	public static void main(String[] args)
	{
		int lowGuess = 0; // To hold the minimum number the user should enter
		int highGuess = 100; // To hold the maximum number the user should enter
		int nextGuess; // To hold the number the user entered
		int count; // To hold the number of times the user tried
		int randNum; // To hold he number the system generates
		String choice = "yes"; // To hold input
                               
                               
		RNG system_number = new RNG(); // Create RNG object
        Scanner keyboard = new Scanner(System.in); // Create Scanner object
                               
        randNum = RNG.rand(); // Assign the number the system generates to it
                               
       
                               
        do
        {    
        	System.out.println("Enter your first guess"); // Ask the users to enter their first guesses
        	RNG.resetCount(); // Reset the count to 0
        	
        	do
            {
        		nextGuess = keyboard.nextInt(); // Get the number from the user
                count = RNG.getCount()+1; // To count the number of times the user tried
                                                               
                // To determine if the number the user entered is out of the range
                RNG.inputValidation(nextGuess, lowGuess, highGuess);
                                               
                // To count the number of tries
                System.out.println("Number of guesses is " + count);
                                                               
                // To determine if the user get the right number
                Result(nextGuess, randNum);
                // To determine if the number the user entered is too high or too low
                Determine(nextGuess, randNum);
                                               
                highGuess = highGuess(nextGuess, lowGuess, highGuess, randNum); // To hold the high number
                lowGuess = lowGuess(nextGuess, lowGuess, highGuess, randNum); // To hold the low number
                
                // Call the function to ask the users to enter the number between the highGuess and the lowGuess
                Range(nextGuess, lowGuess, highGuess, randNum);
                                               
            }while(nextGuess != randNum); // If the number the users entered is not equal to the number the system generated, the function will loop
        	
        	lowGuess = 0; // To reset it to 0 
        	highGuess = 100; // To reset it to 100
                                               
        	System.out.println("Try again? (yes or no)"); // Ask users if they want to play another round
        	keyboard.nextLine();
            choice = keyboard.nextLine(); // Get the users' choices
          
            RNG.resetCount(); // Reset the count to 0
            count = RNG.getCount(); // Return the value of count by calling the function from RNG java  
                                               
        }while(choice.equals("yes")); // If the users would like to keep playing, the function will loop, otherwise, the loop function will end
               
            System.out.println("Hello my name is Shengquan Yang. Thanks for playing...");
            
	}
               
	// To ask the users to enter the number between the highGuess and the lowGuess if their guesses are not the number the system generated
	public static void Range(int nextGuess,int lowGuess,int highGuess,int randNum )
    {
		if (nextGuess != randNum)
        System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
    }
               
	// To determine if the numbers the users entered are too high or too low
    public static void Determine(int nextGuess, int System_number)
    {
    	if (nextGuess > System_number)
    	{
    		System.out.println("Your guess is too high");
    	}
                               
    	else if ((nextGuess < System_number))
    	{
    		System.out.println("Your guess is too low");
    	}
    }
       
    // To return the high numbers 
    public static int highGuess(int nextGuess, int lowGuess, int highGuess, int randNum)
    {             
    	if(nextGuess >= randNum && (nextGuess - randNum) < (highGuess - randNum))
        {
            highGuess=nextGuess;
        }
    	return highGuess;
    }
               
    // To return the low numbers 
    public static int lowGuess(int nextGuess, int lowGuess, int highGuess, int randNum)
    {                        
    	if(nextGuess <= randNum && (randNum - nextGuess) < (randNum - lowGuess))
        {
            lowGuess = nextGuess;
        }
                               
        return lowGuess;
    }
       
    // To determine if the users get the right number
    public static void Result(int nextGuess, int System_number)
    {
    	if (nextGuess == System_number)
    	{
    		System.out.println("Congratulations, you guessed correctly");
    	}
    }
               
}



