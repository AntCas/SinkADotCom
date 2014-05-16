import java.util.*;

public class DotComBust{
	
	private GameHelper helper = new GameHelper(); //helper class takes care of user input and setting the location of the ships
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom> ();
	private int numGuesses = 0; // Measures player performance

	private void setUpGame() {
		//make some dot comes and set locations
		DotCom one = new DotCom("Pets.com");
		DotCom two = new DotCom("eToys.com");
		DotCom three = new DotCom("Go2.com");
		
		//Add dotcoms to the list
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		// Print instructions
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses!");
		
		//for each dotcom in the list, set their location
		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		} // end for loop

	} // end setUpGame()
	
	private void startPlaying() {
		//while there are still ships alive (in the list)
		while (!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess"); //get user guess
			checkUserGuess(userGuess); //check user guess
		} // end while
	
		finishGame(); //Game Over
	
	}// end StartPlaying()

	private void checkUserGuess(String userGuess) {
		numGuesses++; //increment guesses
		String result = "miss"; //default value

		//for each dotcom in dotcomslist
		for (DotCom dotComToTest : dotComsList) { 
			result = dotComToTest.checkYourself(userGuess); // check value of dotcom

			if (result.equals("hit")) { //dotcom was hit (correct guess)
				break;
			} //end if
			
			if (result.equals("kill")) { //dot com was killed
				dotComsList.remove(dotComToTest);
				break;
			} // end if
		} // end for

		System.out.println(result); //print what happened ("miss","hit",or "kill)
	}// end checkUserGuess()

	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		
		//Decide how well user did and print results
		if (numGuesses <= 18) { // They did alright!
			System.out.println("It only took you " + numGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else { // They sucked.
			System.out.println("Took you long enough. " + numGuesses + " guesses.");
			System.out.println("Your options are swimming with the fishes.");	
		} //end if/else

	}//end finishGame()

	public static void main(String[] args) {
		DotComBust game = new DotComBust(); //create the game object
		game.setUpGame(); // tell the game object to set up the game
		game.startPlaying(); //tell the game object to start the main game loop
	} //end main
} // end class
