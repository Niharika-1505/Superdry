package com.superdry.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCount {

	public static void main(String[] args) {
		String str = "this is a dog and this is a cat";
		 
        List <String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
            .collect(Collectors.toList());
 
        Map <String, Integer > unsortedWordCount = list.stream()
            .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println("Unsorted Order:"+unsortedWordCount);
        Map<String, Integer> ascOrder = new TreeMap<String, Integer>(unsortedWordCount);
        System.out.println("Ascending Order:"+ascOrder);
        Map<String, Integer> descOrder = new TreeMap<String, Integer>(Collections.reverseOrder());
        descOrder.putAll(unsortedWordCount);
        System.out.println("Descending Order:"+descOrder);
	}

}
