package structures;

import structures.event.Event;

/*
 * Interface for any object or character that can be interacted with.
 */
public interface Interactable {
	
	/*
	 * Returns an event representing the result of interaction.
	 */
	public abstract Event approach();
}
