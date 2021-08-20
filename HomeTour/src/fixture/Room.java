package fixture;

import java.util.ArrayList;
import java.util.Map;

public class Room extends Fixture {

	private ArrayList<String> exits;
	private boolean lights;
	private boolean hasCat;

	public Room(String name, String shortDescription, String longDescription, boolean hasCat, ArrayList<String> exits) {
		super(name, shortDescription, longDescription);
		this.exits = exits;
		this.lights = true;
		this.hasCat = hasCat;

	}

	public boolean getLights() {
		return lights;
	}

	public void setLights(boolean lights) {
		this.lights = lights;
	}

	public void toggleLights(boolean lights) {

		if (this.lights == true) {
			this.lights = false;
		} else {
			this.lights = true;
		}

	}

	public void petCat(Map<String, Room> rooms, boolean hasCat) {
		Room bedroom = (Room) rooms.get("bedroom");

		if (this.hasCat == true) {
			if (this.name.equals("den"))
				;
			System.out.println("The cat seems to tolerate your attention but then dashes off into the bedroom.");
			this.hasCat = false;
			this.longDescription = "You see a decent sized tv, a beat up leather love seat and couch.";
			bedroom.setLongDescription(
					"The master bedroom contains a walk in closet and en suite bathroom.  The cat is glaring at you from under the bed.");
			bedroom.hasCat = true;

		}
	}

	public boolean getHasCat() {
		return hasCat;
	}

	public void addExit(String exit) {
		this.exits.add(exit);

	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void listExits(Room room) {
		ArrayList<String> exits = this.exits;
		for (String exit : exits) {
			System.out.println(exit);
		}
	}

	public int exitsLength(Room room) {
		ArrayList<String> exits = this.exits;
		return exits.size();
	}

	public String getExitName(Room room, int i) {
		ArrayList<String> exits = this.exits;
		return exits.get(i);

	}

	public String getName() {
		return this.name;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String s) {
		this.longDescription = s;
	}

	public boolean checkExit(Room room, String input) {
		ArrayList<String> exits = this.exits;
		for (String exit : exits) {
			if (input.toLowerCase().equals(exit.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
