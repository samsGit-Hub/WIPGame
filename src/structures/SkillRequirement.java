package structures;

import main.Player;

/*
 * This class handles blocking off options by a skill requirement.
 */
public class SkillRequirement extends Requirement {
	// A reference to the Player.
	private Player player;
	// The minimum level needed to pass the check.
	private int threshold;
	// The type of skill.
	private String type;
	
	/*
	 * Constructor for a skill based requirement.
	 * @param Player is a reference to the player.
	 * @param threshold is the minimum level to pass the check.
	 * @param type is the type of skill.
	 */
	public SkillRequirement(Player player, int threshold, String type) {
		this.player = player;
		this.threshold = threshold;
		this.type = type;
	}

	/*
	 * Performs a skill-check against the player.
	 * @return true if the skill check passes, false otherwise. 
	 */
	@Override
	public boolean check() {
		return player.getLevel(type) >= threshold;
	}
	
	/*
	 * Returns the string version of this object.
	 * @return SR(Skill Requirement)|{TYPE}->{threshold}
	 */
	@Override
	public String serialize() {
		return "SR|" + type + "->" + threshold;
	}

	/*
	 * Gets the minimum level to pass skill-check.
	 */
	public int getThreshold() {
		return threshold;
	}

	/*
	 * Changes the minimum level to pass skill-check.
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
