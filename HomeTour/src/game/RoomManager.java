package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fixture.Room;

public class RoomManager {

	private Map<String, Room> rooms = new HashMap<String, Room>();
	private ArrayList<String> exits = new ArrayList<String>();
	private Room startingRoom;

	public Map<String, Room> init() {

		Room room1 = new Room("entryway", "The entryway to the apartment", "You enter the apartment to your left is a bathroom and a office, in front of you is the den.", false, exits);
		room1.addExit("Bathroom");
		room1.addExit("Den");
		room1.addExit("Office");
		exits = new ArrayList<String>();

		Room room2 = new Room("bathroom", "The guest bathroom", "A small somewhat cramped bathroom full bath", false, exits);
		room2.addExit("Entryway");
		room2.addExit("Office");
		exits = new ArrayList<String>();

		Room room3 = new Room("office", "The office",
				"Originally the guest bedroom covid has seen it somewhat converted into a office.  A mixture of Ikea and old furniture", false,
				exits);
		room3.addExit("Bathroom");
		room3.addExit("Entryway");
		exits = new ArrayList<String>();

		Room room4 = new Room("den", "The Den",
				"You see a decent sized tv, a beat up leather love seat and couch.  A cat perched atop the couch stares at you as if to say why would you enter my space?", true,
				exits);
		room4.addExit("Kitchen");
		room4.addExit("Entryway");
		room4.addExit("Bedroom");
		exits = new ArrayList<String>();

		Room room5 = new Room("bedroom", "The bedroom",
				"The master bedroom contains a walk in closet and en suite bathroom", false, exits);
		room5.addExit("Den");
		exits = new ArrayList<String>();

		Room room6 = new Room("kitchen", "The Kitchen",
				"A small kitchen with a electric stove and range and other old appliances with attached laundry room.", false,
				exits);
		room6.addExit("Den");
		exits = new ArrayList<String>();

		rooms.put(room1.getName(), room1);
		rooms.put(room2.getName(), room2);
		rooms.put(room3.getName(), room3);
		rooms.put(room4.getName(), room4);
		rooms.put(room5.getName(), room5);
		rooms.put(room6.getName(), room6);
		startingRoom = room1;

		return rooms;

	}

	public Room getStartingRoom() {
		return this.startingRoom;
	}

}
