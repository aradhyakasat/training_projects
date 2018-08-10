package com.visa.prj.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MovieExample {

	public static void main(String[] args) {
		BufferedReader breader = null;
		try {
			Path path = Paths.get("src", "movies.csv");
			breader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);

		} catch (IOException exception) {
			System.out.println("Error occured while trying to read the file");
			System.exit(0);
		}

		List<String> lines = breader.lines().collect(Collectors.toList());
		// To get the list of all movie names
		lines.stream().map(line -> line.split(";")[0]).forEach(System.out::println);

		// To Get Director of "A Beautiful Mind"
		//List<String> lines = breader.lines().collect(Collectors.toList());
		lines.stream().map(line->line.split(";")).filter(line->line[0].equals("A Beautiful Mind")).forEach(line->System.out.println(line[2]));
		
	/*	List<Product> mobiles = products.stream() // Useful for collecting andf then sending to say UI than printing on
				// the server side directly
.filter(ProductClient::isMobile).collect(Collectors.toList());
		// Top 5 movies voted on IMDB [ Column 9]

	}*/

}

}