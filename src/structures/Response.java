package structures;

/*
 * Response represents the options the player has to respond
 * in conversation.
 */
public class Response {
	// The actual text of the option.
	private String text; 
	// Any check that could block selection of this response.
	private Requirement requirement; 
	
	/*
	 * Default constructor that assumes no skill-check.
	 * @param text is the text of the response.
	 */
	public Response(String text) {
		this(text, null);
	}
	
	/*
	 * Constructor that takes all arguments.
	 * @param text is the text of the response.
	 * @param is the skill that could bar this option.
	 * @param sayable 
	 */
	public Response(String text, Requirement requirement) {
		this.text = text;
		this.requirement = requirement;
	}
	
	/*
	 * Returns a string version of this object for saving
	 * and loading.
	 * @return the String version of this object.
	 */
	public String serialize() {
		String serializedObject = text + "{";
		
		// Serializes possible attached requirement.
		serializedObject += requirement == null ? "NO REQ" : requirement.serialize();
		
		return serializedObject + "}";
	}
	
	/*
	 * Checks if the player can use this option.
	 * @return true if no skill check, result of the
	 * 	skill-check if there is one.
	 */
	public boolean isSayable() {
		return requirement == null ? true : requirement.check();
	}
	
	/*
	 * Getter for the text variable.
	 * @return text
	 */
	public String getText() {
		return text;
	}
	
	/*
	 * Setter for the text variable.
	 * @param String to override text.
	 */
	public String setText() {
		return text;
	}
	
	/*
	 * Permanently removes requirement.
	 */
	public void removeRequirement() {
		requirement = null;
	}
	
	/*
	 * Overrides current skill.
	 */
	public void addRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
}
