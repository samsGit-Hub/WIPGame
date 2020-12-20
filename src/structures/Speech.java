package structures;

import java.util.ArrayList;

public class Speech {
	private String text;
	private ArrayList<Response> options;
	
	/*
	 * Checks if this text has any response options.
	 * @return true if there are no options to respond with.
	 */
	public boolean needsResponse() {
		return options.size() == 0;
	}
}
