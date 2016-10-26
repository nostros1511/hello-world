
public class ButtonUtil {
	/**
	 * method to get RandomButton which has to be pushed by the player
	 * @return
	 */
	
	public static String getButton (){
		String requestedButton ="";
		String allButtons[] = {"Q","W","E","R","T","Z","U","I","O","P","A","S","D","F","G","H","J","K","L","Y","X","C","V","B","N","M"};
		
		int randomNumber = (int) (Math.random() * 26);
		
		if(randomNumber < allButtons.length && randomNumber >= 0){
			requestedButton = allButtons[randomNumber];
		} else {
			randomNumber = (int)(Math.random() * 26);
		}
		
		return requestedButton;
	}
}


	