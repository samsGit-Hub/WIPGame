package main;

import java.util.HashSet;

import structures.conversation.Speech;

public class GameManager {
	public HashSet<Speech> loadedSpeech;
	
	public void loadNewSpeech(Speech speech) {
		loadedSpeech.add(speech);
	}
	
	public void clearSpeech() {
		loadedSpeech.clear();
	}
}
