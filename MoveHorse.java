
public class MoveHorse {
	/**
	 * Method to Control Horse Speed
	 */
	public static double increaseSpeed(double attributes[][], int horseNumber){
		double oldPace = 0.0;
		double newPace = 0.0;
		int i = horseNumber;
		oldPace = attributes [2][i]; //get Speed of Player
		
		/*
		 * Increase Speed; max Speed = 10;
		 */
		if (oldPace < 7.0)
			newPace = oldPace + 2;
		else if (oldPace < 10.0)
			newPace = oldPace + 1;
		else
			newPace = oldPace;
				
		return newPace;
	}
	
	public static double decreaseSpeed(double attributes[][], int horseNumber){
		double oldPace = 0.0;
		double newPace = 0.0;
		int i = horseNumber;
		oldPace = attributes [2][i]; //get Speed of Player
		
		/*
		 * Decrease Speed; max Speed = 10;
		 */
		if (oldPace >= 7.0)
			newPace = oldPace - 2;
		else if (oldPace >= 4.0)
			newPace = oldPace - 1;
		else
			newPace = oldPace;
		return newPace;
	}



	
	 /**
	  * Method to move Horses according to their speed  
	  * @param attributes
	  * return finishflag (=End of Race)
	  */
	public static boolean moveHorse(String [] names, double [][] attributes,  int position){
		boolean finishflag = false;
		
		for (int i = 0; i < attributes[3].length;i++){
			attributes[3][i] = attributes[3][i] + attributes [2][i]; //increase Meter by Speed
			if (attributes[0][i] <= 60){
				attributes[0][i] = (int)attributes[3][i] / 10 ; //move position; 1 marker = 10 m;
			}
			if (attributes[0][i] > 60){
				attributes[0][i] = (int) ((attributes[3][i] / 10 )- 60) ; //move position; 1 marker = 10 m;
			}
				
			//Check if END OF RACE
			if (attributes[3][0] >= 1200 && attributes [4][i] == 2){
				finishflag = true;
				position = showPosition(attributes);
				MoveHorse.finish(names, attributes, position);
				Util.pause(5000);
				
			}
			//NEXT ROUND
			if (attributes [3][i] >= 600 && attributes [3][i] <= 610){
				attributes [4][i] = 2;
			}
		}
		return finishflag;
	}
	
	/**
	 * Roll for KI and return new Speed
	 * 
	 * Returns
	 * @param attributes
	 * @return
	 */
	public static  double [][] rollKI(double [][] attributes){
		for (int i = 1; i < attributes[1].length; i++){
			double randomNumber = 0.0;
			
			randomNumber = Math.random();
			if (randomNumber < attributes [1][i]){
				attributes[2][i]= MoveHorse.increaseSpeed(attributes, i);
				
			} else {
				MoveHorse.decreaseSpeed(attributes, i);
				attributes[2][i]= MoveHorse.decreaseSpeed(attributes, i);
			}	
		}
		return attributes;
	}
	/**
	 * Method to check Position of Player
	 * @param attributes
	 * @return position
	 */
	
	public static int showPosition(double [][] attributes){
		int position = 1;
		for (int i = 0; i < attributes[3].length; i++  ){
			if (attributes[3][0] < attributes[3][i]){
				position++;
			}
		}
		
		return position;
	}
	
	
	
	/**
	 * *Method to show Position at the End of Race
	 * @param names
	 * @param attributes
	 * @param position
	 */
	public static void finish(String [] names,double [][] attributes, int position){

		switch (position){
		case 1:
			System.out.print(HorseRacing.printField(names, attributes, position) + " END OF RACE!\nCongratulations!\nYou finished " + position + "st!\n");
			break;
		case 2:
			System.out.print(HorseRacing.printField(names, attributes, position) + " END OF RACE!\nCongratulations!\nYou finished " + position + "nd!\n");
			break;
		case 3: 
			System.out.print(HorseRacing.printField(names, attributes, position) + " END OF RACE!\nCongratulations!\nYou finished " + position + "rd!\n");
			break;
		default:
			System.out.print(HorseRacing.printField(names, attributes, position) + " END OF RACE!\nYou finished " + position + "th!\n\n");
			break;
		}
	}



}
