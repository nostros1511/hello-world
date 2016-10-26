import java.util.Scanner;

public class Options {
	/**
	 * Method to show game instructions
	 * @param in
	 */
	public static void showGameInstructions(Scanner in){
		String input = "";
		
		System.out.println("Do you like to read the game instructions?");
		System.out.println("Type 'Yes' to read the instructions. Press any other button to skip!");
		input = in.next();
		if (input.equalsIgnoreCase("Yes") ){
			System.out.print("__________________________________________________________________\n" +
				"As you may have already noticed - this is a horse race!\n" +
				"Compete against seven challengers and finish first!\n"+ 
				"Every few seconds an announcement will tell you to press a certain button.\n" +
				"Press that button within a small time window to speed up your horse\n" +
				"If you are too slow or press the wrong button your horse will slow down.\n" +
				"___________________________________________________________________________\n");
			
			System.out.println("Press enter to continue...");
			in.nextLine();
			in.nextLine();
		}	
	}


	/**
	 * Method for game difficulty
	 * easy : TimeToPressButton = 2,5 sec
	 * normal : TimeToPressButton = 2,0 sec
	 * hard : TimeToPressButton = 1,5 sec
	 * impossible: TimeToPressButton = 1,2 sec
	 */
	public static int chooseDifficulty(Scanner in){
		int timeToPressButton = 0;
		String input = "";
		System.out.println("Choose your difficulty! \n" + 
				"1) easy\n2) normal\n3) hard\n4) impossible");
		input= in.next();
		
		switch (input){
		case "1":
			timeToPressButton = 2500;
			break;
		case "2": 
			timeToPressButton = 2000;
			break;
		case "3":
			timeToPressButton = 1500;
			break;
		case "4": 
			timeToPressButton = 1200;
			break;
		default:
			chooseDifficulty(in);
			
		}
		
		return timeToPressButton;
	}


}

