package structures;

import main.Player;

/*
 * This class handles blocking off options by a skill requirement.
 */
public class SkillRequirement extends Requirement {
	// A reference to the Player.
	private Player player;
	// The minimum level needed to pass the check.
	private int threshhold;
	// The type of skill.
	private String type;
	
	/*
	 * Constructor for a skill based requirement.
	 * @param Player is a reference to the player.
	 * @param threshold is the minimum level to pass the check.
	 * @param type is the type of skill.
	 */
	public SkillRequirement(Player player, int threshhold, String type) {
		this.player = player;
		this.threshhold = threshhold;
		this.type = type;
	}

	/*
	 * Performs a skill-check against the player.
	 * @return true if the skill check passes, false otherwise. 
	 */
	public boolean check() {
		return player.getLevel(type) >= threshhold;
	}

	/*
	 * Gets the minimum level to pass skill-check.
	 */
	public int getThreshhold() {
		return threshhold;
	}

	/*
	 * Changes the minimum level to pass skill-check.
	 */
	public void setThreshhold(int threshhold) {
		this.threshhold = threshhold;
	}
}
