package structures.character;

import java.util.TreeMap;

import structures.Interactable;
import structures.conversation.Speech;
import structures.event.Event;

/*
 * TODO write class description.
 */
public class Character implements Interactable {
	
	// The speech node from which conversing with this character starts.
	private Speech rootSpeech;
	// Represents the relationship this character has with the player.
	private int affinity;
	// Represents the relationships this character has with factions.
	// String is the faction name, Integer is the affinity with that faction.
	private TreeMap<String, Integer> factionalAffinities;
	
	/*
	 * Should return a conversation event with this characters root Speech.
	 */
	@Override
	public Event approach() {
		// TODO Auto-generated method stub
		return null;
	}

}
