package main;

import structures.conversation.Response;
import structures.conversation.SkillRequirement;
import structures.conversation.Speech;

public class Driver {
	public static void main (String[] args) {
		Speech s1 = new Speech(1, "this is a test");
		System.out.println(s1.serialize());
		
		Speech s2 = new Speech(2, "this is a test with an unlinked response.");
		s2.addResponse(new Response("GANG"));
		System.out.println(s2.serialize());
		
		Speech s3 = new Speech(3, "Hello there");
		s3.addResponse(new Response("GANG", new SkillRequirement(null, 12, "penis")), s1);
		s3.addResponse(new Response("GANG2"));
		System.out.println(s3.serialize());
	}
}
