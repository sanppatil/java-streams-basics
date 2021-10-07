package org.enodation.exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface StreamStreams {

	public static void main(String[] args) throws IOException {
		
		//Stream from array, sort, find-first and print
		Stream.of("Ajay", "Atul", "Amy", "Amitabh", "Ashosk", "Arun", "Aanand")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
	
		System.out.println();

		//Stream from array, sort, filter and print
		Stream.of("Ajay", "Atul", "Amy", "Amitabh", "Ashosk", "Arun", "Aanand")		
		.filter(p -> p.contains("m"))
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();

		//Stream row from text file and save to list
		try (Stream<String> bands = Files.lines(Paths.get("bands.txt"));){
			List<String> bandList = bands.filter(b -> b.startsWith("A"))
			.collect(Collectors.toList());
			bandList.forEach(System.out::println);
		}
		System.out.println();
		
				    
		//Stream row from text file, sort, filter, print
		Stream<String> bands2 = Files.lines(Paths.get("bands.txt"));
		bands2.sorted()
			.filter(b -> b.length() > 13)
			.forEach(System.out::println);
		bands2.close();

		System.out.println();


		
		//Stream row from csv file and count all columns
		Stream<String> data = Files.lines(Paths.get("data.csv"));
		System.out.println(data.count()+ " all rows...");
		data.close();
		
		System.out.println();
		
		//Stream row from csv file and count valid columns		
		Stream<String> data1 = Files.lines(Paths.get("data.csv"));
		long rowCount = data1.map(r -> r.split(","))
							.filter(c -> c.length == 3)
							.count();
		System.out.println(rowCount + " good rows...");
		data1.close();

		System.out.println();

		
		//Stream row from csv file and parse rows		
		Stream<String> data2 = Files.lines(Paths.get("data.csv"));		
		data2.map(r -> r.split(","))
			.filter(c -> c.length == 3)
			.filter(c -> Integer.parseInt(c[1]) > 15)
			.forEach(r -> System.out.println(r[0] + " " + r[1] + " "+ r[2]));
		data2.close();
		
		System.out.println();
		
		//Stream row from csv file and store fields into hashmap		
		Stream<String> data3 = Files.lines(Paths.get("data.csv"));		
		Map<String, String> map = new HashMap<>();
		map = data3.map(r -> r.split(","))
			.filter(c -> c.length == 3)
			.filter(c -> Integer.parseInt(c[1]) > 15)
			.collect(Collectors.toMap(c -> c[0], c -> c[1].toString()));
		data3.close();
		System.out.println(map);
		
		System.out.println();
		
		//Reduction sum
		double total = Stream.of(7.5, 3.14, 55.55, 0.268, 99.99)
							.reduce(10000.0, (Double d1, Double d2) -> d1 + d2);
		System.out.println(total);

		
	}

}