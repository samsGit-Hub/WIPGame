package structures;

/*
 * Abstract class that supports anything in game
 * that could check a player -- including skills
 * and relationships.
 */
public abstract class Requirement {
	
	/*
	 * Returns true if the player passes the skill-check, 
	 * false otherwise.
	 */
	public abstract boolean check();
	
	/*
	 * Returns the String form of a requirement.
	 */
	public abstract String serialize();
}
