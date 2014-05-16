import java.util.*;

public class DotCom {
	
	private ArrayList<String> locationCells; // location of dotcom
	private String name;
	
	//Setters
	public void setLocationCells(ArrayList<String> locations) {
		locationCells = locations;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//Getters

	//Constructors
	public DotCom(String name){
		setName(name);
	}

	//Methods
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput); //Get index of user guess if it exists
		
		if (index >= 0) { // The user guess is in the list
			locationCells.remove(index);

			if (locationCells.isEmpty()) { //ship has been sunk
				result = "kill";
				System.out.println("Ouch! You sunk " + name + "    :-(");
			} else {
				result = "hit";
			} //close if/else
		
		} // close if

		return result; // "miss", "hit", or "kill"
		
	} // end checkYourself() method
}//end class
