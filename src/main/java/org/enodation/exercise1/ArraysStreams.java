package org.enodation.exercise1;

import java.util.Arrays;
import java.util.List;

public interface ArraysStreams {

	public static void main(String[] args) {
		
		//Avg of square of int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(num -> num*num)
			.average()
			.ifPresent(System.out::println);
		
		System.out.println();

		//Stream from list, filter and print
		Arrays.stream(new String[] {"Ajay", "Atul", "Amy", "Amitabh", "Ashosk", "Arun", "Aanand"})
			.map(s -> s.toUpperCase())
			.filter(s -> s.length() <=4 )
			.forEach(System.out::println);

		System.out.println();

		//Stream from list, filter and print
		List<String> nameList = Arrays.asList("Ajay", "Atul", "Amy", "Amitabh", "Ashosk", "Arun", "Aanand");
		nameList.stream()
			.map(s -> s.toUpperCase())
			.filter(s -> s.length() <=4 )
			.forEach(System.out::println);


	}

}