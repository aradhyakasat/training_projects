package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

public class Task {

	public static void main(String[] args) {
		String sentence = "I Came I Saw U Came I Left";

		Set<String> unique = new HashSet<>();
		Set<String> dups = new HashSet<>();

		String[] words = sentence.split("\\s");

		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i].hashCode());
			if (unique.contains(words[i])) {
				dups.add(words[i]);
				unique.remove(words[i]);
			}
			else if(dups.contains(words[i]))	{
				{
					unique.remove(words[i]);
				}
				
			} else {
				unique.add(words[i]);
			}

		}

		// System.out.println(words[i].hashCode());

		System.out.println(unique);
		System.out.println(dups);

	}

}
