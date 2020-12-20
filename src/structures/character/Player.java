package structures.character;

import java.util.ArrayList;
import java.util.HashMap;

import structures.Item;

public class Player {
	private HashMap<String, Integer> skills;
	private ArrayList<Item> items;
	
	/*
	 * Gets the skill level tied to the skill type.
	 * @param type is the skill type used to grab level.
	 * @return the int level of the skill type.
	 * @throws IllegalArgumentException if the Player has no such skill.
	 */
	public int getLevel(String type) throws IllegalArgumentException {
		if (skills.containsKey(type)) {
			return skills.get(type);
		} else {
			throw new IllegalArgumentException(type + " is not a possesed skill"
					+ "and therefore cannot have an attached level.");
		}
	}
}
