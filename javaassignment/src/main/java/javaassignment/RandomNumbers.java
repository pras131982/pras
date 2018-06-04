package javaassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RandomNumbers {

	// get logger
	Logger logger = Logger.getLogger(RandomNumbers.class.getName());


	public List<Integer> processRandomNumbers() {
		// Generate first array
		int[] firstArray = getIntArray();
		logger.log(Level.INFO, "firstArray size::" + firstArray.length);
		logger.log(Level.INFO, "firstArray largest number::" + findLargest(firstArray));
		List<Integer> alDuplicates = findDuplicates(firstArray);
		if (!alDuplicates.isEmpty()) {
			logger.log(Level.INFO, "duplicates present in firstArray::" + alDuplicates);
		}

		int[] secondArray = getIntArray();
		logger.log(Level.INFO, "secondArray size::" + secondArray.length);
		logger.log(Level.INFO, "secondArray largest number::" + findLargest(secondArray));

		alDuplicates = findDuplicates(secondArray);
		if (!alDuplicates.isEmpty()) {
			logger.log(Level.INFO, "duplicates present in secondArray::" + alDuplicates);
		}

		return findIntersection(firstArray, secondArray);

	}

	private List<Integer> findDuplicates(int[] numbers) {
		List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		Set<Integer> allItems = new HashSet<>();
		Set<Integer> duplicates = list.stream().filter(n -> !allItems.add(n)).collect(Collectors.toSet());
		List<Integer> alDuplicates = new ArrayList<>(duplicates);
		Collections.sort(alDuplicates);
		List<Integer> alAll = new ArrayList<>(allItems);
		Collections.sort(alAll);
		return alDuplicates;

	}

	public int[] getIntArray() {
		int[] randArray = new int[1000];
		for (int i = 0; i < 1000; i++) {
			randArray[i] = (int) (Math.random() * 1000);
		}
		return randArray;
	}

	public int findLargest(int[] numbers) {
		int largest = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > largest) {
				largest = numbers[i];
			}
		}
		return largest;
	}

	private List<Integer> findIntersection(int[] firstArray, int[] secondArray) {
		List<Integer> firstList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
		List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
		Set<Integer> intersect = firstList.stream().filter(secondList::contains).collect(Collectors.toSet());
		List<Integer> alIntersect = new ArrayList<>(intersect);
		Collections.sort(alIntersect);
		logger.log(Level.INFO, "INTERSECT of firstArray and secondArray::" + alIntersect);
		return alIntersect;

	}
}
