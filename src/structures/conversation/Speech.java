package structures.conversation;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Speech holds what a character says to the player, as well as how the player
 * can respond.
 */
public class Speech {
	// Integer used for Speech linking.
	private int identifier;
	// String text representing what a character says.
	private String text;
	// Map holding response options, and the Speech-es they may link to.
	private HashMap<Response, Speech> options;
	
	/*
	 * Constructor that assumes no response options.
	 * @param identifier sets identifier.
	 * @param text sets text.
	 */
	public Speech(int identifier, String text) {
		this.identifier = identifier;
		this.text = text;
		options = new HashMap<Response, Speech>();
	}
	
	/*
	 * Serialize-r for the Speech Object.
	 * @return the String form of this object.
	 */
	public String serialize() {
		// Serializes text and identifier.
		String serializedObject = "[" + identifier + "]" + text + "\n";
		
		// Serializes options if this Speech object has any.
		if (needsResponse()) {
			for (Entry<Response, Speech> option : options.entrySet()) {
				serializedObject += "    ";
				serializedObject += option.getKey() != null ? 
						option.getKey().serialize() : "NONE";
				// If this response links somewhere, the link is serialized.
				if (option.getValue() != null) {
					serializedObject += "[" + option.getValue().getIdentifier() 
						+ "]";
				} else {
					serializedObject += "[No Link]";
				}
				serializedObject += "\n";
			}
		} else {
			serializedObject += "\n";
		}
		return serializedObject;
	}
	
	/*
	 * Adds a response to the options Map assuming no link.
	 * @param is the response to add.
	 */
	public void addResponse(Response response) {
		options.put(response, null);
	}
	
	/*
	 * Adds a response to the options Map assuming a link.
	 * @param is the response to add.
	 * @param is the speech the response links to.
	 */
	public void addResponse(Response response, Speech speech) {
		options.put(response, speech);
	}
	
	/*
	 * Checks if this text has any response options.
	 * @return true if there are no options to respond with.
	 */
	public boolean needsResponse() {
		return !options.isEmpty();
	}
	
	/*
	 * Getter for the identifier attribute.
	 * @return identifier.
	 */
	public int getIdentifier() {
		return identifier;
	}
}
