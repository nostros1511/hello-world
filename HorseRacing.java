import java.util.Scanner;

public class HorseRacing {
	
	

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Konstanten
		//final int ROUNDLENGTH = 600;
		//final int MAXROUNDS = 2;
		
		//Declaration and initializing
		Scanner in = new Scanner(System.in);
		String input = ""; //String for player input
		long start, end; //Start and End Time for Button Request
		int position = 1;
		int timeToPressButton = 0;
		
		
		//Horse Names
		String names[] = new String[]{"Player	","Blacki   ", "Speedy   ", "Ace      ", "Black Widow", "Road Hawk   ", "Donnerhall   ", "Bonanza   "};
		
		//attributes of horses 
		double attributes[][] = new double[][]{
								 {0, 0, 0, 0, 0, 0, 0, 0}, /*MarkerPosition: 1 = 10m*/ 
								 {0, 0.80, 0.70,  0.65, 0.85, 0.82, 0.78, 0.75}, /*Chance to increase pace*/
								 {5, 5, 5, 5, 5, 5, 5, 5}, /* Pace (1-10)*/
								 {0, 0, 0, 0, 0, 0, 0, 0},/*Meters run , Finish Line = 1200m*/
								 {1, 1, 1, 1, 1, 1, 1, 1}}; /*1 Round = 600m; 2 Rounds*/
			
		
		boolean finishflag = false;	 //Player finished?
		String rButton = "";	 //requestedButton
		
		//Game entry - first output
		Util.printTitle();
		
		//Insert player name
		System.out.print("Welcome! Insert your name:");
		names[0]= in.nextLine();
		
		//Check name length
		if (names[0].length() < 8)
			names[0] += "\t";
		if (names[0].length() > 14)
			names[0] = names[0].substring(0, 14);
		
		//Choose Difficulty
		timeToPressButton = Options.chooseDifficulty(in);
		 
		
		// Read game instructions
		Options.showGameInstructions(in);
			
		//Countdown for Start
		for (int i = 5; i > 0; i--){
			System.out.print(printField(names, attributes, position) + "\tStart in ....\n\t" + i + "\n\n");
			Util.pause(1000);
		}
		System.out.print(printField(names, attributes, position)+ "\n\tSTART\n\n");
		Util.pause(1000);
		
		
		
		//Start
		while (finishflag !=true ){
			
			//getButton to press
			rButton = ButtonUtil.getButton();
			
			input = "";
			start = System.currentTimeMillis();
			end = start + timeToPressButton; 
			
			//Message: Request Button to be pushed
			System.out.print(printField(names, attributes, position) + "Press Button : -->  " + rButton + "  <--\n\n\n");
//TODO: Bug: Erste Angabe automatisch falsch, falls readOptions zuvor nicht aufgerufen wurde		
			input = in.nextLine();

			//Check if requestedButton = Player Button and if input was fast enough, then return new Speed
			if((input.equalsIgnoreCase(rButton) && System.currentTimeMillis()< end )){
				System.out.print(printField(names, attributes, position)+ "Great!\nSpeed increased\n\n");
				Util.pause(100);
				attributes[2][0] = MoveHorse.increaseSpeed(attributes, 0);
			} else {
				System.out.print(printField(names, attributes, position)+ "Wrong!\nSpeed decreased!\n\n");
				Util.pause(100);
				attributes[2][0] = MoveHorse.decreaseSpeed(attributes, 0);
				} //end of else
			//roll for KI
			attributes = MoveHorse.rollKI(attributes);
			
			// Move all Horses
			finishflag = MoveHorse.moveHorse(names, attributes, position);

			Util.pause(1000);
			//Countdown
			for (int i = 2; i > 0; i--){
				System.out.print(printField(names, attributes, position) + "\tNext in ....\n\t" + i + "\n\n");
				finishflag = MoveHorse.moveHorse(names, attributes, position);
				Util.pause(1000);
//System.out.print("\n" + attributes[3][0]); TESTING PURPOSES
				}
			} //end of while loop
		} //end of main 
		
	//TODO: ENDE funzt nicht


	/**
	 * Method to print the gamefield on the command line.
	 * 
	 * @return out
	 */
	public static String printField(String[] names, double attributes[][], int position){
		String out = "";
		position = MoveHorse.showPosition(attributes);
		
		out += ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		for(int i = 0; i < names.length; i++){
			out += names[i] + "\t" + "|";
			for(int j = 0; j <= 60; j++){
				if(j == attributes[0][i]){
					out += "X";
				} else {
					out += "-";
				}
			}
			out += "|" + "\tRound: " + (int)(attributes[4][i] ) + "/2"+ "\n"; // add Round-information 
		}		
		
		//Add pace and position
		out +=("\n\t\tPACE:\t[");
		for (int i=0; i < 10;i++)
			if (i < attributes[2][0])
				out +=("> ");
			else
				out +=("  ");
		out +=("]\t\tPOSITION:  "+ position + "\n");
		//Print Separating line
		for (int i=0;i < 110; i++){
			out += "_";
		}
		out += "\n";
	
	return out;
	}		
}
