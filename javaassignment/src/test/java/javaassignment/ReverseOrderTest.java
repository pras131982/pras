package javaassignment;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseOrderTest {

	@Before
	public void setUp() {
		// System.out.println("@Before - runBeforeTestMethod");
	}

	@After
	public void tearDown() {
		// System.out.println("@After - runAfterTestMethod");
	}

	@Test
	public void testRandomNumberforIntercept() throws IOException {
		new ReverseOrder().reverseOrder();
		try (Stream<String> steam = Files.lines(Paths.get("src/main/resources/output.txt"))) {
			List<String> outputlist = steam.collect(Collectors.toCollection(ArrayList::new));
			assertTrue(outputlist != null && !outputlist.isEmpty());
		}
	}

}
