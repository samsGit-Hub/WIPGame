package structures.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.conversation.Speech;

public class FileManager {
	
	public void loadConversationFromFile(String path) throws IOException {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (Exception e) {
			System.out.println("Unable to open file.");
			e.printStackTrace();
			return;
		}
		String line;
		while ((line = br.readLine()) != null) {
			/*
			 *  "#" represents a comment in files and should be skipped when 
			 *  loading.
			 *  A speech object should start with "[", if it does not there 
			 *  is bad formating and an exception is thrown.
			 */
			if (line.startsWith("#")) {
				continue;
			} else if (line.startsWith("[")) {
				/*
				 *  Lines is a list of all lines in the file that build
				 *  this particular Speech object.
				 */
				ArrayList<String> lines = new ArrayList<String>();
				lines.add(line);
				// Marks this position to return to if there are no responses.
				br.mark(100);
				while ((line = br.readLine()) != null) {
					if (line.startsWith("    ")) {
						lines.add(line);
						br.mark(100);
					} else {
						br.reset();
						break;
					}
				}
				buildSpeechFromFileExcerpt(lines);
			} else {
				throw new IOException("Bad formatting in: " + path);
			}
			
		}
		
		br.close();
	}
	
	private Speech buildSpeechFromFileExcerpt(ArrayList<String> lines) {
		Speech sRet = null;
		if (lines != null && lines.size() > 0) {
			String[] firstLine = lines.get(0).split("]");
			if (firstLine == null || firstLine.length != 2) return null;
			sRet = new Speech(Integer.parseInt(firstLine[0].substring(1)), firstLine[2]);
		}
		
		if (lines != null && lines.size() > 1) {
			//add responses here.
		}
		
		return sRet;
	}
}
