package org.enodation.exercise1;

import java.util.stream.IntStream;

public interface IntStreams {

	public static void main(String[] args) {
		
		//Integer stream
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		
		System.out.println();

		//Integer stream with skip
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(num -> System.out.println(num));

		System.out.println();

		//Integer stream with sum
		System.out.println(IntStream
			.range(1, 10)
			.skip(5)
			.sum());
		
		System.out.println();

		//Reduction - Summary stats
		System.out.println(IntStream.of(7, 2, 19, 88, 73, 4, 10)
			.summaryStatistics());
		
	}

}