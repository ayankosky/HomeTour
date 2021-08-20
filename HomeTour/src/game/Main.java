package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fixture.Room;

public class Main {

	public static void main(String[] args) {

		Map<String, Room> rooms = new HashMap<String, Room>();
		Player player = new Player();
		RoomManager rm = new RoomManager();
		Scanner in = new Scanner(System.in);

		rooms = rm.init();
		Room startingRoom = rm.getStartingRoom();

		player.setCurrentRoom(startingRoom);

		System.out.println(
				"This is my Home Tour project: You can move about the differenet rooms by using enter or move commands.  Also there are additional commands to interact with things in the enviroment. You may type quit at any time to leave.  Enjoy!");

		while (player.isPlaying()) {
			printRoom(player);
			String[] exitChoice = collectInput(in);
			parse(exitChoice, player, rooms);
		}
		in.close();

	}

	private static String[] collectInput(Scanner in) {
		System.out.println("What would you like to do?");

		String input = in.nextLine();

		String[] playerInputs = input.toLowerCase().split("\\s+");

		return playerInputs;
	}

	private static void parse(String[] inputs, Player player, Map<String, Room> rooms) {
		Room room = player.getCurrentRoom();
		String[] locations = new String[3];
		
		try {
			for (int i = 0; i < room.exitsLength(room); i++) {
				locations[i] = room.getExitName(room, i);

				}

			

			if ((inputs[0].contentEquals("move") || inputs[0].equals("enter")) && (room.checkExit(room, inputs[1]))) {
				room = (Room) rooms.get(inputs[1]);
				player.setCurrentRoom(room);
			} else if (inputs[0].contentEquals("quit")) {
				player.setPlaying(false);
				System.out.println("Goodbye");
			} else if (inputs[0].contentEquals("flip") || inputs[0].equals("toggle")) {
				room.toggleLights(room.getLights());
			} else if ((inputs[0].contentEquals("pet") || inputs[0].equals("touch")) && (room.getHasCat())) {
				room.petCat(rooms, room.getHasCat());
			} else {
				System.out.println("Please enter a valid command.");

			}
			;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please enter a valid command.");
		} catch (NullPointerException e) {
			System.out.println("Please Enter a valid command.");
		}

	}

	private static void printRoom(Player player) {
		Room room = player.getCurrentRoom();
		if (room.getLights() == false) {
			System.out.println("You are currently in " + room.getShortDescription());
			System.out.println("The lights are off it is hard to make out the details in the room");
			System.out.println("These are the rooms that you can enter:");
			room.listExits(room);
		} else {
			System.out.println("You are currently in " + room.getShortDescription());
			System.out.println(room.getLongDescription());
			System.out.println("These are the rooms that you can enter:");
			room.listExits(room);

		}

	}

}
